#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#include "person.h"

TPerson family[4];

void initPerson(TPerson *person, char *name, int year, int weight, int height)
{
  strncpy(person->name, name, sizeof(person->name) - 1);
  person->year = year;
  person->weight = weight;
  person->height = height;
  TClub club;
  strncpy(club.name, "FCZ", sizeof(club.name) - 1);
  strncpy(club.topic, "Football", sizeof(club.topic) - 1);
  person->favorite_club = club;
}

void printPerson(TPerson *person)
{
  printf("%s, geb. %d, %dkg, %dcm, ", person->name, person->year, person->weight, person->height);
  printf("Favorite club: %s\n", person->favorite_club);
}

void initFamily()
{
  initPerson(&family[0], "John Doe", 1981, 91, 196);
  initPerson(&family[1], "Jane Doe", 1980, 64, 178);
  initPerson(&family[2], "Jack Doe", 2008, 40, 163);
  initPerson(&family[3], "Judy Doe", 2015, 30, 124);
}

void printFamily()
{
  for (int i = 0; i < sizeof(family) / sizeof(TPerson); i++)
    printPerson(&family[i]);
}

unsigned int findOldestFamilyMember()
{
  unsigned int oldest = 0;
  for (int i = 1; i < sizeof(family) / sizeof(TPerson); i++)
    if (family[i].year < family[oldest].year)
      oldest = i;
  return oldest;
}

int comparePersonsByField(TPerson *a, TPerson *b, char *field)
{
  if (strcmpi(field, "year") == 0)
    return a->year - b->year;
  if (strcmpi(field, "weight") == 0)
    return a->weight - b->weight;
  if (strcmpi(field, "height") == 0)
    return a->height - b->height;
  if (strcmpi(field, "name") == 0)
    return strcmp(a->name, b->name);
}

void sortFamily()
{
  char field[19 + 1];
  printf("Which field should be used for sorting? (name, year, weight, height): ");
  fgets(field, 19, stdin);
  if ((strlen(field) > 0) && (field[strlen(field) - 1] == '\n'))
    field[strlen(field) - 1] = '\0';
  fflush(stdin);

  unsigned int i = 0;
  bool swapped = false;

  while (true)
  {
    if (i + 1 >= (sizeof(family) / sizeof(TPerson)))
    {
      if (!swapped)
        break;

      i = 0;
      swapped = false;
      continue;
    }
    TPerson a = family[i];
    TPerson b = family[i + 1];
    if (comparePersonsByField(&a, &b, field) > 0)
    {
      // swap
      family[i] = b;
      family[i + 1] = a;
      swapped = true;
    }

    i++;
  }
}

int main()
{
  initFamily();

  sortFamily();

  printFamily();

  unsigned int oldest = findOldestFamilyMember();
  printf("Oldest family member: ");
  printPerson(&family[oldest]);

  return EXIT_SUCCESS;
}