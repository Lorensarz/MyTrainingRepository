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

    // Getters

    public String getKeyboardType() {
        return "\nТип: " + keyboardType;
    }

    public String isBacklight() {
        String backlight = "";
        if (this.backlight) {
            backlight = "Есть";
        } else {
            backlight = "Нету";
        }
        return "\nПодсветка: " + backlight;
    }

    public double getWeight() {
        return weight;
    }

}
