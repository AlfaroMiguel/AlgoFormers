package fiuba.algo3.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoformers.autobots.Optimus;
import fiuba.algo3.algoformers.modos.OptimusAlterno;


public class algoformersTest {

	@Test
	public void test01CreoUnTransformerYcambioSuModo(){
		Optimus optimus = new Optimus();
		optimus.cambiarModo();
		assertEquals(optimus.verModo(),OptimusAlterno.getInstance());	
	}
	

}
