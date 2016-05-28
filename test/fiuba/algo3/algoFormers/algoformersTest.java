package fiuba.algo3.algoFormers;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

//import fiuba.algo3.algoformers.Alterno;
//import fiuba.algo3.algoformers.Modo;
import fiuba.algo3.*;
import fiuba.algo3.algoformers.autobots.Autobot;
import fiuba.algo3.algoformers.autobots.Optimus;
import fiuba.algo3.algoformers.decepticons.Decepticon;
import fiuba.algo3.algoformers.modos.OptimusHumanoide;

public class algoformersTest {

	@Test
	public void test01CreoUnTransformerYcambioSuModo(){
		Optimus optimus = new Optimus();
		optimus.cambiarModo();
		Assert.assertTrue(optimus.verModo()==OptimusHumanoide.getInstance());
		
	}
	

}
