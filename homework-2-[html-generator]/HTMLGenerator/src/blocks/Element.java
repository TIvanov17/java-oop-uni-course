package blocks;

import java.util.ArrayList;

public abstract class Element{

    private static final String LEFT_OPEN_TAG_SIGN = "<";
    private static final String LEFT_CLOSE_TAG_SIGN = "</";
    private static final String RIGHT_TAG_SIGN = ">";

    private static final String TILDA_SEPARATOR_SIGN = "~";
    private static final String TILDA_ATTRIBUTE_NAME_SIGN = "#";
    private static final String TILDA_ATTRIBUTE_VALUE_SIGN = "!";
    private static final String TILDA_TEXT_CONTENT_SIGN = "|";

    protected String elementName;
    protected String elementContent;
    protected ElementAttribute attribute;
    protected String elementNestedStructure;
    protected ArrayList<String> elementNestedTSVCodeColl = new ArrayList<>();

    public Element(String elementName){
        this.elementName = elementName;
        this.setElementContentToDefault();
        this.setElementNestedStructureToDefault();
        this.elementNestedTSVCodeColl.add(this.getElementTSVName());
    }

    public Element(String elementName, String elementContent){
        this.elementName = elementName;
        this.elementContent = elementContent;
        this.setElementNestedStructureToDefault();
        this.elementNestedTSVCodeColl.add(this.getElementTSVName());
    }

    public Element(String elementName, ElementAttribute attribute){
        this.elementName = elementName;
        this.setElementContentToDefault();
        this.setElementNestedStructureToDefault();
        this.attribute = attribute;
        this.elementNestedTSVCodeColl.add(this.getElementTSVName());
    }

    public abstract void addElement(Element element);

    public String getOpenTag() {
        String openTag = !hasAttribute()?
                LEFT_OPEN_TAG_SIGN + this.elementName + RIGHT_TAG_SIGN :
                LEFT_OPEN_TAG_SIGN + this.elementName + " " +
                this.attribute.getName() + "=" + "'" +
                this.attribute.getValue() + "'" + RIGHT_TAG_SIGN;

        return openTag;
    }

    public String getCloseTag() {
        return LEFT_CLOSE_TAG_SIGN + this.elementName + RIGHT_TAG_SIGN;
    }

    public String render(){
        return ( this.getOpenTag() + this.elementNestedStructure + this.getCloseTag() );
    }

    public String renderAsTSV() {
        String buildTSVCode = "";
        for(int currentIndex = 0; currentIndex < this.elementNestedTSVCodeColl.size(); currentIndex++){
            String currentElementName = this.elementNestedTSVCodeColl.get(currentIndex);

            if(this.elementNestedTSVCodeColl.size() == 1){
                buildTSVCode += currentElementName;
                break;
            }
            if(isLastElement(currentIndex)){
                buildTSVCode += TILDA_SEPARATOR_SIGN + currentElementName;
                break;
            }
            buildTSVCode += currentElementName + TILDA_SEPARATOR_SIGN;
        }
        return buildTSVCode;
    }

    public String getElementTSVName(){
        if(hasAttribute()){
            return this.elementName + TILDA_ATTRIBUTE_NAME_SIGN +
                   this.attribute.getName() + TILDA_ATTRIBUTE_VALUE_SIGN +
                   this.attribute.getValue();
        }
        if(hasContent()){
            return this.elementName + TILDA_TEXT_CONTENT_SIGN + this.elementContent;
        }
        return this.elementName;
    }

    protected String getElementTagStructure(){
        return this.getOpenTag() + this.getTextContent() + this.getCloseTag();
    }

    protected boolean hasNotNestedElements(){
        return this.elementNestedStructure.equals("");
    }

    private String getTextContent(){
        return this.elementContent;
    }

    private boolean hasAttribute(){
        return this.attribute != null;
    }

    private boolean hasContent(){
        return !this.elementContent.equals("");
    }

    private boolean isLastElement(int currentIndex){
        return currentIndex == this.elementNestedTSVCodeColl.size() - 1;
    }

    private void setElementNestedStructureToDefault(){
        this.elementNestedStructure = "";
    }

    private void setElementContentToDefault(){
        this.elementContent = "";
    }
}