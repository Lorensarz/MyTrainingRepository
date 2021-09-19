import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        System.out.println(calculateSalarySum(
                "Толя заработал 35000 рублей, а Лера - 45000 рублей"));

    }


    public static int calculateSalarySum(String text) {

        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(text);

        Integer sum = 0;

        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group(1));

        }

        if (sum > 0) {
            System.out.printf("%d\n", sum);
        } else {
            System.out.println("Никто ничего не заработал");

        }

        return sum;
    }
}
//TODO: реализуйте метод




