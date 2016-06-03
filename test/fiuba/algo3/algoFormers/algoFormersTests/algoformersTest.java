package fiuba.algo3.algoFormers.algoFormersTests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.Bumblebee;
import fiuba.algo3.algoFormers.autobots.Optimus;
import fiuba.algo3.algoFormers.autobots.Ratchet;
import fiuba.algo3.algoFormers.decepticons.Bonecrusher;
import fiuba.algo3.algoFormers.decepticons.Frenzy;
import fiuba.algo3.algoFormers.decepticons.Megatron;
import fiuba.algo3.algoFormers.excepciones.MismoEquipoException;
import fiuba.algo3.algoFormers.excepciones.OutOfRangeException;
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
	public void test04AutobotAtacarAutobotDistanciaCorrecta(){
		Ratchet ratchet = new Ratchet();
		Optimus optimus = new Optimus();
		Tablero tablero = new Tablero(10,10);
		Coordenada coordOptimus = new Coordenada(1,2);
		Coordenada coordRatchet = new Coordenada(1,3);
		tablero.colocarEnTablero(optimus,coordOptimus);
		tablero.colocarEnTablero(ratchet, coordRatchet);
		ratchet.atacar(tablero,optimus);
	}
	
	@Test (expected = OutOfRangeException.class)
	public void test05AutobotAtacarAutobotDistanciaIncorrecta(){
		Ratchet ratchet = new Ratchet();
		Optimus optimus = new Optimus();
		Tablero tablero = new Tablero(10,10);
		Coordenada coordOptimus = new Coordenada(1,2);
		Coordenada coordRatchet = new Coordenada(1,8);
		tablero.colocarEnTablero(optimus,coordOptimus);
		tablero.colocarEnTablero(ratchet, coordRatchet);
		ratchet.atacar(tablero,optimus);
	}
	
	@Test (expected = MismoEquipoException.class)
	public void test06AutobotAtacarAutobotDistanciaLimite(){
		Ratchet ratchet = new Ratchet();
		Optimus optimus = new Optimus();
		Tablero tablero = new Tablero(10,10);
		Coordenada coordOptimus = new Coordenada(1,2);
		Coordenada coordRatchet = new Coordenada(1,7);
		tablero.colocarEnTablero(optimus,coordOptimus);
		tablero.colocarEnTablero(ratchet, coordRatchet);
		ratchet.atacar(tablero,optimus);
	}
	
	@Test (expected = MismoEquipoException.class)
	public void test07DecepticonAtacarDecepticonDistanciaCorrecta(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		Bonecrusher bonecrusher = new Bonecrusher();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordBonecrusher = new Coordenada(1,4);
		tablero.colocarEnTablero(megatron,coordMegatron);
		tablero.colocarEnTablero(bonecrusher, coordBonecrusher);
		bonecrusher.atacar(tablero, megatron);
	}
	
	@Test (expected = OutOfRangeException.class)
	public void test08DecepticonAtacarDecepticonDistanciaIncorrecta(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		Bonecrusher bonecrusher = new Bonecrusher();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordBonecrusher = new Coordenada(1,7);
		tablero.colocarEnTablero(megatron,coordMegatron);
		tablero.colocarEnTablero(bonecrusher, coordBonecrusher);
		bonecrusher.atacar(tablero, megatron);
	}
	
	@Test (expected = MismoEquipoException.class)
	public void test09DecepticonAtacarDecepticonDistanciaLimite(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		Bonecrusher bonecrusher = new Bonecrusher();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordBonecrusher = new Coordenada(1,5);
		tablero.colocarEnTablero(megatron,coordMegatron);
		tablero.colocarEnTablero(bonecrusher, coordBonecrusher);
		bonecrusher.atacar(tablero, megatron);
	}

	
	@Test
	public void test10AutobotAtacarDecepticonDistanciaCorrecta(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordOptimus = new Coordenada(1,3);
		tablero.colocarEnTablero(megatron,coordMegatron);
		tablero.colocarEnTablero(optimus, coordOptimus);
		optimus.atacar(tablero,megatron);
		assertEquals(megatron.verVida(), 500);
		optimus.cambiarModo();
		megatron.cambiarModo();
		optimus.atacar(tablero,megatron);
		assertEquals(megatron.verVida(),485);
	}
	
	@Test (expected = OutOfRangeException.class)
	public void test11AutobotAtacarDecepticonDistanciaIncorrecta(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordOptimus = new Coordenada(1,7);
		tablero.colocarEnTablero(megatron,coordMegatron);
		tablero.colocarEnTablero(optimus, coordOptimus);
		optimus.atacar(tablero,megatron);
	}
	
	@Test
	public void test12AutobotAtacarDecepticonDistanciaLimite(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordOptimus = new Coordenada(1,4);
		tablero.colocarEnTablero(megatron,coordMegatron);
		tablero.colocarEnTablero(optimus, coordOptimus);
		optimus.atacar(tablero,megatron);
		assertEquals(megatron.verVida(), 500);
	}
	
	@Test
	public void test13DecepticonAtacarAutobotDistanciaCorrecta(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordOptimus = new Coordenada(1,3);
		tablero.colocarEnTablero(megatron,coordMegatron);
		tablero.colocarEnTablero(optimus, coordOptimus);
		megatron.atacar(tablero, optimus);
		assertEquals(optimus.verVida(), 490);
		optimus.cambiarModo();
		megatron.cambiarModo();
		megatron.atacar(tablero, optimus);
		assertEquals(optimus.verVida(), 435);
	}
	
	@Test (expected = OutOfRangeException.class)
	public void test14DecepticonAtacarAutobotDistanciaIncorrecta(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordOptimus = new Coordenada(1,7);
		tablero.colocarEnTablero(megatron,coordMegatron);
		tablero.colocarEnTablero(optimus, coordOptimus);
		megatron.atacar(tablero, optimus);
	}
	
	@Test
	public void test14DecepticonAtacarAutobotDistanciaLimite(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordOptimus = new Coordenada(1,5);
		tablero.colocarEnTablero(megatron,coordMegatron);
		tablero.colocarEnTablero(optimus, coordOptimus);
		megatron.atacar(tablero, optimus);
		assertEquals(optimus.verVida(), 490);
	}
	
	
	
}
