/**
 * @author Alejandro Maldonado Vázquez
 */
package chess.pieces.chessPieces;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.*;
import chess.pieces.ColorEnum;
import chess.pieces.PiecesTypeEnum;
import java.util.LinkedList;
import java.util.List;

// class for the queen piece that extends Rook class instead of the piece class
public class Queen extends Rook {
   
    public Queen(Position p, ColorEnum color) {
        super(p, color);
        this.type = PiecesTypeEnum.QUEEN;
    }

   //Method that includes the moves for the bishop and the rook
    @Override
    public List<Position> getLegalMoves() {
        Board board = Board.getInstance();
        this.legalMoves =new LinkedList<Position>(super.getLegalMoves());
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
    * Special method equals
    */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Queen))
            return false;

        Queen t = (Queen) obj;
        return (t.getColor() == this.getColor() && this.getPosition().equals(t.getPosition())) ? true : false;

    }

}