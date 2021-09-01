import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;



public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;



        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

/**
 1. создать переменные класса LocalDate — birthday и today
 2. написать цикл в котором прибавлять 1 год к birthday и сравнивать дату с сегодняшней
 используя метод isAfter или isBefore

 Таким образом у вас будет проверяться не только год, но и день, что позволит точно
 выводить данные о прошедших днях рождениях.
 */

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - EEE").localizedBy(
                new Locale("us"));
        String stringToday = today.format(formatter);


        LocalDate birthday = LocalDate.of(1990, 12, 31);
        String stringBirthday = birthday.format(formatter);


        LocalDate start = LocalDate.parse(stringBirthday, formatter);
        LocalDate end = LocalDate.parse(stringToday, formatter);


        for (birthday = start; birthday.isBefore(end); birthday = birthday.plusYears(1)) {

            System.out.println(formatter.format(birthday));

        }




        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue


        return "";
    }
}
