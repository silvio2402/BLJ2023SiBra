package Exception;

public class LeaseLengthCollisionException extends Exception {
  public LeaseLengthCollisionException() {
    super("The rental period of the vehicle is in conflict another rental period.");
  }
}
