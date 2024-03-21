package Person;

import java.time.LocalDate;

public class Person {
  public String firstName;
  public String lastName;
  public String address;
  public LocalDate birthdate;
  public String telephone;
  public String email;

  public Person(String firstName, String lastName, String address, LocalDate birthdate, String telephone,
      String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.birthdate = birthdate;
    this.telephone = telephone;
    this.email = email;
  }

  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }

  public int getAgeAt(LocalDate date) {
    return (int) (this.birthdate.until(date).getYears());
  }

  public void printPerson() {
    System.out.println("First name: " + this.firstName);
    System.out.println("Last name: " + this.lastName);
    System.out.println("Address: " + this.address);
    System.out.println("Birthdate: " + this.birthdate);
    System.out.println("Telephone: " + this.telephone);
    System.out.println("Email: " + this.email);
  }
}
