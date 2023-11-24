import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Aquarium {
    public Integer width = 20;
    public Integer height = 10;

    public final ArrayList<Fish> fishes = new ArrayList<Fish>();

    public Aquarium() {
    }

    public Aquarium(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    public void addFish(Fish fish) {
        fishes.add(fish);
    }

    public void plopFish(Fish fish) {
        fish.x = (int) Math.floor(Math.random() * (this.width - fish.bitmap.length()));
        fish.y = (int) Math.floor(Math.random() * this.height);
        fish.lookingRight = Math.random() < 0.5;
        this.addFish(fish);
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
            for (Fish fish : fishes) {
                if (fish.y == y) {
                    final String fishBitmap = fish.lookingRight ? fish.bitmap
                            : reverseBitmap(fish.bitmap);
                    row = row.substring(0, fish.x) + fishBitmap + row.substring(fish.x + fishBitmap.length());
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
