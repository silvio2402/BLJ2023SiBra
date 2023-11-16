#include <linkedlist.h>

TNode *append_node(TNode *head, TData data)
{
  TNode *new_node = malloc(sizeof(TNode));
  new_node->data = data;
  new_node->next = NULL;
  new_node->prev = NULL;

  if (head == NULL)
    return new_node;

  TNode *current = head;

  while (current->next != NULL)
    current = current->next;

  current->next = new_node;
  new_node->prev = current;

  return head;
}

TNode *insert_node(TNode *head, size_t index, TData data)
{
  if (head == NULL && index != 0)
    return NULL;

  TNode *new_node = malloc(sizeof(TNode));
  new_node->data = data;
  new_node->next = NULL;
  new_node->prev = NULL;

  if (index == 0)
  {
    new_node->next = head;
    if (head != NULL)
      head->prev = new_node;
    return new_node;
  }

  TNode *current = get_node(head, index - 1);
  if (current == NULL)
    return head;

  new_node->next = current->next;
  new_node->prev = current;
  if (current->next != NULL)
    current->next->prev = new_node;
  current->next = new_node;

  return head;
}

TNode *remove_node(TNode *head, size_t index, bool free_node)
{
  if (head == NULL)
    return NULL;

  TNode *to_remove = (index == 0) ? head : get_node(head, index);
  if (to_remove == NULL)
    return head;

  if (to_remove->prev != NULL)
    to_remove->prev->next = to_remove->next;
  else
    head = to_remove->next;

  if (to_remove->next != NULL)
    to_remove->next->prev = to_remove->prev;

  if (free_node)
    free(to_remove);

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
      printf(" ⇆ ");

    printf("%d", current->data.value);

    current = current->next;
  }
  printf("\n");
}
