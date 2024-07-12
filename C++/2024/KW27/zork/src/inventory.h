#pragma once

#include <iostream>
#include <list>
#include <memory>

#include "item.h"
using std::list;
using std::shared_ptr;
using std::string;

class Inventory {
 private:
 public:
  list<shared_ptr<Item>> items;

  Inventory();

  void Print();
  void Add(shared_ptr<Item> item);
};
