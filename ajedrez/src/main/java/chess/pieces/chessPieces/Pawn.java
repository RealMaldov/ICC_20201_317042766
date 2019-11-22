package chess.pieces.chessPieces;

import java.util.LinkedList;
import java.util.List;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;
import chess.pieces.chessPieces.Queen;

public class Pawn extends Piece {

    public Piece[][] matrix;
    public Pawn (Position p, ColorEnum color){
        super(p,color);
        this.type= PiecesTypeEnum.PAWN;
    }

    @Override
    public List<Position> getLegalMoves() {
        this.legalMoves = new LinkedList<Position>();
        
        if(this.getColor()== ColorEnum.WHITE){
        int currentX=this.position.getX();
        Position check = new Position(currentX,this.position.getY()+1); 
        Position check2 = new Position(currentX-1,this.position.getY()+1); 
        Position check3 = new Position(currentX+1,this.position.getY()+1); 
        switch(currentX){
            case 0:
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

        int currentY0=this.position.getY();
         
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

        else{
            int currentX=this.position.getX();
        Position check = new Position(currentX,this.position.getY()-1); 
        Position check2 = new Position(currentX-1,this.position.getY()-1); 
        Position check3 = new Position(currentX+1,this.position.getY()-1); 
        switch(currentX){
            case 0:
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
}