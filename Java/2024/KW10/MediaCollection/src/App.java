import java.util.Scanner;

// import Media.*;

public class App {
  static MediaCollection collection = new MediaCollection("My Collection");
  static Scanner in = new Scanner(System.in);

  public static void main(String[] args) throws Exception {
    System.out.println("Would you like to 1. Add a media, 2. Display all media, or 3. Exit?");
    int choice = in.nextInt();
    switch (choice) {
      case 1:
        addMedia();
        break;
      case 2:
        displayMedia();
        break;
      case 3:
        System.exit(0);
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
        break;
    }
  }

  public static void addMedia() {
    System.out.println("What type of media would you like to add? 1. Book, 2. Movie, 3. Album");
    int choice = in.nextInt();
    switch (choice) {
      case 1:
        System.err.println("Books are not supported yet.");
        System.exit(1);
        break;
      case 2:
        System.err.println("Movies are not supported yet.");
        System.exit(1);
        break;
      case 3:
        System.err.println("Albums are not supported yet.");
        System.exit(1);
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
        break;
    }
  }

  public static void displayMedia() {
    collection.displayDetails();
  }
}
