package tests.convert;

import abstractcurrency.HashCurrency;
import bankclasses.CurrencyCreator;
import currency.NFT;
import utility.Util;

public class ConvertHashTest {

    public static void test(){

        System.out.println("HASH -> HASH TESTS");
        convertHashToHash();
        System.out.println("HASH -> GOLD TESTS");
        convertHashToGold();
        System.out.println("HASH -> FIAT TESTS");
        convertHashToFiat();
        System.out.println("HASH -> CUSTOM NFT TESTS");
        convertHashToNFT();
    }

    private static void convertHashToHash(){
        convertFromBTCToHash();
        System.out.println();
        convertFromSBBToHash();
        System.out.println();
        convertFromRTAToHash();
        System.out.println();
        convertFromQAQToHash();
    }

    private static void convertFromBTCToHash(){
        HashCurrency btc = CurrencyCreator.createBTC(1);
        Util.printConvertVisual("BTC", "RTA", btc.convertToRTA());
    }

    private static void convertFromSBBToHash(){
        HashCurrency sbb = CurrencyCreator.createSBB(1);
        Util.printConvertVisual("SBB", "QAQ", sbb.convertToQAQ());
    }

    private static void convertFromRTAToHash(){
        HashCurrency rta = CurrencyCreator.createRTA(1);
        Util.printConvertVisual("RTA", "BTC", rta.convertToBTC());
    }

    private static void convertFromQAQToHash(){
        HashCurrency qaq = CurrencyCreator.createQAQ(1);
        Util.printConvertVisual("QAQ", "RTA", qaq.convertToRTA());
    }

    private static void convertHashToGold(){
        HashCurrency btc = CurrencyCreator.createBTC(1);
        Util.printConvertVisual("BTC", "GOLD", btc.convertToGold());

        HashCurrency sbb = CurrencyCreator.createSBB(1);
        Util.printConvertVisual("SBB", "GOLD", sbb.convertToGold());
    }


    private static void convertHashToFiat(){
        convertFromBTCToFiat();
        System.out.println();
        convertFromSBBToFiat();
        System.out.println();
        convertFromRTAToFiat();
        System.out.println();
        convertFromQAQToFiat();
    }


    private static void convertFromBTCToFiat(){
        HashCurrency btc = CurrencyCreator.createBTC(1);
        Util.printConvertVisual("BTC", "CHF", btc.convertToCHF());
    }

    private static void convertFromSBBToFiat(){
        HashCurrency sbb = CurrencyCreator.createSBB(1);
        Util.printConvertVisual("SBB", "CAD", sbb.convertToCAD());
    }

    private static void convertFromRTAToFiat(){
        HashCurrency rta = CurrencyCreator.createRTA(1);
        Util.printConvertVisual("RTA", "USD", rta.convertToUSD());
    }

    private static void convertFromQAQToFiat(){
        HashCurrency qaq = CurrencyCreator.createQAQ(1);
        Util.printConvertVisual("QAQ", "CHF", qaq.convertToCHF());
    }

    private static void convertHashToNFT(){
        HashCurrency btc = CurrencyCreator.createBTC(1);

        NFT coolArtNFT = CurrencyCreator.createNFT
                ("coolCurrencyArt", -1);

        Util.printConvertVisual("BTC", coolArtNFT.getName(),
                btc.convertToNFT(coolArtNFT));
    }
}
