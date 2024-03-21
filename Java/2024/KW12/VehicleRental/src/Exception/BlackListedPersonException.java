package Exception;

public class BlackListedPersonException extends Exception {
  public BlackListedPersonException() {
    super("You are blacklisted from renting a vehicle.");
  }
}
