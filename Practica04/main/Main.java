/**
 *
 */
 import shapesSVG.Circle;
 import shapesSVG.Line;
 import shapesSVG.Rectangle;
 import shapesSVG.Triangle;
 import shapesSVG.Vector2;

/**
 * @author Alejandro Maldonado V�zquez
 * Main Class
 */
public class Main {
	public static void main(String[] args) {
		String start= "<svg heigth='700' width='700'>";
		String close="</svg>";
//Instance of shapes
	Vector2 zero= new Vector2(300.0,100.0);
	Vector2 zeroTwo= new Vector2(100.0,100.0);
	Vector2 one = new Vector2(500.0, 100.0);
	Line two= new Line(new Vector2(),zeroTwo);
	Rectangle three=new Rectangle(100.0,0.0,100,100);
	Triangle four= new Triangle(250,0.0,200.0,150.0,300.0,150.0);
	Circle five= new Circle(zero,20);
//The shapes to SVG in html
	System.out.println(start);
	System.out.println(one.toSVG());
	System.out.println(two.toSVG());
	System.out.println(three.toSVG());
	System.out.println(four.toSVG());
	System.out.println(five.toSVG());
	System.out.println(close);
	}
}
