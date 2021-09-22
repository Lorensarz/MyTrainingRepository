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


            if (phoneCleaner.length() == 11) {
                System.out.println(phoneCleaner);
            }

            if (phoneCleaner.length() > 11 || phoneCleaner.length() < 10) {
                System.out.println("Неверный формат номера");
            }

            if (phoneCleaner.length() == 10) {
                System.out.println("7" + phoneCleaner);
            }

            if (phoneCleaner.indexOf(0) == 8) {

                StringBuilder sb = new StringBuilder(phoneCleaner);
                sb.setCharAt(0, '7');
                System.out.println(sb);
            }


            //TODO:напишите ваш код тут, результат вывести в консоль.
        }
    }

}
