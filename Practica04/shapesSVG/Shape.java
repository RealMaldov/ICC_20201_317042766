/**
 * @author Maldonado Vázquez Alejandro
 **/


public abstract class Shape implements Comparable<Shape> {

    protected double area;
    protected double perimeter;


    public Shape() {
    }


    abstract public double area();

    abstract public double Perimeter();

    abstract public String toSVG();

     /**
     * Getter getArea
     * @return this.area
     */
    public double getArea() {
        return this.area;
    }

    /**
     * Getter getPerimeter
     * 
     * @return this.perimeter
     */
    public double getPerimeter() {
        return this.perimeter;
    }

    /**
     * Special method equls
     **/
    @Override
    public boolean equals(Object o) {
        if (!(obj instanceof Shape))
        return false;
        Shape f = (Shape) o;
        return (f.calculaArea() == this.area) && (f.calculaPerimetro() == this.perimeter);
    }

    /**
     * Special method toString
     **/
    @Override
    public String toString() {
        return "The perimeter is: " + this.perimetro + ", and the area: " + this.area;
    }

}