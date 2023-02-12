package tests.transfer;

import abstractcurrency.AbstractCurrency;
import bankclasses.CurrencyCreator;
import bankclasses.DigitalWallet;
import bankclasses.User;
import utility.TestChecker;

public class EqualWalletTransferTests {

    public static void test(){
        transferFiatToHash();
        System.out.println();
        transferFiatToNFT();
        System.out.println();
        transferGoldToUsd();
        System.out.println();
        transferHashToGold();
        System.out.println();
        transferNftToFiat();
    }

    private static void transferFiatToHash(){
        String bankName = "FiBank";

        DigitalWallet walletA = new DigitalWallet(CurrencyCreator.createJAP(100));
        User userSender = new User("Pesho Ivanov", bankName, walletA);

        DigitalWallet walletB = new DigitalWallet(CurrencyCreator.createRTA(150));
        User userReceiver = new User("Ivan Ivanov", bankName, walletB);

        AbstractCurrency sendCurrency = CurrencyCreator.createJAP(50);
        AbstractCurrency receiveCurrency = CurrencyCreator.createRTA(1);

        userSender.sendCurrencyTo(userReceiver, sendCurrency, receiveCurrency);

        TestChecker.printTestResult(48.5714,"JAP", userSender);
        TestChecker.printTestResult(850,"RTA", userReceiver);
    }

    private static void transferFiatToNFT(){

        String bankName = "FiBank";

        DigitalWallet walletA = new DigitalWallet(CurrencyCreator.createUSD(100));
        User userSender = new User("Pesho Ivanov", bankName, walletA);

        DigitalWallet walletB = new DigitalWallet(CurrencyCreator.createCHF(10));
        User userReceiver = new User("Ivan Ivanov", bankName, walletB);

        AbstractCurrency sendCurrency = CurrencyCreator.createUSD(50);
        AbstractCurrency receiveCurrency = CurrencyCreator.createNFT("genericMonkey");

        userSender.sendCurrencyTo(userReceiver, sendCurrency, receiveCurrency);

        TestChecker.printTestResult(49,"USD",userSender);
        TestChecker.printTestResult(10, "CHF", userReceiver);
        TestChecker.printTestResult(500, "genericMonkey", userReceiver);

        System.out.println();

        AbstractCurrency newSendCurrency = CurrencyCreator.createUSD(40);
        AbstractCurrency newReceiveCurrency = CurrencyCreator.createNFT("coolArt");

        userSender.sendCurrencyTo(userReceiver, newSendCurrency, newReceiveCurrency);

        TestChecker.printTestResult(8,"USD",userSender);
        TestChecker.printTestResult(10, "CHF", userReceiver);
        TestChecker.printTestResult(500, "genericMonkey", userReceiver);
        TestChecker.printTestResult(400, "coolArt", userReceiver);

    }

    private static void transferGoldToUsd(){
        String bankName = "FiBank";

        DigitalWallet walletA = new DigitalWallet(CurrencyCreator.createGold(3));
        User userSender = new User("Pesho Ivanov", bankName, walletA);

        DigitalWallet walletB = new DigitalWallet(CurrencyCreator.createUSD(0));
        User userReceiver = new User("Ivan Ivanov", bankName, walletB);

        AbstractCurrency sendCurrency = CurrencyCreator.createGold(2.2);
        AbstractCurrency receiveCurrency = CurrencyCreator.createUSD(1);

        userSender.sendCurrencyTo(userReceiver, sendCurrency, receiveCurrency);

        TestChecker.printTestResult(0.79,"GLD", userSender);
        TestChecker.printTestResult(220,"USD", userReceiver);

    }

    private static void transferHashToGold(){
        String bankName = "FiBank";

        DigitalWallet walletA = new DigitalWallet(CurrencyCreator.createSBB(100));
        User userSender = new User("Pesho Ivanov", bankName, walletA);

        DigitalWallet walletB = new DigitalWallet(CurrencyCreator.createGold(0.6));
        User userReceiver = new User("Ivan Ivanov", bankName, walletB);

        AbstractCurrency sendCurrency = CurrencyCreator.createSBB(30);
        AbstractCurrency receiveCurrency = CurrencyCreator.createGold(1);

        userSender.sendCurrencyTo(userReceiver, sendCurrency, receiveCurrency);

        TestChecker.printTestResult(69.8182,"SBB", userSender);
        TestChecker.printTestResult(2.25, "GLD", userReceiver);
    }

    private static void transferNftToFiat(){

        String bankName = "FiBank";

        DigitalWallet walletA = new DigitalWallet(CurrencyCreator.createNFT
                ("genericMonkey", 1000));

        walletA.addNewCurrencyInWallet(CurrencyCreator.createUSD(10));

        User userSender = new User("Pesho Ivanov", bankName, walletA);

        DigitalWallet walletB = new DigitalWallet(CurrencyCreator.createNFT
                ("coolArt", 300));

        User userReceiver = new User("Ivan Ivanov", bankName, walletB);

        AbstractCurrency sendCurrency = CurrencyCreator.createNFT("genericMonkey#111", 1000);
        AbstractCurrency receiveCurrency = CurrencyCreator.createUSD(0);

        userSender.sendCurrencyTo(userReceiver, sendCurrency, receiveCurrency);

        TestChecker.printTestResult(0,"genericMonkey", userSender);
        TestChecker.printTestResult(9,"USD", userSender);

        TestChecker.printTestResult(300,"coolArt", userReceiver);
        TestChecker.printTestResult(100, "USD", userReceiver);
    }

}
