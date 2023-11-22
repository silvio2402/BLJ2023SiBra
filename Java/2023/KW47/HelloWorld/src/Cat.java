public class Cat {
    public String name;
    public String breed;
    public String color;
    public int birthYear;

    public Cat(String name, String breed, String color, int birthYear) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.birthYear = birthYear;
    }

    public void meow() {
        System.out.println("Meow!");
    }

    public void purr() {
        System.out.println("Purr!");
    }

    public void hiss() {
        System.out.println("Hiss!");
    }
}
