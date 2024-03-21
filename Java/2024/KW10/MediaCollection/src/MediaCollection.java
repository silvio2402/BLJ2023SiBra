import java.util.HashSet;

import Media.Media;

public class MediaCollection extends HashSet<Media> {
  private String name;

  public MediaCollection(String name) {
    this.name = name;
  }

  public void displayDetails() {
    System.out.println("Name: " + name);
    System.out.println("Number of items: " + this.size());
    for (Media item : this) {
      System.out.println("*".repeat(20));
      item.displayDetails();
      System.out.println("*".repeat(20));
      System.out.println();
    }
  }
}
