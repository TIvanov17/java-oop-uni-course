package tests;
import blocks.*;

public class CreateNewTableTest {

    public static void test() {
        testCreateEmptyTable();
        System.out.println();
        testCreateEmptyTableMultipleRows();
        System.out.println();
        testCreateTableWithSingleElement();
        System.out.println();
        testCreateTableWithSingleElementOnSpecificRow();
        System.out.println();
        testCreateTableWithSingleElementOutsideTheTable();
        System.out.println();
    }

    private static void testCreateEmptyTable() {

        ElementFactory htmlFactory = new HtmlFactory();
        Table e = htmlFactory.createTable("test", 1, 1);
        String htmlContent = e.render();

        System.out.println("1. Content Table");
        System.out.println(htmlContent);

        TestRunner.check(
                htmlContent,
                "<table name='test'><tr><td></td></tr></table>"
        );

        String tildaContent = e.renderAsTSV();
        System.out.println("1. Tilda");
        System.out.println(tildaContent);

        TestRunner.check(
                tildaContent,
                "table#name!test~tr~~td"
        );
    }

    private static void testCreateEmptyTableMultipleRows() {

        ElementFactory htmlFactory = new HtmlFactory();
        Table e = htmlFactory.createTable(3, 1);
        String htmlContent = e.render();

        System.out.println("2. Content Table");
        System.out.println(htmlContent);

        TestRunner.check(
                htmlContent,
                "<table><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr></table>"
        );

        String tildaContent = e.renderAsTSV();
        System.out.println("2. Tilda");
        System.out.println(tildaContent);

        TestRunner.check(
                tildaContent,
                "table~tr~td~tr~td~tr~~td"
        );
    }

    private static void testCreateTableWithSingleElement() {

        ElementFactory htmlFactory = new HtmlFactory();
        Table e = htmlFactory.createTable(1, 1);
        System.out.println(e.renderAsTSV());
        Element h1 = htmlFactory.createNewElement("h1", "New message");
        e.addElement(h1);

        String htmlContent = e.render();

        System.out.println("3. Content Table");
        System.out.println(htmlContent);
        // <table>
        //  <tr>
        //      <td><h1>New message</h1></td>
        //  </tr>
        // </table>
        TestRunner.check(
                htmlContent,
                "<table><tr><td><h1>New message</h1></td></tr></table>"
        );

        String tildaContent = e.renderAsTSV();
        System.out.println("3. Tilda");
        System.out.println(tildaContent);

        TestRunner.check(
                tildaContent,
                "table~tr~td~~h1|New message"
        );
    }

    private static void testCreateTableWithSingleElementOnSpecificRow() {

        ElementFactory htmlFactory = new HtmlFactory();
        Table e     = htmlFactory.createTable(2, 2);
        Element h1  = htmlFactory.createNewElement("h1", "New message");
        e.addElement(h1, 2,2);

        String htmlContent = e.render();
        System.out.println("4. Content Table");
        System.out.println(htmlContent);

        // <table>
        //  <tr>
        //      <td></td>
        //  </tr>
        //  <tr>
        //      <td><h1>New message</h1></td>
        //  </tr>
        // </table>
        TestRunner.check(
                htmlContent,
                "<table><tr><td></td><td></td></tr><tr><td></td><td><h1>New message</h1></td></tr></table>"
        );

        String tildaContent = e.renderAsTSV();
        System.out.println("4. Tilda");
        System.out.println(tildaContent);

        TestRunner.check(
                tildaContent,
                "table~tr~td~td~tr~td~td~~h1|New message"
        );


    }

    private static void testCreateTableWithSingleElementOutsideTheTable() {

        ElementFactory htmlFactory = new HtmlFactory();
        Table e = htmlFactory.createTable(2, 2);
        Element h1 = htmlFactory.createNewElement("h1", "New message");
        e.addElement(h1, 3,3);

        String htmlContent = e.render();
        System.out.println("5. Content Table");
        System.out.println(htmlContent);
        // <table>
        //  <tr>
        //      <td></td>
        //  </tr>
        //  <tr>
        //      <td></td>
        //  </tr>
        // </table>
        TestRunner.check(
                htmlContent,
                "<table><tr><td></td><td></td></tr><tr><td></td><td></td></tr></table>"
        );
    }
}