import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("--- Stoffwechselrate ---");

        System.out.print("Körpergewicht (kg): ");
        double weight = in.nextDouble();
        in.nextLine();

        System.out.print("Grösse (cm): ");
        double height = in.nextDouble();
        in.nextLine();

        System.out.print("Alter (Jahre): ");
        int age = in.nextInt();
        in.nextLine();

        System.out.print("Geschlecht (m/w): ");
        char gender = in.next().charAt(0);
        in.nextLine();

        double b;
        double mm;
        double ml;
        double mt;

        if (gender == 'm') {
            b = 66.47;
            mm = 13.7;
            ml = 5;
            mt = 6.8;
        } else {
            b = 655.1;
            mm = 9.6;
            ml = 1.8;
            mt = 4.7;
        }

        double g = b + (mm * weight) + (ml * height) - (mt * age);

        System.out.println("Grundumsatz: " + Math.round(g * 100) / 100 + " kcal pro Tag");

        in.close();
    }
}
