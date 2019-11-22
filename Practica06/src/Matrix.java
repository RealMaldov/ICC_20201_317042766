/**
 * @author Alejandro Maldonado V.
 */
import java.util.Iterator;

public class Matrix implements Iterable <Double>{

    private double matrix[][];

    //Construye una matriz vacia de n por m
    /**
     * Constructor
     * @param n
     * @param m
     */
    public Matrix(int n, int m){
            if(n>=0&&m>=0){
        this.matrix=new double[n][m];}
    }

    /**
     * Constructor
     * @param array
     */
    //Construye una matriz dado un arreglo
    public Matrix(double[][] array){
        if(array.length>=0){
            this.matrix=new double[array.length][array[0].length];
            for(int i=0;i<array.length;i++){
                this.matrix[i][0]=array[i][0];
                for(int j=0;j<array[i].length;j++){
                   this.matrix[i][j]=array[i][j]; 
                }
            }
        }
    }

    /**
     * Method scalar
     * @param scalar
     */
    //Función que calcula producto escalar
    public void scalarProduct(double scalar){
        //multiplica scalar por la matriz
        for(int i=0;i<this.matrix.length;i++){
            for(int j=0;j<this.matrix[i].length;j++){
                this.matrix[i][j]=scalar*this.matrix[i][j];
            }
        }
    }

    /**
     * Method add
     * @param m
     */
    //Función que calcula suma de matrices
    public void add(Matrix m){
        //Si las matrices son iguales entonces se suman
        if(m.matrix.length==this.matrix.length&&m.matrix[0].length==this.matrix[0].length){
            for(int i=0;i<this.matrix.length;i++){
                for(int j=0;j<this.matrix[i].length;j++){
                    this.matrix[i][j]=this.matrix[i][j]+m.matrix[i][j];
                }
            }
        }
    }

    /**
     * Method matrixProduct
     * @param m
     */
    //Función que calcula producto de matrices
    public void matrixProduct(Matrix m){
        //si las matrices son iguales entonces las multiplica
        if(m.matrix.length==this.matrix.length&&m.matrix[0].length==this.matrix[0].length){
            double[][] uno=new double[this.matrix.length][this.matrix[0].length];
            int cont=0;
            int cont2=0;
            //un for anidado para que haga el proceso para cada casilla de cada fila
            for(int i=0;i<this.matrix[0].length;i++){    
                cont2=0;
                for(int j=0;j<this.matrix.length;j++){
                    cont=0;
                    while(cont!=this.matrix[0].length){
                      //  System.out.println("uno("+i+j+ ")= "+uno[i][j]+" + "+"("+this.matrix[i][cont]+"*"+m.matrix[cont][cont2]+")");
                        uno[i][j]=uno[i][j]+(this.matrix[i][cont]*m.matrix[cont][cont2]);
                        cont++;     
                    }
                     cont2++;
                }
            }
          for(int i=0;i<this.matrix.length;i++){
            for(int j=0;j<this.matrix[0].length;j++){
                this.matrix[i][j]=uno[i][j];
            }
          }  
        }
    }

    /**
     * Method getElement
     * @param i
     * @param j
     * @return
     */
    //Función que obtiene el elemento i j
    public double getElement(int i, int j){
        //pues solo regresa el elemento de las coordenadas
        if(i<this.matrix.length&&j<this.matrix[0].length)
        return this.matrix[i][j];
        return 0;
    }

    /**
     * Method setElement
     * @param i
     * @param j
     * @param e
     */
    //function set element
    public void setElement(int i, int j,double e){
        //si los valores no se pasan, entonces cambia el valor ahí por e
        if(i<this.matrix.length&&j<this.matrix[0].length){
            this.matrix[i][j]=e;
        }

    }

    //Función que calcula el determinante si es nxn
    public int determinant(){

    return 0;}
    /**
     * Method equals
     */
    //Función que te dice si 2 matrices son iguales
    @Override
    public boolean equals(Object o){
         Matrix uno = (Matrix) o;
        if (uno.matrix.length == this.matrix.length && uno.matrix[0].length == this.matrix[0].length)
           {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                if (this.matrix[i][j] != uno.getElement(i, j))
                    return false;
            }
        }
        return true;
    }
        return false;
    }

@Override
//Method that returns a matrix iterator
    public Iterator <Double> iterator() {    
        return new MatrixIterator();
    }
    
    //Iterator class
    private class MatrixIterator implements Iterator <Double>{
    private int col=1;
    private int ren= 0; 


    private boolean hasNextColumn(){    
        return (col < matrix[0].length-1)?true:false;
    }

    private boolean hasNextRen(){    
        return (ren < matrix.length-1)?true:false;
      }

    public boolean hasNext(){
        if (this.hasNextColumn()){
            return true;
        }else return (this.hasNextRen())?true:false;
    }
   
    //Method that gives back an iterated matrix
     @Override
     public Double next(){
        if (hasNext()){
            if(hasNextColumn()){
                col++;
            }
            else{col=0;
            if(hasNextRen()){
                ren++;
            }}
            return Matrix.this.matrix[this.ren][this.col];
        }
        return null;
      }
    }
}