package Vehicle;

public class Truck extends Vehicle {
  public int payloadCapacity;

  public Truck(String name, int manufactureYear, String vin, double newPrice, double currentPrice,
      Integer odometer, int payloadCapacity) {
    super(name, manufactureYear, vin, newPrice, currentPrice, odometer);
    this.payloadCapacity = payloadCapacity;
  }

  public void printVehicle() {
    super.printVehicle();
    System.out.println("Payload capacity: " + payloadCapacity);
  }
}
