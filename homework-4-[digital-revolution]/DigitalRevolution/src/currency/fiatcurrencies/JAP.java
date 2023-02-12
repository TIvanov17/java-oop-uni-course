package currency.fiatcurrencies;

import abstractcurrency.FiatCurrency;

public class JAP extends FiatCurrency {

    public JAP(double value){
        super("JAP", value, JAP_APOLLO_RATE);
    }
}
