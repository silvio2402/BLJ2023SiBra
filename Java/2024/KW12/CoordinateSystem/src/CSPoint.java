import java.awt.Graphics2D;

public class CSPoint implements CSObject {
  private int x;
  private int y;

  public CSPoint(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public void paint(Graphics2D g2d) {
    g2d.drawLine(x, y, x, y);
  }

  @Override
  public String toString() {
    return String.format("CSPoint[x=%d, y=%d]", x, y);
  }
}
