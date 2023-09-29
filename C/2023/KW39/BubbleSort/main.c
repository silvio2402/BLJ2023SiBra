#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>
#include <math.h>

long millis()
{
  struct timespec spec;
  if (clock_gettime(1, &spec) == -1)
  { /* 1 is CLOCK_MONOTONIC */
    abort();
  }

  return spec.tv_sec * 1000 + spec.tv_nsec / 1e6;
}

void bubble_sort(double *array, unsigned int len)
{
  unsigned int i = 0;
  bool swapped = false;

  while (true)
  {
    if (i + 1 >= len)
    {
      if (!swapped)
      {
        break;
      }

      i = 0;
      swapped = false;
      continue;
    }
    double a = array[i];
    double b = array[i + 1];
    if (a > b)
    {
      // swap
      array[i] = b;
      array[i + 1] = a;
      swapped = true;
    }

    i++;
  }
}

double *array_rand(unsigned int len)
{
  double *array = (double *)malloc(len * sizeof(double));
  for (unsigned int i = 0; i < len; i++)
  {
    array[i] = ((rand() % 400) - 200) / (double)4;
  }
  return array;
}

void array_print(double *array, unsigned int len)
{
  printf("[");
  for (unsigned int i = 0; i < len; i++)
    printf("%g, ", array[i]);
  printf("]\n");
}

int main()
{
  srand(time(NULL));

  unsigned int len = 100;
  double *array = array_rand(len);

  array_print(array, len);

  long start = millis();
  bubble_sort(array, len);
  long end = millis();

  array_print(array, len);

  long diff = end - start;
  printf("It took %ldms\n", diff);

  free(array);
}
