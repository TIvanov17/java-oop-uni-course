package exceptions;

public class InvalidCurrencyValueException extends Exception {

    public InvalidCurrencyValueException(String customMessage){
        super(customMessage);
    }

    public InvalidCurrencyValueException(){
        super("Invalid value for currency.");
    }
}
