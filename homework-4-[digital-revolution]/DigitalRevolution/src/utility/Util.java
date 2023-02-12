package utility;

public class Util {

    private Util(){

    }

    public static double roundValue(double value){
        return Math.round(value * UtilityConstants.ROUND_VALUE) / UtilityConstants.ROUND_VALUE;
    }

    public static void printConvertVisual(String fromCurrency, String toCurrency, double converted){
        System.out.println("From " + fromCurrency  + " to "+ toCurrency +
                            ": " + converted);
    }

    public static void printErrorMessage(String massage){
        System.out.println(UtilityConstants.ANSI_RED + massage + UtilityConstants.ANSI_RESET);
    }
}
