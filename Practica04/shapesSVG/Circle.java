/**
 * 
 */
package shapesSVG;

/**
 * @author Alejandro Maldonado Vázquez 
 * Class Circle
 */
public class Circle {

	private Vector2 center;
	private double radius;
	private double perimeter;
	private double area;
	
/**
 * Constructor Circle
 * @param center
 * @param radius
 */
	public Circle (Vector2 center, double radius) {
		this.center=center;
		this.radius=radius;
	}
	
/**
 * Constructor Circle
 * @param x
 * @param y
 * @param radius
 */
	public Circle(double x, double y, double radius) {
		this.center= new Vector2(x,y);
		this.radius=radius;
	}
	
/**
 * Constructor Circle
 */
	public Circle() {
		this.center=new Vector2();
		this.radius=0;
	}
	
/**
 * Getter getCenter
 * @return Vector2 center
 */
	public Vector2 getCenter() {
		return this.center;
	}
	
/**
 * Getter getRadius
 * @return double radius
 */
	public double getRadius() {
		return this.radius;
	}
/**
 * Method toSVG
 * @return String with html code
 */
	public String toSVG() {
		return "<circle cx='"+this.center.getX()+"' cy='"+this.center.getY()+"' r='"+this.radius+"'/>";
	}
	
/**
 * Method toString
 * @return String with shape specifications
 */
	public String toString() {
		return "Circle in "+center+"and Radius= "+radius; 
	}
	
/**
 * Method equals
 * @param c
 * @return boolean of a comparison between shapes
 */
	public boolean equals(Circle c) {
		return this.center.equals(c.getCenter()) && this.radius==c.getRadius();
	}
	
/**
 * Method area
 * @return this.area
 */
	public double area(){
	    this.area=Math.pow(Math.PI*this.radius,2);
	    return this.area;
	  }
	  
/**
 * Method perimeter
 * @return this.perimeter
 */
	  public double perimeter(){
	    this.perimeter=2*this.radius*Math.PI;
	    return this.perimeter;
	  }
}
