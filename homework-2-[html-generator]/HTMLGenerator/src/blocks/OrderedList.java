package blocks;

import java.util.ArrayList;

public class OrderedList extends ElementList {

    public OrderedList(){
        super(ORDERED_LIST_TAG_NAME);
    }

    public OrderedList(ArrayList<Element> collection){
        super(ORDERED_LIST_TAG_NAME, collection);
    }
}
