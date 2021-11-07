import java.util.*;

public class CoolNumbers {

    public static final String CAR_NUMBER = "Н555ХТ100";


    public static List<String> generateCoolNumbers() {
        String[] letter = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        Arrays.sort(letter);
        HashSet<String> arrNumber = new HashSet<>();
        for (int i = 111; i <= 999; i += 111) {
            for (String a1 : letter) {
                for (String a2 : letter) {
                    for (String a3 : letter) {
                        for (int reg = 1; reg <= 199; reg++) {
                            arrNumber.add(String.format("%s%03d%s%s%d", a1, i, a2, a3, reg));
                        }
                    }
                }
            }
        }

        ArrayList<String> coolNumberList = new ArrayList<>(arrNumber);

        return coolNumberList;

    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        Collections.sort(generateCoolNumbers());
        list = generateCoolNumbers();
        number = CAR_NUMBER;

            if (list.contains(number)) {
                return true;

            }

        return false;

    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        Collections.sort(generateCoolNumbers());
        sortedList = generateCoolNumbers();
        number = CAR_NUMBER;
        int index = Collections.binarySearch(sortedList, number);

        if (index >= 0) {
            return true;

        }
        return false;

    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {

        return false;

    }


    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {

        return false;

    }
}
