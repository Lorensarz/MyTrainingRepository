package ru.skillbox;

public enum AvailableFrequencies {
    GHZ1_8,
    GHZ2_0,
    GHZ3_2,
    GHZ3_5,
    GHZ3_8;

    // public properties

    public String stringedRepresentation = getValue();

    // Private methods

    private String getValue() {
        /**
         Этот код не работает и кидает исключние на null по ссылке на объект, хотя работать должен
         */
        switch (this) {
            case GHZ1_8:
                return "1.8 Ghz";
            case GHZ2_0:
                return "2 GHZ";
            case GHZ3_2:
                return "3.2 Ghz";
            case GHZ3_5:
                return "3.5 GHZ";
            case GHZ3_8:
                return "3.8 GHZ";
            default:
                return "Unknown frequency";
        }
    }

}
