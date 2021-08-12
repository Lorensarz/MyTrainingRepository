package ru.skillbox;

public enum Operation {
    ADD,

    SUBTRACT,

    MULTIPLY;

    double calculate(double a, double b) {

        switch (this) {

            case ADD:
                return a + b;

            case SUBTRACT:
                return a - b;

            case MULTIPLY:
                return a * b;
            default:
                throw new AssertionError("Unknown operations " + this);
        }
    }
}
