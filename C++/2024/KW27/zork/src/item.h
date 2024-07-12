#pragma once

#include <iostream>
#include <list>
#include <memory>

#include "location.h"

using std::list;
using std::shared_ptr;
using std::string;

class Item {
 private:
 public:
  shared_ptr<Location> location;
  string name;
  bool unlocked;
  bool taken;

  Item(string name);

  void Action(string action);

  void NotImplemented();
  // possible actions
  virtual void Take();
  virtual void Use();
};

class TakeableItem : public Item {
 private:
 public:
  TakeableItem(string name);

  void Take() override;
};

class SwordItem : public TakeableItem {
 private:
 public:
  SwordItem();

  void Use() override;
};
