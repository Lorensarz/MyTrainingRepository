package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Computer computer = new Computer("HP", "Home PC");
        System.out.println(Computer.getAllComponents());
        System.out.println(Computer.getTotalWeight());
    }

}
