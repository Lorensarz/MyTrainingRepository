import java.util.Collection;
import java.util.Collections;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска вводимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {

        Collections.sort(CoolNumbers.generateCoolNumbers());
        System.out.println(CoolNumbers.bruteForceSearchInList(CoolNumbers.generateCoolNumbers(),
                CoolNumbers.CAR_NUMBER));


    }
}
