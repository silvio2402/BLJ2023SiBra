package Vehicle;

public class Trailer extends Vehicle {
  public double length;

  public Trailer(String name, int manufactureYear, String vin, double newPrice, double currentPrice, double length) {
    super(name, manufactureYear, vin, newPrice, currentPrice, null);
    this.length = length;
  }

  public void printVehicle() {
    super.printVehicle();
    System.out.println("Length: " + length);
  }
}
