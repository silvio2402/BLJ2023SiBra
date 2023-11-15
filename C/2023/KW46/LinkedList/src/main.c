#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <linkedlist.h>

int main()
{
  TNode *head = random_linkedlist(10);

  print_linkedlist(head);

  printf("Remove node at index 5\n");
  head = remove_node(head, 5, true);

  print_linkedlist(head);

  printf("Insert node at index 5\n");
  TData data = {.value = 99};
  head = insert_node(head, 5, data);

  print_linkedlist(head);

  printf("Append node\n");
  data.value = 100;
  head = append_node(head, data);

  print_linkedlist(head);

  TNode *node = get_node(head, 5);
  printf("Node at index 5: %d\n", node->data.value);

  printf("Node count: %zu\n", count_linkedlist(head));

  free_linkedlist(head);

  return EXIT_SUCCESS;
}
