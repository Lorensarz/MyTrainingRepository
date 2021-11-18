

public class BankAccount {


    private double amountOfMoney;


    public double getAmount() {
        return amountOfMoney;
    }

    public void put(double amountToPut) {
        if (amountToPut >= 0) {
            amountOfMoney += amountToPut;
        }

    }

    public void take(double amountToTake) {
        if (amountToTake <= amountOfMoney) {
            amountOfMoney -= amountToTake;
        }

    }

}
