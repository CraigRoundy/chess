package chess;

/**
 * Represents a single square position on a chess board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPosition {
    private int row;
    private int col;

    public ChessPosition(int row, int col) {
        setColumn(col);
        setRow(row);
    }

    /**
     * @return which row this position is in
     * 1 codes for the bottom row
     */
    public int getRow() {
        return row;
    }

    /**
     * @return which column this position is in
     * 1 codes for the left row
     */
    public int getColumn() {
        return col;
    }

    //Set row variable given input is valid
    public void setRow(int row) {
        if (row < 1 || row > 8) {
            throw new IllegalArgumentException("Invalid row number");
        }
        this.row = row;
    }

    //Set col variable given input is valid
    public void setColumn(int col) {
        if (col < 1 || col > 8) {
            throw new IllegalArgumentException("Invalid column number");
        }
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPosition that = (ChessPosition) o;
        return row == that.row && col == that.col;
    }

    @Override
    public int hashCode() {
        int result = 42;
        result = 31 * result + row;
        result = 31 * result + col;
        return result;
    }
}
