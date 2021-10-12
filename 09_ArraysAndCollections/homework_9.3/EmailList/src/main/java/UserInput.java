import java.util.Scanner;

public class UserInput {

    public static String getLine() {

        System.out.print("Введите команду: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        if (userInput.equals("0")) {
            System.out.println("Введите команду");
        }
        return userInput;
    }
}



