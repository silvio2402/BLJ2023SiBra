import java.awt.Color;
import java.awt.Graphics2D;

public class CSCircle implements CSObject {
  public int x;
  public int y;
  public int r;
  public Color color;

  public CSCircle(int x, int y, int r) {
    this(x, y, r, Color.BLACK);
  }

  public CSCircle(int x, int y, int r, Color color) {
    this.x = x;
    this.y = y;
    this.r = r;
    this.color = color;
  }

  @Override
  public void paint(Graphics2D g2d) {
    g2d.setColor(color);
    g2d.drawOval(x - r, y - r, 2 * r, 2 * r);
  }

  @Override
  public String toString() {
    return String.format("CSCircle[x=%d, y=%d, r=%d]", x, y, r);
  }
}
