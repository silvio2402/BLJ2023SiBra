import java.util.ArrayList;

public class CoordinateSystem {
  public int width;
  public int height;

  private ArrayList<CSObject> objects = new ArrayList<CSObject>();

  public CoordinateSystem(int width, int height) {
    // check if width and height are positive
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width and height must be positive");
    }

    // check if width and height are divisible by 20
    if (width % 20 != 0 || height % 20 != 0) {
      throw new IllegalArgumentException("Width and height must be divisible by 20");
    }

    this.width = width;
    this.height = height;
  }

  public int getCoordinateSystemSize() {
    return Math.max(width, height);
  }

  public void addObject(CSObject object) {
    objects.add(object);
  }

  public ArrayList<CSObject> getObjects() {
    return objects;
  }

  public double getDistance(CSPoint p1, CSPoint p2) {
    return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
  }

  public double getSlope(CSPoint p1, CSPoint p2) {
    return (p2.y - p1.y) / (p2.x - p1.x);
  }
}
