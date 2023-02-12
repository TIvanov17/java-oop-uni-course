package abstractcurrency;

import enums.HashDirectionEnum;

public abstract class HashCurrency extends AbstractCurrency{

    private String code;
    private double value;
    private HashDirectionEnum direction;

    public HashCurrency(String code, double value,
                        HashDirectionEnum direction, double apolloExchangeRate) {

        super(apolloExchangeRate);
        this.code = code;
        this.value = getRoundedValue(value);
        this.direction = direction;
    }

    public String getCode() {
        return this.code;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value){
        this.value = this.getRoundedValue(value);
    }

    public double toApollo() {
        return this.getValue() * this.getApolloExchangeRate();
    }
}
