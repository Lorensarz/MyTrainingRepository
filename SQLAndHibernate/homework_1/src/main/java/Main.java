import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "namezx452672";
        Map<String, String> dataBase = new TreeMap<>();

        try {

            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name,\n" +
                    "COUNT(student_name) / (timestampdiff(month, MIN(subscription_date), MAX(subscription_date)) + 1) AS average_month_pay\n" +
                    "FROM purchaselist\n" +
                    "WHERE YEAR(subscription_date) = 2018\n" +
                    "GROUP BY course_name\n" +
                    "ORDER BY course_name;");

            while (resultSet.next()){
                String courseName = resultSet.getString("course_name");
                String averageMonthPay = resultSet.getString("average_month_pay");
                dataBase.put(courseName, averageMonthPay);
            }
            for (Map.Entry entry : dataBase.entrySet()) {
                System.out.println(entry.getKey() + " - "
                        + entry.getValue());
            }
            connection.close();
            statement.close();
            resultSet.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
