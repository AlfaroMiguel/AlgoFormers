package pruebasdiseño.st;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultitonTest {

	@Test
	public void test() {
		Multiton multiton1 = Multiton.getInstance("uno");
		multiton1.setName("pepe");
		Multiton multiton2 = Multiton.getInstance("dos");
		multiton2.setName("popo");
		assertEquals(multiton1.getName(), "pepe");
		assertEquals(multiton2.getName(), "popo");
	}

}
