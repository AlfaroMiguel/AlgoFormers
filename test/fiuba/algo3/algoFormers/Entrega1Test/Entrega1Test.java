package fiuba.algo3.algoFormers.Entrega1Test;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.Juego.Juego;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.Optimus;
import fiuba.algo3.algoFormers.autobots.Ratchet;
import fiuba.algo3.algoFormers.decepticons.Bonecrusher;
import fiuba.algo3.algoFormers.decepticons.Megatron;
import fiuba.algo3.algoFormers.excepciones.MismoEquipoException;
import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.excepciones.OutOfRangeException;
import fiuba.algo3.algoFormers.modos.OptimusAlterno;
import fiuba.algo3.algoFormers.modos.OptimusHumanoide;

public class Entrega1Test {

	@Test
	public void test01UbicarHumanoideYMoverADireccionValida(){
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenadaInic = new Coordenada(3,4);
		Optimus optimus = new Optimus();
		tablero.put(optimus,coordenadaInic);
		Coordenada coordenadaFinal = new Coordenada(3,7);
		int paso = 3;
		tablero.mover(optimus,coordenadaFinal,paso);
		assertTrue(tablero.estaVacio(coordenadaInic));
		assertEquals(tablero.ver(coordenadaFinal), optimus);
	}
	
	@Test (expected = MovimientoInvalidoException.class)
	public void test02UbicarHumanoideYMoverADireccionInvalida(){
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenadaInic = new Coordenada(3,4);
		Optimus optimus = new Optimus();
		tablero.put(optimus,coordenadaInic);
		Coordenada coordenadaFinal = new Coordenada(3,9);
		int paso = 3;
		tablero.mover(optimus,coordenadaFinal,paso);
	}
	
	
	@Test
	public void test03UbicarHumanoideYTransformarEnAmbasDirecciones(){
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenadaInic = new Coordenada(3,4);
		Optimus optimus = new Optimus();
		OptimusAlterno optimusAlterno = OptimusAlterno.getInstance();
		OptimusHumanoide optimusHumanoide = OptimusHumanoide.getInstance();
		tablero.put(optimus,coordenadaInic);
		assertEquals(optimus.verModo(), optimusHumanoide);
		optimus.cambiarModo();
		assertEquals(optimus.verModo(), optimusAlterno);
		optimus.cambiarModo();
		assertEquals(optimus.verModo(), optimusHumanoide);
	}
	
	@Test
	public void test04UbicarAlternoYMoverAPosicionValida(){
		Optimus optimus = new Optimus();
		optimus.cambiarModo();
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenadaInic = new Coordenada(3,4);
		tablero.put(optimus,coordenadaInic);
		Coordenada coordenadaFinal = new Coordenada(3,9);
		int paso = 5;
		tablero.mover(optimus,coordenadaFinal,paso);
		assertTrue(tablero.estaVacio(coordenadaInic));
		assertEquals(tablero.ver(coordenadaFinal), optimus);
	}
	
	@Test (expected = MovimientoInvalidoException.class)
	public void test05UbicarAlternoYMoverAPosicionInvalida(){
		Optimus optimus = new Optimus();
		optimus.cambiarModo();
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenadaInic = new Coordenada(3,2);
		tablero.put(optimus,coordenadaInic);
		Coordenada coordenadaFinal = new Coordenada(3,9);
		int paso = 5;
		tablero.mover(optimus,coordenadaFinal,paso);
	}
	
	@Test
	public void test06PruebIntegracion(){
		Juego juego = new Juego();
		assertTrue(juego.seUbicoALosPersonajes());
		Boolean encontroLaChispa = false;
		for(int i=9;i<12;i++){
			for(int j=9;j<12;j++){
				if(juego.estaLaChispa(i,j)){
					encontroLaChispa = true;
				}
			}
		}
		assertTrue(encontroLaChispa);
	}
	
	@Test (expected = MismoEquipoException.class)
	public void test07AutobotAtacarAutobotDistanciaCorrecta(){
		Ratchet ratchet = new Ratchet();
		Optimus optimus = new Optimus();
		Tablero tablero = new Tablero(10,10);
		Coordenada coordOptimus = new Coordenada(1,2);
		Coordenada coordRatchet = new Coordenada(1,3);
		tablero.put(optimus,coordOptimus);
		tablero.put(ratchet, coordRatchet);
		ratchet.atacar(tablero,optimus);
	}
	
	@Test (expected = OutOfRangeException.class)
	public void test08AutobotAtacarAutobotDistanciaIncorrecta(){
		Ratchet ratchet = new Ratchet();
		Optimus optimus = new Optimus();
		Tablero tablero = new Tablero(10,10);
		Coordenada coordOptimus = new Coordenada(1,2);
		Coordenada coordRatchet = new Coordenada(1,10);
		tablero.put(optimus,coordOptimus);
		tablero.put(ratchet, coordRatchet);
		ratchet.atacar(tablero,optimus);
	}
	
	@Test (expected = MismoEquipoException.class)
	public void test09AutobotAtacarAutobotDistanciaLimite(){
		Ratchet ratchet = new Ratchet();
		Optimus optimus = new Optimus();
		Tablero tablero = new Tablero(10,10);
		Coordenada coordOptimus = new Coordenada(1,2);
		Coordenada coordRatchet = new Coordenada(1,7);
		tablero.put(optimus,coordOptimus);
		tablero.put(ratchet, coordRatchet);
		ratchet.atacar(tablero,optimus);
	}
	
	@Test (expected = MismoEquipoException.class)
	public void test10DecepticonAtacarDecepticonDistanciaCorrecta(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		Bonecrusher bonecrusher = new Bonecrusher();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordBonecrusher = new Coordenada(1,4);
		tablero.put(megatron,coordMegatron);
		tablero.put(bonecrusher, coordBonecrusher);
		bonecrusher.atacar(tablero, megatron);
	}
	
	@Test (expected = OutOfRangeException.class)
	public void test11DecepticonAtacarDecepticonDistanciaIncorrecta(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		Bonecrusher bonecrusher = new Bonecrusher();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordBonecrusher = new Coordenada(1,7);
		tablero.put(megatron,coordMegatron);
		tablero.put(bonecrusher, coordBonecrusher);
		bonecrusher.atacar(tablero, megatron);
	}
	
	@Test (expected = MismoEquipoException.class)
	public void test12DecepticonAtacarDecepticonDistanciaLimite(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		Bonecrusher bonecrusher = new Bonecrusher();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordBonecrusher = new Coordenada(1,5);
		tablero.put(megatron,coordMegatron);
		tablero.put(bonecrusher, coordBonecrusher);
		bonecrusher.atacar(tablero, megatron);
	}

	
	@Test
	public void test13AutobotAtacarDecepticonDistanciaCorrecta(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordOptimus = new Coordenada(1,3);
		tablero.put(megatron,coordMegatron);
		tablero.put(optimus, coordOptimus);
		optimus.atacar(tablero,megatron);
		assertEquals(megatron.verVida(), 500);
		optimus.cambiarModo();
		megatron.cambiarModo();
		optimus.atacar(tablero,megatron);
		assertEquals(megatron.verVida(),485);
	}
	
	@Test (expected = OutOfRangeException.class)
	public void test14AutobotAtacarDecepticonDistanciaIncorrecta(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordOptimus = new Coordenada(1,7);
		tablero.put(megatron,coordMegatron);
		tablero.put(optimus, coordOptimus);
		optimus.atacar(tablero,megatron);
	}
	
	@Test
	public void test15AutobotAtacarDecepticonDistanciaLimite(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordOptimus = new Coordenada(1,4);
		tablero.put(megatron,coordMegatron);
		tablero.put(optimus, coordOptimus);
		optimus.atacar(tablero,megatron);
		assertEquals(megatron.verVida(), 500);
	}
	
	@Test
	public void test16DecepticonAtacarAutobotDistanciaCorrecta(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordOptimus = new Coordenada(1,3);
		tablero.put(megatron,coordMegatron);
		tablero.put(optimus, coordOptimus);
		megatron.atacar(tablero, optimus);
		assertEquals(optimus.verVida(), 490);
		optimus.cambiarModo();
		megatron.cambiarModo();
		megatron.atacar(tablero, optimus);
		assertEquals(optimus.verVida(), 435);
	}
	
	@Test (expected = OutOfRangeException.class)
	public void test17DecepticonAtacarAutobotDistanciaIncorrecta(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordOptimus = new Coordenada(1,7);
		tablero.put(megatron,coordMegatron);
		tablero.put(optimus, coordOptimus);
		megatron.atacar(tablero, optimus);
	}
	
	@Test
	public void test18DecepticonAtacarAutobotDistanciaLimite(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordOptimus = new Coordenada(1,5);
		tablero.put(megatron,coordMegatron);
		tablero.put(optimus, coordOptimus);
		megatron.atacar(tablero, optimus);
		assertEquals(optimus.verVida(), 490);
	}
	
}
