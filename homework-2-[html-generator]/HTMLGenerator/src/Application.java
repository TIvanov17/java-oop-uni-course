import tests.CreateHtmlStructureTest;
import tests.CreateNewListTest;
import tests.CreateNewTableTest;

public class Application {
    public static void main(String[] args) {

        System.out.println("HTML STRUCTURE TEST:");
        CreateHtmlStructureTest.test();
        System.out.println("LIST TEST:");
        CreateNewListTest.test();
        System.out.println("TABLE TEST:");
        CreateNewTableTest.test();
    }
}