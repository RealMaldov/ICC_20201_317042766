/**
* @author Alejandro Maldonado Vázquez
*/
package chess.pieces.chessPieces;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;
import java.util.LinkedList;
import java.util.List;


 // Class for the bishop piece
 
public class Bishop extends Piece {

    public Bishop(Position p, ColorEnum color) {
        super(p, color);
        this.type = PiecesTypeEnum.BISHOP;
    }

   //Like the rook, this method calculates the next moves
    public List<Position> getLegalMoves() {
        Board board = Board.getInstance();
        this.legalMoves = new LinkedList<Position>();
        for (int i = this.position.getX() + 1, j = this.position.getY() + 1; i < 8 && j < 8; i++, j++) {
            Position nextLegalPosition = new Position(i, j);
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor() == this.getColor())
                break;
            if (piece.getColor() != ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);
        }
        for (int i = this.position.getX() + 1, j = this.position.getY() - 1; i < 8 && j >= 0; i++, j--) {
            Position nextLegalPosition = new Position(i, j);
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor() == this.getColor())
                break;
            if (piece.getColor() != ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);
        }
        for (int i = this.position.getX() - 1, j = this.position.getY() - 1; i >= 0 && j >= 0; i--, j--) {
            Position nextLegalPosition = new Position(i, j);
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor() == this.getColor())
                break;
            if (piece.getColor() != ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);
        }
        for (int i = this.position.getX() - 1, j = this.position.getY() + 1; i >= 0 && j < 8; i--, j++) {
            Position nextLegalPosition = new Position(i, j);
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor() == this.getColor())
                break;
            if (piece.getColor() != ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);
        }
        return this.legalMoves;
    }

    /**
     * Special Method equals
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Bishop))
            return false;
        Bishop t = (Bishop) obj;
        return (t.getColor() == this.getColor() && this.getPosition().equals(t.getPosition())) ? true : false;

    }

}