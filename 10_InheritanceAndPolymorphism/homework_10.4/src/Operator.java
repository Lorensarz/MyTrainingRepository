public class Operator implements Employee {

    private final int salary = (int) (Math.random() * 30000) + 30000;

    @Override
    public int getMonthSalary() {
        return salary;
    }
}
