package ru.skillbox;

public class Hdd {

    // Private properties

    MemoryType memoryType;
    private final int capacity;
    private final double weight;

    // Initialization

    public Hdd(MemoryType memoryType, int capacity, double weight) {
        this.memoryType = memoryType;
        this.capacity = capacity;
        this.weight = weight;
    }

    // Public methods

    public double getWeight() {
        return weight;
    }

    public String getInformation() {
        return "Тип: " + memoryType +
                "\nОбъем памяти: " + capacity;
    }

}
