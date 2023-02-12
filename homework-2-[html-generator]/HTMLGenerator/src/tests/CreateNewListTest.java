package tests;

import blocks.*;

import java.util.ArrayList;

public class CreateNewListTest {

    public static void test() {
        createNewEmptyList();
        System.out.println();
        createNewEmptyUnorderedList();
        System.out.println();
        createNewUnorderedListWithElements();
        System.out.println();
        createNewOrderedListWithElements();
        System.out.println();

        //-----TEST LIST WITH COLLECTION-----//
        createNewListWithCollectionOfElements();
        System.out.println();
    }

    private static void createNewEmptyList() {

        ElementFactory htmlFactory = new HtmlFactory();
        ElementList element = htmlFactory.createList();
        String htmlContent = element.render();

        System.out.println(htmlContent);
        System.out.println("1. Content List");
        TestRunner.check(
                htmlContent,
                "<ul></ul>"
        );
    }

    private static void createNewEmptyUnorderedList() {

        ElementFactory htmlFactory = new HtmlFactory();
        ElementList element = htmlFactory.createList(ElementListEnum.Unordered);
        String htmlContent = element.render();

        System.out.println("2. Content List");
        TestRunner.check(
                htmlContent,
                "<ul></ul>"
        );
    }

    private static void createNewUnorderedListWithElements() {

        ElementFactory htmlFactory = new HtmlFactory();
        ElementList element = htmlFactory.createList(ElementListEnum.Unordered);
        element.addElement(htmlFactory.createNewElement("div", "Element 1"));
        element.addElement(htmlFactory.createTextElement("Simple Text Element"));

        String htmlContent = element.render();

        // <ul>
        //  <li><div>Element 1</div><li>
        //  <li>Simple Text Element<li>
        // </ul>

        System.out.println("3. Content List");
        System.out.println(htmlContent);

        TestRunner.check(
                htmlContent,
                "<ul><li><div>Element 1</div></li><li>Simple Text Element</li></ul>"
        );

        String tildaContent = element.renderAsTSV();
        System.out.println("3. Tilda");
        System.out.println(tildaContent);

        TestRunner.check(
                tildaContent,
                "ul~li~div|Element 1~li~~|Simple Text Element"
        );
    }

    private static void createNewOrderedListWithElements() {

        ElementFactory htmlFactory = new HtmlFactory();
        ElementList element = htmlFactory.createList(ElementListEnum.Ordered);
        element.addElement(htmlFactory.createNewElement("div", "Element 1"));
        element.addElement(htmlFactory.createTextElement("Simple Text Element"));

        String htmlContent = element.render();

        // <ol>
        //  <li><div>Element 1</div><li>
        //  <li>Simple Text Element<li>
        // </ol>
        System.out.println("4. Content List");
        System.out.println(htmlContent);

        TestRunner.check(
                htmlContent,
                "<ol><li><div>Element 1</div></li><li>Simple Text Element</li></ol>"
        );

        String tildaContent = element.renderAsTSV();
        System.out.println("4. Tilda");
        System.out.println(tildaContent);

        TestRunner.check(
                tildaContent,
                "ol~li~div|Element 1~li~~|Simple Text Element"
        );
    }

    // Добавих и такъв тест, защотото видях, че в HTMLFactory има метод,
    // в който се подава типът на списъкът и колекция от елементи.

    private static void createNewListWithCollectionOfElements(){
        ElementFactory htmlFactory = new HtmlFactory();

        Element h1 = htmlFactory.createNewElement("h1", "New Title");
        Element div = htmlFactory.createNewElement("div", "New Div");
        Element div2 = htmlFactory.createNewElement
                ("div", htmlFactory.createAttribute("id", "div2"));

        ArrayList <Element> collection = new ArrayList<>();
        collection.add(h1);
        collection.add(div);
        collection.add(div2);

        ElementList element = htmlFactory.createList(ElementListEnum.Ordered, collection);


        String htmlContent = element.render();

        System.out.println("Last. Content List");
        System.out.println(htmlContent);
        TestRunner.check(
                htmlContent,
                "<ol><li><h1>New Title</h1></li><li><div>New Div</div></li>" +
                        "<li><div id='div2'></div></li></ol>"
        );

        String tildaContent = element.renderAsTSV();
        System.out.println("Last. Tilda");
        System.out.println(tildaContent);

        TestRunner.check(
                tildaContent,
                "ol~li~h1|New Title~li~div|New Div~li~~div#id!div2"
        );
    }
}
