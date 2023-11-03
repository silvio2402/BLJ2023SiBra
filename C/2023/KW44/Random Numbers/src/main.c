#include <stdio.h>
#include <stdlib.h>

#define RANDNUM_COUNT "500"

void random_numbers(int *nums, unsigned int length, int min, int max)
{
  for (int i = 0; i < length; i++)
  {
    nums[i] = min + rand() % (max - min + 1);
  }
}

int main()
{
  unsigned int length = atoi(RANDNUM_COUNT);
  int *nums = malloc(length * sizeof(int));

  if (nums == NULL)
    return 1;

  random_numbers(nums, length, 10, 104);

  for (int i = 0; i < length; i++)
    printf("%d\n", nums[i]);

  if (nums != NULL)
  {
    free(nums);
    nums = NULL;
  }

  return 0;
}