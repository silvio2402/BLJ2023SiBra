package Media;

import java.util.Date;
import java.util.List;

public abstract class Media {
  public String title;
  public List<String> genres;
  public Date publicationDate;
  public int rating;
  public String description;
  public List<String> creators;
  public String language;

  public Media(String title, List<String> genres, Date publicationDate, int rating, String description,
      List<String> creators, String language) {
    this.title = title;
    this.genres = genres;
    this.publicationDate = publicationDate;
    this.rating = rating;
    this.description = description;
    this.creators = creators;
    this.language = language;
  }

  public void displayDetails() {
    System.out.println("Title: " + title);
    System.out.println("Genres: " + String.join(", ", genres));
    System.out.println("Publication Date: " + publicationDate);
    System.out.println("Rating: " + rating);
    System.out.println("Description: " + description);
    System.out.println("Creators: " + String.join(", ", creators));
    System.out.println("Language: " + language);
  }
}