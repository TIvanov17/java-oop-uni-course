package abstractcurrency;

public abstract class FiatCurrency extends AbstractCurrency{

    private String code;
    private double value;

    public FiatCurrency(String code, double value, int apollo) {
        super(apollo);
        this.code = code;
        this.value = this.getRoundedValue(value);
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

    @Override
    public double toApollo() {
        return this.getValue() * this.getApolloExchangeRate();
    }
}
