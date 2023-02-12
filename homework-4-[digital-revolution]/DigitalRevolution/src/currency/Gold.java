package currency;

import abstractcurrency.AbstractCurrency;

public class Gold extends AbstractCurrency {

    private String code;
    private double weight;

    public Gold(double weight) {
        super(GOLD_APOLLO_RATE);
        this.code = "GLD";
        this.weight = this.getRoundedValue(weight);
    }

    public void setWeight(double weight){
        this.weight = this.getRoundedValue(weight);
    }

    public void setValue(double weight){
        this.weight = this.getRoundedValue(weight);
    }

    public double getValue(){
        return this.weight;
    }

    public double getWeight(){
        return this.weight;
    }

    public String getCode(){
        return this.code;
    }

    @Override
    public String toString() {
        return getWeight() + " " + getCode();
    }

    @Override
    public double toApollo() {
        return this.weight * getApolloExchangeRate();
    }
}
