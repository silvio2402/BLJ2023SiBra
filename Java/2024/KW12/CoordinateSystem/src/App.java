public class App {
    public static void main(String[] args) {
        CoordinateSystem cs = new CoordinateSystem(500, 500);

        new CSRenderer(cs, 2, 8);

        CSPoint p1 = new CSPoint(-100, -100);
        CSPoint p2 = new CSPoint(100, 100);
        CSPoint p3 = new CSPoint(-100, 100);
        CSPoint p4 = new CSPoint(100, -100);

        cs.addPoint(p1);
        cs.addPoint(p2);
        cs.addPoint(p3);
        cs.addPoint(p4);

        CSLineSegment l1 = new CSLineSegment(p1, p2);
        CSLineSegment l2 = new CSLineSegment(p3, p4);

        cs.addLineSegment(l1);
        cs.addLineSegment(l2);
    }
}
