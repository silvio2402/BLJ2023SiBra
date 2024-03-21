package Contract;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import Person.Person;

public class Contract {
  public Set<Person> parties;
  public List<Signature> signatures;
  public String contractText;

  public void signContract(Person person, String location) {
    LocalDate signingDate = LocalDate.now();
    Signature signature = new Signature(person, signingDate, location);
    signatures.add(signature);
  }

  public void printContract() {
    for (Person person : parties) {
      System.out.println("Party: " + person.getFullName());
    }
    for (Signature signature : signatures) {
      System.out
          .println("Signature: " + signature.location + ", " + signature.date + ", " + signature.signer.getFullName());
    }
    System.out.println("Contract text: " + contractText);
  }
}
