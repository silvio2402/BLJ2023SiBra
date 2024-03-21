import java.util.HashSet;
import java.util.Set;

import Contract.Contract;
import Person.Person;
import Vehicle.Vehicle;

public class VehicleRentalManager {
  private Set<Person> customers = new HashSet<Person>();
  private Set<Vehicle> vehicles = new HashSet<Vehicle>();
  private Set<Person> blackList = new HashSet<Person>();
  private Set<Contract> contracts = new HashSet<Contract>();

  public void addCustomer(Person person) {
    customers.add(person);
  }

  public void addVehicle(Vehicle vehicle) {
    vehicles.add(vehicle);
  }

  public void addPersonToBlackList(Person person) {
    blackList.add(person);
  }

  public void addContract(Contract contract) {
    contracts.add(contract);
  }

  public void printVehicles() {
    for (Vehicle vehicle : vehicles) {
      System.out.println("-------------------");
      vehicle.printVehicle();
    }
  }

  public void printCustomers() {
    for (Person person : customers) {
      System.out.println("-------------------");
      person.printPerson();
    }
  }

  public void printContracts() {
    for (Contract contract : contracts) {
      System.out.println("-------------------");
      contract.printContract();
    }
  }
}
