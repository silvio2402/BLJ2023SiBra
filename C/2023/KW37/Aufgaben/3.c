#include <stdio.h>

int main()
{
  // 2
  printf("Speicherbedarf char: %d Byte(s)\n", sizeof(char));               // char
  printf("Speicherbedarf short: %d Byte(s)\n", sizeof(short));             // short
  printf("Speicherbedarf int: %d Byte(s)\n", sizeof(int));                 // int
  printf("Speicherbedarf long: %d Byte(s)\n", sizeof(long));               // long
  printf("Speicherbedarf float: %d Byte(s)\n", sizeof(float));             // float
  printf("Speicherbedarf double: %d Byte(s)\n", sizeof(double));           // double
  printf("Speicherbedarf long double: %d Byte(s)\n", sizeof(long double)); // long double

  printf("\n");

  // 3
  char myChar = 'B';
  short myShort = 20000;
  int myInt = 900700134;
  long myLong = 2200900200;
  float myFloat = 90.678;
  double myDouble = 23423415.2359;
  long double mylongDouble = 234560987.23469722;

  // 4
  printf("Speicherbedarf myChar: %d Byte(s)\n", sizeof(myChar));             // myChar
  printf("Speicherbedarf myShort: %d Byte(s)\n", sizeof(myShort));           // myShort
  printf("Speicherbedarf myInt: %d Byte(s)\n", sizeof(myInt));               // myInt
  printf("Speicherbedarf myLong: %d Byte(s)\n", sizeof(myLong));             // myLong
  printf("Speicherbedarf myFloat: %d Byte(s)\n", sizeof(myFloat));           // myFloat
  printf("Speicherbedarf myDouble: %d Byte(s)\n", sizeof(myDouble));         // myDouble
  printf("Speicherbedarf mylongDouble: %d Byte(s)\n", sizeof(mylongDouble)); // mylongDouble

  printf("\n");

  // 5
  printf("myChar: %c\n", myChar);              // myChar
  printf("myShort: %hi\n", myShort);           // myShort
  printf("myInt: %d\n", myInt);                // myInt
  printf("myLong: %ld\n", myLong);             // myLong
  printf("myFloat: %e\n", myFloat);            // myFloat
  printf("myDouble: %e\n", myDouble);          // myDouble
  printf("mylongDouble: %Lf\n", mylongDouble); // mylongDouble

  printf("\n");

  // 6
  printf("myChar: %c\n", myChar);
  printf("myChar: %d\n", myChar);

  printf("\n");

  // 7

  printf("Variable\tZeichen\tdez\thex\tokt\n");
  printf("myChar\t[char]\t'%c'\t%d\t%x\t%o\n", myChar, myChar, myChar, myChar);
  printf("myShort\t[short]\t'%c'\t%d\t%x\t%o\n", myShort, myShort, myShort, myShort);
  printf("myInt\t[int]\t'%c'\t%d\t%x\t%o\n", myInt, myInt, myInt, myInt);
  printf("myLong\t[long]\t'%c'\t%d\t%x\t%o\n", myLong, myLong, myLong, myLong);
  printf("myFloat\t[float]\t'%c'\t%d\t%x\t%o\n", myFloat, myFloat, myFloat, myFloat);
  printf("myDouble\t[double]\t'%c'\t%d\t%x\t%o\n", myDouble, myDouble, myDouble, myDouble);
  printf("mylongDouble\t[long double]\t'%c'\t%d\t%x\t%o\n", mylongDouble, mylongDouble, mylongDouble, mylongDouble);

  printf("\n");

  myChar = '█';
  myShort = 789570117;
  myInt = 4499515600;
  myLong = 2767991154354;
  myFloat = 4128685544.70657734937873244095;
  myDouble = 46190058243374665995.55190301916190388323;
  mylongDouble = 162519000445362708643750402667.220342498170166817518782443909;

  printf("myChar: %c\n", myChar);              // myChar
  printf("myShort: %hi\n", myShort);           // myShort
  printf("myInt: %d\n", myInt);                // myInt
  printf("myLong: %ld\n", myLong);             // myLong
  printf("myFloat: %e\n", myFloat);            // myFloat
  printf("myDouble: %e\n", myDouble);          // myDouble
  printf("mylongDouble: %Lf\n", mylongDouble); // mylongDouble

  return 0;
}
