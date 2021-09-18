

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.format;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }

      Pattern pattern = Pattern.compile("[^\\d].*[а-яА-ЯёЁ]\\s+");
      Matcher matcher = pattern.matcher(input);

      String[] splitString = (input.split("\\s+"));

        if (matcher.find()) {
          System.out.println("Фамилия: " + splitString[0] +
                  "\nИмя: " + splitString[1] +
                  "\nОтчество: " + splitString[2]);
        } else {
          System.out.println("Введенная строка не является ФИО");
        }

        //TODO:напишите ваш код тут, результат вывести в консоль.
        //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
      }
    }
  }
