package Model.Contract;

import java.time.LocalDate;

import Model.Person.Person;

public class Signature {
  public Person signer;
  public LocalDate date;
  public String location;

  public Signature(Person signer, LocalDate date, String location) {
    this.signer = signer;
    this.date = date;
    this.location = location;
  }
}
