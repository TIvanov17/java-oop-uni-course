package tests.transfer.blocked;

import abstractcurrency.AbstractCurrency;
import bankclasses.DigitalWallet;
import bankclasses.User;
import bankclasses.CurrencyCreator;
import enums.DigitalWalletStateEnum;
import utility.TestChecker;

public class BlockedUserWalletTest {

    public static void test(){
        blockedUserSenderWallet();
        System.out.println();
        blockedUserReceiverWallet();
    }

    private static void blockedUserReceiverWallet(){

        String userSenderBankName = "FiBank";
        String userReceiverBankName = "MiBank";

        DigitalWallet walletA = new DigitalWallet(CurrencyCreator.createUSD(100));

        User userSender = new User("Pesho Ivanov", userSenderBankName, walletA);

        DigitalWallet walletB = new DigitalWallet(
                CurrencyCreator.createUSD(0),
                DigitalWalletStateEnum.BLOCKED_STATE
        );

        User userReceiver = new User("Ivan Ivanov", userReceiverBankName, walletB);

        AbstractCurrency sendCurrency = CurrencyCreator.createUSD(50);
        AbstractCurrency receiveCurrency = CurrencyCreator.createUSD(1);

        userSender.sendCurrencyTo(userReceiver, sendCurrency, receiveCurrency);

        TestChecker.printTestResult(100,"USD", userSender);
        TestChecker.printTestResult(0, "USD", userReceiver);
    }

    private static void blockedUserSenderWallet(){

        String userSenderBankName = "FiBank";
        String userReceiverBankName = "MiBank";

        DigitalWallet walletA = new DigitalWallet(
                CurrencyCreator.createUSD(100),
                DigitalWalletStateEnum.BLOCKED_STATE
        );

        User userSender = new User("Pesho Ivanov", userSenderBankName, walletA);

        DigitalWallet walletB = new DigitalWallet(CurrencyCreator.createUSD(0));
        User userReceiver = new User("Ivan Ivanov", userReceiverBankName, walletB);

        AbstractCurrency sendCurrency = CurrencyCreator.createUSD(50);
        AbstractCurrency receiveCurrency = CurrencyCreator.createUSD(1);

        userSender.sendCurrencyTo(userReceiver, sendCurrency, receiveCurrency);

        TestChecker.printTestResult(100,"USD", userSender);
        TestChecker.printTestResult(0, "USD", userReceiver);

    }
}
