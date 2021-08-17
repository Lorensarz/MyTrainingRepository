package ru.skillbox;

public class Computer {

    // Private properties

    private final String vendor;
    private final String name;
    private Cpu myCpu;
    private Ram myRam;
    private Hdd myHdd;
    private Display myDisplay;
    private Keyboard myKeyboard;

    // Initialization

    public Computer(String vendor,
                    String name,
                    Cpu myCpu,
                    Ram myRam,
                    Hdd myHdd,
                    Display myDisplay,
                    Keyboard myKeyboard) {
        this.vendor = vendor;
        this.name = name;
        this.myCpu = myCpu;
        this.myRam = myRam;
        this.myHdd = myHdd;
        this.myDisplay = myDisplay;
        this.myKeyboard = myKeyboard;
    }

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

    public String getTotalWeight() {
        double totalWeight = myCpu.getWeight() +
                myRam.getWeight() +
                myHdd.getWeight() +
                myDisplay.getWeight() +
                myKeyboard.getWeight();

        return "Общий вес ПК: " + totalWeight;
    }

    public String getAllComponents() {
        return "Computer: " + vendor + " " + name +
                "\n\tCPU: " + myCpu.getCoreCount() +
                myCpu.getFrequency() + "GHz" +
                myCpu.getManufacturer() +
                "\n\tDisplay: " + myDisplay.getScreenSize() + "Inch" +
                myDisplay.getDisplayType() +
                "\n\tHDD: " + myHdd.getCapacity() + "Gb" +
                myHdd.getMemoryType() +
                "\n\tKeyboard: " + myKeyboard.getKeyboardType() +
                myKeyboard.isBacklight() +
                "\n\tRAM: " + myRam.getCapacity() + "Gb" +
                myRam.getRamType();
    }

}
