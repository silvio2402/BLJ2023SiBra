package Media;

import java.util.Date;
import java.util.List;

public class VideoGame extends Media {
  public List<String> platforms;
  public boolean multiplayer;

  public VideoGame(String title, List<String> genres, Date publicationDate, int rating, String description,
      List<String> creators, String language, List<String> platforms, boolean multiplayer) {
    super(title, genres, publicationDate, rating, description, creators, language);
    this.platforms = platforms;
    this.multiplayer = multiplayer;
  }

  public void displayDetails() {
    super.displayDetails();
    System.out.println("Platforms: " + String.join(", ", platforms));
    System.out.println("Multiplayer: " + (multiplayer ? "Yes" : "No"));
  }
}