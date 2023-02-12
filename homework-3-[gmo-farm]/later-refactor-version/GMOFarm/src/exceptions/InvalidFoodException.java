package exceptions;

public class InvalidFoodException extends Exception{

    public InvalidFoodException(){
        super("Food is null!");
    }
}
