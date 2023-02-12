package currency.hashcurrencies;

import abstractcurrency.HashCurrency;
import enums.HashDirectionEnum;

public class BTC extends HashCurrency {

    public BTC(double value){
        super("BTC", value, HashDirectionEnum.STRAIGHT_DIRECTION, 1054);
    }
}
