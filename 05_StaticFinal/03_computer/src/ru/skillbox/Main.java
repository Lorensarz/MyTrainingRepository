package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        // Создаем новые объекты компликтующих ПК

        Cpu newCpu = new Cpu(3.2, 4, "Intel", 110);
        Display newDisplay = new Display(47, DisplayType.IPS, 6200);
        Hdd newHdd = new Hdd(HddType.HDD, 1000, 500);
        Keyboard newKeyboard = new Keyboard(KeyboardType.MEHANICAL, true, 600);
        Ram newRam = new Ram(RamType.DDR4, 4, 200);

        // Создаем новый объект ПК

        Computer newComputer = new Computer(
                "HP",
                "Home PC",
                newCpu,
                newRam,
                newHdd,
                newDisplay,
                newKeyboard
        );

        System.out.println(newComputer.getAllComponents());
        System.out.println(newComputer.getTotalWeight());

    }

}
