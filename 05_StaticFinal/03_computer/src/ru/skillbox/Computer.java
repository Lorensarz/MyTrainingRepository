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

    public Computer(String vendor, String name, Cpu myCpu, Ram myRam, Hdd myHdd, Display myDisplay, Keyboard myKeyboard) {
        this.vendor = vendor;
        this.name = name;
        this.myCpu = myCpu;
        this.myRam = myRam;
        this.myHdd = myHdd;
        this.myDisplay = myDisplay;
        this.myKeyboard = myKeyboard;
    }

    // Internal properties

    static Cpu myCpu = new Cpu(3.2, 4, "intel", 110);
    static Ram myRam = new Ram(RamType.DDR4, 4, 80);
    static Hdd myHdd = new Hdd(MemoryType.SSD, 500, 250);
    static Display myDisplay = new Display(27, DisplayType.IPS, 6100);
    static Keyboard myKeyboard = new Keyboard(KeyboardType.MEHANICAL, true, 715);

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
        Computer.myCpu = myCpu;
    }

    public void setMyRam(Ram myRam) {
        Computer.myRam = myRam;
    }

    public void setMyHdd(Hdd myHdd) {
        Computer.myHdd = myHdd;
    }

    public void setMyDisplay(Display myDisplay) {
        Computer.myDisplay = myDisplay;
    }

    public void setMyKeyboard(Keyboard myKeyboard) {
        Computer.myKeyboard = myKeyboard;
    }

    // Public methods

    public static String getTotalWeight() {
        return "Общий вес ПК: " + myCpu.getWeight() +
                myRam.getWeight() +
                myHdd.getWeight() +
                myDisplay.getWeight() +
                myKeyboard.getWeight();
    }

    public static String getAllComponents() {
        return myCpu.getCoreCount() +
                myCpu.getFrequency() +
                myCpu.getManufacturer() +
                myDisplay.getScreenSize() +
                myDisplay.getDisplayType() +
                myHdd.getCapacity() +
                myHdd.getMemoryType() +
                myKeyboard.getKeyboardType() +
                myKeyboard.isBacklight() +
                myRam.getCapacity() +
                myRam.getRamType();
    }

}