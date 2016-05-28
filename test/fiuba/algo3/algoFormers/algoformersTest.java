package fiuba.algo3.algoFormers;

import static org.junit.Assert.*;

import org.junit.Test;

<<<<<<< HEAD
import fiuba.algo3.algoformers.autobots.Bumblebee;
import fiuba.algo3.algoformers.autobots.Optimus;
import fiuba.algo3.algoformers.decepticons.Frenzy;
import fiuba.algo3.algoformers.modos.BumblebeeHumanoide;
import fiuba.algo3.algoformers.modos.FrenzyHumanoide;
=======
import fiuba.algo3.algoformers.autobots.Optimus;
>>>>>>> 039736376981d10109aa787f828d13f190bb7b05
import fiuba.algo3.algoformers.modos.OptimusAlterno;


public class algoformersTest {

	@Test
	public void test01CreoUnTransformerYcambioSuModo(){
		Optimus optimus = new Optimus();
		optimus.cambiarModo();
		assertEquals(optimus.verModo(),OptimusAlterno.getInstance());	
	}
	
	@Test
	public void test02CreoUnTransformerYEsHumanoide(){
		Frenzy frenzy = new Frenzy();
		assertEquals(frenzy.verModo(), FrenzyHumanoide.getInstance());
	}
	
	public void test03CambioModoMuchasVeces(){
		Bumblebee bumblebee = new Bumblebee();
		bumblebee.cambiarModo();
		bumblebee.cambiarModo();
		bumblebee.cambiarModo();
		bumblebee.cambiarModo();
		assertEquals(bumblebee.verModo(),BumblebeeHumanoide.getInstance());
	}
}
