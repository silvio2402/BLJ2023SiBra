#include <stdio.h>
#include <stdint.h>
#include <stdbool.h>
#include <time.h>
#include <stdlib.h>

char upper(char c)
{
  return (c >= 'a' && c <= 'z') ? c - 'a' + 'A' : c;
}

const unsigned int MAX_GUESS = 100;
const int MAX_ROUNDS = 10; // -1 for unlimited

int main()
{
  srand(time(NULL));

  printf("\n\e[31;1m");
  printf(" (                              )    )                                 )             \n");
  printf(" )\\ )      (     (           ( /( ( /(    (             (      )    ( /(    (   (    \n");
  printf("(()/(     ))\\   ))\\ (   (    )\\()))\\())  ))\\    (      ))\\    (     )\\())  ))\\  )(   \n");
  printf(" /(_))_  /((_) /((_))\\  )\\  (_))/((_)\\  /((_)   )\\ )  /((_)   )\\  '((_)\\  /((_)(()\\  \n");
  printf("(_)) __|(_))( (_)) ((_)((_) | |_ | |(_)(_))    _(_/( (_))(  _((_)) | |(_)(_))   ((_) \n");
  printf("  | (_ || || |/ -_)(_-<(_-< |  _|| ' \\ / -_)  | ' \\))| || || '  \\()| '_ \\/ -_) | '_| \n");
  printf("   \\___| \\_,_|\\___|/__//__/  \\__||_||_|\\___|  |_||_|  \\_,_||_|_|_| |_.__/\\___| |_|\n");
  printf("\e[0m\n");

  bool wantsToPlay = true;

  while (wantsToPlay)
  {
    unsigned int rounds = 0;

    unsigned int r = (rand() % MAX_GUESS) + 1;

    while (true)
    {
      if (MAX_ROUNDS >= 0 && rounds >= MAX_ROUNDS)
      {
        printf("Max rounds reached. The number was %u.\e[0m\n", r);
        break;
      }

      int guess = -1;
      do
      {
        printf("Guess a number between 1 and %u: ", MAX_GUESS);
        scanf("%d", &guess);
      } while (guess < 1 || guess > MAX_GUESS);

      rounds++;

      if (guess < r)
      {
        printf("Try higher!\n");
        continue;
      }
      else if (guess > r)
      {
        printf("Try lower!\n");
        continue;
      }
      else
      {
        printf("\e[32mCorrect! The number was %u.\e[0m\n", r);
        break;
      }
    }

    char playAgainStr[2];
    do
    {
      printf("Do you want to play again (y/n)? ");
      scanf("%1s", playAgainStr);
      playAgainStr[0] = upper(playAgainStr[0]);
    } while (playAgainStr[0] != 'Y' && playAgainStr[0] != 'N');

    wantsToPlay = (playAgainStr[0] == 'Y');
  }

  return 0;
}
