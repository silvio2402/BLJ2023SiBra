#pragma once

#include <iostream>
#include <list>
#include <memory>

using std::list;
using std::shared_ptr;
using std::string;

class Location {
 private:
 public:
  string name;
  string first_visit_message;
  string description;
  bool visited;
  shared_ptr<Location> north;
  shared_ptr<Location> south;
  shared_ptr<Location> east;
  shared_ptr<Location> west;

  Location(string name, string first_visit_message, string description);

  void PrintVisit();
};