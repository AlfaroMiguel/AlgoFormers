package pruebasdiseño.af;

public class ColorFactory extends AbstractFactory {

	@Override
	Color getColor(String color) {
		if (color == null){
			return null;
		}
		if (color.equalsIgnoreCase("red")){
			return new Red();
		}
		if (color.equalsIgnoreCase("blue")){
			return new Blue();
		}
		if (color.equalsIgnoreCase("green")){
			return new Green();
		}
		return null;
	}

	@Override
	Shape getShape(String shape) {
		return null;
	}

}
