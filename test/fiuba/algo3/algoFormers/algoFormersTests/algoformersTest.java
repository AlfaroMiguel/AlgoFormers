package fiuba.algo3.algoFormers.algoFormersTests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.autobots.Bumblebee;
import fiuba.algo3.algoFormers.autobots.Optimus;
import fiuba.algo3.algoFormers.autobots.Ratchet;
import fiuba.algo3.algoFormers.decepticons.Bonecrusher;
import fiuba.algo3.algoFormers.decepticons.Frenzy;
import fiuba.algo3.algoFormers.decepticons.Megatron;
import fiuba.algo3.algoFormers.excepciones.MismoEquipoException;
import fiuba.algo3.algoFormers.modos.BumblebeeHumanoide;
import fiuba.algo3.algoFormers.modos.FrenzyHumanoide;
import fiuba.algo3.algoFormers.modos.OptimusAlterno;



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
	public void test04AutobotAtacarAutobotMismoModoSinTenerEnCuentaDistancia(){
		Ratchet ratchet = new Ratchet();
		Optimus optimus = new Optimus();
		ratchet.atacar(optimus);
		ratchet.cambiarModo();
		optimus.cambiarModo();
		ratchet.atacar(optimus);
	}
	
	@Test (expected = MismoEquipoException.class)
	public void test05DecepticonAtacarDecepticonMismoModoSinTenerEnCuentaDistancia(){
		Megatron megatron = new Megatron();
		Bonecrusher bonecrusher = new Bonecrusher();
		bonecrusher.atacar(megatron);
		megatron.cambiarModo();
		bonecrusher.cambiarModo();
		bonecrusher.atacar(megatron);
	}
	
	@Test (expected = MismoEquipoException.class)
	public void test06AutobotAtacarAutobotDiferenteModoSinTenerEnCuentaDistancia(){
		Ratchet ratchet = new Ratchet();
		Optimus optimus = new Optimus();
		ratchet.atacar(optimus);
		ratchet.cambiarModo();
		ratchet.atacar(optimus);
		optimus.atacar(ratchet);
	}
	
	@Test (expected = MismoEquipoException.class)
	public void test07DecepticonAtacarDecepticonDiferenteModoSinTenerEnCuentaDistancia(){
		Megatron megatron = new Megatron();
		Bonecrusher bonecrusher = new Bonecrusher();
		bonecrusher.atacar(megatron);
		megatron.cambiarModo();
		bonecrusher.atacar(megatron);
		megatron.atacar(bonecrusher);
	}
	
	@Test
	public void test08AutobotAtacarDecepticonMismoModoSinTenerEnCuentaDistancia(){
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		optimus.atacar(megatron);
		assertEquals(megatron.verVida(), 500);
		optimus.cambiarModo();
		megatron.cambiarModo();
		optimus.atacar(megatron);
		assertEquals(megatron.verVida(),485);
	}
	
	@Test
	public void test09DecepticonAtacarAutobotMismoModoSinTenerEnCuentaDistancia(){
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		megatron.atacar(optimus);
		assertEquals(optimus.verVida(), 490);
		optimus.cambiarModo();
		megatron.cambiarModo();
		megatron.atacar(optimus);
		assertEquals(optimus.verVida(), 435);
	}
	
	@Test
	public void test10AutobotAtacarDecepticonDiferenteModoSinTenerEnCuentaDistancia(){
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		optimus.atacar(megatron);
		assertEquals(megatron.verVida(), 500);
		optimus.cambiarModo();
		optimus.atacar(megatron);
		assertEquals(megatron.verVida(),485);
	}
	
	@Test
	public void test11DecepticonAtacarAutobotDiferenteModoSinTenerEnCuentaDistancia(){
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		megatron.atacar(optimus);
		assertEquals(optimus.verVida(), 490);
		megatron.cambiarModo();
		megatron.atacar(optimus);
		assertEquals(optimus.verVida(), 435);
	}
	
}
