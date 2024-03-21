package Contract;

import java.time.LocalDate;

import Person.Person;
import Vehicle.Vehicle;

public class RentalContract extends Contract {
  public Person renter;
  public Vehicle vehicle;
  public LocalDate startDate;
  public LocalDate endDate;
  public double price;

  public RentalContract(Person renter, Vehicle vehicle, LocalDate startDate, LocalDate endDate, double price) {
    this.renter = renter;
    this.vehicle = vehicle;
    this.startDate = startDate;
    this.endDate = endDate;
    this.price = price;
  }

  public void printContract() {
    System.out.println("Renter: " + renter.getFullName());
    System.out.println("Vehicle: " + vehicle.name);
    System.out.println("Start date: " + startDate);
    System.out.println("End date: " + endDate);
    System.out.println("Price: " + price);
  }
}
