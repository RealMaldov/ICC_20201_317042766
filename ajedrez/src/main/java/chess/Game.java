/**
 * @author Alejandro Maldonado Vázquez
 */
package chess;
import chess.items.Board;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.chessPieces.Rook;
import chess.pieces.chessPieces.Pawn;
import chess.items.*;
public class Game{
//The principal class that starts the fun
    public static void main(String[] args) {
        Board board = Board.getInstance();
        //Board's specifications
        System.out.println(board.toString());
    }
}