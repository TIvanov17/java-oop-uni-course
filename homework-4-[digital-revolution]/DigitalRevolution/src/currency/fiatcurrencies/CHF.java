package currency.fiatcurrencies;

import abstractcurrency.FiatCurrency;

public class CHF extends FiatCurrency {

    public CHF(double value){
        super("CHF", value, CHF_APOLLO_RATE);
    }
}
