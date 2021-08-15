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

    // Public methods

    public double getWeight() {
        return weight;
    }

    public String getInformation() {
        return "Производитель: " + this.manufacturer +
                "\nЧастота: " + this.frequency +
                "\nКол-во ядер: " + this.coreCount;
    }


}
