import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        Set<Person> people = new HashSet<Person>();

        while (true) {
            System.out.println("1. Add person");
            System.out.println("2. Remove person");
            System.out.println("3. List people");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            String choice = in.nextLine();

            if (choice.equals("1")) {
                System.out.println("--- Add person ---");

                System.out.print("First name: ");
                String firstNameInput = in.nextLine();
                String firstName;
                if (firstNameInput.length() > 0)
                    firstName = firstNameInput;
                else
                    firstName = null;

                System.out.print("Last name: ");
                String lastNameInput = in.nextLine();
                String lastName;
                if (lastNameInput.length() > 0)
                    lastName = lastNameInput;
                else
                    lastName = null;

                System.out.print("Birth year: ");
                String birthYearInput = in.nextLine();
                Integer birthYear;
                if (birthYearInput.length() > 0)
                    birthYear = Integer.parseInt(birthYearInput);
                else
                    birthYear = null;

                System.out.print("Height: ");
                String heightInput = in.nextLine();
                Float height;
                if (heightInput.length() > 0)
                    height = Float.parseFloat(heightInput);
                else
                    height = null;

                System.out.print("Weight: ");
                String weightInput = in.nextLine();
                Float weight;
                if (weightInput.length() > 0)
                    weight = Float.parseFloat(weightInput);
                else
                    weight = null;

                System.out.print("Phone number: ");
                String phoneNumberInput = in.nextLine();
                String phoneNumber;
                if (phoneNumberInput.length() > 0)
                    phoneNumber = phoneNumberInput;
                else
                    phoneNumber = null;

                System.out.print("Email: ");
                String emailInput = in.nextLine();
                String email;
                if (emailInput.length() > 0)
                    email = emailInput;
                else
                    email = null;

                System.out.print("Address: ");
                String addressInput = in.nextLine();
                String address;
                if (addressInput.length() > 0)
                    address = addressInput;
                else
                    address = null;

                Person person = new Person(firstName, lastName, birthYear, height, weight, phoneNumber, email, address);

                people.add(person);

                System.out.println("Person added!");

                System.out.println("------------------");
            } else if (choice.equals("2")) {
                System.out.println("--- Remove person ---");

                System.out.print("First name: ");
                String firstNameInput = in.nextLine();
                String firstName;
                if (firstNameInput.length() > 0)
                    firstName = firstNameInput;
                else
                    firstName = null;

                System.out.print("Last name: ");
                String lastNameInput = in.nextLine();
                String lastName;
                if (lastNameInput.length() > 0)
                    lastName = lastNameInput;
                else
                    lastName = null;

                Integer removed = 0;

                for (Person person : people) {
                    if ((firstName == null || firstName.equals(person.firstName))
                            && (lastName == null || lastName.equals(person.lastName))) {
                        people.remove(person);
                        removed++;
                        break;
                    }
                }

                if (removed == 0)
                    System.out.println("Person not found!");
                else if (removed == 1)
                    System.out.println("Person removed!");
                else
                    System.out.println("Removed " + removed + " people!");

                System.out.println("---------------------");
            } else if (choice.equals("3")) {
                System.out.println("--- People ---");

                for (Person person : people)
                    System.out.println(person.firstName + " " + person.lastName + " (" + person.birthYear + ")");

                System.out.println("--------------");
            } else if (choice.equals("4"))
                break;
            else {
                System.out.println("Invalid choice!");
                System.out.println("------------------");
            }

        }

        in.close();
    }
}
