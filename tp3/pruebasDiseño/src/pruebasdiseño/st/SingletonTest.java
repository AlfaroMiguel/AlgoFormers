package pruebasdiseño.st;

import static org.junit.Assert.*;

import org.junit.Test;

public class SingletonTest {

	@Test
	public void test() {
		Singleton singleton = Singleton.getInstance();
		singleton.setName("pepe");
		assertEquals(singleton.getName(), "pepe");		
	}

}
