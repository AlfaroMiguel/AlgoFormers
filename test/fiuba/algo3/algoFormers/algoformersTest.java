package fiuba.algo3.algoFormers;

import static org.junit.Assert.*;

import org.junit.Test;

<<<<<<< HEAD
import fiuba.algo3.algoFormers.autobots.Bumblebee;
import fiuba.algo3.algoFormers.autobots.Optimus;
import fiuba.algo3.algoFormers.autobots.Ratchet;
import fiuba.algo3.algoFormers.decepticons.Frenzy;
import fiuba.algo3.algoFormers.excepciones.MismoEquipoException;
import fiuba.algo3.algoFormers.modos.BumblebeeHumanoide;
import fiuba.algo3.algoFormers.modos.FrenzyHumanoide;
import fiuba.algo3.algoFormers.modos.OptimusAlterno;
=======

import fiuba.algo3.algoformers.autobots.Bumblebee;
import fiuba.algo3.algoformers.autobots.Optimus;
import fiuba.algo3.algoformers.autobots.Ratchet;
import fiuba.algo3.algoformers.decepticons.Frenzy;
import fiuba.algo3.algoformers.excepciones.MismoEquipoException;
import fiuba.algo3.algoformers.modos.BumblebeeHumanoide;
import fiuba.algo3.algoformers.modos.FrenzyHumanoide;
import fiuba.algo3.algoformers.modos.OptimusAlterno;
>>>>>>> e17ac6ff1cefb9836f4796f24c8960777c842b31


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
	
	@Test
	public void test03CambioModoMuchasVeces(){
		Bumblebee bumblebee = new Bumblebee();
		bumblebee.cambiarModo();
		bumblebee.cambiarModo();
		bumblebee.cambiarModo();
		bumblebee.cambiarModo();
		assertEquals(bumblebee.verModo(),BumblebeeHumanoide.getInstance());
	}
	
	@Test (expected = MismoEquipoException.class)
	public void test04AtacarAlMismoEquipoSinTenerEnCuentaDistancia(){
		Ratchet ratchet = new Ratchet();
		Optimus optimus = new Optimus();
		ratchet.atacar(optimus);
	}
}
