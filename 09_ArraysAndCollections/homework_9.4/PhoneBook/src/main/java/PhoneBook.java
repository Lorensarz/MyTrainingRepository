import java.util.*;

public class PhoneBook {

    TreeMap<String, TreeSet<String>> contacts = new TreeMap<>();

    public void addContact(String phone, String name) {

        if (Validator.nameFormatter(name) &&
                Validator.phoneFormatter(phone) &&
                !phone.isEmpty()) {

            TreeSet<String> newPhone = new TreeSet<>();
            newPhone.add(phone);

            if (contacts.containsValue(newPhone)) {
                for (String key : contacts.keySet()) {
                    if (contacts.get(key).equals(newPhone)) {
                        contacts.remove(key);
                    }
                }
                contacts.put(name, newPhone);
            } else if (contacts.containsKey(name)) {
                TreeSet<String> currentsPhone = contacts.get(name);
                currentsPhone.add(phone);
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

        for (String key : contacts.keySet()) {
            if (contacts.get(key).equals(currentPhones)) {
                contact = formatContact(key, currentPhones);
            }
        }

        return contact;

    }

    public Set<String> getContactByName(String name) {
        TreeSet<String> contact = new TreeSet<>();
        if (contacts.containsKey(name)) {
            String formattedContact = formatContact(name, contacts.get(name));
            contact.add(formattedContact);
        }

        return contact;
    }

    public Set<String> getAllContacts() {

        TreeSet<String> allContacts = new TreeSet<>();

        for (String key : contacts.keySet()) {
            String formatContact = formatContact(key, contacts.get(key));
            allContacts.add(formatContact);
        }

        return allContacts;
    }

    public String formatContact(String name, TreeSet<String> phones) {
        StringBuilder prettyPrintedPhones = new StringBuilder();

        for (String phone : phones) {
            prettyPrintedPhones.append(phone);

            if (!phones.last().equals(phone) && phones.size() > 1) {
                prettyPrintedPhones.append(", ");

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