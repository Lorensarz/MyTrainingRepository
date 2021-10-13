import org.checkerframework.checker.regex.qual.Regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailList {

    private final static String REGEX_EMAIL = "[A-Za-z]+@[A-Za-z]+\\.[a-z]+";


    TreeSet<String> emailList = new TreeSet<>();

    public void add(String email) {

        if (email.matches(REGEX_EMAIL)) {
            email = email.toLowerCase(Locale.ROOT);
            emailList.add(email);

        } else {
            System.out.println("Неверный формат email");
        }


        // TODO: валидный формат email добавляется
    }

    public ArrayList<String> getSortedEmails() {

        // TODO: возвращается список электронных адресов в алфавитном порядке
        return new ArrayList<>(emailList);

    }


    public void printList() {
        for (int i = 0; i < getSortedEmails().size(); i++) {
            System.out.println(getSortedEmails().get(i));
        }

    }
}

