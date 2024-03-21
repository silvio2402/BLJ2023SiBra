package Vehicle;

public class SmallCar extends Vehicle {
  public int seats;
  public int trunkCapacity;

  public SmallCar(String name, int manufactureYear, String vin, double newPrice, double currentPrice,
      Integer odometer, int seats, int trunkCapacity) {
    super(name, manufactureYear, vin, newPrice, currentPrice, odometer);
    this.seats = seats;
    this.trunkCapacity = trunkCapacity;
  }

  public void printVehicle() {
    super.printVehicle();
    System.out.println("Seats: " + seats);
    System.out.println("Trunk capacity: " + trunkCapacity);
  }
}
