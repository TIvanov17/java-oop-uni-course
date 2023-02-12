package currency.hashcurrencies;

import abstractcurrency.HashCurrency;
import enums.HashDirectionEnum;

public class SBB extends HashCurrency {

    public SBB(double value){
        super("SBB", value, HashDirectionEnum.STRAIGHT_DIRECTION, 55);
    }
}
