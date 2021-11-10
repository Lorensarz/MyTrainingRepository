import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        List<String> numbersList = new ArrayList<>();
        String[] letter = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        Arrays.sort(letter);
        for (int i = 111; i <= 999; i += 111) {
            for (String a1 : letter) {
                for (String a2 : letter) {
                    for (String a3 : letter) {
                        for (int reg = 1; reg <= 199; reg++) {
                            numbersList.add(String.format("%s%03d%s%s%d", a1, i, a2, a3, reg));
                        }
                    }
                }
            }
        }
        return numbersList;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        for (String s : list) {
            if (s.equals(number)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        int index = Collections.binarySearch(sortedList, number);
        return index >= 0;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }


    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }
}
