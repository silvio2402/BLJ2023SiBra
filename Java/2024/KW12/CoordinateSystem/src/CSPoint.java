import java.awt.Color;
import java.awt.Graphics2D;

public class CSPoint implements CSObject {
  public int x;
  public int y;
  public Color color;

  public CSPoint(int x, int y) {
    this(x, y, Color.BLACK);
  }

  public CSPoint(int x, int y, Color color) {
    this.x = x;
    this.y = y;
    this.color = color;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public void paint(Graphics2D g2d) {
    g2d.setColor(color);
    g2d.drawLine(x, y, x, y);
  }

  @Override
  public String toString() {
    return String.format("CSPoint[x=%d, y=%d]", x, y);
  }
}
