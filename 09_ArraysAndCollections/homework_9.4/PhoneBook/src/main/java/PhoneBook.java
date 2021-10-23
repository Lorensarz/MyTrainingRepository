import java.util.*;

public class PhoneBook {

    private final static String REGEX_NAME = "[А-Яа-яЁё]{1,}";

    TreeMap<String, TreeSet<String>> contacts = new TreeMap<>();

    public String phoneFormatter (String phone) {
        String phoneCleaner = phone.replaceAll("[^0-9]+", "");

        if (phoneCleaner.indexOf("8") == 0) {
            phoneCleaner = phoneCleaner.replaceFirst("8", "7");
        }

        if (phoneCleaner.length() == 10) {
            phoneCleaner = "7" + phoneCleaner;
        }

        if (phoneCleaner.indexOf("7") != 0 || phoneCleaner.length() != 11) {
            System.out.println("Неверный формат номера");
        }
        return phoneCleaner;
    }

    public Boolean validatedPhone(String phone) {
        String phoneCleaner = phone.replaceAll("[^0-9]+", "");

        if (phoneCleaner.indexOf("8") == 0) {
            phoneCleaner = phoneCleaner.replaceFirst("8", "7");
        }

        if (phoneCleaner.length() == 10) {
            phoneCleaner = "7" + phoneCleaner;
        }

        if (phoneCleaner.indexOf("7") != 0 || phoneCleaner.length() != 11) {
            return false;
        }
        return true;
    }

    public void addContact(String phone, String name) {
        if (name.matches(REGEX_NAME) && validatedPhone(phone)) {
            String formattedPhone = phoneFormatter(phone);
            TreeSet<String> newPhone = new TreeSet<>();
            newPhone.add(formattedPhone);

            if (contacts.containsValue(newPhone)) {
                for (String key: contacts.keySet()) {
                    if  (contacts.get(key).equals(newPhone)) {
                        contacts.remove(key);
                    }
                }
                contacts.put(name, newPhone);
                return;
            } else if (contacts.containsKey(name)) {
                TreeSet<String> currentsPhone = contacts.get(name);
                currentsPhone.add(formattedPhone);
                contacts.put(name, currentsPhone);
            } else {
                contacts.put(name, newPhone);
            }
        }

        // проверьте корректность формата имени и телефона (отдельные методы для проверки)
        // если такой номер уже есть в списке, то перезаписать имя абонента
    }

    public String getContactByPhone(String phone) {
        String contact = "";
        TreeSet<String> currentPhones = new TreeSet<>();
        for (TreeSet<String> value : contacts.values()) {
            if (value.contains(phone)) {
                currentPhones = value;
            }
        }

        for (String key : contacts.keySet())  {
            if (contacts.get(key).equals(currentPhones)) {
                String formattedContact = formatContact(key, currentPhones);
                contact = formattedContact;
            }
        }

        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        return contact;

    }

    public Set<String> getContactByName(String name) {
        TreeSet<String> contact = new TreeSet<>();
        if (contacts.keySet().contains(name)) {
            String formattedContact = formatContact(name, contacts.get(name));
            contact.add(formattedContact);
        }

        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        return contact;
    }

    public Set<String> getAllContacts() {

        TreeSet<String> allContacts = new TreeSet<>();

        for (String key : contacts.keySet()) {
            String formatContact = formatContact(key, contacts.get(key));
            allContacts.add(formatContact);
        }

        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        return allContacts;
    }

    public String formatContact(String name, TreeSet<String> phones) {
            String prettyPrintedPhones = "";
            for (String phone : phones) {
                prettyPrintedPhones += phone;
                if (phones.last() != phone && phones.size() > 1) {
                    prettyPrintedPhones += ", ";
                }

            }
            return name + " - " + prettyPrintedPhones;
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