#include <stdio.h>
#include <time.h>
#include <stdlib.h>

/*
3, 5    -> 8
-4, -6  -> -10
0, 0    -> 0
*/
int sum(int a, int b)
{
  return a + b;
}

/*
0, 2, 3 -> 1.6666666
5, 5, 5 -> 5
5, 4, 3 -> 4
*/
float avg(int a, int b, int c)
{
  return (a + b + c) / 3.0;
}

/*
    -> print "Hello!"
*/
void say_hello()
{
  printf("Hello!\n");
}

/*
5   -> print "*****"
0   -> print ""
1   -> print "*"
*/
void print_stars(int count)
{
  for (unsigned int i = 0; i < count; i++)
  {
    printf("*");
  }
  printf("\n");
}

/*
0, 10   -> 3
0, 10   -> 7
0, 10   -> 0
*/
int random_num(int min, int max)
{
  return (rand() % (max - min + 1) + min);
}

/*
5   -> 0
2   -> 1
234 -> 1
*/
int is_even(int num)
{
  return (num % 2 == 0);
}

/*
0   -> 32
100 -> 212
-11 -> 12.2
*/
float celsius_to_fahrenheit(float celsius)
{
  return celsius * (9.0 / 5.0) + 32;
}

/*
32  -> 0
0   -> -17.7778
100 -> 37.7778
*/
float fahrenheit_to_celsius(float fahrenheit)
{
  return (fahrenheit - 32) * (5.0 / 9.0);
}

/*
1   -> print "#"
2   -> print "##"
              ##
5   -> print "#####"
              #   #
              #   #
              #   #
              #####
*/
void print_square(unsigned int size)
{
  for (unsigned int y = 0; y < size; y++)
  {
    for (unsigned int x = 0; x < size; x++)
    {
      if (y == 0 || y == size - 1)
      {
        printf("#");
      }
      else if (x == 0 || x == size - 1)
      {
        printf("#");
      }
      else
      {
        printf(" ");
      }
    }
    printf("\n");
  }
}

/*
(Eigenrecherche, was die Fibonacci Reihe ist)
*/
void fibonacci_recurse(unsigned int a, unsigned int b, unsigned int count)
{
  unsigned int new = a + b;
  printf("%d ", new);
  if (count > 0)
    fibonacci_recurse(b, new, count - 1);
}
int fibonacci_sequence(unsigned int count)
{
  printf("1 ");
  fibonacci_recurse(0, 1, count - 2);
  printf("\n");
}

/*
(Eigenrecherche, wie Primzahlen ermittelt werden können)
*/
int is_not_prime(unsigned int num)
{
  for (unsigned int i = 2; i < num; i++)
    if (num % i == 0)
      return i;

  return 0;
}

int main()
{
  srand(time(NULL));

  printf("Sum of 5 and 8: %d\n", sum(5, 8));

  printf("Average of 2, 9, and 27: %f\n", avg(2, 9, 27));

  say_hello();

  print_stars(10);

  printf("Random number between 5 and 25: %d\n", random_num(5, 25));

  printf("Is 99 even?: %d\n", is_even(99));

  printf("25C is: %fF\n", celsius_to_fahrenheit(25));

  printf("85F is: %fC\n", fahrenheit_to_celsius(85));

  print_square(10);

  fibonacci_sequence(10);

  printf("What can divide 99?: %d\n", is_not_prime(99));

  return 0;
}