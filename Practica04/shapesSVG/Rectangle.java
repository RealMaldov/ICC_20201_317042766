/**
 * 
 */
package shapesSVG;

/**
 * @author Alejandro Maldonado Vázquez
 *
 */
public class Rectangle {
	
	private Vector2 v1;
	private double width;
	private double height;
	private double area;
	private double perimeter;
	
/**
 * Constructor Rectangle
 * @param v1
 * @param width
 * @param height
 */
	public Rectangle (Vector2 v1, double width, double height) {
		this.v1=v1;
		this.width=width;
		this.height=height;
	}
	
/**
 * Conctructor Rectangle
 * @param x
 * @param y
 * @param width
 * @param height
 */
	public Rectangle (double x, double y, double width,double height) {
		this.v1=new Vector2(x,y);
		this.width=width;
		this.height=height;
	}
	
/**
 * Constructor Rectangle
 */
	public Rectangle () {
		this.v1=new Vector2();
		this.width=0.0;
		this.height=0.0;
	}
 
/**
 * Getter getWidth
 * @return double width
 */
	public double getWidth() {
		return this.width;
	}
	
/**
 * Getter getHeight
 * @return double height
 */
	public double getHeight() {
		return this.height;
	}
	
/**
 * Getter getV1
 * @return Vector2 v1
 */
	public Vector2 getV1() {
		return this.v1;
	}
/**
 * Method toSVG
 * @return String with html code
 */
	public String toSVG () {
		return "<rect x='"+this.v1.getX()+"' y='"+this.v1.getY()+"' width='"+this.width+"' height='"+this.height+"'/>";
	}
	
/**
 * Method toString
 * @return String with shapes specifications
 */
	public String toString() {
		return width+" times "+height+" in "+v1;
	}
	
/**
 * Method equals
 * @param r
 * @return boolean of a comparison between shapes
 */
	public boolean equals(Rectangle r) {
		return this.v1.equals(r.getV1())&& this.height==r.getHeight()&& this.width==r.getWidth();
	}
}
