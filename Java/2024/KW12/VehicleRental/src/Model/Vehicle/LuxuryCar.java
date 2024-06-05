package Model.Vehicle;

public class LuxuryCar extends Vehicle {
  public int horsePower;

  public LuxuryCar(String name, int manufactureYear, String vin, double newPrice, double currentPrice,
      Integer odometer, int horsePower) {
    super(name, manufactureYear, vin, newPrice, currentPrice, odometer);
  }

  public void printVehicle() {
    super.printVehicle();
    System.out.println("Horse power: " + horsePower);
  }
}
