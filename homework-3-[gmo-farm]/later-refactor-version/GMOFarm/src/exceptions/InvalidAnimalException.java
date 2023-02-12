package exceptions;

public class InvalidAnimalException extends Exception{

    public InvalidAnimalException(){
        super("Animal is null!");
    }
}
