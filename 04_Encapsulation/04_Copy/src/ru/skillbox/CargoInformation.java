package ru.skillbox;

public class CargoInformation {
    /*
    -Создайте иммутабельный класс для хранения информации о грузах, передаваемых в курьерскую службу.
    Название класса придумайте самостоятельно.
    -Создайте у класса следующие поля:
    габариты;
    масса;
    адрес доставки;
    свойство — можно ли переворачивать;
    регистрационный номер (может содержать буквы);
    является ли груз хрупким.
    -Типы полей задайте в соответствии с данными, которые в них содержатся.
    -Габариты — ширина, высота и длина — должны храниться в отдельном иммутабельном классе Dimensions.
    - Создайте класс Dimensions с соответствующими полями и реализуйте в нём метод вычисления объёма
     груза (название метода придумайте самостоятельно).
    -Реализуйте в классе методы, дающие возможность изменять адрес доставки, габариты и массу груза
     без изменения исходного объекта путём создания его копии.
    */
    private final Dimensions dimensions;
    private final int weight;
    private final String deliveryAddress;
    private final boolean reversible;
    private final String registrationNumber;
    private final boolean fragility;

    public CargoInformation(int width, int hight, int lenght, int weight, String deliveryAddress, boolean reversible, String registrationNumber, boolean fragility) {
        dimensions = new Dimensions(width, hight, lenght);
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.reversible = reversible;
        this.registrationNumber = registrationNumber;
        this.fragility = fragility;

        System.out.println("Объем посылки -  " + dimensions.getCargoVolume());

    }


    public int getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isReversible() {
        return reversible;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isFragility() {

        return fragility;
    }

    public CargoInformation setDeliveryAddress(String deliveryAdres) {
        return new CargoInformation(dimensions.getWidth(), dimensions.getHight(), dimensions.getLenght(), weight, deliveryAddress, reversible, registrationNumber, fragility);
    }
    public CargoInformation setWidth(int width) {
        return new CargoInformation(dimensions.getWidth(), dimensions.getHight(), dimensions.getLenght(), weight, deliveryAddress, reversible, registrationNumber, fragility);
    }
    public CargoInformation setHight(int hight) {
        return new CargoInformation(dimensions.getWidth(), dimensions.getHight(), dimensions.getLenght(), weight, deliveryAddress, reversible, registrationNumber, fragility);
    }
    public CargoInformation setLenght(int lenght) {
        return new CargoInformation(dimensions.getWidth(), dimensions.getHight(), dimensions.getLenght(), weight, deliveryAddress, reversible, registrationNumber, fragility);
    }

    public CargoInformation setWeight(int weight) {
        return new CargoInformation(dimensions.getWidth(), dimensions.getHight(), dimensions.getLenght(), weight, deliveryAddress, reversible, registrationNumber, fragility);
    }

    public CargoInformation setReversible(boolean reversible) {
        return new CargoInformation(dimensions.getWidth(), dimensions.getHight(), dimensions.getLenght(), weight, deliveryAddress, reversible, registrationNumber, fragility);
    }

    public CargoInformation setRegistrationNumber(String registrationNumber) {
        return new CargoInformation(dimensions.getWidth(), dimensions.getHight(), dimensions.getLenght(), weight, deliveryAddress, reversible, registrationNumber, fragility);
    }

    public CargoInformation setFragility(boolean fragility) {
        return new CargoInformation(dimensions.getWidth(), dimensions.getHight(), dimensions.getLenght(), weight, deliveryAddress, reversible, registrationNumber, fragility);
    }

    public String toString() {
        return "\tгабариты - " + dimensions.getWidth() + "x" + dimensions.getHight() + "x" + dimensions.getLenght() +
                "\n\tмасса - " + weight +
                "\n\tадрес доставки - " + deliveryAddress +
                "\n\tсвойство — можно ли переворачивать - " + reversible +
                "\n\tрегистрационный номер - " + registrationNumber +
                "\n\tявляется ли груз хрупким - " + fragility;
    }


}
