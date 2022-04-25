import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {

    Bank bank;
    Account clientOne;
    Account clientTwo;
    Account clientThree;

    @Before
    public void setUp() {
        bank = new Bank();
        clientOne = new Account("11111111111", 1_500_000);
        clientTwo = new Account("22222222222", 2_000_000);
        clientThree = new Account("44444444444", 2_500_000);

        bank.addAccountToBank(clientOne);
        bank.addAccountToBank(clientTwo);
        bank.addAccountToBank(clientThree);
    }

    @Test
    public void testAllSumMoneyAccounts() {
        long expected = clientOne.getMoney() + clientTwo.getMoney() + clientThree.getMoney();
        long actual = bank.getSumAllAccounts();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTransferBeforeVerificationLimit() {
        bank.transfer(clientOne.getAccNumber(), clientTwo.getAccNumber(), 10_000);
        long expectedClientOne = 1_490_000;
        long actualClientOne = bank.getBalance(clientOne.getAccNumber());
        Assert.assertEquals(expectedClientOne, actualClientOne);

        long expectedClientTwo = 2_010_000;
        long actualClientTwo = bank.getBalance(clientTwo.getAccNumber());
        Assert.assertEquals(expectedClientTwo, actualClientTwo);
    }

    @Test
    public void testTransferAfterVerificationLimit() {
        bank.transfer(clientOne.getAccNumber(), clientTwo.getAccNumber(), 1_000_000);
        long expectedClientOne = 500_000;
        long expectedClientTwo= 3_000_000;

        long actualClientOne = bank.getBalance(clientOne.getAccNumber());
        Assert.assertEquals(expectedClientOne, actualClientOne);

        long actualClientTwo = bank.getBalance(clientTwo.getAccNumber());
        Assert.assertEquals(expectedClientTwo, actualClientTwo);
    }

    @Test
    public void testSumMoneyAfterTransfer() {
        bank.transfer(clientOne.getAccNumber(), clientTwo.getAccNumber(), 100_000);
        long expectedSumMoneyAfterTransfer = 6_000_000;
        long actualSumMoneyAfterTransfer = bank.getSumAllAccounts();
        Assert.assertEquals(expectedSumMoneyAfterTransfer, actualSumMoneyAfterTransfer);
    }
}