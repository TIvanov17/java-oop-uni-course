package tests.convert;

import bankclasses.CurrencyCreator;
import currency.Gold;
import currency.NFT;
import utility.Util;

public class ConvertGoldTest {

    public static void test(){
        convertGoldToFiat();
        System.out.println();
        convertGoldToHash();
        System.out.println();
        convertGoldToNFT();
    }

    private static void convertGoldToFiat(){
        Gold gold = CurrencyCreator.createGold(1);

        Util.printConvertVisual("GOLD", "USD", gold.convertToUSD());
        Util.printConvertVisual("GOLD", "CHF", gold.convertToCHF());
    }


    private static void convertGoldToHash(){
        Gold gold = CurrencyCreator.createGold(1);
        Util.printConvertVisual("GOLD", "RTA", gold.convertToRTA());
        Util.printConvertVisual("GOLD", "QAQ", gold.convertToQAQ());
    }

    private static void convertGoldToNFT(){
        Gold gold = CurrencyCreator.createGold(1);

        NFT coolArtNFT = CurrencyCreator.createNFT
                ("coolCurrencyArt", 10000);

        Util.printConvertVisual("GOLD", coolArtNFT.getName(),
                gold.convertToNFT(coolArtNFT));
    }
}
