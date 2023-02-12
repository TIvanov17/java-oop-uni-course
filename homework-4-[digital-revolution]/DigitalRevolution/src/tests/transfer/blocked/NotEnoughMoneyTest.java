package tests.transfer.blocked;

import abstractcurrency.AbstractCurrency;
import bankclasses.DigitalWallet;
import bankclasses.User;
import bankclasses.CurrencyCreator;
import utility.TestChecker;

public class NotEnoughMoneyTest {

    public static void test(){
        notEnoughCurrencyValueHash();
        System.out.println();
        notEnoughCurrencyValueGold();
    }

    private static void notEnoughCurrencyValueGold(){
        String bankName = "FiBank";

        DigitalWallet walletA = new DigitalWallet(CurrencyCreator.createGold(3));
        User userSender = new User("Pesho Ivanov", bankName, walletA);

        DigitalWallet walletB = new DigitalWallet(CurrencyCreator.createCAD(10));
        User userReceiver = new User("Ivan Ivanov", bankName, walletB);

        AbstractCurrency sendCurrency = CurrencyCreator.createGold(3.1);
        AbstractCurrency receiveCurrency = CurrencyCreator.createCAD(1);

        userSender.sendCurrencyTo(userReceiver, sendCurrency, receiveCurrency);

        TestChecker.printTestResult(3,"GLD", userSender);
        TestChecker.printTestResult(10,"CAD", userReceiver);
    }

    private static void notEnoughCurrencyValueHash(){
        String bankName = "FiBank";

        DigitalWallet walletA = new DigitalWallet(CurrencyCreator.createSBB(10));
        User userSender = new User("Pesho Ivanov", bankName, walletA);

        DigitalWallet walletB = new DigitalWallet(CurrencyCreator.createQAQ(750));
        User userReceiver = new User("Ivan Ivanov", bankName, walletB);

        AbstractCurrency sendCurrency = CurrencyCreator.createSBB(10);
        AbstractCurrency receiveCurrency = CurrencyCreator.createQAQ(1);

        userSender.sendCurrencyTo(userReceiver, sendCurrency, receiveCurrency);

        TestChecker.printTestResult(10,"SBB", userSender);
        TestChecker.printTestResult(750,"QAQ", userReceiver);
    }
}
