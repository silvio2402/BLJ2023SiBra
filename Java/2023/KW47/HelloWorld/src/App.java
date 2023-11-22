import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("Hello, World!");

        // int a = in.nextInt();
        // System.out.println(a);

        System.out.println("--- Dogs ---");

        Dog fido = new Dog("Fido", "Labrador", "Brown", 2015);
        Dog lassie = new Dog("Lassie", "Collie", "Brown", 2010);
        Dog rex = new Dog("Rex", "German Shepherd", "Black", 2018);
        Dog clifford = new Dog("Clifford", "Big Red Dog", "Red", 2000);

        ArrayList<Dog> dogs = new ArrayList<Dog>();

        dogs.add(fido);
        dogs.add(lassie);
        dogs.add(rex);
        dogs.add(clifford);

        for (Dog dog : dogs) {
            System.out.println(dog.name);
        }

        in.close();
    }
}
