public class CardAccount extends BankAccount {

    @Override
    public boolean take(double amountToTake) {
        super.take(amountToTake + (amountToTake * 0.01));
        return true;
    }

    @Override
    public boolean send(BankAccount receiver, double amount) {
        if (amount <= amountOfMoney && receiver.put(amount)) {
            amountOfMoney -= (amount + (amount * 0.01));
            return true;

        }
        return false;

    }

    // не забывайте, обращаться к методам и конструкторам родителя
    // необходимо используя super, например, super.put(10D);
}

