import java.awt.Color;

public class App {
    public static void main(String[] args) {
        CoordinateSystem cs = new CoordinateSystem(500, 500);

        new CSRenderer(cs, 2, 3);

        cs.addObject(new CSPoint(-50, 100, Color.RED));
        cs.addObject(new CSCircle(100, 100, 50, Color.BLUE));
        cs.addObject(new CSLine(-30, -50, 60, 80, Color.GREEN));
        cs.addObject(new CSRectangle(0, 0, 100, 100, Color.YELLOW));
    }
}
