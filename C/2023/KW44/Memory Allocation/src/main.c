#include <stdio.h>

int main()
{
  int *nums = malloc(5 * sizeof(int));

  if (nums == NULL)
  {
    return 1;
  }

  for (int i = 0; i < 5; i++)
  {
    nums[i] = i;
  }

  if (nums != NULL)
  {
    free(nums);
    nums = NULL;
  }

  return 0;
}