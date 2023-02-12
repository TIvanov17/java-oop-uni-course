package currency.fiatcurrencies;

import abstractcurrency.FiatCurrency;

public class USD extends FiatCurrency {

    public USD(double value) {
        super("USD", value, USD_APOLLO_RATE);
    }

}
