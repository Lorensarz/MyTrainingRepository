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

    public KeyboardType getKeyboardType() {
        return KeyboardType.valueOf("Тип: " + keyboardType);
    }

    public String isBacklight() {
        return "Подсветка: " + backlight;
    }

    public double getWeight() {
        return weight;
    }

}
