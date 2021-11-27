import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Company company = new Company();

        List<Employee> workers = new ArrayList<>();

        for (int i = 0; i < 180; i++) {
            company.hire(new Operator());
        }

        for (int i = 0; i < 80; i++) {
            workers.add(new Manager());
            if (i % 8 == 0) {
                workers.add(new TopManager(company));
            }
        }
        company.hireAll(workers);
        printEmployees(company);
        System.out.println("------------------");
        List<Employee> employees = company.getEmployees();
        for (int i = 0; i < employees.size() / 2; i++) {
            company.fire(employees.get(i));
        }
        printEmployees(company);


    }

    private static void printEmployees(Company company) {
        System.out.println("Топ 10 наибольших зарплат:");
        List<Employee> topSalaryStaff = company.getTopSalaryStaff(10);
        for (Employee e : topSalaryStaff) {
            System.out.println(e.getMonthSalary());
        }
        System.out.println("------------------");
        System.out.println("Топ 10 наименьших зарплат:");
        List<Employee> lowestSalaryStaff = company.getLowestSalaryStaff(10);
        for (Employee e : lowestSalaryStaff) {
            System.out.println(e.getMonthSalary());
        }
    }


}
