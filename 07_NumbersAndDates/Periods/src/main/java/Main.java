import java.time.*;


public class Main {


    public static void main(String[] args) {

        LocalDate birthday = LocalDate.of(1970, 1, 1);
        LocalDate now = LocalDate.now();

        getPeriodFromBirthday(birthday, now);

    }


    private static void getPeriodFromBirthday(LocalDate birthday, LocalDate now) {

        Period difference = Period.between(birthday, now);
        System.out.printf("%d years, %d months, %d days ",
                difference.getYears(), difference.getMonths(), difference.getDays());
    }

}
