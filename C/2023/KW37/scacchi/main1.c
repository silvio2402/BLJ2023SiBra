#include <stdio.h>
#include <stdbool.h>
#include <stdint.h>
#include <string.h>
#include <stdlib.h>

enum _Piece
{
  PIECE_CLEAR,
  PIECE_WHITE_KING,
  PIECE_WHITE_ROOK,
  PIECE_WHITE_BISHOP,
  PIECE_WHITE_QUEEN,
  PIECE_WHITE_KNIGHT,
  PIECE_WHITE_PAWN,
  PIECE_BLACK_KING,
  PIECE_BLACK_ROOK,
  PIECE_BLACK_BISHOP,
  PIECE_BLACK_QUEEN,
  PIECE_BLACK_KNIGHT,
  PIECE_BLACK_PAWN,
};
typedef enum _Piece Piece;

char *pieceSymbols[] = {
    " ",
    "\U00002654", // ♔
    "\U00002656", // ♖
    "\U00002657", // ♗
    "\U00002655", // ♕
    "\U00002658", // ♘
    "\U00002659", // ♙
    "\U0000265A", // ♚
    "\U0000265C", // ♜
    "\U0000265D", // ♝
    "\U0000265B", // ♛
    "\U0000265E", // ♞
    "\U0000265F", // ♟
};

char *latinSmallSymbols[] = {
    "\U00001D00", // ᴀ
    "\U00000299", // ʙ
    "\U00001D04", // ᴄ
    "\U00001D05", // ᴅ
    "\U00001D07", // ᴇ
    "\U0000A730", // ꜰ
    "\U00000262", // ɢ
    "\U0000029C", // ʜ
    "\U0000026A", // ɪ
    "\U00001D0A", // ᴊ
    "\U00001D0B", // ᴋ
    "\U0000029F", // ʟ
    "\U00001D0D", // ᴍ
    "\U00000274", // ɴ
    "\U00001D0F", // ᴏ
    "\U00001D18", // ᴘ
    "\U0000A7AF", // ꞯ
    "\U00000280", // ʀ
    "\U0000A731", // ꜱ
    "\U00001D1B", // ᴛ
    "\U00001D1C", // ᴜ
    "\U00001D20", // ᴠ
    "\U00001D21", // ᴡ
    "x",
    "\U0000028F", // ʏ
    "\U00001D22", // ᴢ
};

char *superscriptLetterSymbols[] = {
    "\U00001d43", // ᵃ
    "\U00001d47", // ᵇ
    "\U00001d9c", // ᶜ
    "\U00001d48", // ᵈ
    "\U00001d49", // ᵉ
    "\U00001da0", // ᶠ
    "\U00001d4d", // ᵍ
    "\U000002b0", // ʰ
    "\U00002071", // ⁱ
    "\U000002b2", // ʲ
    "\U00001d4f", // ᵏ
    "\U000002e1", // ˡ
    "\U00001d50", // ᵐ
    "\U0000207f", // ⁿ
    "\U00001d52", // ᵒ
    "\U00001d56", // ᵖ
    "q",
    "\U000002b3", // ʳ
    "\U000002e2", // ˢ
    "\U00001d57", // ᵗ
    "\U00001d58", // ᵘ
    "\U00001d5b", // ᵛ
    "\U000002b7", // ʷ
    "\U000002e3", // ˣ
    "\U000002b8", // ʸ
    "\U00001dbb", // ᶻ
};

char *superscriptDigitSymbols[] = {
    "\U000000B9", // ¹
    "\U000000B2", // ²
    "\U000000B3", // ³
    "\U00002074", // ⁴
    "\U00002075", // ⁵
    "\U00002076", // ⁶
    "\U00002077", // ⁷
    "\U00002078", // ⁸
    "\U00002079", // ⁹
};

typedef Piece Board[8][8];

struct _BoardCoords
{
  uint8_t x, y;
};
typedef struct _BoardCoords BoardCoords;

bool Piece_is_white(Piece piece)
{
  return (piece >= PIECE_WHITE_KING && piece <= PIECE_WHITE_PAWN);
}
bool Piece_is_black(Piece piece)
{
  return (piece >= PIECE_BLACK_KING && piece <= PIECE_BLACK_PAWN);
}

void BoardCoords_print(BoardCoords *boardCoords)
{
  char x = 'A' + boardCoords->x;
  char y = '1' + boardCoords->y;
  printf("%c%c", x, y);
}

void Board_print(Board board, BoardCoords *selected)
{
  for (int8_t y = -1; y <= 8; y++)
  {
    for (int8_t x = -1; x <= 8; x++)
    {
      printf("\e[0m");
      if (x < 0 || x >= 8)
      {
        if (y >= 0 && y < 8)
        {
          printf(" %s ", superscriptDigitSymbols[7 - y]);
        }
        else
        {
          printf("   ");
        }
        continue;
      }
      if (y < 0 || y >= 8)
      {
        if (y < 0)
        {
          printf("%s ", superscriptLetterSymbols[x]);
        }
        else if (y >= 8)
        {
          printf("%s ", superscriptLetterSymbols[x]);
        }
        continue;
      }
      if (!((x + y % 2) % 2))
      {
        printf("\e[48;2;255;255;255m");
      }
      else
      {
        printf("\e[48;2;0;0;0m");
      }
      if (selected != NULL && selected->x == x && selected->y == y)
      {
        printf("\e[46m");
      }
      printf("\e[1m%s ", pieceSymbols[board[y][x]]);
    }
    printf("\n");
  }
}

char upper(char c)
{
  return (c >= 'a' && c <= 'z') ? c - 'a' + 'A' : c;
}

BoardCoords BoardCoords_input()
{
  char input[3];
  char x_char;
  char y_char;
  do
  {
    scanf("%2s", input);
    x_char = upper(input[0]);
    y_char = input[1];
  } while (x_char < 'A' || x_char > 'H' || y_char < '1' || y_char > '8');

  BoardCoords coords;
  coords.x = x_char - 'A';
  coords.y = 7 - (y_char - '1');

  return coords;
}

bool Board_valid_move(Board board, Piece piece, BoardCoords *pos, BoardCoords *move)
{
  if (move->x > 7 || move->x < 0 || move->y > 7 || move->y < 0)
    return false;

  switch (piece)
  {
  case PIECE_WHITE_PAWN:
    if (move->x == pos->x && move->y == pos->y - 1 && pos->y > 0 && board[move->y][move->x] == PIECE_CLEAR)
      // Move forward
      return true;
    if (move->x == pos->x && move->y == pos->y - 2 && pos->y == 6 && board[pos->y - 1][move->x] == PIECE_CLEAR && board[move->y][move->x] == PIECE_CLEAR)
      // Move 2 forward from beginning
      return true;
    if (abs(move->x - pos->x) == 1 && move->y == pos->y - 1 && Piece_is_black(board[move->y][move->x]))
      // Eat diag
      return true;
    break;

  case PIECE_BLACK_PAWN:
    if (move->x == pos->x && move->y == pos->y + 1 && pos->y < 7 && board[move->y][move->x] == PIECE_CLEAR)
      // Move forward
      return true;
    if (move->x == pos->x && move->y == pos->y + 2 && pos->y == 2 && board[pos->y + 1][move->x] == PIECE_CLEAR && board[move->y][move->x] == PIECE_CLEAR)
      // Move 2 forward from beginning
      return true;
    if (abs(move->x - pos->x) == 1 && move->y == pos->y + 1 && Piece_is_white(board[move->y][move->x]))
      // Eat diag
      return true;
    break;

  case PIECE_WHITE_KING:
    if (abs(move->x - pos->x) + abs(move->y - pos->y) == 1 && board[move->y][move->x] == PIECE_CLEAR)
      // Move straight one
      return true;
    break;
  }

  return false;
}

int main()
{
  Board board = {
      {
          PIECE_BLACK_ROOK,
          PIECE_BLACK_KNIGHT,
          PIECE_BLACK_BISHOP,
          PIECE_BLACK_KING,
          PIECE_BLACK_QUEEN,
          PIECE_BLACK_BISHOP,
          PIECE_BLACK_KNIGHT,
          PIECE_BLACK_ROOK,
      },
      {
          PIECE_BLACK_PAWN,
          PIECE_BLACK_PAWN,
          PIECE_BLACK_PAWN,
          PIECE_BLACK_PAWN,
          PIECE_BLACK_PAWN,
          PIECE_BLACK_PAWN,
          PIECE_BLACK_PAWN,
          PIECE_BLACK_PAWN,
      },
      {
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
      },
      {
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
      },
      {
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
      },
      {
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
          PIECE_CLEAR,
      },
      {
          PIECE_WHITE_PAWN,
          PIECE_WHITE_PAWN,
          PIECE_WHITE_PAWN,
          PIECE_WHITE_PAWN,
          PIECE_WHITE_PAWN,
          PIECE_WHITE_PAWN,
          PIECE_WHITE_PAWN,
          PIECE_WHITE_PAWN,
      },
      {
          PIECE_WHITE_ROOK,
          PIECE_WHITE_KNIGHT,
          PIECE_WHITE_BISHOP,
          PIECE_WHITE_KING,
          PIECE_WHITE_QUEEN,
          PIECE_WHITE_BISHOP,
          PIECE_WHITE_KNIGHT,
          PIECE_WHITE_ROOK,
      },
  };

  bool whiteTurn = true;

  while (true)
  {
    Board_print(board, NULL);

    if (whiteTurn)
    {
      printf("Player White\n");
    }
    else
    {
      printf("Player Black\n");
    }

    BoardCoords pos;
    BoardCoords move;

    Piece piece;

    do
    {
      printf("Enter the position you want to move: ");

      pos = BoardCoords_input();

      printf("Selected %d, %d\n", pos.x, pos.y);

      piece = board[pos.y][pos.x];

      if (whiteTurn ? !Piece_is_white(piece) : !Piece_is_black(piece))
      {
        printf("Please select one of your pieces.\n");
        continue;
      }

      break;
    } while (true);

    Board_print(board, &pos);

    do
    {
      printf("Enter the position you want to move to: ");

      move = BoardCoords_input();

      if (!Board_valid_move(board, piece, &pos, &move))
      {
        printf("Please enter a valid move.\n");
        continue;
      }

      break;
    } while (true);

    board[pos.y][pos.x] = PIECE_CLEAR;
    board[move.y][move.x] = piece;

    whiteTurn = !whiteTurn;
  }

  return 0;
}
