package bankclasses;

import abstractcurrency.AbstractCurrency;
import currency.NFT;
import enums.DigitalWalletStateEnum;

import java.util.ArrayList;

public class DigitalWallet extends AbstractWallet {

    public DigitalWallet(AbstractCurrency currency){
        super(currency);
    }

    public DigitalWallet(AbstractCurrency currency, DigitalWalletStateEnum state){
        super(currency);
        this.setDigitalWalletState(state);
    }

    public DigitalWallet(){
        super();
    }

    public void transferCurrencyTo(User userReceiver, AbstractCurrency send,
                                   AbstractCurrency receive){

        DigitalWallet receiverWallet = userReceiver.getWallet();

        if(this.hasEnoughMoney(send)){
            this.doTransfer(receiverWallet, send, receive);
        }
    }

    private void doTransfer(DigitalWallet userWallet, AbstractCurrency send,
                            AbstractCurrency receive){
        this.withdraw(send);
        this.addTo(userWallet, send, receive);
    }

    private void withdraw(AbstractCurrency withdraw){

        double initialCurrencyInApollo = this.getInitialCurrency().toApollo();
        double withdrawValue = withdraw.toApollo();
        this.getInitialCurrency().setApolloValue(initialCurrencyInApollo - withdrawValue);
    }

    private void addTo(DigitalWallet receiverWallet, AbstractCurrency send,
                       AbstractCurrency receive) {

        double convertSendToReceive = send.convertToCurrency(receive);
        double oldWalletAmount = receiverWallet.getWalletInitialCurrencyAmount();

        if(isReceiveAndUserCurrencyEqual(receiverWallet, receive)){
            receiverWallet.setNewWalletAmount(oldWalletAmount + convertSendToReceive);
            return;
        }
        if(receive instanceof NFT){
            this.setNewNftCurrency(receiverWallet, send, receive);
            return;
        }

        this.setNewCurrencyProcess(receiverWallet, send, receive);
    }

    public boolean hasOnlyNftCurrency(){
        for (AbstractCurrency currency: this.getCurrencyColl()){
            if(!(currency instanceof NFT)){
                return false;
            }
        }
        return true;
    }

    public AbstractCurrency getFirstNonNftCurrency(){
        for (AbstractCurrency currency: this.getCurrencyColl()){
            if(!(currency instanceof NFT)){
                return currency;
            }
        }
        return null;
    }

    public void setNewWalletAmount(double newWalletAmount){
        if (this.getInitialCurrency() instanceof NFT){
            getFirstNonNftCurrency().setValue(newWalletAmount);
            return;
        }
        this.getInitialCurrency().setValue(newWalletAmount);
    }

    public AbstractCurrency getSpecifiedCurrency(String code){

        if(findCurrencyInDigitalWallet(code) == null){
            throw new IllegalArgumentException();
        }
        return findCurrencyInDigitalWallet(code);
    }


    private void setNewNftCurrency(DigitalWallet receiverWallet, AbstractCurrency send,
                                   AbstractCurrency receive){

        double sendCurrencyToApollo = send.toApollo();
        NFT newNft = new NFT(receive.getCode(), sendCurrencyToApollo);
        receiverWallet.getCurrencyColl().add(newNft);
    }

    private void setNewCurrencyProcess(DigitalWallet receiverWallet, AbstractCurrency send,
                                       AbstractCurrency receive){

        double sendCurrencyToReceiveCurrency = send.convertToCurrency(receive);
        AbstractCurrency newCurrency = receive;

        newCurrency.setValue(sendCurrencyToReceiveCurrency);
        receiverWallet.getCurrencyColl().add(newCurrency);
    }

    private boolean isReceiveAndUserCurrencyEqual(DigitalWallet receiverWallet,
                                                  AbstractCurrency receive){

        return receiverWallet.getInitialCurrency().getCode().equals(receive.getCode());
    }

    private AbstractCurrency findCurrencyInDigitalWallet(String code){

        for (AbstractCurrency currency : this.getCurrencyColl()) {
            if (hasFoundCurrency(currency.getCode(), code)) {
                return currency;
            }
        }
        return null;
    }

    private boolean hasFoundCurrency(String currentCode, String codeToFind){
        return currentCode.equals(codeToFind);
    }
}