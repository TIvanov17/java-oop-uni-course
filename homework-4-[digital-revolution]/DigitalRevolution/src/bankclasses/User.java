package bankclasses;

import abstractcurrency.AbstractCurrency;
import currency.NFT;
import currency.fiatcurrencies.USD;
import enums.DigitalWalletStateEnum;
import exceptions.NotAllowedDigitalWalletStateException;
import exceptions.NotCorrectCurrencyException;
import utility.Util;

public class User {

    private String name;
    private Bank bank;
    private DigitalWallet wallet;

    public User(String name, String bankName, DigitalWallet wallet){
        this.name = name;
        this.bank = new Bank(bankName);
        this.wallet = wallet;
    }

    public DigitalWallet getWallet(){
        return this.wallet;
    }

    public double getUserSpecifiedCurrencyAmount(String code){
        return this.wallet.getSpecifiedCurrency(code).getValue();
    }

    public String getUserSpecifiedWalletAvailability(String code) {
        return this.getUserSpecifiedCurrencyAmount(code) + " " +
                this.wallet.getSpecifiedCurrency(code).getCode();
    }

    public void sendCurrencyTo(User userReceiver, AbstractCurrency send,
                               AbstractCurrency receive){

        try {
            this.ensureDigitalWalletNotBlocked(userReceiver);
            this.ensureCorrectCurrenciesAndAmount(send, receive);
            this.ensureDigitalWalletHasNotOnlyNft();

        } catch (NotAllowedDigitalWalletStateException exception) {
            Util.printErrorMessage("Transfer failed, a wallet is blocked!");
            return;
        } catch (NotCorrectCurrencyException exception){
            Util.printErrorMessage("Transfer failed, not correct currency or amount!");
            return;
        }

        double tax = this.bank.setTransferTax(this, userReceiver, send);
        this.wallet.setNewWalletAmount(tax);
        this.wallet.transferCurrencyTo(userReceiver, send, receive);
    }

    private void ensureDigitalWalletNotBlocked(User userReceiver)
            throws NotAllowedDigitalWalletStateException {

        if (this.isDigitalWalletBlocked() || userReceiver.isDigitalWalletBlocked()){

            throw new NotAllowedDigitalWalletStateException("Fail Transfer!");
        }
    }

    private void ensureCorrectCurrenciesAndAmount(AbstractCurrency send,
                                                  AbstractCurrency receive)
            throws NotCorrectCurrencyException {

        if (!isTransferCurrenciesCorrect(send, receive) ||
                !this.wallet.hasEnoughMoney(send)){

            throw new NotCorrectCurrencyException("Fail Transfer!");
        }
    }

    private void ensureDigitalWalletHasNotOnlyNft() throws NotCorrectCurrencyException {
        if(this.wallet.hasOnlyNftCurrency()){
            throw new NotCorrectCurrencyException("Fail transfer!");
        }
    }

    private boolean isDigitalWalletBlocked(){
        return this.wallet.getDigitalWalletState().equals(DigitalWalletStateEnum.BLOCKED_STATE);
    }

    private boolean isTransferCurrenciesCorrect(AbstractCurrency send, AbstractCurrency receive){
        return this.isCurrencyCorrect(send, "RTA", "QAQ") &&
                this.isCurrencyCorrect(receive, "BTC", "SBB");

    }

    private boolean isCurrencyCorrect(AbstractCurrency send, String firstCode, String secondCode){
        return !send.getCode().equals(firstCode) && !send.getCode().equals(secondCode);
    }

    private boolean isDigitalWalletInitialCurrencyNft(AbstractCurrency currency){
        return currency instanceof NFT;
    }

    private static class Bank{

        private String bankName;

        private Bank(String bankName){
            this.bankName = bankName;
        }

        private String getBankName(){
            return this.bankName;
        }

        private boolean isBankEqual(Bank bank){
            return this.getBankName().equals(bank.getBankName());
        }

        private double setTransferTax(User userSender, User userReceiver, AbstractCurrency send){

            AbstractCurrency initialCurrency = userSender.wallet.getInitialCurrency();
            double valueToSend = send.getValue();

            if(userSender.isDigitalWalletInitialCurrencyNft(initialCurrency)){
                initialCurrency = userSender.wallet.getFirstNonNftCurrency();
            }

            if (this.isBankEqual(userReceiver.bank)) {
                return this.equalBanksProcess(initialCurrency);
            }

            return this.differentBankProcess(userSender, initialCurrency, valueToSend);
        }

        private double equalBanksProcess(AbstractCurrency currency) {

            double initialCurrencyInUSD = currency.convertToUSD();

            AbstractCurrency currencyInUsd = new USD(initialCurrencyInUSD - 1);
            return currencyInUsd.convertToCurrency(currency);
        }


        private double differentBankProcess(User sender, AbstractCurrency currency, double valueToSend){
            double currentValue = currency.getValue();
            double tax = valueToSend * 0.03;

            return this.getTax(sender, currency, currentValue, tax);
        }

        private double getTax(User sender, AbstractCurrency nonNftCurrency,
                              double currentValue, double tax){

            if(sender.isDigitalWalletInitialCurrencyNft(sender.wallet.getInitialCurrency())){
                return nonNftCurrency.getValue() - (tax / nonNftCurrency.getApolloExchangeRate()) ;
            }
            return currentValue - tax;
        }
    }
}