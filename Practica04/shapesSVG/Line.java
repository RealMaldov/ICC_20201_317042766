/**
 * 
 */
package shapesSVG;

/**
 * @author Alejandro Maldonado Vázquez
 * Class Line
 */
public class Line {

	private Vector2 v1;
	private Vector2 v2;
	private double length;
	
/**
 *  COnstructor Line
 * @param v1
 * @param v2
 */
	public Line (Vector2 v1, Vector2 v2) {
		this.v1=v1;
		this.v2=v2;
	}
	
/**
 * Constructor Line
 */
	public Line (){
		this.v1=new Vector2();
		this.v2= new Vector2();	
	}
	
/**
 * Getter getV1
 * @return Vector2 v1
 */
	public Vector2 getV1 () {
		return this.v1;
	}
	
/**
 * getter getV2
 * @return Vector2 V2
 */
	public Vector2 getV2() {
		return this.v2;
	}

/**
 * Method toSVG
 * @return String with html code
 */
	public String toSVG() {
		return "<line x1='"+this.v1.getX()+"' y1='"+this.v1.getY()+"' x2='"+this.v2.getX()+"' y2='"+this.v2.getY()+"' style=\"stroke:pink;stroke-width:8 \"/>";
	}
	
/**
 * Method toString
 *  @return String with Line specifications
 */
	public String toString() {
		return v1+" to "+v2;
	}
	
/**
 * Method equals
 * @param l
 * @return boolean of a comparison between shapes
 */
	public boolean equals(Line l) {
		return v1.equals(l.getV1()) && v2.equals(l.getV2());
	}
	
/**
 * Method length
 * @param v2
 * @return this.length
 */
	public double length (Vector2 v2) {
		this.length=this.v1.magnitude(v2);
		return this.length;
	}
}
