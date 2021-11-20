

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        CardAccount cardAccount = new CardAccount();
        DepositAccount depositAccount = new DepositAccount();
        System.out.println(cardAccount.put(200));
        System.out.println(cardAccount.getAmount());
        System.out.println(cardAccount.send(depositAccount, 50));
        System.out.println(cardAccount.getAmount());
        System.out.println(depositAccount.getAmount());


    }
}
