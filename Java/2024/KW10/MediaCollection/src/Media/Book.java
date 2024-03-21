package Media;

import java.util.Date;
import java.util.List;

public class Book extends Media {
  public String isbn;
  public int pageCount;

  public Book(String title, List<String> genres, Date publicationDate, int rating, String description,
      List<String> creators, String language, String isbn, int pageCount) {
    super(title, genres, publicationDate, rating, description, creators, language);
    this.isbn = isbn;
    this.pageCount = pageCount;
  }

  @Override
  public void displayDetails() {
    super.displayDetails();
    System.out.println("ISBN: " + isbn);
    System.out.println("Page Count: " + pageCount);
  }
}