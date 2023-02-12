package currency.fiatcurrencies;

import abstractcurrency.FiatCurrency;

public class CAD extends FiatCurrency {

    public CAD(double value) {
        super("CAD", value, CAD_APOLLO_RATE);
    }

}
