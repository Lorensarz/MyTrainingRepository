
import java.util.Collections;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        sortBySalaryAndAlphabet(staff);


    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        Collections.sort(staff, ((o1, o2) -> {
            if(o1.getSalary().equals (o2.getSalary())) {
                return compareNames(o1.getName(), o2.getName());
            } else if(o1.getSalary() > o2.getSalary()){
                return 1;
            } else if(o1.getSalary() < o2.getSalary()) {
                return -1;
            }
            return 0;
        }));

        for (Employee employee : staff) {
            System.out.println(employee);
        }
        //TODO Метод должен отсортировать сотрудников по заработной плате и алфавиту.
    }

    public static  int compareNames(String lhs, String rhs) {
        int alphabetOffset = lhs.compareTo(rhs);
        if (alphabetOffset >= 1) {
            return 1;
        } else if (alphabetOffset <= -1) {
            return -1;
        } else {
            return 0;
        }

    };

}