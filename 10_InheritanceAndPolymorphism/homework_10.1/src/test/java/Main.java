

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        CardAccount cardAccount = new CardAccount();
        DepositAccount depositAccount = new DepositAccount();
        cardAccount.put(200);
        System.out.println("cardAccount - " + cardAccount.getAmount());
        cardAccount.send(bankAccount, 50);
        System.out.println("cardAccount - " + cardAccount.getAmount());
        System.out.println("bankAccount - " + bankAccount.getAmount());


    }
}
