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

    // Getters

    public MemoryType getMemoryType() {
        return MemoryType.valueOf("Тип: " + memoryType);
    }

    public String getCapacity() {
        return "Вместимость: " + capacity;
    }

    public double getWeight() {
        return weight;
    }

}
