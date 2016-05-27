package pruebasdiseño.af;

import static org.junit.Assert.*;

import org.junit.Test;

public class AbstractFactoryTest {

	@Test
	public void test() {
		AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
		Shape circle = shapeFactory.getShape("circle");
		circle.draw();
		
	}

}
