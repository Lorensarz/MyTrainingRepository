import java.util.Scanner;
import java.util.Set;

public class Main {
    private final static String COMMAND_LIST = "LIST";
    private static final PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Введите номер, имя или команду:");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;

            }

            try {
                if (input.equals(COMMAND_LIST)) {
                    printSet(phoneBook.getAllContacts());
                    continue;
                }

                if (Validator.nameFormatter(input)) {
                    if (phoneBook.getContactByName(input).isEmpty()) {
                        System.out.println("Такого имени в телефонной книге нет.");
                        System.out.println("Введите номер телефона для абонента \"" + input + "\":");
                        String inputPhone = scanner.nextLine();
                        phoneBook.addContact(inputPhone, input);
                        System.out.println("Контакт сохранен!");

                    } else {
                        printSet(phoneBook.getContactByName(input));
                    }
                    continue;
                }
                if (Validator.phoneFormatter(input)) {
                    if (phoneBook.getContactByPhone(input).isEmpty()) {
                        System.out.println("Такого номера нет в телефонной книге.");
                        System.out.println("Введите имя абонента для номера \"" + input + "\":");
                        String inputName = scanner.nextLine();
                        phoneBook.addContact(input, inputName);
                        System.out.println("Контакт сохранен!");

                    } else {
                        System.out.println(phoneBook.getContactByPhone(input));
                    }

                } else {
                    System.out.println("Неверный формат ввода");
                }

            } catch(Exception e){
                    System.out.println("Что-то пошло не так");
                }


        }
    }

    private static void printSet(Set<String> set) {
        for (String item : set) {
            System.out.println(item);

        }

    }
}




