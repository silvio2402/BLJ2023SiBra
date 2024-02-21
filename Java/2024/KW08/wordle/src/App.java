import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import exceptions.InvalidWordException;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Wordle!");
        playGame();
    }

    private static void playGame() {
        WordList wordList;
        try {
            wordList = new WordList();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find wordlist.txt");
            return;
        }

        while (true) {
            System.out.println("Enable hard mode?");
            System.out.println("Press 'y' to enable, or any other key to disable.");
            boolean hardMode = in.nextLine().equals("y");

            WordleGame game = new WordleGame(wordList, hardMode);

            System.out.println("Start guessing!");
            System.out.println();

            while (true) {
                String guess = inputGuess(game);

                if (game.isCorrect(guess)) {
                    System.out.println("You win!");
                    System.out.println();

                    System.out.println("Start a new game?");
                    System.out.println("Press 'y' to start a new game, or any other key to exit.");
                    String input = in.nextLine();
                    if (input.equals("y")) {
                        break;
                    } else {
                        System.exit(0);
                    }
                }
            }
        }
    }

    private static String inputGuess(WordleGame game) {
        while (true) {
            try {

                String guess = in.nextLine();
                LetterState[] result = game.guessWord(guess);
                System.out.print("\033[A\033[2K\r");
                printResult(result, guess);
                return guess;
            } catch (InvalidWordException e) {
                System.out.println(e.getMessage() + " Try again!");
            }
        }
    }

    private static Map<LetterState, String> letterStateColors;
    static {
        letterStateColors = new HashMap<LetterState, String>();
        letterStateColors.put(LetterState.CORRECT, "\u001B[32m");
        letterStateColors.put(LetterState.PRESENT, "\u001B[33m");
        letterStateColors.put(LetterState.ABSENT, "\u001B[31m");
    }

    private static void printResult(LetterState[] result, String guess) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(letterStateColors.get(result[i]));
            System.out.print(guess.charAt(i));
        }
        System.out.println("\u001B[0m");
    }
}
