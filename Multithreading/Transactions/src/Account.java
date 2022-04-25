public class Account {


    private String accNumber;
    private long money;
    private boolean isBlocked;

    public Account(String accNumber, long money) {
        this.money = money;
        this.accNumber = accNumber;
        isBlocked = false;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean getStatus() {
        return isBlocked;
    }

    public void blockedAccount() {
        isBlocked = true;
    }

    @Override
    public String toString() {
        return "Номер аккаунта: " + getAccNumber() + ". Остаток на счёте: " + getMoney() + " руб.";
    }


}
