public class App {
    public static void main(String[] args) {
        CoordinateSystem cs = new CoordinateSystem(500, 500);

        new CSRenderer(cs, 2, 3);

        cs.addObject(new CSPoint(0, 100));
        cs.addObject(new CSCircle(100, 100, 50));
        cs.addObject(new CSLine(-30, -50, 60, 80));
        cs.addObject(new CSPoint(0, 0));
    }
}
