public class Dog {
    public String name;
    public String breed;
    public String color;
    public int birthYear;

    public Dog(String name, String breed, String color, int birthYear) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.birthYear = birthYear;
    }

    public void bark() {
        System.out.println("Woof!");
    }
}
