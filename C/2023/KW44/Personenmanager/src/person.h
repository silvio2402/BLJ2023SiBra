
#ifndef PERSON_H
#define PERSON_H

typedef struct Club
{
  char name[30 + 1];
  char topic[20 + 1];
} TClub;

typedef struct Person
{
  char name[50 + 1];
  int year;
  int weight;
  int height;
  TClub favorite_club;
} TPerson;

#endif // PERSON_H