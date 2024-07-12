#include "inventory.h"

#include <iostream>
using std::cout;
using std::endl;
using std::string;

Inventory::Inventory() {}

void Inventory::Print() {
  if (items.empty()) {
    cout << "You are empty-handed." << endl;
  } else {
    cout << "You are carrying:" << endl;
    for (auto &item : items) {
      cout << "  " << item->name << endl;
    }
  }
}

void Inventory::Add(shared_ptr<Item> item) { items.push_back(item); }
