public class App {
    public static void main(String[] args) throws Exception {
        Aquarium aquarium = new Aquarium(140, 20);

        for (int i = 0; i < 30; i++) {
            Fish fish = FishTypes.getRandomFish();
            aquarium.plopFish(fish);
        }

        aquarium.printAquarium();
    }
}
