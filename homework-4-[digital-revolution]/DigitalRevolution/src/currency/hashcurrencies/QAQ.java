package currency.hashcurrencies;

import abstractcurrency.HashCurrency;
import enums.HashDirectionEnum;

public class QAQ extends HashCurrency {

    public QAQ(double value){
        super("QAQ", value, HashDirectionEnum.REVERSE_DIRECTION, 0.014);
    }
}
