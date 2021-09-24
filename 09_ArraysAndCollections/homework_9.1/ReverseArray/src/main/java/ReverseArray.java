
public class ReverseArray {

    //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
    public static String[] reverse(String[] strings) {
        
        for (int i = 0; i < strings.length; i++) {

        }

        String temp;

        for (int i = 0; i < strings.length / 2; i++) {
            temp = strings[strings.length - i - 1];
            strings[strings.length - i - 1] = strings[i];
            strings[i] = temp;

        }

        return strings;

    }
}