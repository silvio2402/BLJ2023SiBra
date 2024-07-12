#include "main.h"

#include <iostream>

#include "game.h"
using std::cout;
using std::endl;

int main(int argc, char **argv) {
  cout << "Hello, World!" << endl;

  Game game;

  game.Play();

  return EXIT_SUCCESS;
}
