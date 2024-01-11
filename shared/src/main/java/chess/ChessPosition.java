package chess;

// Class represents the chess square position
// Includes row, column
// Row is 1-8, column is 1-8
public class ChessPosition {
    int row;
    int col;

    public ChessPosition(int row, int col) {
        if (row < 1 || row > 8 || col < 1 || col > 8) {
            throw new IllegalArgumentException("Invalid position");
        }
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return col;
    }
}
