
public class CSLineSegment {
  private CSPoint p1;
  private CSPoint p2;

  public CSLineSegment(CSPoint p1, CSPoint p2) {
    this.p1 = p1;
    this.p2 = p2;
  }

  public CSPoint getP1() {
    return p1;
  }

  public CSPoint getP2() {
    return p2;
  }
}