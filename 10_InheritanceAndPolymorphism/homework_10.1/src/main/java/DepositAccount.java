import java.time.LocalDate;


public class DepositAccount extends BankAccount {

    LocalDate date = LocalDate.now();
    LocalDate lastIncome = date.plusMonths(1);

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
    }

    @Override
    public void take(double amountToTake) {
        if (date.isAfter(lastIncome)) {
            super.take(amountToTake);
        }
    }

}

