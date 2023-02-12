package currency.hashcurrencies;

import abstractcurrency.HashCurrency;
import enums.HashDirectionEnum;

public class RTA extends HashCurrency {

    public RTA(double value){
        super("RTA", value, HashDirectionEnum.REVERSE_DIRECTION, 0.5);
    }
}
