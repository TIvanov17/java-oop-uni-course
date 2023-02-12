package abstractcurrency;

import currency.NFT;

import static utility.Util.roundValue;

public abstract class AbstractCurrency implements Convertible {

    protected static final int USD_APOLLO_RATE = 10;
    protected static final int CAD_APOLLO_RATE = 5;
    protected static final int JAP_APOLLO_RATE = 7;
    protected static final int CHF_APOLLO_RATE = 20;

    protected static final int GOLD_APOLLO_RATE = 1000;

    protected static final int BTC_APOLLO_RATE = 1054;
    protected static final int SBB_APOLLO_RATE = 55;
    protected static final double RTA_APOLLO_RATE = 0.5;
    protected static final double QAQ_APOLLO_RATE = 0.014;

    private double apolloExchangeRate;

    public AbstractCurrency(double apolloExchangeRate) {
        this.apolloExchangeRate = apolloExchangeRate;
    }

    public abstract String getCode();

    public abstract double getValue();

    public abstract void setValue(double value);

    public abstract double toApollo();

    public double getApolloExchangeRate() {
        return this.apolloExchangeRate;
    }

    public void setApolloValue(double apolloValue) {
        this.setValue(apolloValue / this.getApolloExchangeRate());
    }

    public void setApolloExchangeRateValue(double value) {
        this.apolloExchangeRate = value;
    }

    public double convertToQAQ() {
        return this.convertTo(QAQ_APOLLO_RATE);
    }

    public double convertToBTC() {
        return this.convertTo(BTC_APOLLO_RATE);
    }

    public double convertToSBB() {
        return this.convertTo(SBB_APOLLO_RATE);
    }

    public double convertToRTA() {
        return this.convertTo(RTA_APOLLO_RATE);
    }

    public double convertToUSD() {
        return this.convertTo(USD_APOLLO_RATE);
    }

    public double convertToCAD() {
        return this.convertTo(CAD_APOLLO_RATE);
    }

    public double convertToJAP() {
        return this.convertTo(JAP_APOLLO_RATE);
    }

    public double convertToCHF() {
        return this.convertTo(CHF_APOLLO_RATE);
    }

    public double convertToGold() {
        return this.convertTo(GOLD_APOLLO_RATE);
    }

    public double convertToNFT(NFT nft) {
        return this.convertTo(nft.getValue());

    }

    public double convertToCurrency(AbstractCurrency currency) {
        return this.toApollo() / currency.getApolloExchangeRate();
    }

    protected double getRoundedValue(double value) {
        return roundValue(value);
    }

    private double convertTo(double rate) {
        return getRoundedValue(this.toApollo() / rate);
    }
}