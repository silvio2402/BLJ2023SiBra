#ifndef LINKEDLIST_H
#define LINKEDLIST_H

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct Data
{
  int value;
} TData;

typedef struct Node
{
  TData data;
  struct Node *next;
} TNode;

TNode *append_node(TNode *head, TData data);

TNode *insert_node(TNode *head, size_t index, TData data);

TNode *remove_node(TNode *head, size_t index, bool free_node);

TNode *random_linkedlist(size_t size);

size_t count_linkedlist(TNode *head);

TNode *get_node(TNode *head, size_t index);

void free_linkedlist();

void print_linkedlist(TNode *head);

#endif // LINKEDLIST_H