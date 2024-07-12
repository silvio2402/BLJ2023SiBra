#pragma once

#include <iostream>
#include <list>
#include <memory>

#include "inventory.h"
#include "location.h"
using std::list;
using std::string;
using std::unique_ptr;

class Game {
 private:
 public:
  list<shared_ptr<Item>> items;
  shared_ptr<Location> location;

  Game();

  void Play();
  void ParseCommand(string command);
  void LoadLocations();
  void PrintVisit();
  void PrintInventory();
  void GoNorth();
  void GoSouth();
  void GoEast();
  void GoWest();
};