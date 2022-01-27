import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Movements {

    public Movements(String pathMovementsCsv) {

    }

    public static List<Fields> parseMovementList(String filePath) throws IOException {
        List<Fields> bankingHistoriesList = new ArrayList<>();
        List<String> fileLines = Files.readAllLines(Paths.get(filePath));
        for (String fileLine : fileLines) {
            String[] splitedText = fileLine.split(",");
            ArrayList<String> columnList = new ArrayList<>();
            for (String s : splitedText) {
                if (isColumnPart(s)) {
                    String lastText = columnList.get(columnList.size() - 1);
                    columnList.set(columnList.size() - 1, lastText + "," + s);
                } else {
                    columnList.add(s);
                }
            }
            Fields fields = new Fields();
            fields.accountType = columnList.get(0);
            fields.accountNumber = columnList.get(1);
            fields.currency = columnList.get(2);
            fields.dateOperation = columnList.get(3);
            fields.wiringReference = columnList.get(4);
            fields.operationDescription = columnList.get(5);
            fields.income = columnList.get(6);
            fields.expense = columnList.get(7);
            bankingHistoriesList.add(fields);
        }
        return bankingHistoriesList;
    }

    public double getExpenseSum() {
        return 0.0;
    }

    public double getIncomeSum() {
        return 0.0;
    }

    private static boolean isColumnPart(String text) {
        String trimText = text.trim();
        return trimText.indexOf(",") == trimText.lastIndexOf(",") && trimText.endsWith(",");
    }
}
