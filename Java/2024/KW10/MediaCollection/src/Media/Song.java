package Media;

import java.util.Date;
import java.util.List;

public class Song extends Media {
  public String album;
  public int length;

  public Song(String title, List<String> genres, Date publicationDate, int rating, String description,
      List<String> creators, String language, String album, int length) {
    super(title, genres, publicationDate, rating, description, creators, language);
    this.album = album;
    this.length = length;
  }

  @Override
  public void displayDetails() {
    super.displayDetails();
    System.out.println("Album: " + album);
    System.out.println("Length: " + length / 60 + ":" + length % 60);
  }
}