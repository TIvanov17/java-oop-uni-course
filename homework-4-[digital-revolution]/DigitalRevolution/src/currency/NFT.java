package currency;

import abstractcurrency.AbstractCurrency;

public class NFT extends AbstractCurrency {

    private String name;
    private static final int DEFAULT_NFT_APL_VALUE = 0;

    public NFT(String name, double apolloExchangeRate) {
        super(apolloExchangeRate);
        this.name = name;
    }

    public NFT(String name) {
        super(DEFAULT_NFT_APL_VALUE);
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public double getValue(){
        return this.getApolloExchangeRate();
    }

    @Override
    public void setApolloValue(double value) {
        this.setApolloExchangeRateValue(value);
    }

    public void setValue(double value){
        this.setApolloValue(value);
    }

    public String getCode(){
        return this.name;
    }

    public String toString(){
        return this.name + ":: " + this.getValue() + "APL";
    }

    @Override
    public double toApollo() {
        return this.getApolloExchangeRate();
    }
}
