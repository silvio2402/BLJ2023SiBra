import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Wordle!");
        System.out.println("Start guessing!");
        System.out.println();
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

        WordleGame game = new WordleGame(wordList);

        while (true) {
            inputGuess(game);
        }
    }

    private static void inputGuess(WordleGame game) {
        String guess = in.nextLine();
        guess = String.format("%-5s", guess);
        System.out.print("\033[A\033[2K\r");
        LetterState[] result = game.guessWord(guess);
        printResult(result, guess);
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
