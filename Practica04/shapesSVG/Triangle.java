/**
 * 
 */
package shapesSVG;

/**
 * @author A.Maldov
 *
 */
public class Triangle extends Shape implements Transform{
	private Vector2 v1;
	private Vector2 v2;
	private Vector2 v3;
	private double perimeter;
	private double area;
	
/**
 * Constructor Triangle
 * @param v1
 * @param v2
 * @param v3
 */
	public Triangle(Vector2 v1, Vector2 v2, Vector2 v3) {
		this.v1=v1;
		this.v2=v2;
		this.v3=v3;
	}

/**
 * Constructor Triangle
 * @param x1
 * @param y1
 * @param x2
 * @param y2
 * @param x3
 * @param y3
 */
	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
		this.v1=new Vector2(x1,y1);
		this.v2=new Vector2(x2,y2);
		this.v3=new Vector2(x3,y3);	
	}
	
/**
 * Constructor Triangle
 */
	public Triangle() {
		this.v1=new Vector2();
		this.v2= new Vector2();
		this.v3= new Vector2();
	}
	
/**
 * Getter getV1
 * @return Vector2 v1
 */
	public Vector2 getV1() {
		return this.v1;
	}
	
	/**
	 * Getter getV2
	 * @return Vector2 v2
	 */
	public Vector2 getV2() {
		return this.v2;
	}

	/**
	 * Getter getV3
	 * @return Vector2 v3
	 */
	public Vector2 getV3() {
		return this.v3;
	}
/**
 * Method toSVG
 * @return String with html code
 */
	public String toSVG () {
		return "<polygon points=\""+this.v1.getX()+","+this.v1.getY()+","+this.v2.getX()+","+this.v2.getY()+","+this.v3.getX()+","+this.v3.getY()+"\" style=\"fill:lime;stroke:purple;stroke-width:5\" />";
	}
	
/**
 * Method toString
 * @return String with shapes Specifications
 */
	public String toString() {
		return "Polygon in"+v1+v2+v3; 
	}

/**
 * Method equals
 * @param t
 * @return boolean of a comparison between shapes
 */
	public boolean equals(Triangle t) {
		return this.v1.equals(t.getV1()) && this.v2.equals(t.getV2())&& this.v3.equals(t.getV3());
	}
	
/**
 * Method area
 * @return this.area
 */
	public double area() {
		this.area=(this.v1.magnitude(v2)*(this.v1.middlePoint(v2).magnitude(v3)))/2;
		return this.area;
	}
	
/**
 * Method perimeter 
 * @return this.perimeter
 */
	  public double perimeter(){    
		this.perimeter=this.v1.magnitude(v2)+this.v2.magnitude(v3)+this.v3.magnitude(v1);
		return this.perimeter;  
	  }

	  public void transform(Transform x){
        this.v1 = x.transform(this.v1);
        this.v2 = x.transform(this.v2);
        this.v3 = x.transform(this.v3);
  }
}
