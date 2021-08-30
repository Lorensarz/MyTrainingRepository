import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final int MAX_COUNT_BOXES_IN_CONTAINER = 27;
    private static final int MAX_COUNT_CONTAINERS_IN_TRUCK = 12;
    private static final int MAX_COUNT_BOXES_IN_TRUCK = MAX_COUNT_BOXES_IN_CONTAINER *
            MAX_COUNT_CONTAINERS_IN_TRUCK;

    private static int totalContainers = 1;
    private static int totalTrucks = 1;




    private static int calculateContainersCount(int boxes) {

        totalContainers = boxes / MAX_COUNT_BOXES_IN_CONTAINER;

        int remainderOfTheDivisionBoxes = boxes % MAX_COUNT_BOXES_IN_CONTAINER;
        if (remainderOfTheDivisionBoxes > 0) {
            totalContainers++;
        }
        return totalContainers++;

    }

    private static int calculateTrucksCount(int boxes) {
        totalTrucks = boxes / MAX_COUNT_BOXES_IN_TRUCK;

        int remainderOfTheDivisionContainers = totalContainers % MAX_COUNT_CONTAINERS_IN_TRUCK;
        if (remainderOfTheDivisionContainers > 0) {
            totalTrucks++;
        }
        return totalTrucks++;

    }

    private static void printCalculateInformation(int boxes, int totalContainers, int totalTrucks) {

        int box;
        int boxesCounter = 0;
        int containersCounter = 0;


        System.out.println("Грузовик: " + totalTrucks);
        System.out.println("\tКонтейнер: " + totalContainers);

        for (box = 1; box <= boxes; box++) {
            System.out.println("\t\tЯщик: " + box);

            containersCounter++;
            if (containersCounter == MAX_COUNT_BOXES_IN_TRUCK) {
                totalTrucks++;
                System.out.println("Грузовик: " + totalTrucks);
                containersCounter = 0;

            }

            boxesCounter++;
            if (boxesCounter == MAX_COUNT_BOXES_IN_CONTAINER) {
                totalContainers++;
                System.out.println("\tКонтейнер: " + totalContainers);
                boxesCounter = 0;

            }
        }

    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int boxes = scanner.nextInt();

        printCalculateInformation(boxes, totalContainers, totalTrucks);
        System.out.println("Необходимо:" + System.lineSeparator() + "Грузовиков - " + calculateTrucksCount(boxes) + " шт." +
                System.lineSeparator() + "Контейнеров - " + calculateContainersCount(boxes) + " шт.");

        ;


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
