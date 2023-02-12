import tests.convert.*;
import tests.transfer.DifWalletTransferTests;
import tests.transfer.EqualWalletTransferTests;
import tests.transfer.blocked.*;

public class Application {

    public static void main(String[] args) {

        System.out.println("ТЕСТОВЕ ЗА ПРЕОБРАЗУВАНЕ НА ЕДНА ВАЛУТА В ДРУГА");
        ConvertFiatTest.test();
        System.out.println();
        ConvertHashTest.test();
        System.out.println();
        ConvertGoldTest.test();
        System.out.println();
        ConvertNftTest.test();
        System.out.println();

        System.out.println("ТРАНСФЕРИ С ЕДНАКЪВ ТИП ПОРТФЕЙЛ");
        DifWalletTransferTests.test();

        System.out.println("ТРАНСФЕРИ С РАЗЛИЧЕН ТИП ПОРТФЕЙЛ");
        EqualWalletTransferTests.test();

        System.out.println("ТЕСТ ЗА НАДВИШАВАНЕ НА СТОЙНОСТТА");
        NotEnoughMoneyTest.test();
        System.out.println("ТЕСТ ЗА БЛОКИРАН ПОРФЕЙЛ");
        BlockedUserWalletTest.test();

    }
}
