package exceptions;

public class NotAllowedDigitalWalletStateException extends Exception{

    public NotAllowedDigitalWalletStateException(String customMessage){
        super(customMessage);
    }

}