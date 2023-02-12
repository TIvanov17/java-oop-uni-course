package exceptions;

public class NotCorrectCurrencyException extends Exception{

    public NotCorrectCurrencyException(String customMessage){
        super(customMessage);
    }
}
