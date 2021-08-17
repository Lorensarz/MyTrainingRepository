package ru.skillbox;

public class Display {

    // Privat properties

    private final int screenSize;
    private final DisplayType displayType;
    private final double weight;

    // Initialization

    public Display(int screenSize, DisplayType displayType, double weight) {
        this.screenSize = screenSize;
        this.displayType = displayType;
        this.weight = weight;
    }

    // Getters

    public String getScreenSize() {
        return "\nДиагональ: " + screenSize;
    }

    public String getDisplayType() {
        return "\nТип:" + DisplayType.IPS;
    }

    public double getWeight() {
        return weight;
    }

}
