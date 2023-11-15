#include <linkedlist.h>

TNode *append_node(TNode *head, TData data)
{
  TNode *new_node = malloc(sizeof(TNode));
  new_node->data = data;
  new_node->next = NULL;

  if (head == NULL)
    return new_node;

  TNode *current = head;

  while (current->next != NULL)
    current = current->next;

  current->next = new_node;

  return head;
}

TNode *insert_node(TNode *head, size_t index, TData data)
{
  if (head == NULL)
    return NULL;

  if (index == 0)
  {
    TNode *new_node = append_node(NULL, data);
    return new_node;
  }

  TNode *current = get_node(head, index - 1);

  TNode *new_node = append_node(NULL, data);
  new_node->next = current->next;
  current->next = new_node;

  return head;
}

TNode *remove_node(TNode *head, size_t index, bool free_node)
{
  if (head == NULL)
    return NULL;

  if (index == 0)
  {
    TNode *next = head->next;
    if (free_node)
      free(head);
    return next;
  }

  TNode *before = get_node(head, index - 1);

  TNode *after = before->next->next;

  if (free_node)
    free(before->next);

  before->next = after;

  return head;
}

TNode *random_linkedlist(size_t size)
{
  TNode *head = NULL;

  for (int i = 0; i < size; i++)
  {
    TData new_data = {.value = rand() % 100};
    head = append_node(head, new_data);
  }

  return head;
}

size_t count_linkedlist(TNode *head)
{
  size_t count = 0;
  TNode *current = head;

  while (current != NULL)
  {
    count++;
    current = current->next;
  }

  return count;
}

TNode *get_node(TNode *head, size_t index)
{
  if (head == NULL)
    return NULL;

  TNode *current = head;

  for (size_t i = 0; i < index; i++)
  {
    if (current->next == NULL)
      return NULL;

    current = current->next;
  }

  return current;
}

void free_linkedlist()
{
  TNode *head = NULL;
  TNode *current = head;

  while (current != NULL)
  {
    TNode *next = current->next;
    free(current);
    current = next;
  }
}

void print_linkedlist(TNode *head)
{
  TNode *current = head;

  while (current != NULL)
  {
    if (current != head)
      printf(" → ");

    printf("%d", current->data.value);

    current = current->next;
  }
  printf("\n");
}
