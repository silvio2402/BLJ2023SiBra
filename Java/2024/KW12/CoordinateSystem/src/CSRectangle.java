import java.awt.Color;
import java.awt.Graphics2D;

public class CSRectangle implements CSObject {
  public int x;
  public int y;
  public int w;
  public int h;
  public Color color;

  public CSRectangle(int x, int y, int w, int h) {
    this(x, y, w, h, Color.BLACK);
  }

  public CSRectangle(int x, int y, int w, int h, Color color) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.color = color;
  }

  @Override
  public void paint(Graphics2D g2d) {
    g2d.setColor(color);
    g2d.drawRect(x, y, w, h);
  }

  public String toString() {
    return String.format("CSRectangle[x=%d, y=%d, w=%d, h=%d]", x, y, w, h);
  }
}
