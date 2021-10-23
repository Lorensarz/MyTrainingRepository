import java.util.*;

public class PhoneBook {

    private static final String REGEX_NAME = "[\\Dа-яА-ЯёЁ]";
    private static final String NOT_VALID_PHONE_RESPONSE = "Неверный формат номера\n";

    TreeMap<String, String> phoneBook = new TreeMap<>();
    Set<String> setPhoneBook = new TreeSet<>();


    public String phoneFormatter(String phone) {

        String phoneCleaner = phone.replaceAll("[^0-9]+", "");

        if (phoneCleaner.indexOf("8") == 0) {
            phoneCleaner = phoneCleaner.replaceFirst("8", "7");

        }

        if (phoneCleaner.length() == 10) {
            phoneCleaner = "7" + phoneCleaner;

        }

        if (phoneCleaner.indexOf("7") != 0 || phoneCleaner.length() != 11) {
            System.out.println(NOT_VALID_PHONE_RESPONSE);

        }
        return phoneCleaner;

    }

    public void addContact(String phone, String name) {

        if (name.matches(REGEX_NAME) && phone.equals(phoneFormatter(phone))) {
            if (phoneBook.containsKey(phone)) {
                phoneBook.replace(phone, phoneBook.get(phone), name);

            } else {
                phoneBook.put(phone, name);

            }

        }
        // проверьте корректность формата имени и телефона (отдельные методы для проверки)
        // если такой номер уже есть в списке, то перезаписать имя абонента

    }

    public String getContactByPhone(String phone) {

        if (phoneBook.containsKey(phone)) {
            return phoneBook.get(phone) + " - " + phone;

        } else {

            return "";

        }
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
    }

    public Set<String> getContactByName(String name) {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа

            if (value.equals(name)) {

                return Collections.singleton(value + " - " + key);

            } else {

                return new TreeSet<>();

                // формат одного контакта "Имя - Телефон"
                // если контакт не найден - вернуть пустой TreeSet

            }
        }
        return null;
    }

        public Set<String> getAllContacts () {
            for (String key : phoneBook.keySet()) {
                setPhoneBook.add(phoneBook.get(key) + " - " + key);
            }
            if (!setPhoneBook.isEmpty()) {
                return setPhoneBook;
            }

            return new TreeSet<>();
            // формат одного контакта "Имя - Телефон"
            // если контактов нет в телефонной книге - вернуть пустой TreeSet

        }

        // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
        // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
    }