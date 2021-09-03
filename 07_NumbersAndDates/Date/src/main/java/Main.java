import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;



public class Main {

    // Private properties

    private static int year;
    private static int month;
    private static int day;

    public static void main(String[] args) {

        // Properties

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    // Getters
    public static int getYear() {
        return year;
    }

    public static int getMonth() {
        return month;
    }

    public static int getDay() {
        return day;
    }

    // Setters

    public static void setYear(int year) {
        Main.year = year;
    }

    public static void setMonth(int month) {
        Main.month = month;
    }

    public static void setDay(int day) {
        Main.day = day;
    }

    // Public methods

    public static String collectBirthdays(int year, int month, int day) {
        Main.year = year;
        Main.month = month;
        Main.day = day;

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

        //while (today.isAfter(birthday)) {
        //    birthday = birthday.plusYears(1);
        //    System.out.println(formatter.format(birthday));

        for (birthday = start; birthday.isBefore(end); birthday = birthday.plusYears(1)) {

            System.out.println(formatter.format(birthday));
        }

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue

        return "";
    }
}
