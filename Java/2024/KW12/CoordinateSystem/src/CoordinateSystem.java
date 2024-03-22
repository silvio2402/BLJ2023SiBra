import java.util.ArrayList;

public class CoordinateSystem {
  public int width;
  public int height;

  private ArrayList<CSPoint> points = new ArrayList<CSPoint>();
  private ArrayList<CSLineSegment> lineSegments = new ArrayList<CSLineSegment>();

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

  public void addPoint(CSPoint point) {
    points.add(point);
  }

  public void addLineSegment(CSLineSegment lineSegment) {
    lineSegments.add(lineSegment);
  }

  public ArrayList<CSPoint> getPoints() {
    return points;
  }

  public ArrayList<CSLineSegment> getLineSegments() {
    return lineSegments;
  }
}
