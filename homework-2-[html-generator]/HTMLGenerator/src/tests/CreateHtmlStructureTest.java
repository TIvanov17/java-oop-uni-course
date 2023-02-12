package tests;

import blocks.Element;
import blocks.ElementFactory;
import blocks.HtmlFactory;

public class CreateHtmlStructureTest {

    public static void test() {
        createSimpleElement();
        System.out.println();
        createElementWithAttribute();
        System.out.println();
        createNestedElement();
        System.out.println();
        createSuperNestedElementStructure();
        System.out.println();
    }

    private static void createSimpleElement() {

        ElementFactory htmlFactory = new HtmlFactory();
        Element element = htmlFactory.createNewElement("html");
        String htmlContent = element.render();

        // <html></html>
        System.out.println("1. Content");
        TestRunner.check(
                htmlContent,
                "<html></html>"
        );

        String tildaContent = element.renderAsTSV();
        System.out.println("1. Tilda");
        System.out.println(tildaContent);
        TestRunner.check(
                tildaContent,
                "html"
        );
    }

    private static void createElementWithAttribute() {

        ElementFactory htmlFactory = new HtmlFactory();
        Element element = htmlFactory.createNewElement(
                "html",
                htmlFactory.createAttribute("lang", "bg")
        );
        String htmlContent = element.render();
        System.out.println(htmlContent);

        System.out.println("2. Content");
        // <html></html>
        TestRunner.check(
                htmlContent,
                "<html lang='bg'></html>"
        );

        String tildaContent = element.renderAsTSV();
        System.out.println("2. Tilda");
        System.out.println(tildaContent);
        // html#lang!bg
        TestRunner.check(
                tildaContent,
                "html#lang!bg"
        );
    }

    private static void createNestedElement() {

        ElementFactory htmlFactory = new HtmlFactory();
        Element element = htmlFactory.createNewElement("html");
        Element div = htmlFactory.createNewElement("div");
        Element h1 = htmlFactory.createNewElement("h1");
        Element h2 = htmlFactory.createNewElement("h2", "Second level title");
        div.addElement(h1);
        div.addElement(h2);
        element.addElement(div);
        String htmlContent = element.render();

        // <html>
        //  <div>
        //      <h1></h1>
        //      <h2>Second level title</h2>
        //  </div>
        // </html>
        System.out.println("3. Content");
        System.out.println(htmlContent);
        TestRunner.check(
                htmlContent,
                "<html><div><h1></h1><h2>Second level title</h2></div></html>"
        );

        System.out.println("3. Tilda");
        String tildaContent = element.renderAsTSV();
        System.out.println(tildaContent);

        TestRunner.check(
                tildaContent,
                "html~div~h1~~h2|Second level title"
        );

    }

    private static void createSuperNestedElementStructure() {

        ElementFactory htmlFactory = new HtmlFactory();
        Element div1 = htmlFactory.createNewElement("div");
        Element div2 = htmlFactory.createNewElement("div", htmlFactory.createAttribute("id", "div2"));
        Element div3 = htmlFactory.createNewElement("div", htmlFactory.createAttribute("id", "div3"));
        Element div4 = htmlFactory.createNewElement("div", htmlFactory.createAttribute("id", "div4"));
        Element div5 = htmlFactory.createNewElement("div", htmlFactory.createAttribute("id", "div5"));

        div1.addElement(div2);
        div1.addElement(div3);
        div4.addElement(div1);
        div5.addElement(div4);

        String htmlContent = div5.render();

        // <div id='div5'>
        //  <div id='div4'>
        //      <div>
        //          <div id='div2'></div>
        //          <div id='div3'></div>
        //      </div>
        //  </div>
        // </div>
        System.out.println("4. Content");
        System.out.println(div5.render());
        TestRunner.check(
                htmlContent,
                "<div id='div5'><div id='div4'><div><div id='div2'></div><div id='div3'></div></div></div></div>"
        );

        String tildaContent = div5.renderAsTSV();

        System.out.println("4. Tilda");
        System.out.println(tildaContent);

        TestRunner.check(
                tildaContent,
                "div#id!div5~div#id!div4~div~div#id!div2~~div#id!div3"
        );
    }
}