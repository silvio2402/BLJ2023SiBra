package Media;

import java.util.Date;
import java.util.List;

public class Movie extends Media {
  public int length;

  public Movie(String title, List<String> genres, Date publicationDate, int rating, String description,
      List<String> creators, String language, int length) {
    super(title, genres, publicationDate, rating, description, creators, language);
    this.length = length;
  }

  @Override
  public void displayDetails() {
    super.displayDetails();
    System.out.println("Length: " + length / 60 + ":" + length % 60);
  }
}