

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        CardAccount cardAccount = new CardAccount();
        DepositAccount depositAccount = new DepositAccount();
        bankAccount.put(200);
        System.out.println("bankAccount - " + bankAccount.getAmount());
        bankAccount.send(cardAccount, 50);
        System.out.println("bankAccount - " + bankAccount.getAmount());
        System.out.println("cardAccount - " + cardAccount.getAmount());


    }
}
