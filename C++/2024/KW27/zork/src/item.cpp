#include "item.h"

#include <iostream>
using std::cout;
using std::endl;
using std::string;

/*
 * Item
 */
Item::Item(string name) : name(name) { unlocked = false; }

void Item::Action(string action) {
  if (action == "take")
    Take();
  else if (action == "use")
    Use();
  else {
    NotImplemented();
  }
}

/* Actions */
void Item::NotImplemented() {
  cout << "You can't do that with the " << name << "." << endl;
}

void Item::Take() { NotImplemented(); }

void Item::Use() { NotImplemented(); }

/*
 * TakeableItem
 */
TakeableItem::TakeableItem(string name) : Item(name) { taken = false; }

/* Actions */
void TakeableItem::Take() {
  cout << "You take the " << name << "." << endl;
  taken = true;
}

/*
 * SwordItem
 */
SwordItem::SwordItem() : TakeableItem("sword") {}

/* Actions */
void SwordItem::Use() {
  if (!taken) {
    cout << "You haven't taken the sword." << endl;
    return;
  }
  cout << "You swing the sword." << endl;
}
