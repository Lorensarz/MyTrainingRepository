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
    }

    public void moveDown() {

        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }

    public int getCurrentFloor() {

        return currentFloor;
    }

    public void move(int floor) {
        while (floor >= minFloor) {
            moveUp();
        }
        while (floor <= maxFloor) {
            moveDown();
        }
    }
}
