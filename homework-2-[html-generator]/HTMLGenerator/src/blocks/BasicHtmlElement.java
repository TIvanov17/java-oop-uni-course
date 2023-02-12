package blocks;

public class BasicHtmlElement extends Element {

    public BasicHtmlElement(String elementName) {
        super(elementName);
    }

    public BasicHtmlElement(String elementName, String elementContent) {
        super(elementName, elementContent);
    }

    public BasicHtmlElement(String elementName, ElementAttribute attribute) {
        super(elementName, attribute);
    }

    public void addElement(Element element) {
        if (element.hasNotNestedElements()) {
            this.elementNestedStructure += element.getElementTagStructure();
            this.elementNestedTSVCodeColl.add(element.getElementTSVName());
            return;
        }
        this.elementNestedStructure += element.render();
        this.elementNestedTSVCodeColl.addAll(element.elementNestedTSVCodeColl);
    }
}