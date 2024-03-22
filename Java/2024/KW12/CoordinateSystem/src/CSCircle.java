import java.awt.Graphics2D;

public class CSCircle implements CSObject {
  public int x;
  public int y;
  public int r;

  public CSCircle(int x, int y, int r) {
    this.x = x;
    this.y = y;
    this.r = r;
  }

  @Override
  public void paint(Graphics2D g2d) {
    g2d.drawOval(x - r, y - r, 2 * r, 2 * r);
  }

  @Override
  public String toString() {
    return String.format("CSCircle[x=%d, y=%d, r=%d]", x, y, r);
  }
}
