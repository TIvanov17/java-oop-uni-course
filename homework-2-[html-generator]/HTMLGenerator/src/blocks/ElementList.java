package blocks;

import java.util.ArrayList;

public abstract class ElementList extends Element  {

    protected static final String UNORDERED_LIST_TAG_NAME = "ul";
    protected static final String ORDERED_LIST_TAG_NAME = "ol";
    protected static final String LIST_ITEM_TAG_NAME = "li";
    private ArrayList<Element> collection = new ArrayList<>();

    public ElementList(String listType){
        super(listType);
    }

    public ElementList(String listType, ArrayList<Element> collection){
        super(listType);
        this.collection = collection;
        this.addAllElementsFromCollection();
    }

    @Override
    public void addElement(Element element){
        Element listItem = new BasicHtmlElement(LIST_ITEM_TAG_NAME);
        listItem.addElement(element);
        this.elementNestedStructure += listItem.render();
        this.elementNestedTSVCodeColl.addAll(listItem.elementNestedTSVCodeColl);
    }

    private void addAllElementsFromCollection(){
        for(Element element: collection){
            addElement(element);
        }
    }
}