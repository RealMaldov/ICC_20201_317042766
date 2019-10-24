/**
 * @author Alejandro Maldonado 
 */
public class MatrixTest{
    
    public static void scalarProduct_test(){
        double[][] uno={{1,2,3},{1,2,3}};
        double[][] dos={{2,4,6},{2,4,6}};
        Matrix one= new Matrix(uno);
        Matrix two= new Matrix(dos);
        one.scalarProduct(2);
        if(one.equals(two))
        System.out.println("Yei");
        else
        System.out.println("scalar product failed");
    }
    public static void add_test(){
        double[][] uno={{1,2,3},{1,2,3}};
        double[][] dos={{3,4,6},{2,4,6}};
        double[][] tres={{4,6,9},{3,6,9}};
        Matrix one= new Matrix(uno);
        Matrix two= new Matrix(dos);
        Matrix three= new Matrix(tres);
        one.add(two);
        if(one.equals(three))
        System.out.println("Yei");
        else
        System.out.println("addition failed");
    }
    public static void matrixProduct_test(){
        double[][] uno={{2,0,1},{3,0,0},{5,1,1}};
        double[][] dos={{1,0,1},{1,2,1},{1,1,0}};
        double[][] tres={{3,1,2},{3,0,3},{7,3,6}};
        Matrix one= new Matrix(uno);
        Matrix two= new Matrix(dos);
        Matrix three= new Matrix(tres);
        one.matrixProduct(two);
         if(one.equals(three))
        System.out.println("Yei");
        else
        System.out.println("matrix product failed");
    }
    public static void setElement_test(){
        double[][] uno={{2,0,1},{3,0,0}};
        double[][] dos={{1,0,1},{3,0,0}};
        Matrix one= new Matrix(uno);
        Matrix two= new Matrix(dos);
        one.setElement(0,0,1);
        if(one.equals(two))
        System.out.println("Yei");
        else
        System.out.println("setElement failed");
    }
    public static void getElement_test(){
        double[][] uno={{2,0,1},{3,0,0}};
        Matrix one= new Matrix(uno);     
        if(one.getElement(0,0)==2)
        System.out.println("Yei");
        else
        System.out.println("Get element failed");
    }
    public static void determinant_test(){
        System.out.println("Determinant failed");
    }
    public static void equals_test(){
        double[][] uno={{2,0,1},{3,0,0}};
        double[][] dos={{2,0,1},{3,0,0}};
        Matrix one= new Matrix(uno);  
        Matrix two= new Matrix(dos); 
        if(one.equals(two))
        System.out.println("Yei");
        else 
        System.out.println("equals failed");
    }

    public static void main(String[] args) {
        scalarProduct_test();
        add_test();
        matrixProduct_test();
        setElement_test();
        getElement_test();
        determinant_test();
        equals_test();
    }
}