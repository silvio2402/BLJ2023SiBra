#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <windows.h>
#include <time.h>

#define COLS 4
#define ROWS 4

#define WINDOW_WIDTH 500
#define WINDOW_HEIGHT 500

#define ABS(x) (((x) < 0) ? -(x) : (x))

unsigned int board[ROWS][COLS];

const char g_szClassName[] = "myWindowClass";

void PaintWindow(HWND hwnd)
{
  PAINTSTRUCT ps;
  HDC hdc = BeginPaint(hwnd, &ps);
  HPEN hPen = CreatePen(PS_NULL, 3, RGB(0, 0, 0));
  SelectObject(hdc, hPen);
  HBRUSH hBrush = SelectObject(hdc, GetStockObject(DC_BRUSH));

  HFONT hFont = CreateFont(50, 0, 0, 0, FW_NORMAL, FALSE, FALSE, FALSE, DEFAULT_CHARSET, OUT_OUTLINE_PRECIS,
                           CLIP_DEFAULT_PRECIS, CLEARTYPE_QUALITY, VARIABLE_PITCH, TEXT("Arial"));
  SelectObject(hdc, hFont);

  RECT rect;
  GetClientRect(hwnd, &rect);

  int width = rect.right - rect.left;
  int height = rect.bottom - rect.top;

  int cellWidth = width / COLS;
  int cellHeight = height / ROWS;

  for (size_t y = 0; y < ROWS; y++)
  {
    for (size_t x = 0; x < COLS; x++)
    {
      RECT cellRect;
      cellRect.left = x * cellWidth;
      cellRect.top = y * cellHeight;
      cellRect.right = cellRect.left + cellWidth;
      cellRect.bottom = cellRect.top + cellHeight;

      unsigned int num = board[y][x];

      bool isEmpty = num == 0;
      bool isRed = !isEmpty && ((num - 1) % COLS + (num - 1) / COLS) % 2 == 0;

      COLORREF color;

      if (isRed)
        color = RGB(255, 32, 32);
      else
        color = RGB(255, 255, 255);

      SetDCBrushColor(hdc, color);
      SetBkColor(hdc, color);

      char numstr[5];
      sprintf(numstr, "%d", num);

      if (!isEmpty)
      {
        Rectangle(hdc, cellRect.left, cellRect.top, cellRect.right, cellRect.bottom);
        DrawTextExA(hdc, numstr, -1, &cellRect, DT_NOCLIP | DT_CENTER | DT_SINGLELINE | DT_VCENTER, NULL);
      }
    }
  }

  // SelectObject(hdc, hPen);
  SelectObject(hdc, hBrush);
  EndPaint(hwnd, &ps);
}

void HandleLMouseClick(HWND hwnd, POINT pt)
{
  RECT rect;
  GetClientRect(hwnd, &rect);

  int width = rect.right - rect.left;
  int height = rect.bottom - rect.top;

  int cellWidth = width / COLS;
  int cellHeight = height / ROWS;

  int x = pt.x / cellWidth;
  int y = pt.y / cellHeight;

  int emptyX;
  int emptyY;

  for (size_t y = 0; y < ROWS; y++)
    for (size_t x = 0; x < COLS; x++)
      if (board[y][x] == 0)
      {
        emptyX = x;
        emptyY = y;
      }

  if (ABS(x - emptyX) + ABS(y - emptyY) == 1)
  {
    unsigned int temp = board[y][x];
    board[y][x] = board[emptyY][emptyX];
    board[emptyY][emptyX] = temp;
  }

  InvalidateRect(hwnd, NULL, true);
}

void RandomizeBoard()
{
  for (unsigned int i = 0; i < ROWS * COLS; i++)
  {
    board[i / COLS][i % COLS] = i + 1;
    if (i == ROWS * COLS - 1)
      board[i / COLS][i % COLS] = 0;
  }

  int emptyX;
  int emptyY;

  for (size_t y = 0; y < ROWS; y++)
    for (size_t x = 0; x < COLS; x++)
      if (board[y][x] == 0)
      {
        emptyX = x;
        emptyY = y;
      }

  // scramble
  unsigned int i = 0;
  while (i < ROWS * COLS * 100)
  {
    unsigned int r = rand() % 4;
    int switchX = r == 0 ? emptyX - 1 : r == 1 ? emptyX + 1
                                               : emptyX;
    int switchY = r == 2 ? emptyY - 1 : r == 3 ? emptyY + 1
                                               : emptyY;

    if (switchX >= 0 && switchX < COLS && switchY >= 0 && switchY < ROWS)
    {
      unsigned int temp = board[switchY][switchX];
      board[switchY][switchX] = board[emptyY][emptyX];
      board[emptyY][emptyX] = temp;

      emptyX = switchX;
      emptyY = switchY;

      i++;
    }
  }
}

// Step 4: the Window Procedure
LRESULT CALLBACK WndProc(HWND hwnd, UINT msg, WPARAM wParam, LPARAM lParam)
{
  switch (msg)
  {
  case WM_CREATE:
    HMENU hMenu, hSubMenu;

    hMenu = CreateMenu();
    AppendMenu(hMenu, MF_STRING, 1, "&Randomize");

    SetMenu(hwnd, hMenu);

    break;
  case WM_COMMAND:
    switch (LOWORD(wParam))
    {
    case 1:
      RandomizeBoard();
      InvalidateRect(hwnd, NULL, true);
      break;
    }
    break;
  case WM_SIZE:
    InvalidateRect(hwnd, NULL, true);
    break;
  case WM_PAINT:
    PaintWindow(hwnd);
    break;
  case WM_LBUTTONDOWN:
    // get the mouse position
    POINT pt;
    pt.x = LOWORD(lParam);
    pt.y = HIWORD(lParam);

    HandleLMouseClick(hwnd, pt);
    break;
  case WM_CLOSE:
    DestroyWindow(hwnd);
    break;
  case WM_DESTROY:
    PostQuitMessage(0);
    break;
  default:
    return DefWindowProc(hwnd, msg, wParam, lParam);
  }
  return 0;
}

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow)
{
  srand(time(NULL));

  WNDCLASSEX wc;
  HWND hwnd;
  MSG Msg;

  // Step 1: Registering the Window Class
  wc.cbSize = sizeof(WNDCLASSEX);
  wc.style = 0;
  wc.lpfnWndProc = WndProc;
  wc.cbClsExtra = 0;
  wc.cbWndExtra = 0;
  wc.hInstance = hInstance;
  wc.hIcon = LoadIcon(NULL, IDI_APPLICATION);
  wc.hCursor = LoadCursor(NULL, IDC_ARROW);
  HBRUSH hBgBrush = CreateSolidBrush(RGB(32, 32, 32));
  wc.hbrBackground = hBgBrush;
  wc.lpszMenuName = NULL;
  wc.lpszClassName = g_szClassName;
  wc.hIconSm = LoadIcon(NULL, IDI_APPLICATION);

  if (!RegisterClassEx(&wc))
  {
    // get last error
    char error[256];
    FormatMessage(FORMAT_MESSAGE_FROM_SYSTEM, NULL, GetLastError(), 0, error, 256, NULL);
    MessageBox(NULL, error, "Error!", MB_ICONEXCLAMATION | MB_OK);
    return 0;
  }

  // Step 2: Creating the Window
  hwnd = CreateWindowEx(
      WS_EX_CLIENTEDGE,
      g_szClassName,
      "Sliding Puzzle",
      WS_OVERLAPPEDWINDOW,
      CW_USEDEFAULT, CW_USEDEFAULT,
      WINDOW_WIDTH, WINDOW_WIDTH,
      NULL, NULL, hInstance, NULL);

  if (hwnd == NULL)
  {
    MessageBox(NULL, "Window Creation Failed!", "Error!", MB_ICONEXCLAMATION | MB_OK);
    return 0;
  }

  RandomizeBoard();

  ShowWindow(hwnd, nCmdShow);
  UpdateWindow(hwnd);

  // Step 3: The Message Loop
  while (GetMessage(&Msg, NULL, 0, 0) > 0)
  {
    TranslateMessage(&Msg);
    DispatchMessage(&Msg);
  }
  return Msg.wParam;
}
