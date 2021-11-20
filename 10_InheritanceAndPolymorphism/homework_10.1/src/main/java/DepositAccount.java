import java.time.LocalDate;


public class DepositAccount extends BankAccount {


    private LocalDate lastIncome;

    @Override
    public boolean put(double amountToPut) {
        lastIncome = LocalDate.now();
        super.put(amountToPut);
        return true;
    }

    @Override
    public boolean take(double amountToTake) {
        if (LocalDate.now().isAfter(lastIncome.plusMonths(1))) {
            super.take(amountToTake);
            return true;
        }
        return false;
    }

    @Override
    public boolean send(BankAccount receiver, double amount) {
        if (LocalDate.now().isAfter(lastIncome.plusMonths(1))) {
            if (amount <= amountOfMoney) {
                receiver.put(amount);
                amountOfMoney -= amount;
                return true;

            }
            return false;

        }
        return true;

    }
}

