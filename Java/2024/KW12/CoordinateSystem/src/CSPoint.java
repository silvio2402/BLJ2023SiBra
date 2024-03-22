import java.awt.Point;

public class CSPoint extends Point {
  private static int sequence = 0;

  private int id;

  public CSPoint(int x, int y) {
    super(x, y);

    this.id = sequence++;
  }

  public CSPoint() {
    this(0, 0);
  }
}
