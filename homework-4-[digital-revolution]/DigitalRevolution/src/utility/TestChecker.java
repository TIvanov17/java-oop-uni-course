package utility;

import bankclasses.User;

public class TestChecker {

    private TestChecker(){

    }

    public static void printTestResult(double expected, String expectedCode, User user){
        System.out.println(checkTest(expected, expectedCode, user));
    }

    private static String checkTest(double expected, String expectedCode, User user){

        String expectedCurrency = expected + " " + expectedCode;
        String actualCurrency = user.getUserSpecifiedWalletAvailability(expectedCode);

        return expectedCurrency.equals(actualCurrency)?
                UtilityConstants.ANSI_GREEN + "Test Pass:" +  UtilityConstants.ANSI_RESET +
                        " (Expected: " + expectedCurrency +
                        " = Actual: " + actualCurrency + ")" :
                UtilityConstants.ANSI_RED + "Test Fail: " +  UtilityConstants.ANSI_RESET +
                        "(Expected: " + expectedCurrency +
                        " != Actual: " + actualCurrency + ")";
    }
}
