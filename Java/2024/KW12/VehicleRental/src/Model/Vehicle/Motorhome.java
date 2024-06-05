package Model.Vehicle;

public class Motorhome extends Vehicle {
  public int waterCapacity;

  public Motorhome(String name, int manufactureYear, String vin, double newPrice, double currentPrice,
      Integer odometer, int waterCapacity) {
    super(name, manufactureYear, vin, newPrice, currentPrice, odometer);
    this.waterCapacity = waterCapacity;
  }

  public void printVehicle() {
    super.printVehicle();
    System.out.println("Water capacity: " + waterCapacity);
  }
}
