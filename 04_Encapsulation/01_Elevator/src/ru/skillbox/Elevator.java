package ru.skillbox;

public class Elevator {
    public int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public void moveUp() {

        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
        System.out.println("Текущий этаж после движения вверх: " + getCurrentFloor());
    }

    public void moveDown() {

        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
        System.out.println("Текущий этаж после движения вниз: " + getCurrentFloor());
    }

    public int getCurrentFloor() {

        return currentFloor;
    }

    public void move(int floor) {
        if (floor > maxFloor || floor < minFloor) {
            System.out.println("Не правильно введен этаж!");
        } else {

            while (currentFloor < floor) {
                moveUp();
                System.out.println("Едем на: " + floor);
            }

            while (currentFloor > floor) {
                moveDown();
                System.out.println("Едем на: " + floor);

            }
        }
    }
}