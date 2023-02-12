package utility;

import java.util.Random;

public class Util {

    public static final String NEW_LINE = "\n";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    private Util(){

    }

    public static int generateRandomAbilityValue(int lowerBound, int upperBound){
        Random random = new Random();
        return random.nextInt(upperBound) + lowerBound;
    }

    public static void printErrorMessage(String massage){
        System.out.println(ANSI_RED + massage + ANSI_RESET);
    }
}
