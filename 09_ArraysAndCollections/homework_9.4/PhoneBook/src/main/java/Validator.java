public class Validator {
    private final static String REGEX_NAME = "[А-Яа-яЁё]+";

    public static boolean nameFormatter(String name) {
        return name.matches(REGEX_NAME);
    }

    public static boolean phoneFormatter(String phone) {
        String phoneCleaner = phone.replaceAll("[^0-9]+", "");

        if (phoneCleaner.indexOf("7") == 0) {
            phoneCleaner = phoneCleaner.replaceFirst("7", "8");

        }

        if (phoneCleaner.length() == 10) {
            phoneCleaner = "8" + phoneCleaner;

        }

        if (phoneCleaner.indexOf("8") != 0 || phoneCleaner.length() != 11) {
            return false;

        }
        return true;

    }
}


