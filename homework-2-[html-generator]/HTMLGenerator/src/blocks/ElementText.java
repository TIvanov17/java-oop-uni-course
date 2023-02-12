package blocks;

public class ElementText extends BasicHtmlElement {

    private static final String NO_TAG_STRUCTURE = "";

    public ElementText(String content) {
        super(NO_TAG_STRUCTURE);
        this.elementContent = content;
    }

    @Override
    public String render(){
        return this.elementContent;
    }

    @Override
    public String getOpenTag(){
        return NO_TAG_STRUCTURE;
    }

    @Override
    public String getCloseTag(){
        return NO_TAG_STRUCTURE;
    }
}
