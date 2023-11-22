public class Person {
  public String firstName;
  public String lastName;
  public Integer birthYear;
  public Float height;
  public Float weight;
  public String phoneNumber;
  public String email;
  public String address;

  public Person() {
  }

  public Person(String firstName, String lastName, Integer birthYear, Float height, Float weight, String phoneNumber,
      String email, String address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthYear = birthYear;
    this.height = height;
    this.weight = weight;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.address = address;
  }

}
