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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (money != account.money) return false;
        return accNumber.equals(account.accNumber);
    }

    @Override
    public int hashCode() {
        int result = accNumber.hashCode();
        result = 31 * result + (int) (money ^ (money >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Номер аккаунта: " + getAccNumber() + ". Остаток на счёте: " + getMoney() + " руб.";
    }


}
