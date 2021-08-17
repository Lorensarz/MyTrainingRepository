package ru.skillbox;

public class Cpu {

    // Private properties

    private final double frequency;
    private final int coreCount;
    private final String manufacturer;
    private final double weight;

    // Initialization

    public Cpu(double frequency, int coreCount, String manufacturer, double weight) {
        this.frequency = frequency;
        this.coreCount = coreCount;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    // Getters

    public String getFrequency() {
        return "\nЧастота: " + frequency;
    }

    public String getCoreCount() {
        return "\nКоличество ядер: " + coreCount;
    }

    public String getManufacturer() {
        return "\nПроизводитель: " + manufacturer;
    }

    public double getWeight() {
        return weight;
    }

}
