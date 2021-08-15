package ru.skillbox;
import static ru.skillbox.Operation.ADD;

public class ArithmeticCalculator {
    int a;
    int b;

    public ArithmeticCalculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public double calculate(Operation operation) {

            switch (operation) {

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
