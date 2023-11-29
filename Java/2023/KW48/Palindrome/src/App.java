import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("--- Palindrome Checker ---");

        System.out.print("Enter a number: ");
        long number = in.nextLong();
        in.nextLine();

        int length = getLength(number);
        boolean isPalindrome = true;

        for (int i = 1; i <= length / 2; i++) {
            if (getDigit(number, i) != getDigit(number, length - i + 1)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome)
            System.out.println(number + " is a palindrome.");
        else
            System.out.println(number + " is not a palindrome.");

        in.close();
    }

    public static int getDigit(long number, int position) {
        return (int) (number / Math.pow(10, position - 1)) % 10;
    }

    public static int getLength(long number) {
        return (int) Math.log10(number) + 1;
    }
}
