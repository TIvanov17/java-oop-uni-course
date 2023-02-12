package tests.convert;

import bankclasses.CurrencyCreator;
import abstractcurrency.FiatCurrency;
import currency.NFT;
import utility.Util;

public class ConvertFiatTest {

    public static void test(){

        System.out.println("FIAT -> FIAT TESTS");
        convertFiatToFiat();
        System.out.println("FIAT -> GOLD TESTS");
        convertFiatToGold();
        System.out.println("FIAT -> HASH TESTS");
        convertFiatToHash();
        System.out.println("FIAT -> CUSTOM NFT TESTS");
        convertFiatToNFT();
    }

    private static void convertFiatToNFT() {
        FiatCurrency usd = CurrencyCreator.createUSD(1000);

        NFT coolArtNFT = CurrencyCreator.createNFT
                ("coolCurrencyArt", 10000);

        Util.printConvertVisual("USD", coolArtNFT.getName(),
                                usd.convertToNFT(coolArtNFT));

    }

    private static void convertFiatToHash(){
        convertFromUSDToHash();
        System.out.println();
        convertFromCADToHash();
        System.out.println();
        convertFromJAPToHash();
        System.out.println();
        convertFromCHFToHash();
    }

    private static void convertFromUSDToHash(){
        FiatCurrency usd = CurrencyCreator.createUSD(1);
        System.out.println("From USD to BTC: " + usd.convertToBTC());
    }

    private static void convertFromCADToHash(){
        FiatCurrency cad = CurrencyCreator.createCAD(1);
        System.out.println("From CAD to QAQ: " + cad.convertToQAQ());
    }

    private static void convertFromJAPToHash(){
        FiatCurrency jap = CurrencyCreator.createJAP(1);
        System.out.println("From JAP to QAQ: " + jap.convertToQAQ());
    }

    private static void convertFromCHFToHash(){
        FiatCurrency chf = CurrencyCreator.createCHF(1);
        System.out.println("From CHF to QAQ: " + chf.convertToQAQ());
    }

    private static void convertFiatToGold(){

        convertFromUSDToGold();
        System.out.println();
        convertFromCADToGold();
        System.out.println();
        convertFromJAPToGold();
        System.out.println();
        convertFromCHFToGold();
    }

    private static void convertFromUSDToGold(){
        FiatCurrency usd = CurrencyCreator.createUSD(1);
        System.out.println("From USD to Gold: " + usd.convertToGold());
    }

    private static void convertFromCADToGold(){
        FiatCurrency cad = CurrencyCreator.createCAD(1);
        System.out.println("From CAD to Gold: "+ cad.convertToGold());
    }

    private static void convertFromJAPToGold(){
        FiatCurrency jap = CurrencyCreator.createJAP(1);
        System.out.println("From JAP to Gold: " + jap.convertToGold());
    }

    private static void convertFromCHFToGold(){
        FiatCurrency chf = CurrencyCreator.createCHF(1);
        System.out.println("From CHF to Gold: " + chf.convertToGold());
    }

    private static void convertFiatToFiat(){

        convertFromUSDToFiatCurrencies();
        System.out.println();
        convertFromCADToFiatCurrencies();
        System.out.println();
        convertFromJAPToFiatCurrencies();
        System.out.println();
        convertFromCHFToFiatCurrencies();
    }

    private static void convertFromUSDToFiatCurrencies(){
        FiatCurrency usd = CurrencyCreator.createUSD(-1);
        Util.printConvertVisual("USD", "CAD", usd.convertToCAD());
    }

    private static void convertFromCADToFiatCurrencies(){
        FiatCurrency cad = CurrencyCreator.createCAD(1);
        Util.printConvertVisual("CAD", "CHF", cad.convertToCHF());
    }

    private static void convertFromJAPToFiatCurrencies(){
        FiatCurrency jap = CurrencyCreator.createJAP(1);
        Util.printConvertVisual("JAP", "CHF", jap.convertToCHF());
    }

    private static void convertFromCHFToFiatCurrencies(){
        FiatCurrency chf = CurrencyCreator.createCHF(1);
        Util.printConvertVisual("CHF", "CAD", chf.convertToCAD());
    }
}