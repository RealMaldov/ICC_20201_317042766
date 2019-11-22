/**
 * @author Alejandro Maldonado Vázquez
 */
package chess.pieces;
import java.util.LinkedList;
import java.util.List;
import chess.items.Board;
import chess.items.Position;

//Class with the parent Concept of a chess piece
public abstract class Piece{
    protected Position position;
    protected LinkedList<Position> legalMoves = null;
    protected PiecesTypeEnum type;
    protected ColorEnum color;
    protected Board board;
    protected int extra=0;

    //Constructor with position and color as attributes
    public Piece(Position p, ColorEnum color) {
        this.position = p;
        this.color = color;
    }

    //Method that tells if something can be added, for instance, a list
    public int isAppendable(Position p){
        Board board = Board.getInstance();
        Piece piece = board.getPiece(p);
        if(piece.getColor() == this.getColor())return -1;
        if(piece.getColor() != ColorEnum.NONE)return 0;
        return 1;
    }
    
    /**
     * Getter getPosition
     * @return this.position
     */
    public Position getPosition(){
        return this.position;
    }

    //Method that serves for the start of the pawns
    public int getExtra(){
       // System.out.println("A"+extra+" Se le sumo 1");
        return extra++;
    }

    /**
     * Getter getColor
     * @return this.color
     */
    public ColorEnum getColor(){
        return this.color;
    }

    /**
     * Getter getType
     * @return this.type
     */
    public PiecesTypeEnum getType(){
        return this.type;
    }

    // Method that verifies if a chess piece can move
    public void moveTo(Position p) {
        if (isLegalMove(p)) {
            this.position = p;
            this.legalMoves = null;
            return;
        } else
            return;
    }
    
    //This calls the legal moves of each piece
    public abstract List<Position> getLegalMoves();
   
    public boolean isLegalMove(Position p) {
        List<Position> moves = this.getLegalMoves();
        return (moves.contains(p)) ? true : false;
    }

    /**
     * Special method toString
     */
    @Override
    public String toString() {
        return this.type.toString();
    }

    /**
     * Special method equals
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Piece))return false;
        Piece p = (Piece)obj;
        if(p.getType().equals(this.type) && p.getColor().equals(this.getColor()) && p.getPosition().equals(this.position))
        return true;
        return false;
    }
}