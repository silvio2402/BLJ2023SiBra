package Vehicle;

public abstract class Vehicle {
  public String name;
  public int manufactureYear;
  public String vin;
  public double newPrice;
  public double currentPrice;
  public Integer odometer;

  public Vehicle(String name, int manufactureYear, String vin, double newPrice, double currentPrice, Integer odometer) {
    this.name = name;
    this.manufactureYear = manufactureYear;
    this.vin = vin;
    this.newPrice = newPrice;
    this.currentPrice = currentPrice;
    this.odometer = odometer;
  }

  public void printVehicle() {
    System.out.println("Name: " + name);
    System.out.println("Manufacture year: " + manufactureYear);
    System.out.println("VIN: " + vin);
    System.out.println("New price: " + newPrice);
    System.out.println("Current price: " + currentPrice);
    System.out.println("Odometer: " + odometer);
  }
}
