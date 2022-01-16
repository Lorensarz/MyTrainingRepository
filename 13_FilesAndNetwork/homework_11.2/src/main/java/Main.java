import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
           String input = scanner.nextLine();
           if (input.equals("")) {
               break;
           }
            System.out.println("Введите путь к папке: ");
            FileUtils.copyFolder(input, input);
        }

    }
}
