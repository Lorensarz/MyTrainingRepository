import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    private static final EmailList emailList = new EmailList();
    
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите команду: ");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            String[] splitInput = (input.split("\\s+"));
            String command = splitInput[0];

            if (command.equals("ADD")) {
                String[] resultEmail = input.split(" ", 2);
                String email = resultEmail[1];
                emailList.add(email);

            }

            if (command.equals("LIST")) {
                emailList.getSortedEmails();
                for (int i = 0; i < emailList.getSortedEmails().size(); i++) {
                    System.out.println(emailList.getSortedEmails().get(i));
                }

                //TODO: write code here
            }

        }
    }
}
