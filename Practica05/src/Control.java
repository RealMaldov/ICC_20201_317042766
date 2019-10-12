import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author Alejandro Maldonado Vázquez
 */
public class Control{


    /**
     * Method problema1
     * @param palabra
     * @return boolean
     */
    public static boolean problema1(String palabra){
        //Hacemos un array de la palabra dada
        String[] one= palabra.split("");
        //contador para el otro array
        int ii=0;
        //el array donde pondremos los valores volteados
        String[] two=new String[one.length];

        //For en el que volteamos los valores del array  de la palabra dada
        for (int cont =one.length-1;cont>=0;cont--){
            two[ii]=one[cont];
            ii++;
        }
        //una vez teniendo el otro array lo comparamos con el array de la palabra dada, si es igual es un
        //palindromo
        if(Arrays.equals(one, two)){
            return true;
        }
        else
        return false;
    }

    /**
     * Method problema2
     * @param arreglo
     * @param k
     * @return boolean
     */
    public static boolean problema2(int[] arreglo, int k){
         //El contador para verificar todos los números
         int i=0;
         //El contador para verificar un número con todos los que le siguen en el array
         int c=i+1;

        while(i<arreglo.length){
            //Revisamos que en la posición donde estemos sumado con sus sucesores den k
            while(c<arreglo.length){
                if(arreglo[i]+arreglo[c]!=k){
                System.out.println(arreglo[i]+" sumado con " +arreglo [c]+ " no te da k" );

                c++;
                }
                else {if(arreglo[i]+arreglo[c]==k){
                    System.out.println(arreglo[i]+" sumado con "+arreglo[c]+" te da"+ k);
                return true;
                }}
            }
                i++;
                c=i+1;
                }
                return false;
            }

    /**
     * Method problema3
     * @param arreglo
     */
    public static void problema3(int[] arreglo){
        //one es igual a el tamaño del arreglo paràmetro
        int one=arreglo.length-1;
        //El contador para verificar todos los números
        int i=0;
        //El contador para verificar un número con todos los que le siguen en el array
        int c=i+1;
        //arreglo con 8 elementos donde vamos ordenando
        int[] two= new int [one+1];

        while(i<arreglo.length){
            //Revisamos que en la posición donde estemos sea mayor que todos, es decir, nos aseguramos que
            //el primero sea el mayor para sus consequentes, que el segundo sea el mayor para sus consequentes
            //etc.
            while(c<arreglo.length){
                if(arreglo[i]>=arreglo[c]){
                System.out.println(arreglo[i]+" si es mayor o igual que " +arreglo [c]+"y mi c= "+c);
                c++;
                }
                else {
                System.out.println(arreglo[i]+" no es mayor que "+arreglo[c]+" entonces:");
                //Cambiamos de lugar el más grande
                two[one]=arreglo[c];
                two[one-1]=arreglo[i];
                arreglo[i]=two[one];
                arreglo[c]=two[one-1];
                System.out.println("Cambio de "+arreglo[c]+ " con "+ arreglo[i]);
                System.out.println("El arreglo queda como:");
                for (int ii=0;ii<arreglo.length;ii++){
                System.out.println(arreglo[ii]);
                }
                c=i+1;
                }
            }
            two[one]=arreglo[i];
            one--;
            i++;
            c=i+1;
        }
        //una vez acomodado el arreglo creado modificamos el que se nos da como parámetro
        for (int ii=0;ii<arreglo.length;ii++){
            arreglo[ii]=two[ii];
        }
        return;
    }

    /**
     * Method problema4
     * @param arreglo
     * @param buscando
     * @return boolean
     */
    public static boolean problema4(int[] arreglo, int buscando){
        int i=0;
        int ii=arreglo.length;

        //Iteración de divisiones hasta que i no sea menor
        while(i<ii){
            int mitad= (i+ii)/2;
           if(buscando==arreglo[mitad])//Ya lo encontramos c:
               return true;
            if(buscando>arreglo[mitad])// si es mayor redefinimos el array hacia la derecha
                i=mitad+1;
            else// si es menor redefinimos el array hacia la izquierda

                ii=mitad-1;
        }
        // si no esta el elemento pues regresa false
        return false;
    }

    /**
     * Method problema5
     * @param n
     * @return boolean
     */
    public static boolean problema5(int n){
        if(n==0 && n==1)
            return false;
            //sacamos los modulos de la division de n entre sus antecesores
            //si el modulo da 0 entonces no es primo
        for(int i=n-1;i>=2;i--){
            if(n%i==0)
            return false;
        }
        return true;
    }

    /**
     * Method problema 6
     * @param n
     * @return Int[]
     */
    public static int[] problema6(int n){
        //definimos un arreglo vacio si nos meten un valor menor o igual a 2
        int[] arr=new int[0];
        int primos=0;

        if(n<2)
        return arr;
        //buscamos cuantos primos hay para definir el isugiente array
        for(int ii =2;ii<n;ii++){
            if(problema5(ii))
            primos++;
        }
        System.out.println(primos);

        int z=0;
        //array con n primos
        int[] arrdos=new int[primos];
        //metemos los primos en el array ya definido
        for(int i=2;i<n;i++){
            if(problema5(i)==true){
                arrdos[z]=i;
                z++;
            }
        }
        return arrdos;
    }

    public static void main(String[] args) {
        String resultado = "";
        int[] desordenado = {9,8,7,6,5,4,3,2,1};
        int[] ordenado    = {1,2,3,4,5,6,7,8,9};
        int[] primos10 = {2,3,5,7};
        if(problema1("oso")==true && problema1("palabra")==false)resultado+="P1 bien\n";else resultado+="P1 mal\n";
        if(problema2(desordenado, 17)==true) resultado+="P2 bien\n";else resultado+="P2 mal\n";
        problema3(desordenado);
        if(Arrays.equals(desordenado,ordenado) == true)resultado+="P3 bien\n";else resultado+="P3 mal\n";
        if(problema4(desordenado,2)== true && problema4(desordenado,18)== false)resultado+="P4 bien\n";else resultado+="P4 mal\n";
        if(problema5(7)==true && problema5(6)==false)resultado+="P5 bien\n";else resultado+="P5 mal\n";
        if(Arrays.equals(problema6(10), primos10) == true)resultado+="P6 bien\n";else resultado+="P6 mal\n";
        System.out.println(resultado);
    }
}
