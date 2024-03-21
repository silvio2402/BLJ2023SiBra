package Exception;

public class MinorAgeException extends Exception {
  public MinorAgeException() {
    super("You must be at least 18 years old.");
  }
}
