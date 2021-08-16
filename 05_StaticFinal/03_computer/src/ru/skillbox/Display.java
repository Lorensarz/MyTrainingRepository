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
        return "Диагональ: " + screenSize;
    }

    public DisplayType getDisplayType() {
        return DisplayType.valueOf("Диагональ" + this.displayType);
    }

    public double getWeight() {
        return weight;
    }

}
