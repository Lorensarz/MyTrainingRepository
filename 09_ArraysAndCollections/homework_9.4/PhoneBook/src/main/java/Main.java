import java.util.Scanner;

public class Main {
    private final static String COMMAND_LIST = "LIST";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();


        while (true) {

            System.out.println("Введите номер, имя или команду:");
            String input = scanner.nextLine();


            if (Validator.nameFormatter(input)) {
                System.out.println("Такого имени в телефонной книге нет.");
                System.out.println("Введите номер телефона для абонента \"" + input + "\":");
                String inputPhone = scanner.nextLine();
                phoneBook.addContact(inputPhone, input);
                System.out.println("Контакт сохранен!");

            }

            if (input.equals(Validator.phoneFormatter(input)) &&
                    !phoneBook.contacts.containsValue(input)) {
                System.out.println("Такого номера нет в телефонной книге.");
                System.out.println("Введите имя абонента для номера \"" + input + "\":");
                String inputName = scanner.nextLine();
                phoneBook.addContact(input, inputName);
                System.out.println("Контакт сохранен!");

            } else {
                System.out.println(phoneBook.getContactByPhone(input));


            }

            if (input.equals(COMMAND_LIST)) {

                System.out.println(phoneBook.getAllContacts());

            }

            if (input.equals("0")) {
                break;
            }
        }


    }

}




