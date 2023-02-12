package bankclasses;

import abstractcurrency.AbstractCurrency;
import currency.NFT;
import enums.DigitalWalletStateEnum;

import java.util.ArrayList;

public abstract class AbstractWallet {

    private AbstractCurrency initialCurrency;
    private DigitalWalletStateEnum state;
    private ArrayList<AbstractCurrency> currencyColl;

    public AbstractWallet(AbstractCurrency currency){
        this.initialCurrency = currency;
        this.state = DigitalWalletStateEnum.ACTIVE_STATE;
        this.currencyColl = new ArrayList<>();
        this.addNewCurrencyInWallet(this.initialCurrency);
    }

    public AbstractWallet(){
        this.initialCurrency = null;
        this.state = DigitalWalletStateEnum.ACTIVE_STATE;
        this.currencyColl = new ArrayList<>();
    }

    public abstract void transferCurrencyTo(User userReceiver,
                                            AbstractCurrency send,
                                            AbstractCurrency receive);

    public DigitalWalletStateEnum getDigitalWalletState(){
        return this.state;
    }

    public void setDigitalWalletState(DigitalWalletStateEnum state){
        this.state = state;
    }

    public void addNewCurrencyInWallet(AbstractCurrency currency){
        this.currencyColl.add(currency);
    }

    public AbstractCurrency getInitialCurrency(){
        return this.initialCurrency;
    }

    public ArrayList<AbstractCurrency> getCurrencyColl(){
        return this.currencyColl;
    }

    public double getWalletInitialCurrencyAmount(){
        return this.initialCurrency.getValue();
    }

    public boolean hasEnoughMoney(AbstractCurrency send){

        AbstractCurrency currency = this.initialCurrency;
        if (currency instanceof NFT){
            return currency.toApollo() >= send.toApollo();
        }
        return this.initialCurrency.toApollo() > send.toApollo();
    }
}
