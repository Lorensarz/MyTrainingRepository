import java.util.Scanner;

public class Main {

    private static final int MAX_COUNT_BOXES_IN_CONTAINER = 27;
    private static final int MAX_COUNT_CONTAINERS_IN_TRUCK = 12;

    private static int totalContainers = 0;
    private static int totalTrucks = 0;


    private static int calculateContainersCount(int boxes) {

        totalContainers = boxes / MAX_COUNT_BOXES_IN_CONTAINER;

        int remainderOfTheDivisionBoxes = boxes % MAX_COUNT_BOXES_IN_CONTAINER;
        if (remainderOfTheDivisionBoxes > 0) {
            totalContainers++;
        }
        return totalContainers;

    }

    private static int calculateTrucksCount(int totalContainers) {
        totalTrucks = totalContainers / MAX_COUNT_CONTAINERS_IN_TRUCK;

        int remainderOfTheDivisionContainers = totalContainers % MAX_COUNT_CONTAINERS_IN_TRUCK;
        if (remainderOfTheDivisionContainers > 0) {
            totalTrucks++;
        }
        return totalTrucks;

    }

   private static void printCalculateInformation(int boxes, int totalContainers, int totalTrucks) {
        for (int boxesCounter = 1; boxesCounter <= boxes; boxesCounter++) {

            }

        }



    public static void main(String[] args) {
        System.out.println("Введите кол-во ящиков: ");
        Scanner scanner = new Scanner(System.in);
        int boxes = scanner.nextInt();

        printCalculateInformation(boxes, totalContainers, totalTrucks);


        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }
}
