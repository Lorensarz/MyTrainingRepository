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
        return "Частота: " + frequency;
    }

    public String getCoreCount() {
        return "Количество ядер: " + coreCount;
    }

    public String getManufacturer() {
        return "Производитель: " + manufacturer;
    }

    public double getWeight() {
        return weight;
    }

}
