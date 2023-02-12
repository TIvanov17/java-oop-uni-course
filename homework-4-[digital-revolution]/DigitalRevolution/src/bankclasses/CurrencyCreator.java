package bankclasses;

import abstractcurrency.FiatCurrency;
import abstractcurrency.HashCurrency;
import currency.Gold;
import currency.NFT;
import currency.fiatcurrencies.CAD;
import currency.fiatcurrencies.CHF;
import currency.fiatcurrencies.JAP;
import currency.fiatcurrencies.USD;
import currency.hashcurrencies.BTC;
import currency.hashcurrencies.QAQ;
import currency.hashcurrencies.RTA;
import currency.hashcurrencies.SBB;
import exceptions.InvalidCurrencyValueException;

public class CurrencyCreator  {

    private static final double DEFAULT_CURRENCY_VALUE = 1.0;
    private static final int MIN_POSSIBLE_CURRENCY_VALUE = 0;

    private CurrencyCreator(){

    }

    public static FiatCurrency createUSD(double value){
        return new USD(ensureValidValue(value));
    }

    public static FiatCurrency createCAD(double value){
        return new CAD(ensureValidValue(value));
    }

    public static FiatCurrency createJAP(double value){
        return new JAP(ensureValidValue(value));
    }

    public static FiatCurrency createCHF(double value){
        return new CHF(ensureValidValue(value));
    }

    public static HashCurrency createBTC(double value){
        return new BTC(ensureValidValue(value));
    }

    public static HashCurrency createSBB(double value){
        return new SBB(ensureValidValue(value));
    }

    public static HashCurrency createRTA(double value){
        return new RTA(ensureValidValue(value));
    }

    public static HashCurrency createQAQ(double value){
        return new QAQ(ensureValidValue(value));
    }

    public static NFT createNFT(String name, int apolloValue){
        return new NFT(name, (int) ensureValidValue(apolloValue));
    }

    public static NFT createNFT(String name){
        return new NFT(name);
    }

    public static Gold createGold(double weight){
        return new Gold(ensureValidValue(weight));
    }

    private static double ensureValidValue(double value){
        return !isValidValue(value) ? setDefaultValue(value) : value;
    }

    private static boolean isValidValue(double value){
        return value >= MIN_POSSIBLE_CURRENCY_VALUE;
    }

    private static double setDefaultValue(double value){

        try {
            throw new InvalidCurrencyValueException();

        } catch (InvalidCurrencyValueException e){
            System.err.println("Invalid value " + value +
                    ", but set default value " + DEFAULT_CURRENCY_VALUE + " !");
            return DEFAULT_CURRENCY_VALUE;
        }
    }
}
