package pruebasdiseño.fc;

import pruebasdiseño.af.Circle;
import pruebasdiseño.af.Rectangle;
import pruebasdiseño.af.Shape;
import pruebasdiseño.af.Square;

public class ShapeMaker {
	
	private Shape rectangle;
	private Shape square;
	private Shape circle;
	
	public ShapeMaker(){
		circle = new Circle();
		rectangle = new Rectangle();
		square = new Square();
	}
	
	public void drawCircle(){
		circle.draw();
	}
	public void drawRectangle(){
		rectangle.draw();
	}
	public void drawSquare(){
		square.draw();
	}
}
