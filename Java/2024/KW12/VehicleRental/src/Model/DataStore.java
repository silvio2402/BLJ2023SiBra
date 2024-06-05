package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.Contract.*;
import Model.Person.*;
import Model.Vehicle.*;

public class DataStore {
  private static List<Person> customers = new ArrayList<Person>();
  private static List<Vehicle> vehicles = new ArrayList<Vehicle>();
  private static List<Person> blackList = new ArrayList<Person>();
  private static List<Contract> contracts = new ArrayList<Contract>();

  public static List<Person> getCustomers() {
    return customers;
  }

  public static List<Vehicle> getVehicles() {
    return vehicles;
  }

  public static List<Person> getBlackList() {
    return blackList;
  }

  public static List<Contract> getContracts() {
    return contracts;
  }

  public static void addCustomer(Person person) {
    customers.add(person);
  }

  public static void addVehicle(Vehicle vehicle) {
    vehicles.add(vehicle);
  }

  public static void addPersonToBlackList(Person person) {
    blackList.add(person);
  }

  public static void addContract(Contract contract) {
    contracts.add(contract);
  }

  public static void loadSampleData() {
    // Vehicles
    Motorhome hymermobil = new Motorhome("Hymermobil", 2019, "WVGZZZ70ZKW000000",
        80000, 60000, 10000, 100);
    addVehicle(hymermobil);
    Motorhome vWCalifornia = new Motorhome("VW California", 2018,
        "WVGZZZ70ZKW000001", 60000, 50000, 20000, 80);
    addVehicle(vWCalifornia);
    SmallCar opelcorsa = new SmallCar("Opel corsa", 2019, "WVGZZZ70ZKW000002",
        20000, 15000, 5000, 5, 300);
    addVehicle(opelcorsa);
    SmallCar fiat500 = new SmallCar("Fiat 500", 2018, "WVGZZZ70ZKW000003", 18000,
        13000, 10000, 4, 250);
    addVehicle(fiat500);
    SmallCar hyundaiI10 = new SmallCar("Hyundai I10", 2017, "WVGZZZ70ZKW000004",
        15000, 10000, 15000, 4, 200);
    addVehicle(hyundaiI10);
    SmallCar suzukiSwift = new SmallCar("Suzuki Swift", 2016,
        "WVGZZZ70ZKW000005", 14000, 9000, 20000, 4, 180);
    addVehicle(suzukiSwift);
    LuxuryCar mercedesSKlasse = new LuxuryCar("Mercedes S-Klasse", 2019,
        "WVGZZZ70ZKW000006", 120000, 100000, 5000,
        300);
    addVehicle(mercedesSKlasse);
    LuxuryCar bMW4Z4cabriolet = new LuxuryCar("BMW4 Z4 cabriolet", 2018,
        "WVGZZZ70ZKW000007", 90000, 80000, 10000,
        250);
    addVehicle(bMW4Z4cabriolet);
    LuxuryCar mazdaMX5cabriolet = new LuxuryCar("Mazda MX5 cabriolet", 2017,
        "WVGZZZ70ZKW000008", 80000, 70000,
        15000, 200);
    addVehicle(mazdaMX5cabriolet);
    LuxuryCar bMW18 = new LuxuryCar("BMW 18", 2016, "WVGZZZ70ZKW000009", 70000,
        60000, 20000, 180);
    addVehicle(bMW18);
    Truck mercedesVita = new Truck("Mercedes Vita", 2019, "WVGZZZ70ZKW000010",
        80000, 60000, 10000, 5000);
    addVehicle(mercedesVita);
    Truck vWCrafter = new Truck("VW Crafter", 2018, "WVGZZZ70ZKW000011", 60000,
        50000, 20000, 4000);
    addVehicle(vWCrafter);
    Truck ivecodaily = new Truck("Iveco daily", 2017, "WVGZZZ70ZKW000012", 50000,
        40000, 30000, 3000);
    addVehicle(ivecodaily);
    Truck opelCicoroE = new Truck("Opel Cicoro E", 2016, "WVGZZZ70ZKW000013",
        40000, 30000, 40000, 2000);
    addVehicle(opelCicoroE);
    Truck vWeCrafter = new Truck("VW e-Crafter", 2015, "WVGZZZ70ZKW000014",
        30000, 20000, 50000, 1000);
    addVehicle(vWeCrafter);
    Trailer boeckmannHochlader = new Trailer("Böckmann Hochlader", 2019,
        "WVGZZZ70ZKW000015", 5000, 4000, 5);
    addVehicle(boeckmannHochlader);
    Trailer boeckmannBootsanhaenger = new Trailer("Böckmann Bootsanhänger", 2018,
        "WVGZZZ70ZKW000016", 4000, 3000,
        6);
    addVehicle(boeckmannBootsanhaenger);
    Trailer boeckmannTieflader = new Trailer("Böckmann Tieflader", 2017,
        "WVGZZZ70ZKW000017", 3000, 2000, 7);
    addVehicle(boeckmannTieflader);

    // Customers
    Person peterNyffeler = new Person("Peter", "Nyffeler", "123 Main St",
        LocalDate.of(1990, 5, 15), "555-1234",
        "peter@example.com");
    addCustomer(peterNyffeler);
    Person bobbyShmurda = new Person("Bobby", "Shmurda", "456 Elm St",
        LocalDate.of(1995, 8, 4), "555-5678",
        "bobby@example.com");
    addCustomer(bobbyShmurda);
    Person anitaMaxwin = new Person("Anita", "Maxwin", "789 Oak St",
        LocalDate.of(1988, 12, 20), "555-9012",
        "anita@example.com");
    addCustomer(anitaMaxwin);
    Person mikeOxlong = new Person("Mike", "Oxlong", "321 Pine St",
        LocalDate.of(1992, 3, 10), "555-3456",
        "mike@example.com");
    addCustomer(mikeOxlong);
    Person dixieNormous = new Person("Dixie", "Normous", "654 Maple St",
        LocalDate.of(1998, 7, 1), "555-7890",
        "dixie@example.com");
    addCustomer(dixieNormous);
    Person benDover = new Person("Ben", "Dover", "987 Cedar St",
        LocalDate.of(1993, 9, 25), "555-2345",
        "ben@example.com");
    addCustomer(benDover);
    Person hughJazz = new Person("Hugh", "Jazz", "1234 Walnut St",
        LocalDate.of(1991, 6, 5), "555-6789",
        "hugh@example.com");
    addCustomer(hughJazz);

    // Person fill = new Person("Fill", "Fill", "1234 Walnut St",
    // LocalDate.of(1991, 6, 5), "555-6789",
    // "fill@example.com");
    // addCustomer(fill);
    // addCustomer(fill);
    // addCustomer(fill);
    // addCustomer(fill);
    // addCustomer(fill);
    // addCustomer(fill);
    // addCustomer(fill);
    // addCustomer(fill);
    // addCustomer(fill);
    // addCustomer(fill);
    // addCustomer(fill);
    // addCustomer(fill);
    // addCustomer(fill);
    // addCustomer(fill);
    // addCustomer(fill);
    // addCustomer(fill);
    // addCustomer(fill);
    // addCustomer(fill);
    // addCustomer(fill);

    // Rental contracts
    addContract(new RentalContract(peterNyffeler,
        hymermobil, LocalDate.of(2020, 1, 1),
        LocalDate.of(2020, 1, 15), 1000));
    addContract(new RentalContract(bobbyShmurda,
        vWCalifornia, LocalDate.of(2020, 1, 1),
        LocalDate.of(2020, 1, 15), 800));
    addContract(new RentalContract(anitaMaxwin, opelcorsa,
        LocalDate.of(2020, 1, 1),
        LocalDate.of(2020, 1, 15), 400));
    addContract(new RentalContract(mikeOxlong, fiat500,
        LocalDate.of(2020, 1, 1),
        LocalDate.of(2020, 1, 15), 300));
    addContract(new RentalContract(dixieNormous, hyundaiI10,
        LocalDate.of(2020, 1, 1),
        LocalDate.of(2020, 1, 15), 200));
    addContract(new RentalContract(benDover, suzukiSwift,
        LocalDate.of(2020, 1, 1),
        LocalDate.of(2020, 1, 15), 180));
    addContract(new RentalContract(hughJazz,
        mercedesSKlasse, LocalDate.of(2020, 1, 1),
        LocalDate.of(2020, 1, 15), 300));
    addContract(new RentalContract(peterNyffeler,
        bMW4Z4cabriolet, LocalDate.of(2020, 1, 1),
        LocalDate.of(2020, 1, 15), 250));
    addContract(new RentalContract(bobbyShmurda,
        mazdaMX5cabriolet, LocalDate.of(2020, 1, 1),
        LocalDate.of(2020, 1, 15), 200));
    addContract(new RentalContract(anitaMaxwin, bMW18,
        LocalDate.of(2020, 1, 1),
        LocalDate.of(2020, 1, 15), 180));

  }

}
