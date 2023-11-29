import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("--- Baumstammvolumen ---");

        System.out.print("Durchmesser (cm): ");
        double d = in.nextDouble();
        in.nextLine();

        System.out.print("Länge (m): ");
        double l = in.nextDouble();
        in.nextLine();

        double v = (Math.PI * Math.pow(d, 2) * l) / 4 / 10000;

        System.out.println("Volumen: " + Math.round(v * 1000) / 1000.0);

        in.close();
    }
}
