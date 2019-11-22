package shapesSVG;

/**
 * @author Alejandro Maldonado V�zquez
 * Class Vector2
 */

public class Vector2 extends Shape{

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
 * Method magnitude
 * @param z
 * @return this.magnitude
 */
	public double magnitude (Vector2 z) {
		double newX = Math.pow((this.x-z.x),2);
		double newY = Math.pow((this.y-z.y),2);
		this.magnitude=Math.sqrt(newX+newY);
		return this.magnitude;
	}
	
/**
 * Method middlePoint 	
 * @param v2
 * @return new Vector2(newX,newY);
 */
	public Vector2 middlePoint(Vector2 v2){
		  double newX= (this.x-v2.getX())/2;
		  double newY= (this.y-v2.getY())/2;
		   return new Vector2(newX,newY);
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