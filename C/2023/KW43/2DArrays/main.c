#include <stdio.h>
#include <stdlib.h>

typedef unsigned int matrix_value;

int main()
{
  unsigned int rows = 5;
  unsigned int cols = 6;

  matrix_value *matrix = (matrix_value *)malloc(rows * cols * sizeof(matrix_value));

  for (unsigned int i = 0; i < rows; i++)
    for (unsigned int j = 0; j < cols; j++)
      matrix[i * cols + j] = 1 + i * cols + j;

  for (unsigned int i = 0; i < rows; i++)
  {
    for (unsigned int j = 0; j < cols; j++)
    {
      printf("%.2d ", matrix[i * cols + j]);
    }
    printf("\n");
  }

  free(matrix);
}