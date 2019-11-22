/**
 * @author Alejandro Maldonado Vázquez
 */
package gui;

import java.util.LinkedList;
import java.util.List;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import processing.core.PApplet;
import processing.core.PImage;

//Class with all the necessary grafics for the game
public class ChessGUI extends PApplet {
    Position selected = null;
    ColorEnum turn = ColorEnum.WHITE;

    int PIXEL_SIZE = 50;
    List<Position> legalMoves = new LinkedList<>();
    Board board = Board.getInstance();
    PImage black_rook;
    PImage white_rook;
    PImage black_pawn;
    PImage white_pawn;
    PImage black_queen;
    PImage white_queen;
    PImage black_king;
    PImage white_king;
    PImage black_horse;
    PImage white_horse;
    PImage black_bishop;
    PImage white_bishop;

//Main clas that starts the graphic functions for the game
    public static void main(String[] args) {
        PApplet.main("gui.ChessGUI");
    }

    //Size of the gui
    @Override
    public void settings() {
        size(400, 440);
    }

    //Method that loads the images
    @Override
    public void setup() {
        // legalMoves = board.getPiece(new Position(4,4)).getLegalMoves();
        System.out.println(board.getPiece(new Position(4, 4)).getLegalMoves());
        black_rook = loadImage(getClass().getResource("/black-rook-50.png").getPath());
        white_rook = loadImage(getClass().getResource("/white-rook-50.png").getPath());
        black_pawn = loadImage(getClass().getResource("/black-pawn-50.png").getPath());
        white_pawn = loadImage(getClass().getResource("/white-pawn-50.png").getPath());
        black_queen = loadImage(getClass().getResource("/black-queen-50.png").getPath());
        white_queen = loadImage(getClass().getResource("/white-queen-50.png").getPath());
        black_king = loadImage(getClass().getResource("/black-king-50.png").getPath());
        white_king = loadImage(getClass().getResource("/white-king-50.png").getPath());
        black_horse = loadImage(getClass().getResource("/black-horse-50.png").getPath());
        white_horse = loadImage(getClass().getResource("/white-horse-50.png").getPath());
        black_bishop = loadImage(getClass().getResource("/black-bishop-50.png").getPath());
        white_bishop = loadImage(getClass().getResource("/white-bishop-50.png").getPath());
    }

    //Funcions that calls all the drawing functions
    @Override
    public void draw() {
        drawBoard();
        drawPosibleMoves();
        writeTurn();
    }

    //Method that writes the turn
    public void writeTurn() {
        fill(255, 255, 255);
        rect(0,400,400,40);
        textSize(20);
        fill(0, 0, 0);
        text(turn.toString().toLowerCase()+" moves", 30, 430);
    }

    //Function that draws the possible moves calling calculator methods
    public void drawPosibleMoves() {
        stroke(255, 0, 0);
        fill(0, 0, 0, 100);
        for (Position g : legalMoves) {
            int x = g.getX();
            int y = g.getY();
            rect(x * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
        }
        stroke(0, 0, 0);
    }

    //Function that draws the board
    public void drawBoard() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0)
                        fill(255,15, 150);
                    else
                        fill(255, 255, 255);
                } else {
                    if (j % 2 == 0)
                        fill(255, 255, 255);
                    else
                        fill(255,15, 150);
                }
                rect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
                Piece p = board.getPiece(new Position(i, j));
                drawPiece(p);
            }
        }
    }

    //Function that draws each piece with their respective image
    public void drawPiece(Piece p) {
        int x = p.getPosition().getX();
        int y = p.getPosition().getY();
        switch (p.getType()) {
        case ROOK:
            if (p.getColor().equals(ColorEnum.WHITE))
                image(white_rook, x * PIXEL_SIZE, y * PIXEL_SIZE);
            if (p.getColor().equals(ColorEnum.BLACK))
                image(black_rook, x * PIXEL_SIZE, y * PIXEL_SIZE);
            break;
        case EMPTY:
            break;
        case PAWN:
        if (p.getColor().equals(ColorEnum.WHITE))
            image(white_pawn, x * PIXEL_SIZE, y * PIXEL_SIZE);
        if (p.getColor().equals(ColorEnum.BLACK))
            image(black_pawn, x * PIXEL_SIZE, y * PIXEL_SIZE);
            break;
        case QUEEN:
        if (p.getColor().equals(ColorEnum.WHITE))
            image(white_queen, x * PIXEL_SIZE, y * PIXEL_SIZE);
        if (p.getColor().equals(ColorEnum.BLACK))
            image(black_queen, x * PIXEL_SIZE, y * PIXEL_SIZE);
            break;
        case KING:
        if (p.getColor().equals(ColorEnum.WHITE))
            image(white_king, x * PIXEL_SIZE, y * PIXEL_SIZE);
        if (p.getColor().equals(ColorEnum.BLACK))
            image(black_king, x * PIXEL_SIZE, y * PIXEL_SIZE);
            break;   
        case HORSE:
            if (p.getColor().equals(ColorEnum.WHITE))
                image(white_horse, x * PIXEL_SIZE, y * PIXEL_SIZE);
            if (p.getColor().equals(ColorEnum.BLACK))
                image(black_horse, x * PIXEL_SIZE, y * PIXEL_SIZE);
                break; 
        case BISHOP:
            if (p.getColor().equals(ColorEnum.WHITE))
                image(white_bishop, x * PIXEL_SIZE, y * PIXEL_SIZE);
            if (p.getColor().equals(ColorEnum.BLACK))
                image(black_bishop, x * PIXEL_SIZE, y * PIXEL_SIZE);
                break; 
        default:
            break;
        }
    }

    //Method that Shows a selected square
    @Override
    public void mouseClicked() {
        int x = mouseX / PIXEL_SIZE;
        int y = mouseY / PIXEL_SIZE;
        Position p = new Position(x, y);
        if(!p.isLegal())return;
        Piece piece = board.getPiece(p);

        if (selected == null) {

            if (!piece.getColor().equals(turn))
                return;
            this.legalMoves = piece.getLegalMoves();
            selected = p;
            return;
        } else {
            this.legalMoves = piece.getLegalMoves();
            Piece piece2 = board.getPiece(selected);
            if (!piece2.isLegalMove(p)) {
                selected = null;
                return;
            }
            if (turn.equals(ColorEnum.WHITE))
                turn = ColorEnum.BLACK;
            else
                turn = ColorEnum.WHITE;
            this.board.move(selected, new Position(x, y));
            selected = null;
        }

        this.legalMoves = new LinkedList<>();
        System.out.println("Pieza en coord:");
        System.out.println("X: "+ x);
        System.out.println("Y: "+y);
    }

}