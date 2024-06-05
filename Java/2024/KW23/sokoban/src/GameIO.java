
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameIO extends JFrame {

  private Game game;
  private BufferedImage displayArea;

  private int scale;

  private final Map<Integer, Runnable> inputMap;

  private static BufferedImage FLOOR_IMAGE;
  private static BufferedImage WALL_IMAGE;
  private static BufferedImage PLAYER_IMAGE;
  private static BufferedImage BOX_IMAGE;
  private static BufferedImage GOAL_IMAGE;
  private static BufferedImage BOX_ON_GOAL_IMAGE;

  public GameIO(Game game, int scale) {
    this.game = game;
    this.scale = scale;

    inputMap = Map.of(KeyEvent.VK_UP, game::moveUp, KeyEvent.VK_DOWN, game::moveDown,
        KeyEvent.VK_LEFT, game::moveLeft, KeyEvent.VK_RIGHT, game::moveRight, KeyEvent.VK_ESCAPE,
        game::resetField);

    loadImages();

    initInput();
    initOutput();
    updateOutput();
  }

  private void loadImages() {
    try {
      FLOOR_IMAGE = ImageIO.read(getClass().getResourceAsStream("/resources/floor.png"));
      WALL_IMAGE = ImageIO.read(getClass().getResourceAsStream("/resources/wall.png"));
      PLAYER_IMAGE = ImageIO.read(getClass().getResourceAsStream("/resources/player.png"));
      BOX_IMAGE = ImageIO.read(getClass().getResourceAsStream("/resources/box.png"));
      GOAL_IMAGE = ImageIO.read(getClass().getResourceAsStream("/resources/goal.png"));
      BOX_ON_GOAL_IMAGE = ImageIO.read(getClass().getResourceAsStream("/resources/box_on_goal.png"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void initOutput() {
    displayArea = new BufferedImage(game.getRowCount() * scale, game.getColCount() * scale,
        BufferedImage.TYPE_INT_ARGB);

    this.getContentPane().add(new JLabel(new ImageIcon(displayArea)));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("Sokoban");
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  private void initInput() {
    this.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (inputMap.containsKey(e.getKeyCode())) {
          inputMap.get(e.getKeyCode()).run();
          updateOutput();
        }
      }
    });
  }

  private void updateOutput() {
    Graphics2D g2d = (Graphics2D) displayArea.getGraphics();

    for (int x = 0; x < game.getRowCount(); x++) {
      for (int y = 0; y < game.getColCount(); y++) {
        int scaledX = x * scale;
        int scaledY = y * scale;

        byte field = game.getField()[y][x];

        if ((field & game.WALL_MASK) > 0) {
          g2d.drawImage(WALL_IMAGE, scaledX, scaledY, scale, scale, null);
        } else {
          g2d.drawImage(FLOOR_IMAGE, scaledX, scaledY, scale, scale, null);
        }

        if ((field & game.PLAYER_MASK) > 0) {
          g2d.drawImage(PLAYER_IMAGE, scaledX, scaledY, scale, scale, null);
        }

        if ((field & game.BOX_MASK) > 0) {
          if ((field & game.GOAL_MASK) > 0) {
            g2d.drawImage(BOX_ON_GOAL_IMAGE, scaledX, scaledY, scale, scale, null);
          } else {
            g2d.drawImage(BOX_IMAGE, scaledX, scaledY, scale, scale, null);
          }
        } else if ((field & game.GOAL_MASK) > 0) {
          g2d.drawImage(GOAL_IMAGE, scaledX, scaledY, scale, scale, null);
        }
      }
    }

    g2d.dispose();

    repaint();
  }
}
