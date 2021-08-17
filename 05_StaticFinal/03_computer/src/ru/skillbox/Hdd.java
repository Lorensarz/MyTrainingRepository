package ru.skillbox;

public class Hdd {

    // Private properties

    HddType hddType;
    private final int capacity;
    private final double weight;

    // Initialization

    public Hdd(HddType hddType, int capacity, double weight) {
        this.hddType = hddType;
        this.capacity = capacity;
        this.weight = weight;
    }

    // Getters

    public String getMemoryType() {
        return "\nТип: " + hddType;
    }

    public String getCapacity() {
        return "\nВместимость: " + capacity;
    }

    public double getWeight() {
        return weight;
    }

}
