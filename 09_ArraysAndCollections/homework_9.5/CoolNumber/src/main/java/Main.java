import java.text.DecimalFormat;
import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска вводимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    private static final String REGEX_NUMBER = "^[A-Я]\\d{3}[А-Я]{2}\\d{2,3}$";
    private static final List<String> list = CoolNumbers.generateCoolNumbers();
    private static final HashSet<String> hashSet = new HashSet<>(CoolNumbers.generateCoolNumbers());
    private static final TreeSet<String> treeSet = new TreeSet<>(CoolNumbers.generateCoolNumbers());


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВведите номер автомобиля в формате: Х999ХХ199");
            String number = scanner.nextLine();
            if (number.equals("0")) {
                break;
            }

            if (number.matches(REGEX_NUMBER)) {

                try {


                    //bruteForceSearchInList

                    long startBruteForceSearchTime = System.nanoTime();
                    boolean bruteForceSearch = CoolNumbers.bruteForceSearchInList(list, number);
                    long endBruteForceSearchTime = System.nanoTime();
                    long totalBruteForceSearchTime = endBruteForceSearchTime - startBruteForceSearchTime;
                    if (bruteForceSearch) {
                        System.out.println("Поиск перебором: номер найден, поиск занял: "
                                + totalBruteForceSearchTime + "нс");
                    } else {
                        System.out.println("Поиск перебором: номер не найден, поиск занял: "
                                + totalBruteForceSearchTime + "нс");
                    }


                    //binarySearchInList


                    Collections.sort(list);
                    long startBinarySearchTime = System.nanoTime();
                    boolean binarySearch = CoolNumbers.binarySearchInList(list, number);
                    long endBinarySearchTime = System.nanoTime();
                    long totalBinarySearchTime = endBinarySearchTime - startBinarySearchTime;
                    if (binarySearch) {
                        String binarySearchResult = "номер найден,";
                        System.out.println("Бинарный поиск: номер найден, поиск занял: "
                                + totalBinarySearchTime + "нс");
                    } else {
                        String binarySearchResult = "номер не найден,";
                        System.out.println("Бинарный поиск: номер не найден, поиск занял: "
                                + totalBinarySearchTime + "нс");
                    }


                    //searchInHashSet


                    long startHashSetSearch = System.nanoTime();
                    boolean hashSetSearch = CoolNumbers.searchInHashSet(hashSet, number);
                    long endHashSetSearch = System.nanoTime();
                    long totalHashSetSearch = endHashSetSearch - startBinarySearchTime;
                    if (hashSetSearch) {
                        System.out.println("Поиск в HashSet: номер найден, поиск занял: "
                                + startHashSetSearch + "нс");
                    } else {
                        System.out.println("Поиск в HashSet: номер не найден, поиск занял: "
                                + totalHashSetSearch + "нс");
                    }


                    //searchInTreeSet


                    long startTreeSetSearch = System.nanoTime();
                    boolean treeSetSearch = CoolNumbers.searchInTreeSet(treeSet, number);
                    long endTreeSetSearch = System.nanoTime();
                    long totalTreeSetSearch = endTreeSetSearch - startTreeSetSearch;
                    if (treeSetSearch) {
                        System.out.println("Поиск в TreeSet: номер найден, поиск занял: "
                                + totalTreeSetSearch + "нс");
                    } else {
                        System.out.println("Поиск в TreeSet: номер не найден, поиск занял: "
                                + totalTreeSetSearch + "нс");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            } else {
                System.out.println("Номер введен некорректно!");
            }
        }
    }
}
