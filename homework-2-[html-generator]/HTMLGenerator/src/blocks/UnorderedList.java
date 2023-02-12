package blocks;

import java.util.ArrayList;

public class UnorderedList extends ElementList{

    public UnorderedList(){
        super(UNORDERED_LIST_TAG_NAME);
    }

    public UnorderedList(ArrayList<Element> collection){
        super(UNORDERED_LIST_TAG_NAME, collection);
    }
}
