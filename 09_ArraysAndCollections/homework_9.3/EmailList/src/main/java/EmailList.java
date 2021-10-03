import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailList {

    TreeSet<String> emailList = new TreeSet<>();

    public void add(String email) {
        Pattern pattern = Pattern.compile(
                "[A-Za-z]+@[A-Za-z]+\\.[a-z]+");
        Matcher matcher = pattern.matcher(email);

        if (matcher.find()) {
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

}
