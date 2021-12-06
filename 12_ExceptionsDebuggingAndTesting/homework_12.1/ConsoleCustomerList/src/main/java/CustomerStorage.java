import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        final int CURRENT_SIZE = 4;
        final String REGEX_EMAIL = "[A-Za-z]+@[A-Za-z]+\\.[a-z]+";
        final String REGEX_PHONE = "^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$";



        String[] components = data.split("\\s+");
        if (components.length != CURRENT_SIZE) {
            throw new IllegalArgumentException("Строка data имеет не верный формат");
        }
        if (!components[INDEX_EMAIL].matches(REGEX_EMAIL)) {
            throw new IllegalArgumentException("Строка Email имеет не верный формат");
        }
        if (!components[INDEX_PHONE].matches(REGEX_PHONE)) {
            throw new IllegalArgumentException("Строка Phone имеет не верный формат");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));


    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }

}