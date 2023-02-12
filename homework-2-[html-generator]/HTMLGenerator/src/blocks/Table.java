package blocks;

public class Table extends Element {

    private static final String TABLE_TAG_NAME = "table";
    private static final String TABLE_ROW_TAG_NAME = "tr";
    private static final String TABLE_COL_TAG_NAME = "td";
    private static final int NOT_SPECIFIC_POSITION = -1;

    private int tableNumberOfRows;
    private int tableNumberOfCols;

    public Table(int row, int col){
        super(TABLE_TAG_NAME);
        this.tableNumberOfRows = row;
        this.tableNumberOfCols = col;
        this.elementNestedStructure = refreshTable(null, NOT_SPECIFIC_POSITION, NOT_SPECIFIC_POSITION );
    }

    public Table(ElementAttribute attribute, int row, int col) {
        super(TABLE_TAG_NAME, attribute);
        this.tableNumberOfRows = row;
        this.tableNumberOfCols = col;
        this.elementNestedStructure = refreshTable(null, NOT_SPECIFIC_POSITION, NOT_SPECIFIC_POSITION );
    }

    @Override
    public void addElement(Element element){
        this.elementNestedStructure = refreshTable(element, NOT_SPECIFIC_POSITION, NOT_SPECIFIC_POSITION);
    }

    public void addElement(Element element, int tablePositionRow, int tablePositionCol){
        this.elementNestedStructure = refreshTable
                (element, tablePositionRow, tablePositionCol);
    }

    private String refreshTable(Element element, int positionRow, int positionCol){
        int rowNumber = NOT_SPECIFIC_POSITION;
        int colNumber = NOT_SPECIFIC_POSITION;

        if (shouldAddElementOnPosition(element, positionRow, positionCol)){
            rowNumber = positionRow;
            colNumber = positionCol;
        }
        return getTableInnerStructure(element, rowNumber, colNumber);
    }

    private String getTableInnerStructure(Element element, int positionRow, int positionCol){
        Element rowElement, colElement;
        clearElementNestedTSVCodeColl();
        String tableInnerStructure = "";

        for (int indexRow = 0; indexRow < tableNumberOfRows; indexRow++){
            rowElement = new BasicHtmlElement(TABLE_ROW_TAG_NAME);

            for (int indexCol = 0; indexCol < tableNumberOfCols; indexCol++){
                colElement = new BasicHtmlElement(TABLE_COL_TAG_NAME);

                if (isPositionReached(positionRow, indexRow, positionCol, indexCol) ||
                    shouldAddElement(element,positionRow, positionCol)) {

                    colElement.addElement(element);
                }
                rowElement.addElement(colElement);
            }
            tableInnerStructure += rowElement.render();
            this.elementNestedTSVCodeColl.addAll(rowElement.elementNestedTSVCodeColl);
        }
        return tableInnerStructure;
    }

    private void clearElementNestedTSVCodeColl(){
        this.elementNestedTSVCodeColl.clear();
        this.elementNestedTSVCodeColl.add(this.getElementTSVName());
    }

    private boolean isPositionReached(int positionRow, int currentRow,
                                      int positionCol, int currentCol) {

        return positionRow == currentRow + 1 && positionCol == currentCol + 1;
    }

    private boolean shouldAddElement(Element element, int row, int col){
        return element != null && row == NOT_SPECIFIC_POSITION && col == NOT_SPECIFIC_POSITION;
    }

    private boolean shouldAddElementOnPosition(Element element, int row, int col){
        return element != null && row != NOT_SPECIFIC_POSITION && col != NOT_SPECIFIC_POSITION;
    }
}