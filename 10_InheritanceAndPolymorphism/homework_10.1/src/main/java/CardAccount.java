public class CardAccount extends BankAccount {

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake + (amountToTake * 0.01));
    }

    // не забывайте, обращаться к методам и конструкторам родителя
    // необходимо используя super, например, super.put(10D);
}
