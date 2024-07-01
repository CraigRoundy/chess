package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {
    private PieceType type;
    private ChessGame.TeamColor pieceColor;

    //Initiates piece obj if color and type are valid
    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        setPieceColor(pieceColor);
        setPieceType(type);
    }

    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    public void setPieceColor(ChessGame.TeamColor pieceColor) {
        boolean validPieceColor = false;
        for (ChessGame.TeamColor pieceColor2 : ChessGame.TeamColor.values()) {
            if (pieceColor2 == pieceColor) {
                validPieceColor = true;
                break;
            }
        }
        if (!validPieceColor) {
            throw new IllegalArgumentException("Invalid piece color: " + pieceColor);
        }
        this.pieceColor = pieceColor;
    }

    public void setPieceType(PieceType type) {
        boolean validPieceType = false;
        for (PieceType pieceType : PieceType.values()) {
            if (pieceType == type) {
                validPieceType = true;
                break;
            }
        }
        if (!validPieceType) {
            throw new IllegalArgumentException("Invalid piece type: " + type);
        }
        this.type = type;
    }

    public ChessGame.TeamColor getTeamColor() {
        return pieceColor;
    }

    public PieceType getPieceType() {
        return type;
    }


    private Collection<ChessMove> trimInvalidMoves(Collection<ChessMove> moves) {
        Collection<ChessMove> invalidMoves = new ArrayList<>();
        for (ChessMove move : moves) {

        }
        return moves;
    }
    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        //Create collection of valid chess moves
        //First identify the type of piece
        //Accordingly find potential moves
        //Filter invalid moves

        Collection<ChessMove> moves = new ArrayList<>();
        int currentRow = myPosition.getRow();
        int currentColumn = myPosition.getColumn();
        PieceType pieceType = getPieceType();

        if (pieceType == PieceType.KING) {
            moves.add(new ChessMove(myPosition, new ChessPosition( currentRow + 1, currentColumn - 1), null));
            moves.add(new ChessMove(myPosition, new ChessPosition( currentRow + 1, currentColumn), null));
            moves.add(new ChessMove(myPosition, new ChessPosition( currentRow + 1, currentColumn + 1), null));
            moves.add(new ChessMove(myPosition, new ChessPosition( currentRow , currentColumn - 1), null));
            moves.add(new ChessMove(myPosition, new ChessPosition( currentRow , currentColumn + 1), null));
            moves.add(new ChessMove(myPosition, new ChessPosition( currentRow - 1, currentColumn - 1), null));
            moves.add(new ChessMove(myPosition, new ChessPosition( currentRow - 1, currentColumn), null));
            moves.add(new ChessMove(myPosition, new ChessPosition( currentRow - 1, currentColumn + 1), null));
        }
        else if (pieceType == PieceType.QUEEN) {
            //Queen moves up to seven spaces in any direction
            for(int i = 1; i < 9; i++) {
                for(int j = 1; j < 9; j++) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(currentRow + i, currentColumn + j), null));
                    moves.add(new ChessMove(myPosition, new ChessPosition(currentRow + i, currentColumn - j), null));
                    moves.add(new ChessMove(myPosition, new ChessPosition(currentRow - i, currentColumn + j), null));
                    moves.add(new ChessMove(myPosition, new ChessPosition(currentRow - i, currentColumn - j), null));
                    moves.add(new ChessMove(myPosition, new ChessPosition(currentRow + i, currentColumn), null));
                    moves.add(new ChessMove(myPosition, new ChessPosition(currentRow - i, currentColumn), null));
                    moves.add(new ChessMove(myPosition, new ChessPosition(currentRow, currentColumn + j), null));
                    moves.add(new ChessMove(myPosition, new ChessPosition(currentRow, currentColumn - j), null));
                }
            }
        }
        else if (pieceType == PieceType.BISHOP) {
            for(int i = 1; i < 9; i++) {
                for (int j = 1; j < 9; j++) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(currentRow + i, currentColumn + j), null));
                    moves.add(new ChessMove(myPosition, new ChessPosition(currentRow + i, currentColumn - j), null));
                    moves.add(new ChessMove(myPosition, new ChessPosition(currentRow - i, currentColumn + j), null));
                    moves.add(new ChessMove(myPosition, new ChessPosition(currentRow - i, currentColumn - j), null));
                }
            }
        }
        else if (pieceType == PieceType.KNIGHT) {
            moves.add(new ChessMove(myPosition, new ChessPosition(currentRow + 2, currentColumn + 1), null));
            moves.add(new ChessMove(myPosition, new ChessPosition(currentRow + 2, currentColumn - 1), null));
            moves.add(new ChessMove(myPosition, new ChessPosition(currentRow + 1, currentColumn + 2), null));
            moves.add(new ChessMove(myPosition, new ChessPosition(currentRow + 1, currentColumn - 2), null));
            moves.add(new ChessMove(myPosition, new ChessPosition(currentRow - 2, currentColumn + 1), null));
            moves.add(new ChessMove(myPosition, new ChessPosition(currentRow - 2, currentColumn - 1), null));
            moves.add(new ChessMove(myPosition, new ChessPosition(currentRow - 1, currentColumn + 2), null));
            moves.add(new ChessMove(myPosition, new ChessPosition(currentRow - 1, currentColumn - 2), null));
        }
        else if (pieceType == PieceType.ROOK) {
            for(int i = 1; i < 9; i++) {
                for(int j = 1; j < 9; j++) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(currentRow + i, currentColumn), null));
                    moves.add(new ChessMove(myPosition, new ChessPosition(currentRow - i, currentColumn), null));
                    moves.add(new ChessMove(myPosition, new ChessPosition(currentRow, currentColumn + j), null));
                    moves.add(new ChessMove(myPosition, new ChessPosition(currentRow, currentColumn - j), null));
                }
            }
        }
        else if (pieceType == PieceType.PAWN) {

            //If on starting row allow two moves forward
            if()
        }
        else {
            throw new IllegalArgumentException("Invalid piece type: " + pieceType);
        }
        trimInvalidMoves(moves);
        return moves;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPiece that = (ChessPiece) o;
        return type == that.type && pieceColor == that.pieceColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, pieceColor);
    }


}
