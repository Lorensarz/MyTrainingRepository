import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            String phoneCleaner = input.replaceAll("[^0-9]+", "");


            if (phoneCleaner.indexOf("8") == 0) {
                phoneCleaner = phoneCleaner.replaceFirst("8", "7");
            }

            if (phoneCleaner.length() == 10) {
                phoneCleaner = "7" + phoneCleaner;
            }

            if (phoneCleaner.indexOf("7") != 0 || phoneCleaner.length() != 11) {
                System.out.println("Неверный формат номера");
                break;
            }
            System.out.println(phoneCleaner);


            //TODO:напишите ваш код тут, результат вывести в консоль.
        }
    }

}
