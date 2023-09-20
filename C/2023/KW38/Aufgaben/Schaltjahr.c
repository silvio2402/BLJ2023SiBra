#include <stdio.h>
#include <stdbool.h>

bool isLeapYear(int year);
int daysInMonth(int month, int year);
void printDateInfo(int month, int year);

int main()
{
  int month = 10;
  int year = 1997;

  // todo get user input for month and year
  // todo third

  printf("Geben Sie das Jahr an: ");
  scanf("%d", &year);

  printf("Geben Sie den Monat an: ");
  scanf("%d", &month);

  printDateInfo(month, year);

  return 0;
}

bool isLeapYear(int year)
{
  // todo first
  // returns 1 if isLeapYear
  // returns 0 if is no LeapYear
  if (year % 4 != 0)
    return false;

  if (year % 100 != 0)
    return true;

  if (year % 400 != 0)
    return false;

  return true;
}

int daysInMonth(int month, int year)
{
  // to do second
  // returns 30, 31, 28 or 29
  if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
  {
    return 31;
  }
  else if (month == 4 || month == 6 || month == 9 || month == 11)
  {
    return 30;
  }
  else
  {
    if (isLeapYear(year))
    {
      return 29;
    }
    else
    {
      return 28;
    }
  }
}

void printDateInfo(int month, int year)
{
  int days = daysInMonth(month, year);

  printf("Der Monat %d hat im Jahr %d %d Tage. \n", month, year, days);

  printf("Das Jahr %d ist ", year);
  if (!isLeapYear(year))
  {
    printf("kein ");
  }
  else
  {
    printf("ein ");
  }
  printf("Schaltjahr. \n");
}
