package tests.transfer;

import abstractcurrency.AbstractCurrency;
import bankclasses.CurrencyCreator;
import bankclasses.DigitalWallet;
import bankclasses.User;
import utility.TestChecker;

public class DifWalletTransferTests {

    public static void test(){
        transferUsdToChfMultipleUserCurrency();
        System.out.println();
        transferGoldToBtcImpossibleTest();
        System.out.println();
        transferGoldToQaq();
        System.out.println();
        transferGoldToNft();
        System.out.println();
        transferHashToNFT();
        System.out.println();
        transferHashToFiat();
        System.out.println();
        transferNftToGold();
    }

    private static void transferUsdToChfMultipleUserCurrency(){

        String userSenderBankName = "FiBank";
        String userReceiverBankName = "MiBank";

        DigitalWallet walletA = new DigitalWallet(CurrencyCreator.createUSD(100));
        User userSender = new User("Pesho Ivanov", userSenderBankName, walletA);

        DigitalWallet walletB = new DigitalWallet(CurrencyCreator.createCAD(10));
        User userReceiver = new User("Ivan Ivanov", userReceiverBankName, walletB);

        AbstractCurrency sendCurrency = CurrencyCreator.createUSD(50);
        AbstractCurrency receiveCurrency = CurrencyCreator.createCHF(1);

        userSender.sendCurrencyTo(userReceiver, sendCurrency, receiveCurrency);

        TestChecker.printTestResult(48.5,"USD", userSender);
        TestChecker.printTestResult(10,"CAD", userReceiver);
        TestChecker.printTestResult(25,"CHF", userReceiver);
    }

    private static void transferGoldToBtcImpossibleTest() {
        String userSenderBankName = "FiBank";
        String userReceiverBankName = "MiBank";

        DigitalWallet walletA = new DigitalWallet(CurrencyCreator.createGold(3));
        User userSender = new User("Pesho Ivanov", userSenderBankName, walletA);

        DigitalWallet walletB = new DigitalWallet(CurrencyCreator.createBTC(0));
        User userReceiver = new User("Ivan Ivanov", userReceiverBankName, walletB);

        AbstractCurrency sendCurrency = CurrencyCreator.createGold(2.2);
        AbstractCurrency receiveCurrency = CurrencyCreator.createBTC(1);

        userSender.sendCurrencyTo(userReceiver, sendCurrency, receiveCurrency);

        TestChecker.printTestResult(3, "GLD", userSender);
        TestChecker.printTestResult(0, "BTC", userReceiver);
    }

    private static void transferGoldToQaq() {
        String userSenderBankName = "FiBank";
        String userReceiverBankName = "MiBank";

        DigitalWallet walletA = new DigitalWallet(CurrencyCreator.createGold(3));
        User userSender = new User("Pesho Ivanov", userSenderBankName, walletA);

        DigitalWallet walletB = new DigitalWallet(CurrencyCreator.createQAQ(0));
        User userReceiver = new User("Ivan Ivanov", userReceiverBankName, walletB);

        AbstractCurrency sendCurrency = CurrencyCreator.createGold(2.2);
        AbstractCurrency receiveCurrency = CurrencyCreator.createQAQ(0);

        userSender.sendCurrencyTo(userReceiver, sendCurrency, receiveCurrency);

        TestChecker.printTestResult(0.734, "GLD", userSender);
        TestChecker.printTestResult(157142.8571, "QAQ", userReceiver);
    }

    private static void transferGoldToNft() {
        String userSenderBankName = "FiBank";
        String userReceiverBankName = "MiBank";

        DigitalWallet walletA = new DigitalWallet(CurrencyCreator.createGold(3));
        User userSender = new User("Pesho Ivanov", userSenderBankName, walletA);

        DigitalWallet walletB = new DigitalWallet(CurrencyCreator.createCHF(10));
        User userReceiver = new User("Ivan Ivanov", userReceiverBankName, walletB);

        AbstractCurrency sendCurrency = CurrencyCreator.createGold(2);
        AbstractCurrency receiveCurrency = CurrencyCreator.createNFT("genericMonkey");

        userSender.sendCurrencyTo(userReceiver, sendCurrency, receiveCurrency);

        TestChecker.printTestResult(0.94,"GLD",userSender);
        TestChecker.printTestResult(10, "CHF", userReceiver);
        TestChecker.printTestResult(2000, "genericMonkey", userReceiver);
    }

    private static void transferHashToNFT(){
        String userSenderBankName = "FiBank";
        String userReceiverBankName = "MiBank";

        DigitalWallet walletA = new DigitalWallet(CurrencyCreator.createSBB(333));
        User userSender = new User("Pesho Ivanov", userSenderBankName, walletA);

        DigitalWallet walletB = new DigitalWallet(CurrencyCreator.createCHF(10));
        User userReceiver = new User("Ivan Ivanov", userReceiverBankName, walletB);

        AbstractCurrency sendCurrency = CurrencyCreator.createSBB(123);
        AbstractCurrency receiveCurrency = CurrencyCreator.createNFT("genericMonkey");

        userSender.sendCurrencyTo(userReceiver, sendCurrency, receiveCurrency);

        TestChecker.printTestResult(206.31,"SBB", userSender);
        TestChecker.printTestResult(10, "CHF", userReceiver);
        TestChecker.printTestResult(6765, "genericMonkey", userReceiver);
    }

    private static void transferHashToFiat(){
        String userSenderBankName = "FiBank";
        String userReceiverBankName = "MiBank";

        DigitalWallet walletA = new DigitalWallet(CurrencyCreator.createSBB(10));
        User userSender = new User("Pesho Ivanov", userSenderBankName, walletA);

        DigitalWallet walletB = new DigitalWallet(CurrencyCreator.createCHF(10));
        User userReceiver = new User("Ivan Ivanov", userReceiverBankName, walletB);

        AbstractCurrency sendCurrency = CurrencyCreator.createSBB(8);
        AbstractCurrency receiveCurrency = CurrencyCreator.createCHF(1);

        userSender.sendCurrencyTo(userReceiver, sendCurrency, receiveCurrency);

        TestChecker.printTestResult(1.76,"SBB", userSender);
        TestChecker.printTestResult(32,"CHF", userReceiver);
    }

    private static void transferNftToGold(){

        String userSenderBankName = "FiBank";
        String userReceiverBankName = "MiBank";

        DigitalWallet walletA = new DigitalWallet(CurrencyCreator.createNFT
                ("genericMonkey", 10000));

        walletA.addNewCurrencyInWallet(CurrencyCreator.createGold(1));

        User userSender = new User("Pesho Ivanov", userSenderBankName, walletA);

        DigitalWallet walletB = new DigitalWallet(CurrencyCreator.createNFT
                ("coolArt", 300));

        User userReceiver = new User("Ivan Ivanov", userReceiverBankName, walletB);

        AbstractCurrency sendCurrency = CurrencyCreator.createNFT("genericMonkey", 6000);
        AbstractCurrency receiveCurrency = CurrencyCreator.createGold(0);

        userSender.sendCurrencyTo(userReceiver, sendCurrency, receiveCurrency);

        TestChecker.printTestResult(4000,"genericMonkey", userSender);
        TestChecker.printTestResult(0.82,"GLD", userSender);

        TestChecker.printTestResult(300,"coolArt", userReceiver);
        TestChecker.printTestResult(6, "GLD", userReceiver);
    }
}
