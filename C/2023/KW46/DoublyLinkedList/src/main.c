#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <linkedlist.h>

int main()
{

  /* 1. To update the code for a doubly linked list, I first added a prev pointer to the TNode struct.
  Then I updated the append_node function to set the prev pointer of the new node to the last node in the list.
  I also updated the insert_node function to set the prev pointer of the new node to the node at the index before inserting the new node.
  Finally, I updated the remove_node function to set the prev pointer of the node after the removed node to the node before the removed node. */

  /* 2. The advantages of a doubly linked list are that it is easier to traverse the list backwards making it faster to work with big lists. */

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
