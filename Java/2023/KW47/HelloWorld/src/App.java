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

        System.out.println("--- Cats ---");

        Cat garfield = new Cat("Garfield", "Tabby", "Orange", 2000);
        Cat tom = new Cat("Tom", "Tabby", "Grey", 2005);
        Cat sylvester = new Cat("Sylvester", "Tuxedo", "Black and White", 2010);
        Cat felix = new Cat("Felix", "Tuxedo", "Black and White", 2015);

        ArrayList<Cat> cats = new ArrayList<Cat>();

        cats.add(garfield);
        cats.add(tom);
        cats.add(sylvester);
        cats.add(felix);

        for (Cat cat : cats) {
            System.out.println(cat.name);
        }

        in.close();
    }
}
