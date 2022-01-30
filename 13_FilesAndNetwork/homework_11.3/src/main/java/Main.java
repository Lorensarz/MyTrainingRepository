

public class Main {
    public static void main(String[] args) {
        String filePath =
                "C:\\Skillbox\\java_basics\\13_FilesAndNetwork\\homework_11.3\\src\\test\\resources\\movementList.csv";
        Movements movements = new Movements(filePath);
        System.out.println("Суммы расходо: " + movements.getExpenseSum());
        System.out.println("Сумммы доходов: " + movements.getIncomeSum());
        System.out.println();


    }
}
