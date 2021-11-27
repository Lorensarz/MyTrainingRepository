public class TopManager implements Employee {
    private final int salary = (int) (Math.random() * 50000) + 50000;
    Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        if (company.getIncome() > 10_000_000) {
            return (int) (salary * 1.5);
        }
        return salary;
    }
}
