import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


    }

    public static String splitTextIntoWords(String text) {
//TODO реализуйте метод

        String replaceText = text.replaceAll("[^a-zA-z’]+", "\n").trim();


        return replaceText;
    }
}
