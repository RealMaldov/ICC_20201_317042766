/**
 * @author Alejandro Maldonado Vázquez
 */
package chess.items;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.chessPieces.Empty;
import chess.pieces.chessPieces.Rook;
import chess.pieces.chessPieces.Pawn;
import chess.pieces.chessPieces.Queen;
import chess.pieces.chessPieces.King;
import chess.pieces.chessPieces.Horse;
import chess.pieces.chessPieces.Bishop;


public class Board{
    public int SIZE = 8;
    public Piece[][] matrix;
    private static Board instance = null;
    private Board(){
        this.matrix = new Piece[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.matrix[i][j] = new Empty(new Position(i, j), ColorEnum.NONE);
            }
        }
        //This creates the pieces for the white side
        this.matrix[0][1] = new Pawn (new Position(0, 1), ColorEnum.WHITE);
        this.matrix[1][1] = new Pawn (new Position(1, 1), ColorEnum.WHITE);
        this.matrix[2][1] = new Pawn (new Position(2, 1), ColorEnum.WHITE);
        this.matrix[3][1] = new Pawn (new Position(3, 1), ColorEnum.WHITE);
        this.matrix[4][1] = new Pawn (new Position(4, 1), ColorEnum.WHITE);
        this.matrix[5][1] = new Pawn (new Position(5, 1), ColorEnum.WHITE);
        this.matrix[6][1] = new Pawn (new Position(6, 1), ColorEnum.WHITE);
        this.matrix[7][1] = new Pawn (new Position(7, 1), ColorEnum.WHITE);
        this.matrix[0][0] = new Rook(new Position(0, 0), ColorEnum.WHITE);
        this.matrix[7][0] = new Rook(new Position(7, 0), ColorEnum.WHITE);
        this.matrix[1][0] = new Horse(new Position(1, 0), ColorEnum.WHITE);
        this.matrix[6][0] = new Horse(new Position(6, 0), ColorEnum.WHITE);
        this.matrix[2][0] = new Bishop(new Position(2, 0), ColorEnum.WHITE);
        this.matrix[5][0] = new Bishop(new Position(5, 0), ColorEnum.WHITE);
        this.matrix[4][0] = new King(new Position(4, 0), ColorEnum.WHITE);
        this.matrix[3][0] = new Queen(new Position(3, 0), ColorEnum.WHITE);
        //This creates the pieces for the black side
        this.matrix[0][6] = new Pawn (new Position(0, 6), ColorEnum.BLACK);
        this.matrix[1][6] = new Pawn (new Position(1, 6), ColorEnum.BLACK);
        this.matrix[2][6] = new Pawn (new Position(2, 6), ColorEnum.BLACK);
        this.matrix[3][6] = new Pawn (new Position(3, 6), ColorEnum.BLACK);
        this.matrix[4][6] = new Pawn (new Position(4, 6), ColorEnum.BLACK);
        this.matrix[5][6] = new Pawn (new Position(5, 6), ColorEnum.BLACK);
        this.matrix[6][6] = new Pawn (new Position(6, 6), ColorEnum.BLACK);
        this.matrix[7][6] = new Pawn (new Position(7, 6), ColorEnum.BLACK);
        this.matrix[0][7] = new Rook(new Position(0, 7), ColorEnum.BLACK);
        this.matrix[7][7] = new Rook(new Position(7, 7), ColorEnum.BLACK);
        this.matrix[1][7] = new Horse(new Position(1, 7), ColorEnum.BLACK);
        this.matrix[6][7] = new Horse(new Position(6, 7), ColorEnum.BLACK);
        this.matrix[2][7] = new Bishop(new Position(2, 7), ColorEnum.BLACK);
        this.matrix[5][7] = new Bishop(new Position(5, 7), ColorEnum.BLACK);
        this.matrix[4][7] = new King(new Position(4, 7), ColorEnum.BLACK);
        this.matrix[3][7] = new Queen(new Position(3, 7), ColorEnum.BLACK);
        
    }

    /**
     * Getter getInstance
     * @return instance
     */
    public static Board getInstance(){
        if(instance == null)
            instance = new Board();
        return instance;
    }

    /**
     * Getter getSize
     * @return this.size
     */
    public int getSize(){
        return this.SIZE;
    }

    /**
     * Method that verifies if a piece can move
     * @param p
     * @param q
     */
    public void move(Position p, Position q){
        if(!p.isLegal() || !q.isLegal())return;
        Piece piece = this.getPiece(p);
        if(!piece.isLegalMove(q))return;
        piece.moveTo(q);
        this.matrix[p.getX()][p.getY()] = new Empty(p,ColorEnum.NONE);
        this.matrix[q.getX()][q.getY()] = piece; 
    }

    /**
     * Getter getPiece
     * @param p
     * @return the instance of a piece
     */
    public Piece getPiece(Position p){
        //if(p.isOutOfBoard(SIZE))return null;
        return this.matrix[p.getX()][p.getY()];
    }


    /**
     * Special Method toString
     */
    public String toString(){
        var result = "";
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result = " "+ this.matrix[i][j]+" "+result;
            }
            result += '\n';
        }
        return result;
    }

}