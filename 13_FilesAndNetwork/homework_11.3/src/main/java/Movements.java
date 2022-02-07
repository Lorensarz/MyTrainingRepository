import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Movements {

    public Movements(String pathMovementsCsv) {
        this.filePath = pathMovementsCsv;
        startParsing();


    }

    private List<Fields> fields;
    private final String filePath;

    public void startParsing() {
        try {
            parseMovementList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Fields> parseMovementList() throws IOException {
        List<Fields> bankingHistoriesList = new ArrayList<>();
        List<String> fileLines = Files.readAllLines(Paths.get(filePath));
        fields = new ArrayList<>();
        for (String fileLine : fileLines) {
            String[] splitedText = fileLine.split(",");
            ArrayList<String> columnList = new ArrayList<>();
            for (String s : splitedText) {
                if (isColumnPart(s)) {
                    String lastText = columnList.get(columnList.size() - 1);
                    columnList.set(columnList.size() - 1,
                            lastText.replaceAll("\"", "") + "," +
                                    s.replaceAll("\"", ""));
                } else {
                    columnList.add(s);
                }
            }

            Fields field = new Fields();
            field.setAccountType(columnList.get(0));
            field.setAccountNumber(columnList.get(1));
            field.setCurrency(columnList.get(2));
            field.setDateOperation(columnList.get(3));
            field.setWiringReference(columnList.get(4));
            field.setOperationDescription(columnList.get(5));
            field.setIncome(columnList.get(6));
            field.setExpense(columnList.get(7));
            bankingHistoriesList.add(field);
            fields.add(field);
        }
        return bankingHistoriesList;
    }

    public double getExpenseSum() {
        double sum = 0;
        for (Fields expense : fields) {
            try {
                double doubleExpense = Double.parseDouble(expense.getExpense());
                sum += doubleExpense;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return sum;

    }

    public double getIncomeSum() {
        double sum = 0;
        for (Fields income : fields) {
            try {
                double doubleIncome = Double.parseDouble(income.getIncome());
                sum += doubleIncome;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sum;
    }

    public String getColumnOperationDescription() {
        return "";
    }


    private boolean isColumnPart(String text) {
        String trimText = text.trim();
        return trimText.indexOf("\"") == trimText.lastIndexOf("\"") && trimText.endsWith("\"");
    }

}
