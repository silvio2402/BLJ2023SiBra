import java.awt.Color;
import java.awt.Graphics2D;

public class CSLine implements CSObject {
  public int x1;
  public int y1;
  public int x2;
  public int y2;
  public Color color;

  public CSLine(int x1, int y1, int x2, int y2) {
    this(x1, y1, x2, y2, Color.BLACK);
  }

  public CSLine(int x1, int y1, int x2, int y2, Color color) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.color = color;
  }

  @Override
  public void paint(Graphics2D g2d) {
    g2d.setColor(color);
    g2d.drawLine(x1, y1, x2, y2);
  }

  @Override
  public String toString() {
    return String.format("CSLine[x1=%d, y1=%d, x2=%d, y2=%d]", x1, y1, x2, y2);
  }
}
