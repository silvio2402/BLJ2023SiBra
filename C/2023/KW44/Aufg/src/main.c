#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

void swappy(int *a, int *b);

int main()
{
  int x = 3;
  int y = 4;

  printf("x: %d, y: %d\n", x, y);

  swappy(&x, &y);

  printf("x: %d, y: %d\n", x, y);

  return EXIT_SUCCESS;
}

void swappy(int *a, int *b)
{
  int tmp = *a;
  *a = *b;
  *b = tmp;
}
