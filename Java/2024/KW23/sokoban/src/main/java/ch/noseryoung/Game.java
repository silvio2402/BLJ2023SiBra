package ch.noseryoung;

enum Direction {
  UP, DOWN, LEFT, RIGHT
}

class Position {
  int x;
  int y;
}

public class Game {

  public static final byte WALL_MASK = 1 << 0; // 0000 0001
  public static final byte PLAYER_MASK = 1 << 1; // 0000 0010
  public static final byte GOAL_MASK = 1 << 2; // 0000 0100
  public static final byte BOX_MASK = 1 << 3; // 0000 1000

  private byte[][] gameField;
  private int level = 0;

  private boolean useLevels = true;

  public Game() {
    Levels.loadLevels();
    resetField();
  }

  public Game(byte[][] gameField) {
    this.gameField = gameField;
    this.useLevels = false;
  }

  public void moveUp() {
    System.out.println("UP");
    moveDirection(Direction.UP);
  }

  public void moveDown() {
    System.out.println("DOWN");
    moveDirection(Direction.DOWN);
  }

  public void moveLeft() {
    System.out.println("LEFT");
    moveDirection(Direction.LEFT);
  }

  public void moveRight() {
    System.out.println("RIGHT");
    moveDirection(Direction.RIGHT);
  }

  private boolean isOutOfBounds(Position position) {
    return position.x < 0 || position.x >= gameField.length || position.y < 0 || position.y >= gameField[0].length;
  }

  private void moveDirection(Direction direction) {
    Position playerPosition = getPlayerPosition();
    Position nextPosition = getNextPosition(playerPosition, direction);
    if (isOutOfBounds(nextPosition))
      return;
    if ((gameField[nextPosition.x][nextPosition.y] & WALL_MASK) > 0)
      return;

    if ((gameField[nextPosition.x][nextPosition.y] & BOX_MASK) > 0) {
      Position nextBoxPosition = getNextPosition(nextPosition, direction);
      if (isOutOfBounds(nextBoxPosition))
        return;
      if ((gameField[nextBoxPosition.x][nextBoxPosition.y] & WALL_MASK) > 0
          || (gameField[nextBoxPosition.x][nextBoxPosition.y] & BOX_MASK) > 0)
        return;

      gameField[nextBoxPosition.x][nextBoxPosition.y] |= BOX_MASK;
      gameField[nextPosition.x][nextPosition.y] &= ~BOX_MASK;
    }

    gameField[nextPosition.x][nextPosition.y] |= PLAYER_MASK;
    gameField[playerPosition.x][playerPosition.y] &= ~PLAYER_MASK;

    if (useLevels) {
      checkWin();
    }
  }

  private Position getNextPosition(Position firstPosition, Direction direction) {
    Position nextPosition = new Position();
    switch (direction) {
      case UP:
        nextPosition.x = firstPosition.x - 1;
        nextPosition.y = firstPosition.y;
        break;
      case DOWN:
        nextPosition.x = firstPosition.x + 1;
        nextPosition.y = firstPosition.y;
        break;
      case LEFT:
        nextPosition.x = firstPosition.x;
        nextPosition.y = firstPosition.y - 1;
        break;
      case RIGHT:
        nextPosition.x = firstPosition.x;
        nextPosition.y = firstPosition.y + 1;
        break;
    }
    return nextPosition;
  }

  private Position getPlayerPosition() {
    Position playerPosition = new Position();
    for (int x = 0; x < gameField.length; x++) {
      for (int y = 0; y < gameField[x].length; y++) {
        if ((gameField[x][y] & PLAYER_MASK) > 0) {
          playerPosition.x = x;
          playerPosition.y = y;
          return playerPosition;
        }
      }
    }
    return playerPosition;
  }

  public void resetField() {
    System.out.println("ESC");

    byte[][] levelToCopy = Levels.levels.get(level);

    gameField = java.util.Arrays.stream(levelToCopy).map(el -> el.clone()).toArray($ -> levelToCopy.clone());
  }

  public byte[][] getField() {
    return gameField;
  }

  public int getColCount() {
    return gameField.length;
  }

  public int getRowCount() {
    return gameField[0].length;
  }

  private void checkWin() {
    for (int x = 0; x < gameField.length; x++) {
      for (int y = 0; y < gameField[x].length; y++) {
        if ((gameField[x][y] & GOAL_MASK) > 0 && (gameField[x][y] & BOX_MASK) == 0) {
          return;
        }
      }
    }

    System.out.println("WIN");

    level++;
    if (level >= Levels.levels.size()) {
      level = 0;
    }
    resetField();
  }
}
