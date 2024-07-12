#include "location.h"

#include <iostream>
using std::cout;
using std::endl;
using std::string;

Location::Location(string name, string first_visit_message, string description)
    : name(name),
      first_visit_message(first_visit_message),
      description(description) {
  visited = false;
  north = nullptr;
  south = nullptr;
  east = nullptr;
  west = nullptr;
}

void Location::PrintVisit() {
  cout << name << endl;

  if (!visited) {
    cout << first_visit_message << endl;
    visited = true;
  }

  cout << description << endl;
}
