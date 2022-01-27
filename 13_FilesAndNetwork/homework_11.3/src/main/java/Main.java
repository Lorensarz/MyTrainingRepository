import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath =
                "C:\\Skillbox\\java_basics\\13_FilesAndNetwork\\homework_11.3\\src\\test\\resources\\movementList.csv";
        Movements.parseMovementList(filePath);
        List<Object> movements = new ArrayList<>();
        movements.add(Movements.parseMovementList(filePath));
        StringBuilder str = new StringBuilder();
        for (Object move : movements) {
            str.append(move).append(",");
        }
        System.out.println(str);

    }
}
