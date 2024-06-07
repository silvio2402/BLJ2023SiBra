package ch.noseryoung;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

public class GameTest {
  @Test
  public void test_moveRight_fromFloor_toFloor() {
    byte[][] actual = { { Game.PLAYER_MASK, 0, 0 } };
    byte[][] expected = { { 0, Game.PLAYER_MASK, 0 } };

    Game game = new Game(actual);
    game.moveRight();
    assertArrayEquals(expected, game.getField());
  }

  @Test
  public void test_moveRight_fromFloor_toWall() {
    byte[][] actual = { { Game.PLAYER_MASK, Game.WALL_MASK, 0 } };
    byte[][] expected = { { Game.PLAYER_MASK, Game.WALL_MASK, 0 } };

    Game game = new Game(actual);
    game.moveRight();
    assertArrayEquals(expected, game.getField());
  }

  @Test
  public void test_moveRight_fromFloor_toGoal() {
    byte[][] actual = { { Game.PLAYER_MASK, Game.GOAL_MASK, 0 } };
    byte[][] expected = { { 0, Game.PLAYER_MASK | Game.GOAL_MASK, 0 } };

    Game game = new Game(actual);
    game.moveRight();
    assertArrayEquals(expected, game.getField());
  }

  @Test
  public void test_moveRight_fromFloor_toGoal_toFloor() {
    byte[][] actual = { { Game.PLAYER_MASK, Game.GOAL_MASK, 0 } };
    byte[][] expected = { { 0, Game.GOAL_MASK, Game.PLAYER_MASK } };

    Game game = new Game(actual);
    game.moveRight();
    game.moveRight();
    assertArrayEquals(expected, game.getField());
  }

  @Test
  public void test_moveRight_fromFloor_toBox() {
    byte[][] actual = { { Game.PLAYER_MASK, Game.BOX_MASK, 0 } };
    byte[][] expected = { { 0, Game.PLAYER_MASK, Game.BOX_MASK } };

    Game game = new Game(actual);
    game.moveRight();
    assertArrayEquals(expected, game.getField());
  }

  @Test
  public void test_moveRight_fromFloor_toBoxBox() {
    byte[][] actual = { { Game.PLAYER_MASK, Game.BOX_MASK, Game.BOX_MASK } };
    byte[][] expected = { { Game.PLAYER_MASK, Game.BOX_MASK, Game.BOX_MASK } };

    Game game = new Game(actual);
    game.moveRight();
    assertArrayEquals(expected, game.getField());
  }

  @Test
  public void test_moveRight_fromFloor_toBoxWall() {
    byte[][] actual = { { Game.PLAYER_MASK, Game.BOX_MASK, Game.WALL_MASK } };
    byte[][] expected = { { Game.PLAYER_MASK, Game.BOX_MASK, Game.WALL_MASK } };

    Game game = new Game(actual);
    game.moveRight();
    assertArrayEquals(expected, game.getField());
  }

  @Test
  public void test_moveRight_fromFloor_toBoxGoal() {
    byte[][] actual = { { Game.PLAYER_MASK, Game.BOX_MASK, Game.GOAL_MASK } };
    byte[][] expected = { { 0, Game.PLAYER_MASK, Game.BOX_MASK | Game.GOAL_MASK } };

    Game game = new Game(actual);
    game.moveRight();
    assertArrayEquals(expected, game.getField());
  }

  @Test
  public void test_moveRight_fromFloor_toOutside() {
    byte[][] actual = { { 0, 0, Game.PLAYER_MASK } };
    byte[][] expected = { { 0, 0, Game.PLAYER_MASK } };

    Game game = new Game(actual);
    game.moveRight();
    assertArrayEquals(expected, game.getField());
  }

  @Test
  public void test_moveRight_fromFloor_toBoxOutside() {
    byte[][] actual = { { 0, Game.PLAYER_MASK, Game.BOX_MASK } };
    byte[][] expected = { { 0, Game.PLAYER_MASK, Game.BOX_MASK } };

    Game game = new Game(actual);
    game.moveRight();
    assertArrayEquals(expected, game.getField());
  }
}
