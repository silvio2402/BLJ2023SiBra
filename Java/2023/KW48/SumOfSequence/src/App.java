import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.print("From: ");
        Long from = in.nextLong();
        in.nextLine();

        System.out.print("To: ");
        Long to = in.nextLong();
        in.nextLine();

        Long sum = sumOfSequence(from, to);
        System.out.println("Sum of sequence: " + sum);

        in.close();
    }

    public static Long sumOfSequence(Long from, Long to) {
        Long sum = 0L;

        for (Long i = from; i < to + 1; i++)
            sum += i;

        return sum;
    }
}
