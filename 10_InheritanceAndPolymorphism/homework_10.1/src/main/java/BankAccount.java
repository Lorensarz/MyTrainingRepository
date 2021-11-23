

public class BankAccount {


    private double amountOfMoney;

    public double getAmount() {
        return amountOfMoney;
    }


    public boolean put(double amountToPut) {
        if (amountToPut >= 0) {
            setAmountOfMoney(getAmountOfMoney() + amountToPut);
            return true;
        }
        return false;

    }

    public boolean take(double amountToTake) {
        if (amountToTake <= getAmountOfMoney()) {
            setAmountOfMoney(getAmountOfMoney() - amountToTake);
            return true;
        }
        return false;

    }

    public boolean send(BankAccount receiver, double amount) {
        if (getAmountOfMoney() > 0 && receiver.put(amount)) {
            setAmountOfMoney(getAmountOfMoney() - amount);
            return true;
        }
        return false;
    }

    //Setters and getters

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }
}
