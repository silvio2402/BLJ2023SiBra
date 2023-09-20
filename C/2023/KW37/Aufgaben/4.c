#include <stdio.h>

#define PI 3.1415926;

float g_r = 5.5;

int main()
{
  unsigned int n = 1000;

  // 1
  printf("Dezimal:\t%d\n", n);
  printf("Oktal:\t \t0%o\n", n);
  printf("Hexadecimal:\t0x%x\n", n);

  printf("\n");

  // 2
  printf("Radius: %0.01f\n", g_r);

  float u = 2 * g_r * PI;
  printf("Umfang: %0.01f\n", u);

  printf("\n");

  // 3
  unsigned int x = 0xff;
  unsigned int y = 023;

  printf("%d\n", x);
  printf("%d\n", y);

  printf("\n");

  // 6
  double a;

  a = 2 / 3;
  printf("%0.1f\n", a);

  a = (double)2 / 3;
  printf("%.1lf\n", a);

  printf("\n");

  // 7
  a = 0;
  int i = 0;
  for (i = 0; i < 10; i++)
  {
    a = a + 1;
  }
  printf("%.1lf\n", a);
  if (a == 10)
  {
    printf("Das Resultat ist 1.0\n");
  }

  return 0;
}
