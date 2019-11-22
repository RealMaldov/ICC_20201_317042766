/**
 * @author Alejandro Maldonado Vázquez
 */
package chess.pieces.chessPieces;

import java.util.LinkedList;
import java.util.List;
import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;

//class for the rook piece that inherits the piece attributes
public class Rook extends Piece {
    /**
     * Constructor for the Rook piece
     * @param p
     * @param color
     */
    public Rook(Position p, ColorEnum color) {
        super(p, color);
        this.type = PiecesTypeEnum.ROOK;
    }

    //Method that calculates the possible moves for the rook
    public List<Position> getLegalMoves() {
        Board board = Board.getInstance();
        this.legalMoves = new LinkedList<Position>();

        //An iterator for the remaining spaces of the board for the x axis
        for (int i = this.position.getX() + 1; i < 8; i++) {
            
            Position nextLegalPosition = new Position(i, this.position.getY());
            if (this.isAppendable(nextLegalPosition) == -1)
                break;
            if (this.isAppendable(nextLegalPosition) == 0) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);
        }

        //Method that calculates the remaining spaces behind of the position in the x axis each turn
        for (int i = this.position.getX() - 1; i >= 0; i--) {
            Position nextLegalPosition = new Position(i, this.position.getY());
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor() == this.getColor())
                break;
            if (piece.getColor() != ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);

        }

        //Method like the one above, it calculates the remaning spaces of the board for the y axis
        for (int i = this.position.getY() + 1; i < 8; i++) {
            Position nextLegalPosition = new Position(this.position.getX(), i);
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor() == this.getColor())
                break;
            if (piece.getColor() != ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);

        }

        //Method like the one above, it calculates the spaces behind of the position in the y axis
        for (int i = this.position.getY() - 1; i >= 0; i--) {
            Position nextLegalPosition = new Position(this.position.getX(), i);
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
        if (!(obj instanceof Rook))
            return false;

        Rook t = (Rook) obj;
        return (t.getColor() == this.getColor() && this.getPosition().equals(t.getPosition())) ? true : false;

    }
}