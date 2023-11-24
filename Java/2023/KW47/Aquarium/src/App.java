public class App {
    public static Aquarium aquarium;

    public static void main(String[] args) throws Exception {
        Aquarium aquarium = new Aquarium(140, 50);

        for (int i = 0; i < 30; i++) {
            Fish fish = FishTypes.getRandomFish();
            aquarium.plopFish(fish);
        }

        while (true) {
            aquarium.update(100);
            System.out.println("\033[H");
            aquarium.printAquarium();
            Thread.sleep(100);
        }
    }
}
