import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter height: ");
        String heightInput = in.nextLine();
        Integer height = Integer.parseInt(heightInput);

        TreeRenderer tree = new TreeRenderer(height);
        tree.print();

        in.close();
    }
}
