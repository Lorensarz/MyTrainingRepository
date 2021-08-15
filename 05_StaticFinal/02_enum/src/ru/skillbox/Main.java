package ru.skillbox;

import ru.skillbox.ArithmeticCalculator;
import ru.skillbox.Operation;
public class Main {
    public static void main(String[] args) {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(1, 2);
        double result = arithmeticCalculator.calculate(Operation.MULTIPLY);
        System.out.println(result);
    }
}
