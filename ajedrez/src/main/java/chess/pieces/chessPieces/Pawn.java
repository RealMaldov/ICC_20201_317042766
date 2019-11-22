/**
 * @author Alejandro Maldonado Vázquez
 */
package chess.pieces.chessPieces;

import java.util.LinkedList;
import java.util.List;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;

/**
 * CLass of the Pawn piece
 */
public class Pawn extends Piece {

    //We call de parents constructor and make the Pawn one
    public Pawn (Position p, ColorEnum color){
        super(p,color);
        this.type= PiecesTypeEnum.PAWN;
    }

    //This is where all the fun is
    @Override
    public List<Position> getLegalMoves() {
        this.legalMoves = new LinkedList<Position>();
        
        //Side of the function for the white side
        if(this.getColor()== ColorEnum.WHITE){
        int currentX=this.position.getX();
        Position check = new Position(currentX,this.position.getY()+1); 
        Position check2 = new Position(currentX-1,this.position.getY()+1); 
        Position check3 = new Position(currentX+1,this.position.getY()+1); 
        
        //Cases for the normal pawns and the ones in the edge
        //its exactly like the ones below
        switch(currentX){
            case 0:
            if(this.position.getY()<7){
            //if one piece is in the front it considers this for the next moves, it also considers the board
            //its exactly like the ones below
            if (this.isAppendable(check) == 0 || this.isAppendable(check3) == 0){
                if(this.isAppendable(check)==0)
                {
                if(this.isAppendable(check3)==0&&this.isAppendable(check)==0){
                Position nextLegalPosition = check3; 
                this.legalMoves.add(nextLegalPosition);}}
                if(this.isAppendable(check)!=0){
                        Position nextLegalPosition = check3; 
                        this.legalMoves.add(nextLegalPosition);}
            }
        }
        int currentY0=this.position.getY();
         
        //It calculates the next move considering the board
        //its exactly like the ones below
        if(currentY0<7&&this.isAppendable(check)!=0){
            if(getExtra()==0){
                for(int i=0;i<2;i++){
                    System.out.println("CurrentY vale: "+currentY0);
                currentY0++;
                Position nextLegalPosition = new Position(this.position.getX(),currentY0); 
                if (this.isAppendable(nextLegalPosition) != -1)
                    this.legalMoves.add(nextLegalPosition);
                if (this.isAppendable(nextLegalPosition) == 0) 
                    this.legalMoves.add(nextLegalPosition); 
                }
            }
            else{
            currentY0++;
            Position nextLegalPosition = new Position(this.position.getX(),currentY0);
            currentY0--;
            if (this.isAppendable(nextLegalPosition) != -1)
            this.legalMoves.add(nextLegalPosition);

            if (this.isAppendable(nextLegalPosition) == 0) 
                this.legalMoves.add(nextLegalPosition);            
        }}  
              
        return this.legalMoves;
            case 7:
            if(this.position.getY()<7){
            if (this.isAppendable(check) == 0 || this.isAppendable(check2) == 0){
                if(this.isAppendable(check)==0)
                {
                if(this.isAppendable(check2)==0&&this.isAppendable(check)==0){
                Position nextLegalPosition = check2; 
                this.legalMoves.add(nextLegalPosition);}}
                if(this.isAppendable(check)!=0){
                        Position nextLegalPosition = check2; 
                        this.legalMoves.add(nextLegalPosition);}
                }
            }
        int currentY7=this.position.getY();
         
        if(currentY7<7&&this.isAppendable(check)!=0){
            if(getExtra()==0){
                for(int i=0;i<2;i++){
                    System.out.println("Currenty vale: "+currentY7);
                currentY7++;
                Position nextLegalPosition = new Position(this.position.getX(),currentY7); 
                if (this.isAppendable(nextLegalPosition) != -1)
                    this.legalMoves.add(nextLegalPosition);
                if (this.isAppendable(nextLegalPosition) == 0) 
                    this.legalMoves.add(nextLegalPosition); 
                }
            }
            else{
            currentY7++;
            Position nextLegalPosition = new Position(this.position.getX(),currentY7);
            currentY7--;
            if (this.isAppendable(nextLegalPosition) != -1)
            this.legalMoves.add(nextLegalPosition);

            if (this.isAppendable(nextLegalPosition) == 0) 
                this.legalMoves.add(nextLegalPosition);            
        }}  
        return this.legalMoves;
            default:
            if(this.position.getY()<7){
            if (this.isAppendable(check) == 0 || this.isAppendable(check2) == 0 || this.isAppendable(check3) == 0){
                if(this.isAppendable(check)==0)
                {
                if(this.isAppendable(check3)==0&&this.isAppendable(check)==0){
                currentX++;
                Position nextLegalPosition = new Position(currentX,this.position.getY()+1); 
                currentX--;
                this.legalMoves.add(nextLegalPosition);}
                if(this.isAppendable(check2)==0&&this.isAppendable(check)==0){
                currentX--;
                Position nextLegalPosition2 = new Position(currentX,this.position.getY()+1); 
                currentX++;
                this.legalMoves.add(nextLegalPosition2);}
            }
            if(this.isAppendable(check)!=0){
                if(this.isAppendable(check3)==0){
                    currentX++;
                    Position nextLegalPosition = new Position(currentX,this.position.getY()+1); 
                    currentX--;
                    this.legalMoves.add(nextLegalPosition);}
                    if(this.isAppendable(check2)==0){
                    currentX--;
                    Position nextLegalPosition2 = new Position(currentX,this.position.getY()+1); 
                    currentX++;
                    this.legalMoves.add(nextLegalPosition2);}
            }
        }
        }
        int currentY=this.position.getY();
         
        if(currentY<7&&this.isAppendable(check)!=0){
            if(getExtra()==0){
                for(int i=0;i<2;i++){
                    System.out.println("Currenty vale: "+currentY);
                currentY++;
                Position nextLegalPosition = new Position(this.position.getX(),currentY); 
                if (this.isAppendable(nextLegalPosition) != -1)
                    this.legalMoves.add(nextLegalPosition);
                if (this.isAppendable(nextLegalPosition) == 0) 
                    this.legalMoves.add(nextLegalPosition); 
                }
            }
            else{
            currentY++;
            Position nextLegalPosition = new Position(this.position.getX(),currentY);
            currentY--;
            if (this.isAppendable(nextLegalPosition) != -1)
            this.legalMoves.add(nextLegalPosition);

            if (this.isAppendable(nextLegalPosition) == 0) 
                this.legalMoves.add(nextLegalPosition);            
        }}  
    
        return this.legalMoves;
       
        }
        }

        //Side of the function made for the black side
        else{
            int currentX=this.position.getX();
        Position check = new Position(currentX,this.position.getY()-1); 
        Position check2 = new Position(currentX-1,this.position.getY()-1); 
        Position check3 = new Position(currentX+1,this.position.getY()-1); 
        switch(currentX){
            case 0:
            if(this.position.getY()<7){
            if (this.isAppendable(check) == 0 || this.isAppendable(check3) == 0 ){

                System.out.println("Check: "+this.isAppendable(check));
                System.out.println("Check3: "+this.isAppendable(check3));

                if(this.isAppendable(check)==0)
                {

                if(this.isAppendable(check3)==0&&this.isAppendable(check)==0){

                Position nextLegalPosition = check3; 
                this.legalMoves.add(nextLegalPosition);}}

                if(this.isAppendable(check)!=0){
                        Position nextLegalPosition = check3; 
                        this.legalMoves.add(nextLegalPosition);}
            }
        }
        int currentY0=this.position.getY();
         
        if(currentY0<7&&this.isAppendable(check)!=0){
            if(getExtra()==0){
                for(int i=0;i<2;i++){
                    System.out.println("Currenty vale: "+currentY0);
                currentY0--;
                Position nextLegalPosition = new Position(this.position.getX(),currentY0); 
                if (this.isAppendable(nextLegalPosition) != -1)
                    this.legalMoves.add(nextLegalPosition);
                if (this.isAppendable(nextLegalPosition) == 0) 
                    this.legalMoves.add(nextLegalPosition); 
                }
            }
            else{
            currentY0--;
            Position nextLegalPosition = new Position(this.position.getX(),currentY0);
            currentY0++;
            if (this.isAppendable(nextLegalPosition) != -1)
            this.legalMoves.add(nextLegalPosition);

            if (this.isAppendable(nextLegalPosition) == 0) 
                this.legalMoves.add(nextLegalPosition);            
        }}  
              
        return this.legalMoves;
            case 7:
            if(this.position.getY()<7){
            if (this.isAppendable(check) == 0 || this.isAppendable(check2) == 0){
                if(this.isAppendable(check)==0)
                {
                if(this.isAppendable(check2)==0&&this.isAppendable(check)==0){
                Position nextLegalPosition = check2; 
                this.legalMoves.add(nextLegalPosition);}}
                if(this.isAppendable(check)!=0){
                        Position nextLegalPosition = check2; 
                        this.legalMoves.add(nextLegalPosition);}
                }
            
            }
        int currentY7=this.position.getY();
         
        if(currentY7<7&&this.isAppendable(check)!=0){
            if(getExtra()==0){
                for(int i=0;i<2;i++){
                    System.out.println("Currenty vale: "+currentY7);
                currentY7--;
                Position nextLegalPosition = new Position(this.position.getX(),currentY7); 
                if (this.isAppendable(nextLegalPosition) != -1)
                    this.legalMoves.add(nextLegalPosition);
                if (this.isAppendable(nextLegalPosition) == 0) 
                    this.legalMoves.add(nextLegalPosition); 
                }
            }
            else{
            currentY7--;
            Position nextLegalPosition = new Position(this.position.getX(),currentY7);
            currentY7++;
            if (this.isAppendable(nextLegalPosition) != -1)
            this.legalMoves.add(nextLegalPosition);

            if (this.isAppendable(nextLegalPosition) == 0) 
                this.legalMoves.add(nextLegalPosition);            
        }}  
        return this.legalMoves;
            default:
            if(this.position.getY()<7){
            if (this.isAppendable(check) == 0 || this.isAppendable(check2) == 0 || this.isAppendable(check3) == 0){
                if(this.isAppendable(check)==0)
                {
                if(this.isAppendable(check3)==0&&this.isAppendable(check)==0){

                Position nextLegalPosition = check3; 
                this.legalMoves.add(nextLegalPosition);}
                if(this.isAppendable(check2)==0&&this.isAppendable(check)==0){
                Position nextLegalPosition2 = check2; 
                this.legalMoves.add(nextLegalPosition2);}
            }
            if(this.isAppendable(check)!=0){
                if(this.isAppendable(check3)==0){
                    Position nextLegalPosition = check3; 
                    this.legalMoves.add(nextLegalPosition);}
                    if(this.isAppendable(check2)==0){
                    Position nextLegalPosition2 = check2; 
                    this.legalMoves.add(nextLegalPosition2);}
            }
        }
        }
        int currentY=this.position.getY();
         
        if(currentY<7&&this.isAppendable(check)!=0){
            if(getExtra()==0){
                for(int i=0;i<2;i++){
                    System.out.println("CurrentY value: "+currentY);
                currentY--;
                Position nextLegalPosition = new Position(this.position.getX(),currentY); 
                if (this.isAppendable(nextLegalPosition) != -1)
                    this.legalMoves.add(nextLegalPosition);
                if (this.isAppendable(nextLegalPosition) == 0) 
                    this.legalMoves.add(nextLegalPosition); 
                }
            }
            else{
            currentY--;
            Position nextLegalPosition = new Position(this.position.getX(),currentY);
            currentY++;
            if (this.isAppendable(nextLegalPosition) != -1)
            this.legalMoves.add(nextLegalPosition);

            if (this.isAppendable(nextLegalPosition) == 0) 
                this.legalMoves.add(nextLegalPosition);            
        }}  
              
        return this.legalMoves;
        
        }
        }
    }

    /**
    * Special method equals
    */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pawn))
            return false;

        Pawn t = (Pawn) obj;
        return (t.getColor() == this.getColor() && this.getPosition().equals(t.getPosition())) ? true : false;

    }
}