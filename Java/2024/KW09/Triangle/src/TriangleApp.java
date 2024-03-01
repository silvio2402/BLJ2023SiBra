
import java.time.LocalDate;
import java.util.Scanner;

// Import the exceptions
import exceptions.*;

public class TriangleApp {

  private String company;
  private String handler;

  private boolean isRunning;

  private String sideAInput;
  private String sideBInput;
  private String sideCInput;

  private double sideA;
  private double sideB;
  private double sideC;

  private String code;

  private static Scanner in = new Scanner(System.in);

  /**
   * The constructor.
   * 
   * @param company of type String to print in the application header
   * @param handler of type String to print in the application header
   */
  public TriangleApp(String company, String handler) {
    // Persist company and handler in the intended fields
    this.company = company;
    this.handler = handler;
    // Set field isRunning to true
    this.isRunning = true;
  }

  /**
   * This method starts the actual application. It will remain in a loop as long
   * as the field "isRunning" is true.
   */
  public void start() {
    printHeader();
    while (isRunning) {
      System.out.println("\nTEST CASES TRIANGLE\n");

      // Ask user for all 3 sides and assign to intended fields
      sideAInput = promptSide("A");
      sideBInput = promptSide("B");
      sideCInput = promptSide("C");

      try {
        validateInput();
        code = determineTriangleType();
      } catch (TriangleException e) {
        code = e.getMessage();
      } finally {
        printResult();
        promptAction();
      }
    }
  }

  /**
   * This method prints the application header.
   */
  private void printHeader() {
    // Print a fancy app header with handler, company and current year
    System.out.println("******************************");
    System.out.println("TEST CASES TRIANGLE");
    System.out.println("******************************");
    System.out.println("Company: " + company);
    System.out.println("Handler: " + handler);
    System.out.println("Year: " + LocalDate.now().getYear());
    System.out.println("******************************");
  }

  /**
   * This method prints the evaluated code in an aesthetically pleasing way.
   */
  private void printResult() {
    // Print code
    System.out.println("Code: " + code);
  }

  /**
   * This method prompts the user to give an input for a trinalge side.
   * 
   * @param side of type String to display as title for the prompt.
   * @return the input of type String.
   */
  private String promptSide(String side) {
    // Ask user for input
    System.out.print("Enter side " + side + ": ");
    return in.nextLine();
  }

  /**
   * This method prompts the user to give an input.<br>
   * "q": Quits the program.<br>
   * "c": Continues the program.<br>
   * else: Keeps asking for an input until "q" or "c" is entered.
   */
  private void promptAction() {
    String action = "";
    // Get valid prompt
    while (!action.equals("q") && !action.equals("c")) {
      System.out.print("Do you want to continue (c) or quit (q)? ");
      action = in.nextLine();
    }

    // Check if program needs to be cancelled (set isRunning to false)
    if (action.equals("q")) {
      isRunning = false;
    }

    System.out.println("******************************");
  }

  /**
   * This method validates the three entered values, to be used as sides for a
   * triangle.
   * 
   * @throws TriangleException if the validation fails. This means that the
   *                           entered values do not lead to a triangle.
   */
  private void validateInput() throws TriangleException {
    // IllegalTriangleSideException
    try {
      sideA = Double.parseDouble(sideAInput);
      // Do the same for sideB and SideC
      sideB = Double.parseDouble(sideBInput);
      sideC = Double.parseDouble(sideCInput);

    } catch (NumberFormatException nfe) {
      throw new IllegalTriangleSideException();
    }

    // ZeroTriangleSideException
    if (sideA == 0 || sideB == 0 || sideC == 0) {
      // throws ZeroTriangleSideException
      throw new ZeroTriangleSideException();
    }

    // Validate other triangle cases

    // NegativeTriangleSideException
    if (sideA < 0 || sideB < 0 || sideC < 0) {
      // throws NegativeTriangleSideException
      throw new NegativeTriangleSideException();
    }

    // ImpossibleTriangleException
    if (sideA + sideB < sideC || sideA + sideC < sideB || sideB + sideC < sideA) {
      // throws ImpossibleTriangleException
      throw new ImpossibleTriangleException();
    }

    // TriangleIsLineException
    if (sideA + sideB == sideC || sideA + sideC == sideB || sideB + sideC == sideA) {
      // throws TriangleIsLineException
      throw new TriangleIsLineException();
    }
  }

  /**
   * This method determines whether the three entered values lead to a
   * equilateral, isosceles, right-angled or scalene triangle.
   * 
   * @return The corresponding code for each triangle.
   */
  private String determineTriangleType() {
    // Based on sideA, sideB, sideC, return correct code
    // TRI84TF Gleichschenkliges Dreieck
    // TRI66TF Gleichseitiges Dreieck
    // TRI60TF Gewöhnliches Dreieck
    // TRI72TF Rechtwinkliges Dreieck

    if (sideA == sideB && sideB == sideC) {
      return "TRI66TF";
    } else if (sideA == sideB || sideA == sideC || sideB == sideC) {
      return "TRI84TF";
    } else if (Math.pow(sideA, 2) + Math.pow(sideB, 2) == Math.pow(sideC, 2)
        || Math.pow(sideA, 2) + Math.pow(sideC, 2) == Math.pow(sideB, 2)
        || Math.pow(sideB, 2) + Math.pow(sideC, 2) == Math.pow(sideA, 2)) {
      return "TRI72TF";
    } else {
      return "TRI60TF";
    }
  }
}
