import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

public class AutomatonRenderer extends JPanel {
  private Automaton automaton;

  private JScrollPane scrollPane;
  private JFrame mainFrame;

  private int scale;

  public AutomatonRenderer(Automaton automaton, int scale) {
    this.automaton = automaton;
    this.scale = scale;

    int preferredWidth = automaton.getCurrentGeneration().length() * scale;
    int preferredHeight = automaton.getHistory().size() * scale;

    int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

    this.setPreferredSize(new Dimension(preferredWidth, preferredHeight));

    scrollPane = new JScrollPane(this);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    mainFrame = new JFrame("Elementary Cellular Automaton - Rule " + automaton.getIntegerRule());
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.add(scrollPane);

    if (preferredWidth > screenWidth) {
      mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    mainFrame.setSize(screenWidth / 2, screenHeight / 2);
    mainFrame.setLocationRelativeTo(null);

    initKeyControls();
    mainFrame.setVisible(true);
  }

  private void initKeyControls() {
    mainFrame.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
          System.exit(0);
        } else if (e.getKeyCode() == KeyEvent.VK_PAGE_UP) {
          scale++;
        } else if (e.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
          scale = Math.max(1, --scale);
        }

        int preferredWidth = automaton.getCurrentGeneration().length() * scale;
        int preferredHeight = automaton.getHistory().size() * scale;
        AutomatonRenderer.this.setPreferredSize(new Dimension(preferredWidth, preferredHeight));

        revalidate();
        repaint();
      }
    });
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    g2d.setStroke(new BasicStroke(scale));
    g2d.setColor(Color.BLACK);

    for (int y = 0; y < automaton.getHistory().size(); y++) {
      for (int x = 0; x < automaton.getCurrentGeneration().length(); x++) {
        if (automaton.getHistory().get(y).charAt(x) == '1') {
          g2d.drawLine(x * scale, y * scale, x * scale, y * scale);
        }
      }
    }
  }
}
