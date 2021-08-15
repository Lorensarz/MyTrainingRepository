package ru.skillbox;

public class Ram {

    // Private properties

    private final RamType ramType;
    private final int capacity;
    private final double weight;

    // Iniatialization

    public Ram(RamType ramType, int capacity, double weight) {
        this.ramType = ramType;
        this.capacity = capacity;
        this.weight = weight;
    }

    // Public methods

    public double getWeight() {
        return weight;
    }

    public String getInformation() {
        return "Тип: " + ramType +
                "\nОбЪем: " + capacity;
    }

}

