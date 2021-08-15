package ru.skillbox;

public class Display {

    // Privat properties

    private final int screenSize;
    private DisplayType displayType = DisplayType.IPS;
    private final double weight;

    // Initialization

    public Display(int screenSize, DisplayType displayType, double weight) {
        this.screenSize = screenSize;
        this.displayType = displayType;
        this.weight = weight;
    }

    // Public methods

    public double getWeight() {
        return weight;
    }

    public String getInformation() {
        return "Диагональ: " + screenSize +
                "\nТип:" + displayType;
    }

}
