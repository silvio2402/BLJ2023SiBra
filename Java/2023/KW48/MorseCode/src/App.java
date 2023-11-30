import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.print("Would you like to encode or decode or exit? ");
            String choice = in.nextLine();

            if (choice.equals("encode"))
                encode();
            else if (choice.equals("decode"))
                decode();
            else if (choice.equals("exit"))
                break;
            else
                System.out.println("Invalid choice.");

        }
    }

    private static void encode() {
        System.out.print("Enter text to encode: ");
        String text = in.nextLine();

        System.out.println("Encoded: " + Morse.encode(text));
    }

    private static void decode() {
        System.out.print("Enter morse to decode: ");
        String morse = in.nextLine();

        System.out.println("Decoded: " + Morse.decode(morse));
    }
}
