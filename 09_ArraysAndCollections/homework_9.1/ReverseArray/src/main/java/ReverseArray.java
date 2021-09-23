import java.util.Arrays;

public class ReverseArray {

    //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
    public static String[] reverse(String[] strings) {
        for (int i = strings.length - 1; i >= 0; i--) {
            System.out.println(strings[i]);

        }


        return strings;

    }
}