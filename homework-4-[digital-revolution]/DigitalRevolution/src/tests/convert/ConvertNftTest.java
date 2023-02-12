package tests.convert;

import bankclasses.CurrencyCreator;
import currency.NFT;
import utility.Util;

public class ConvertNftTest {


    public static void test(){
        convertNftToFiat();
        System.out.println();
        convertNftToHash();
        System.out.println();
        convertNftToNFT();
    }

    private static void convertNftToFiat(){
        NFT coolArtNFT = CurrencyCreator.createNFT
                ("coolCurrencyArt", 10000);

        Util.printConvertVisual(coolArtNFT.getName(), "USD", coolArtNFT.convertToUSD());
    }


    private static void convertNftToHash(){
        NFT coolArtNFT = CurrencyCreator.createNFT
                ("coolCurrencyArt", 10000);

        Util.printConvertVisual(coolArtNFT.getName(), "BTC", coolArtNFT.convertToBTC());
    }

    private static void convertNftToNFT(){
        NFT coolArtNFT = CurrencyCreator.createNFT
                ("coolCurrencyArt", 10000);

        Util.printConvertVisual(coolArtNFT.getName(),"GOLD" ,
                coolArtNFT.convertToGold());
    }
}
