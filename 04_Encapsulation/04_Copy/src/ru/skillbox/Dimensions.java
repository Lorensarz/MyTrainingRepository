package ru.skillbox;

public class Dimensions {
        //Габариты — ширина, высота и длина — должны храниться в отдельном иммутабельном классе Dimensions.
    // Создайте класс Dimensions с соответствующими полями и реализуйте в нём метод вычисления объёма груза.
    private final int width;
    private final int hight;
    private final int lenght;
    int cargoVolume;

    public Dimensions(int width, int hight, int lenght) {
        this.width = width;
        this.hight = hight;
        this.lenght = lenght;
    }

    //getters
    public int getWidth() {
        return width;
    }

    public int getHight() {
        return hight;
    }

    public int getLenght() {
        return lenght;
    }

    public int getCargoVolume() {
        cargoVolume = width * hight * lenght;
        return cargoVolume;
    }
//setters


    public Dimensions setWidth(int width) {
        return new Dimensions(width, hight, lenght);
    }

    public Dimensions setHight(int hight) {
        return new Dimensions(width, hight, lenght);
    }

    public Dimensions setLenght(int lenght) {
        return new Dimensions(width, hight, lenght);
    }

    public void setCargoVolume(int cargoVolume) {
        this.cargoVolume = cargoVolume;
    }
}
