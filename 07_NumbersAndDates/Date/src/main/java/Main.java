import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;



public class Main {


    public static void main(String[] args) {

        // Properties

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    // Public methods

    public static String collectBirthdays(int year, int month, int day) {

        /**
         1. создать переменные класса LocalDate — birthday и today
         2. написать цикл в котором прибавлять 1 год к birthday и сравнивать дату с сегодняшней
         используя метод isAfter или isBefore
         */

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(year, month, day);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - EEE").localizedBy(
                new Locale("us"));

        String stringToday = today.format(formatter);
        String stringBirthday = birthday.format(formatter);

        LocalDate start = LocalDate.parse(stringBirthday, formatter);
        LocalDate end = LocalDate.parse(stringToday, formatter);

        int age = 0;
        String result = "";

        for (birthday = start; birthday.isBefore(end) || birthday.plusYears(1).equals(LocalDate.now()); birthday = birthday.plusYears(1)) {
            result += age++ + " - " + formatter.format(birthday) + System.lineSeparator();

        }

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue

        return result;
    }
}
