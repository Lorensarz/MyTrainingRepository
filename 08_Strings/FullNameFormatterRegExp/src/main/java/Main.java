

import java.util.Scanner;

import static java.lang.String.format;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }


      String[] stringArray = input.split("\\s+");


      System.out.println("Фамилия: " + stringArray[0]);
      System.out.println("Имя: " + stringArray[1]);
      System.out.println("Отчество: " + stringArray[2]);

      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
    }
  }

}