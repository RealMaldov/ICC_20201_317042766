package shapesSVG;

/**
 * @author Alejandro Maldonado Vázquez
 * Class Vector2
 */

public class Vector2 {

	private double x;
	private double y;
	private double magnitude;
	
/**
 * Constructor Vector2
 * @param x
 * @param y
 */
	public Vector2(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
/**
 * Constructor Vector2
 */
	public Vector2() {
		this.x=0.0;
		this.y=0.0;
	}
	
/**
 * Getter getX
 * @return this.x
 */
	public double getX () {
		return this.x;
	}
	
/**
 * Getter getY
 * @return this.y
 */
	public double getY () {
		return this.y;
	}
	
/**
 * Method distance
 * @param z
 * @return Math.sqrt(newX+newY);
 */
	public double distance (Vector2 z) {
		double newX = Math.pow((this.x-z.x),2);
		double newY = Math.pow((this.y-z.y),2);
		return Math.sqrt(newX+newY);
	}
	
/**
 * Method toSVG
 * @return String with html code
 */
	public String toSVG() {
	return "<circle cx='"+this.x+"' cy='"+this.y+"' r='"+"3.0"+"'/>";
	}
	
/**
 * Method toString
 *  @return String with vector specifications
 */
	public String toString() {
		return "("+String.valueOf(this.x)+","+String.valueOf(this.y)+")";
	}
	
/**
 * Method equals
 * @param v2
 * @return boolean of a comparison between shapes
 */
	public boolean equals(Vector2 v2) {
		return this.x==v2.getX() && this.y==v2.getY();
	}
}