package tests;

public class TestRunner {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void check(String what, String against) {

        String message = what.equals(against) ?
                                            ANSI_GREEN + "Test Pass" +  ANSI_RESET :
                                            ANSI_RED+ "Test Fail" + ANSI_RESET;
        System.out.println(message);
    }
}
