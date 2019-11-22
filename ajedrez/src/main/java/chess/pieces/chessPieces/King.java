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

// Class of the king piece
public class King extends Piece{

  public King(Position p, ColorEnum color){
    super(p, color);
    this.type = PiecesTypeEnum.KING;

  }
  //Its easier to verify each move for this piece
  public void verifyMoves(Position position, List<Position> l ){
    Board board = Board.getInstance();
    if(position.isOutOfBoard(board.getSize())){
      Piece piece = board.getPiece(position);
      if(piece.getColor().equals(this.getColor())) return;
      else 
      if(piece.getColor().equals(ColorEnum.NONE) || !piece.getColor().equals(this.getColor())) 
      l.add(position);
    }
    return;
  }

  /* The king does not posses many moves so its easier to instance each one of them */
  public List<Position> getLegalMoves(){
    if(this.legalMoves == null){

      this.legalMoves = new LinkedList<Position>();
      Position nextPosition = new Position(this.position.getX()-1, this.position.getY()-1);
      this.verifyMoves(nextPosition, legalMoves);

      Position nextPosition2 = new Position(this.position.getX(), this.position.getY()-1);
      this.verifyMoves(nextPosition2, legalMoves);

      Position nextPosition3 = new Position(this.position.getX()+1, this.position.getY()-1);
      this.verifyMoves(nextPosition3, legalMoves);

      Position nextPosition4 = new Position(this.position.getX()-1, this.position.getY());
      this.verifyMoves(nextPosition4, legalMoves);

      Position nextPosition5 = new Position(this.position.getX()+1, this.position.getY());
      this.verifyMoves(nextPosition5, legalMoves);

      Position nextPosition6 = new Position(this.position.getX()-1, this.position.getY()+1);
      this.verifyMoves(nextPosition6, legalMoves);

      Position nextPosition7 = new Position(this.position.getX(), this.position.getY()+1);
      this.verifyMoves(nextPosition7, legalMoves);

      Position nextPosition8 = new Position(this.position.getX()+1, this.position.getY()+1);
      this.verifyMoves(nextPosition8, legalMoves);


    }
    return this.legalMoves;
  }

  /**
    * Special method equals
    */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof King))
            return false;

        King t = (King) obj;
        return (t.getColor() == this.getColor() && this.getPosition().equals(t.getPosition())) ? true : false;

    }

}