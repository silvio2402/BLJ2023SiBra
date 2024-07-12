#include "game.h"

#include <iostream>
#include <list>
#include <memory>
using std::cin;
using std::cout;
using std::endl;
using std::list;
using std::make_shared;
using std::move;
using std::string;
using std::unique_ptr;

Game::Game() {
  location = nullptr;
  LoadLocations();
  PrintVisit();
}

void Game::Play() {
  while (true) {
    cout << "> ";

    string in;
    getline(cin, in);

    ParseCommand(in);
  }
}

void Game::ParseCommand(string in) {
  if (in.rfind("go", 0) == 0) {
    auto arg = in.substr(3);
    if (arg == "north")
      GoNorth();
    else if (arg == "south")
      GoSouth();
    else if (arg == "east")
      GoEast();
    else if (arg == "west")
      GoWest();
    else
      cout << "I don't understand that direction." << endl;
  } else if (in == "inventory") {
    PrintInventory();
  } else {
    auto space_i = in.find(' ');
    if (space_i != string::npos) {
      auto verb = in.substr(0, space_i);
      auto arg = in.substr(space_i + 1);

      for (auto &item : items) {
        if ((item->location == location || item->taken) && item->name == arg) {
          item->Action(verb);
          return;
        }
      }
      cout << "You don't have that item." << endl;
      return;
    }
    cout << "I don't understand that command." << endl;
  }
}

void Game::LoadLocations() {
  // Create the locations
  auto the_forest_clearing = make_shared<Location>(
      "The Forest Clearing",
      "You step into a serene forest clearing, bathed in dappled sunlight.",
      "The clearing is peaceful, with birds chirping and a gentle breeze "
      "rustling the leaves. A rusted sword lies half-buried in the ground.");

  auto sword = make_shared<SwordItem>();
  sword->unlocked = true;
  sword->location = the_forest_clearing;
  items.emplace_back(move(sword));

  auto the_dark_cave = make_shared<Location>(
      "The Dark Cave",
      "You cautiously enter the dark cave, feeling the air cool around you.",
      "The cave is damp and echoing, with the sound of dripping water. A "
      "small, glowing crystal catches your eye in the darkness.");

  auto crystal = make_shared<TakeableItem>("crystal");
  crystal->unlocked = true;
  crystal->location = the_dark_cave;
  items.emplace_back(move(crystal));

  auto the_spooky_woods = make_shared<Location>(
      "The Spooky Woods",
      "You push through thick, tangled undergrowth into the eerie woods.",
      "The woods are filled with twisted trees and strange shadows. An old, "
      "moth-eaten map is pinned to a tree trunk.");

  auto map = make_shared<TakeableItem>("map");
  map->unlocked = true;
  map->location = the_spooky_woods;
  items.emplace_back(move(map));

  auto the_riverbank = make_shared<Location>(
      "The Riverbank",
      "You arrive at the riverbank, where the water flows swiftly.",
      "The riverbank is lined with smooth stones and a gentle slope. A fishing "
      "rod leans against a tree stump.");

  auto rod = make_shared<TakeableItem>("rod");
  rod->unlocked = true;
  rod->location = the_riverbank;
  items.emplace_back(move(rod));

  auto the_abandoned_hut =
      make_shared<Location>("The Abandoned Hut",
                            "You push open the creaky door of the abandoned hut, dust "
                            "swirling in the air.",
                            "The hut is dilapidated, with broken furniture and cobwebs. "
                            "A rusty key hangs from a nail on the wall.");

  auto key = make_shared<TakeableItem>("key");
  key->unlocked = true;
  key->location = the_abandoned_hut;
  items.emplace_back(move(key));

  // Link locations
  the_forest_clearing->north = the_dark_cave;
  the_forest_clearing->west = the_spooky_woods;
  the_forest_clearing->east = the_riverbank;

  the_dark_cave->south = the_forest_clearing;

  the_spooky_woods->east = the_forest_clearing;

  the_riverbank->west = the_forest_clearing;
  the_riverbank->east = the_abandoned_hut;

  the_abandoned_hut->west = the_riverbank;

  /*
  | ----------- | -------------- | --------- | ------------ |
  |             | darkCave       |           |              |
  | spookyWoods | forestClearing | riverbank | abandonedHut |
  */

  location = the_forest_clearing;
}

void Game::PrintVisit() {
  this->location->PrintVisit();
}

void Game::PrintInventory() {
  cout << "Inventory:" << endl;
  for (auto &item : items) {
    cout << item->name << endl;
  }
}

void Game::GoNorth() {
  if (location->north == nullptr) {
    cout << "You can't go that way." << endl;
    return;
  }

  cout << "You go north." << endl;
  location = location->north;

  this->PrintVisit();
}

void Game::GoSouth() {
  if (location->south == nullptr) {
    cout << "You can't go that way." << endl;
    return;
  }

  cout << "You go south." << endl;
  location = location->south;

  this->PrintVisit();
}

void Game::GoEast() {
  if (location->east == nullptr) {
    cout << "You can't go that way." << endl;
    return;
  }

  cout << "You go east." << endl;
  location = location->east;

  this->PrintVisit();
}

void Game::GoWest() {
  if (location->west == nullptr) {
    cout << "You can't go that way." << endl;
    return;
  }

  cout << "You go west." << endl;
  location = location->west;

  this->PrintVisit();
}
