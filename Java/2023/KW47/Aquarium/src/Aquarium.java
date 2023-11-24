import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Aquarium {
    public Integer width = 140;
    public Integer height = 50;

    public final ArrayList<Fish> fishes = new ArrayList<Fish>();

    public Aquarium() {
    }

    public Aquarium(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    public void addFish(Fish fish) {
        this.fishes.add(fish);
    }

    public void plopFish(Fish fish) {
        fish.x = (double) (Math.random() * Fish.COORD_DIV * (this.width - fish.bitmap.length()));
        fish.y = (double) (Math.random() * Fish.COORD_DIV * this.height);
        fish.lookingRight = Math.random() < 0.5;
        this.addFish(fish);
    }

    public void update(Integer deltaTime) {
        for (Fish fish : this.fishes) {
            float deltaX = (float) (fish.speed * deltaTime / 1000.0 * Fish.COORD_DIV);
            if (!fish.lookingRight)
                deltaX = -deltaX;

            fish.x += Math.round(deltaX);
            if (fish.x < 0) {
                fish.x = (double) 0;
                fish.lookingRight = true;
            } else if (fish.x > Fish.COORD_DIV * (this.width - fish.bitmap.length())) {
                fish.x = (double) (Fish.COORD_DIV * (this.width - fish.bitmap.length()));
                fish.lookingRight = false;
            }
        }
    }

    private static Map<Character, Character> reverseMap = new HashMap<Character, Character>() {
        {
            put('>', '<');
            put('<', '>');
            put('(', ')');
            put(')', '(');
            put('[', ']');
            put(']', '[');
            put('{', '}');
            put('}', '{');
            put('/', '\\');
            put('\\', '/');
        }
    };

    private static String reverseBitmap(String bitmap) {
        String out = new StringBuilder(bitmap).reverse().toString();

        for (int i = 0; i < out.length(); i++) {
            Character c = out.charAt(i);
            if (reverseMap.containsKey(c)) {
                out = out.substring(0, i) + reverseMap.get(c) + out.substring(i + 1);
            }
        }

        return out;
    }

    public String renderAquarium() {
        String aquarium = "";
        for (int y = 0; y < this.height; y++) {
            String row = " ".repeat(this.width);
            for (Fish fish : this.fishes) {
                Integer fishY = (int) Math.round(fish.y / Fish.COORD_DIV);
                if (fishY == y) {
                    Integer fishX = (int) Math.round(fish.x / Fish.COORD_DIV);
                    final String fishBitmap = fish.lookingRight ? fish.bitmap
                            : reverseBitmap(fish.bitmap);
                    row = row.substring(0, fishX) + fishBitmap + row.substring(fishX + fishBitmap.length());
                }
            }
            aquarium += row + "\n";
        }
        return aquarium;
    }

    public void printAquarium() {
        System.out.println(renderAquarium());
    }
}
