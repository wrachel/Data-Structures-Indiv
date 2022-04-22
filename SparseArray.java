import java.util.ArrayList;
import java.util.List;

public class SparseArray {
    /**
     * The number of rows and columns in the sparse array.
     */
    private int numRows;
    private int numCols;
    /**
     * The list of entries representing the non-zero elements of the sparse array. Entries are stored in the
     * list in no particular order. Each non-zero element is represented by exactly one entry in the list.
     */
    private List<SparseArrayEntry> entries;

    /**
     * Constructs an empty SparseArray.
     */

    public SparseArray() {
        entries = new ArrayList<SparseArrayEntry>();
    }

    /**
     * Returns the number of rows in the sparse array.
     */
    public int getNumRows() {
        return numRows;
    }

    /**
     * Returns the number of columns in the sparse array.
     */
    public int getNumCols() {
        return numCols;
    }

    /**
     * Returns the value of the element at row index row and column index col in the sparse array.
     * Precondition: 0  row < getNumRows()
     * 0  col < getNumCols()
     */

    //part a
    public int getValueAt(int row, int col) {
        int sum = 0;
        for(SparseArrayEntry i : entries){
            if(i.getRow() == row && i.getCol() == col){
                sum = i.getValue();
            }
        }
        return sum;
    }


    //partb
    public void removeColumn(int col){
        for (int i = 0; i < entries.size(); i++){
            SparseArrayEntry temp = entries.get(i);

            if(temp.getCol() == col){
                entries.remove(i);
            }
        }
        for (int i = 0; i < entries.size(); i++){
            SparseArrayEntry temp2 = entries.get(i);
            if(temp2.getCol() > col){
                SparseArrayEntry value = new SparseArrayEntry(temp2.getRow(), temp2.getCol() - 1, temp2.getValue());
            }
        }
    }

    public static void main(String args[]){
        System.out.println("honestly, i do not want to implement this");
    }
}
