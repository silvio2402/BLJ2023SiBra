public class App {
    public static void main(String[] args) {
        CoordinateSystem cs = new CoordinateSystem(500, 500);

        new CSRenderer(cs, 2, 8);

        CSPoint p1 = new CSPoint(0, 0);
        CSPoint p2 = new CSPoint(10, 10);
        CSPoint p3 = new CSPoint(-10, 10);
        CSPoint p4 = new CSPoint(10, -10);

        cs.addPoint(p1);
        cs.addPoint(p2);
        cs.addPoint(p3);
        cs.addPoint(p4);
    }
}
