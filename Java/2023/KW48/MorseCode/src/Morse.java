import java.util.concurrent.ConcurrentHashMap;

class MorseTreeNode {
    Character value;
    MorseTreeNode dot;
    MorseTreeNode dash;
}

public class Morse {
    public static final ConcurrentHashMap<Character, String> morseTable = new ConcurrentHashMap<Character, String>() {
        {
            put('a', ".-");
            put('b', "-...");
            put('c', "-.-.");
            put('d', "-..");
            put('e', ".");
            put('f', "..-.");
            put('g', "--.");
            put('h', "....");
            put('i', "..");
            put('j', ".---");
            put('k', "-.-");
            put('l', ".-..");
            put('m', "--");
            put('n', "-.");
            put('o', "---");
            put('p', ".--.");
            put('q', "--.-");
            put('r', ".-.");
            put('s', "...");
            put('t', "-");
            put('u', "..-");
            put('v', "...-");
            put('w', ".--");
            put('x', "-..-");
            put('y', "-.--");
            put('z', "--..");
            put('0', "-----");
            put('1', ".----");
            put('2', "..---");
            put('3', "...--");
            put('4', "....-");
            put('5', ".....");
            put('6', "-....");
            put('7', "--...");
            put('8', "---..");
            put('9', "----.");
            put('.', ".-.-.-");
            put(',', "--..--");
            put(':', "---...");
            put('?', "..--..");
            put('\'', ".----.");
            put('-', "-....-");
            put('/', "-..-.");
            put('(', "-.--.");
            put(')', "-.--.-");
            put('"', ".-..-.");
            put('=', "-...-");
            put('!', "-.-.--");
            put('+', ".-.-.");
            put('×', "-..-");
            put('@', ".--.-.");
        }
    };

    public static String encode(String text) {
        String encoded = "";
        for (int i = 0; i < text.length(); i++) {
            Character c = Character.toLowerCase(text.charAt(i));
            if (c == ' ') {
                encoded += " / ";
                continue;
            }
            String morse = morseTable.get(c);
            if (morse != null) {
                encoded += morse + " ";
            }
        }
        return encoded;
    }

    public static MorseTreeNode morseTree = new MorseTreeNode();

    private static void buildMorseTree() {
        for (Character c : morseTable.keySet()) {
            String morse = morseTable.get(c);
            MorseTreeNode node = morseTree;
            for (int i = 0; i < morse.length(); i++) {
                Character m = morse.charAt(i);
                if (m == '.') {
                    if (node.dot == null)
                        node.dot = new MorseTreeNode();

                    node = node.dot;
                } else if (m == '-') {
                    if (node.dash == null)
                        node.dash = new MorseTreeNode();

                    node = node.dash;
                }
            }
            node.value = c;
        }
    }

    public static String decode(String morse) {
        if (morseTree.value == null)
            buildMorseTree();

        String decoded = "";
        String[] letters = morse.split(" ");

        for (int i = 0; i < letters.length; i++) {
            String letter = letters[i];
            if (letter.equals("/")) {
                decoded += " ";
                continue;
            }
            MorseTreeNode node = morseTree;
            for (int j = 0; j < letter.length(); j++) {
                Character m = letter.charAt(j);
                if (m == '.')
                    node = node.dot;
                else if (m == '-')
                    node = node.dash;

            }
            if (node.value != null)
                decoded += node.value;

        }

        return decoded;
    }
}
