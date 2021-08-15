package ru.skillbox;

public class Computer {

    // Private properties

    private final String vendor;
    private final String name;

    // Initialization

    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

    // Internal properties

    Cpu myCpu = new Cpu(3.2, 4, "intel", 110);
    Ram myRam = new Ram(RamType.DDR4, 4, 80);
    Hdd myHdd = new Hdd(MemoryType.SSD, 500, 250);
    Display myDisplay = new Display(27, DisplayType.IPS, 6100);
    Keyboard myKeyboard = new Keyboard(KeyboardType.MEHANICAL, true, 715);

    // Getters

    public Cpu getMyCpu() {
        return myCpu;
    }

    public Ram getMyRam() {
        return myRam;
    }

    public Hdd getMyHdd() {
        return myHdd;
    }

    public Display getMyDisplay() {
        return myDisplay;
    }

    public Keyboard getMyKeyboard() {
        return myKeyboard;
    }

    // Setters

    public void setMyCpu(Cpu myCpu) {
        this.myCpu = myCpu;
    }

    public void setMyRam(Ram myRam) {
        this.myRam = myRam;
    }

    public void setMyHdd(Hdd myHdd) {
        this.myHdd = myHdd;
    }

    public void setMyDisplay(Display myDisplay) {
        this.myDisplay = myDisplay;
    }

    public void setMyKeyboard(Keyboard myKeyboard) {
        this.myKeyboard = myKeyboard;
    }

    // Public methods

    /**
     * // Если сделать все классы наследником класса Component которые будут заимствовать переменную Weight
     * и геттеры Weight
     * // Можно использовать полиморфизм, обьеденяя под одним типом разные компоненты
     * public double getTotalWeight() {
     * int componentsCount = 5;
     * Component[] components = new Component[] {myCpu, myRam, myHdd, myDisplay, myKeyboard};
     * Double totalWeight;
     * for(int index = 0; index < componentsCount; index += 1) {
     * totalWeight += components[index].getWeight();
     * }
     * return totalWeight;
     * }
     */

    public double getTotalWeight() {
        return myCpu.getWeight() +
                myRam.getWeight() +
                myHdd.getWeight() +
                myDisplay.getWeight() +
                myKeyboard.getWeight();
    }

    // Object inheritances

    @Override
    public String toString() {
        return "Computer: " + vendor + " " + name +
                "\n\tmyCpu:\n" + myCpu.getInformation() +
                "\n\tmyRam:\n" + myRam.getInformation() +
                "\n\tmyHdd:\n" + myHdd.getInformation() +
                "\n\tmyDisplay:\n" + myDisplay.getInformation() +
                "\n\tmyKeyboard:\n" + myKeyboard.getInformation() +
                "\n\tОбщий вес ПК:\n" + getTotalWeight() + " г.";
    }

}