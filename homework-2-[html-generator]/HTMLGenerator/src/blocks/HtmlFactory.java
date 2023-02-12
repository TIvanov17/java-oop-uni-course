package blocks;

import java.util.ArrayList;

public class HtmlFactory extends ElementFactory {

    @Override
    public Element createNewElement(String name) {
        return new BasicHtmlElement(name);
    }

    @Override
    public Element createNewElement(String name, String content) {
        return new BasicHtmlElement(name, content);
    }

    @Override
    public Element createNewElement(String name, ElementAttribute attribute) {
        return new BasicHtmlElement(name,attribute);
    }

    @Override
    public ElementAttribute createAttribute(String name, String value) {
        return new ElementAttribute(name, value);
    }

    @Override
    public Table createTable(String tableName, int row, int col) {
        return new Table(createAttribute("name", tableName), row, col);
    }

    @Override
    public Table createTable(int row, int col) {
        return new Table(row, col);
    }

    @Override
    public ElementText createTextElement(String content) {
        return new ElementText(content);
    }

    @Override
    public ElementList createList() {
        return new UnorderedList();
    }

    @Override
    public ElementList createList(ElementListEnum listType) {
        return listType.equals(ElementListEnum.Unordered)?
                new UnorderedList():
                new OrderedList();
    }

    @Override
    public ElementList createList(ElementListEnum listType, ArrayList<Element> collection) {
        return listType.equals(ElementListEnum.Unordered)?
                new UnorderedList(collection):
                new OrderedList(collection);
    }
}