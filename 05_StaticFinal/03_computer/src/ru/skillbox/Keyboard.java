package ru.skillbox;

public class Keyboard {

    // Private properties

    private KeyboardType keyboardType = KeyboardType.MEHANICAL;
    private final boolean backlight;
    private final double weight;

    // Initialization

    public Keyboard(KeyboardType keyboardType, boolean backlight, double weight) {
        this.keyboardType = keyboardType;
        this.backlight = backlight;
        this.weight = weight;
    }

    // Public methods

    public double getWeight() {
        return weight;
    }

    public String getInformation() {
        String backlight = "";
        if (this.backlight) {
            backlight = "Есть";
        } else {
            backlight = "Нету";
        }
        return "Тип: " + keyboardType +
                "\nПодсветка: " + backlight;
    }

}
