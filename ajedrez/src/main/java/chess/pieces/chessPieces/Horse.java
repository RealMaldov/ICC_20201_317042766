package chess.pieces.chessPieces;

import java.util.LinkedList;
import java.util.List;
import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;

/* Clase para la pieza Caballo que extiende de la clase abstracta Pieza*/
public class Horse extends Piece{

  /* Constructor para la clase Caballo*/
  public Horse(Position p, ColorEnum color){
    super(p, color);
    this.type = PiecesTypeEnum.HORSE;

  }
  /* Método para verificar si una pieza se agrega a la lista o no*/
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
/*this.movimientosLegales = new LinkedList<Posicion>();
      Posicion uno = new Posicion(this.posicion.getX()-2, this.posicion.getY()+1);
      this.verificar(uno, movimientosLegales); */

  /* ALGORITMO PRINCIPAL PARA CADA PIEZA */
  public List<Position> getLegalMoves(){
    if(this.legalMoves == null){

      this.legalMoves = new LinkedList<Position>();
      Position nextPosition = new Position(this.position.getX()-2, this.position.getY()+1);
      this.verifyMoves(nextPosition, legalMoves);

      Position nextPosition2 = new Position(this.position.getX()-2, this.position.getY()-1);
      this.verifyMoves(nextPosition2, legalMoves);

      Position nextPosition3 = new Position(this.position.getX()-1, this.position.getY()-2);
      this.verifyMoves(nextPosition3, legalMoves);

      Position nextPosition4 = new Position(this.position.getX()+1, this.position.getY()-2);
      this.verifyMoves(nextPosition4, legalMoves);

      Position nextPosition5 = new Position(this.position.getX()+2, this.position.getY()-1);
      this.verifyMoves(nextPosition5, legalMoves);

      Position nextPosition6 = new Position(this.position.getX()+2, this.position.getY()+1);
      this.verifyMoves(nextPosition6, legalMoves);

      Position nextPosition7 = new Position(this.position.getX()-1, this.position.getY()+2);
      this.verifyMoves(nextPosition7, legalMoves);

      Position nextPosition8 = new Position(this.position.getX()+1, this.position.getY()+2);
      this.verifyMoves(nextPosition8, legalMoves);


    }
    return this.legalMoves;
  }


  /** Método equals para la pieza de la caballo
  * @param : Object Caballo
  **//*
  @Override
  public boolean equals(Object obj){
    if(!(obj instanceof Horse)) return false;
    @SuppressWarnings("unchecked") Caballo pieza = (Caballo) obj;
    if(pieza.getColor() == this.getColor() && this.getPosicion().equals(pieza.getPosicion())) return true;
    else return false;
  }*/

}