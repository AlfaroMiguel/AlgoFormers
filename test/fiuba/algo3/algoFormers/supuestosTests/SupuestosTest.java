package fiuba.algo3.algoFormers.supuestosTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import fiuba.algo3.algoFormers.autobots.Bumblebee;
import fiuba.algo3.algoFormers.autobots.Optimus;
import fiuba.algo3.algoFormers.autobots.Ratchet;
import fiuba.algo3.algoFormers.autobots.Superion;
import fiuba.algo3.algoFormers.decepticons.Bonecrusher;
import fiuba.algo3.algoFormers.decepticons.Frenzy;
import fiuba.algo3.algoFormers.decepticons.Megatron;
import fiuba.algo3.algoFormers.decepticons.Menasor;
import fiuba.algo3.algoFormers.excepciones.NoCombinableException;
import fiuba.algo3.algoFormers.habitables.BurbujaInmaculada;
import fiuba.algo3.algoFormers.habitables.DobleCanion;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;

public class SupuestosTest {
	
	//distancia de combinacion
	@Test
	public void test01CombinarAutobotsDistanciaCorrecta(){
		Tablero tablero = new Tablero(100,100);
		
		Optimus optimus = new Optimus();
		Ratchet ratchet = new Ratchet();
		Bumblebee bumblebee = new Bumblebee();
		
		Coordenada coordOptimus = new Coordenada(4,4);
		Coordenada coordRatchet = new Coordenada(5,4);
		Coordenada coordBumblebee = new Coordenada(4,5);
		
		tablero.colocarEnTablero(optimus, coordOptimus);
		tablero.colocarEnTablero(ratchet, coordRatchet);
		tablero.colocarEnTablero(bumblebee, coordBumblebee);
		
		Superion superion = new Superion(optimus,ratchet,bumblebee);
		
		tablero.combinarAlgoformers(superion, optimus, ratchet, bumblebee, 1);
		
		assertSame(tablero.obtenerAccionableEnCoordenada(coordOptimus),superion);
	}
	
	@Test (expected = NoCombinableException.class)
	public void test02CombinarAutobotsDistanciaIncorrecta(){
		Tablero tablero = new Tablero(100,100);
		
		Optimus optimus = new Optimus();
		Ratchet ratchet = new Ratchet();
		Bumblebee bumblebee = new Bumblebee();
		
		Coordenada coordOptimus = new Coordenada(4,7);
		Coordenada coordRatchet = new Coordenada(5,4);
		Coordenada coordBumblebee = new Coordenada(4,5);
		
		tablero.colocarEnTablero(optimus, coordOptimus);
		tablero.colocarEnTablero(ratchet, coordRatchet);
		tablero.colocarEnTablero(bumblebee, coordBumblebee);
		
		Superion superion = new Superion(optimus,ratchet,bumblebee);
		
		tablero.combinarAlgoformers(superion, optimus, ratchet, bumblebee, 1);
		
	}
	
	@Test
	public void test03CombinarDecepticonsDistanciaCorrecta(){
		Tablero tablero = new Tablero(100,100);
		
		Megatron megatron = new Megatron();
		Frenzy frenzy = new Frenzy();
		Bonecrusher bonecrusher = new Bonecrusher();
		
		Coordenada coordMegatron = new Coordenada(4,4);
		Coordenada coordFrenzy = new Coordenada(5,4);
		Coordenada coordBonecrusher = new Coordenada(4,5);
		
		tablero.colocarEnTablero(megatron, coordMegatron);
		tablero.colocarEnTablero(frenzy, coordFrenzy);
		tablero.colocarEnTablero(bonecrusher, coordBonecrusher);
		
		Menasor menasor = new Menasor(megatron,bonecrusher,frenzy);
		
		tablero.combinarAlgoformers(menasor, megatron, bonecrusher, frenzy, 1);
		
		assertSame(tablero.obtenerAccionableEnCoordenada(coordMegatron), menasor);
	}
	
	@Test (expected = NoCombinableException.class)
	public void test04CombinarDecepticonsDistanciaIncorrecta(){
		Tablero tablero = new Tablero(100,100);
		
		Megatron megatron = new Megatron();
		Frenzy frenzy = new Frenzy();
		Bonecrusher bonecrusher = new Bonecrusher();
		
		Coordenada coordMegatron = new Coordenada(4,7);
		Coordenada coordFrenzy = new Coordenada(5,4);
		Coordenada coordBonecrusher = new Coordenada(4,5);
		
		tablero.colocarEnTablero(megatron, coordMegatron);
		tablero.colocarEnTablero(frenzy, coordFrenzy);
		tablero.colocarEnTablero(bonecrusher, coordBonecrusher);
		
		Menasor menasor = new Menasor(megatron,bonecrusher,frenzy);
		
		tablero.combinarAlgoformers(menasor, megatron, bonecrusher, frenzy, 1);
		
	}
	//combinar/descombinar colocando algoformers en posiciones correctas
	@Test
	public void test05CombinarYDescombinarAutobotsConTableroVacioCorrectamente(){
		Tablero tablero = new Tablero(100,100);
		
		Optimus optimus = new Optimus();
		Ratchet ratchet = new Ratchet();
		Bumblebee bumblebee = new Bumblebee();
		
		Coordenada coordOptimus = new Coordenada(4,4);
		Coordenada coordRatchet = new Coordenada(3,5);
		Coordenada coordBumblebee = new Coordenada(3,4);
		
		tablero.colocarEnTablero(optimus, coordOptimus);
		tablero.colocarEnTablero(ratchet, coordRatchet);
		tablero.colocarEnTablero(bumblebee, coordBumblebee);
		
		Superion superion = new Superion(optimus,ratchet,bumblebee);
		
		tablero.combinarAlgoformers(superion, optimus, ratchet, bumblebee, 1);
		
		tablero.descombinarAlgoformers(superion);
		
		Coordenada coordNuevaRatchet = new Coordenada(5,4);
		Coordenada coordNuevaBumblebee = new Coordenada(5,3);
		
		assertSame(tablero.obtenerAccionableEnCoordenada(coordOptimus), optimus);
		assertSame(tablero.obtenerAccionableEnCoordenada(coordNuevaRatchet), ratchet);
		assertSame(tablero.obtenerAccionableEnCoordenada(coordNuevaBumblebee), bumblebee);
	}
	
	@Test
	public void test06CombinarYDescombinarAutobotsConUnEspacioOcupadoCorrectamente(){
		Tablero tablero = new Tablero(100,100);
		
		Optimus optimus = new Optimus();
		Ratchet ratchet = new Ratchet();
		Bumblebee bumblebee = new Bumblebee();
		
		Megatron megatron = new Megatron();
		Coordenada coordMegatron = new Coordenada(5,4);
		
		Coordenada coordOptimus = new Coordenada(4,4);
		Coordenada coordRatchet = new Coordenada(3,5);
		Coordenada coordBumblebee = new Coordenada(3,4);
		
		tablero.colocarEnTablero(megatron, coordMegatron);
		
		tablero.colocarEnTablero(optimus, coordOptimus);
		tablero.colocarEnTablero(ratchet, coordRatchet);
		tablero.colocarEnTablero(bumblebee, coordBumblebee);
		
		Superion superion = new Superion(optimus,ratchet,bumblebee);
		
		tablero.combinarAlgoformers(superion, optimus, ratchet, bumblebee, 1);
		
		tablero.descombinarAlgoformers(superion);
		
		Coordenada coordNuevaRatchet = new Coordenada(5,3);
		Coordenada coordNuevaBumblebee = new Coordenada(4,3);
		
		assertSame(tablero.obtenerAccionableEnCoordenada(coordOptimus), optimus);
		assertSame(tablero.obtenerAccionableEnCoordenada(coordNuevaRatchet), ratchet);
		assertSame(tablero.obtenerAccionableEnCoordenada(coordNuevaBumblebee), bumblebee);
	}
	
	@Test
	public void test07CombinarYDescombinarAutobotsConMasDeUnEspacioOcupadoCorrectamente(){
		Tablero tablero = new Tablero(100,100);
		
		Optimus optimus = new Optimus();
		Ratchet ratchet = new Ratchet();
		Bumblebee bumblebee = new Bumblebee();
		
		Megatron megatron = new Megatron();
		Coordenada coordMegatron = new Coordenada(5,4);
		
		Frenzy frenzy = new Frenzy();
		Coordenada coordFrenzy = new Coordenada(4,3);
		
		Coordenada coordOptimus = new Coordenada(4,4);
		Coordenada coordRatchet = new Coordenada(3,5);
		Coordenada coordBumblebee = new Coordenada(3,4);
		
		tablero.colocarEnTablero(megatron, coordMegatron);
		tablero.colocarEnTablero(frenzy, coordFrenzy);
		
		tablero.colocarEnTablero(optimus, coordOptimus);
		tablero.colocarEnTablero(ratchet, coordRatchet);
		tablero.colocarEnTablero(bumblebee, coordBumblebee);
		
		Superion superion = new Superion(optimus,ratchet,bumblebee);
		
		tablero.combinarAlgoformers(superion, optimus, ratchet, bumblebee, 1);
		
		tablero.descombinarAlgoformers(superion);
		
		Coordenada coordNuevaRatchet = new Coordenada(5,3);
		Coordenada coordNuevaBumblebee = new Coordenada(3,4);
		
		assertSame(tablero.obtenerAccionableEnCoordenada(coordOptimus), optimus);
		assertSame(tablero.obtenerAccionableEnCoordenada(coordNuevaRatchet), ratchet);
		assertSame(tablero.obtenerAccionableEnCoordenada(coordNuevaBumblebee), bumblebee);
	}
	
	@Test
	public void test08CombinarYDescombinarAutobotsEnEsquinaDeTableroVacioCorrectamente(){
		Tablero tablero = new Tablero(10,10);
		
		Optimus optimus = new Optimus();
		Ratchet ratchet = new Ratchet();
		Bumblebee bumblebee = new Bumblebee();
		
		Coordenada coordOptimus = new Coordenada(1,9);
		Coordenada coordRatchet = new Coordenada(1,8);
		Coordenada coordBumblebee = new Coordenada(0,9);
		
		tablero.colocarEnTablero(optimus, coordOptimus);
		tablero.colocarEnTablero(ratchet, coordRatchet);
		tablero.colocarEnTablero(bumblebee, coordBumblebee);
		
		Superion superion = new Superion(optimus,ratchet,bumblebee);
		
		tablero.combinarAlgoformers(superion, optimus, ratchet, bumblebee, 1);
		
		tablero.descombinarAlgoformers(superion);
		
		Coordenada coordNuevaRatchet = new Coordenada(2,8);
		Coordenada coordNuevaBumblebee = new Coordenada(1,8);
		
		assertSame(tablero.obtenerAccionableEnCoordenada(coordOptimus), optimus);
		assertSame(tablero.obtenerAccionableEnCoordenada(coordNuevaRatchet), ratchet);
		assertSame(tablero.obtenerAccionableEnCoordenada(coordNuevaBumblebee), bumblebee);
		
	}
	
	@Test
	public void test09CombinarYDescombinarAutobotsEnEsquinaEncerradoCorrectamente(){
		Tablero tablero = new Tablero(10,10);
		
		Optimus optimus = new Optimus();
		Ratchet ratchet = new Ratchet();
		Bumblebee bumblebee = new Bumblebee();
		
		Coordenada coordOptimus = new Coordenada(1,9);
		Coordenada coordRatchet = new Coordenada(1,8);
		Coordenada coordBumblebee = new Coordenada(0,9);
		
		tablero.colocarEnTablero(optimus, coordOptimus);
		tablero.colocarEnTablero(ratchet, coordRatchet);
		tablero.colocarEnTablero(bumblebee, coordBumblebee);
		
		Superion superion = new Superion(optimus,ratchet,bumblebee);
		
		tablero.combinarAlgoformers(superion, optimus, ratchet, bumblebee, 1);
		
		Megatron megatron = new Megatron();
		Frenzy frenzy = new Frenzy();
		Bonecrusher bonecrusher = new Bonecrusher();
		
		Coordenada coordMegatron = new Coordenada(2,8);
		Coordenada coordFrenzy = new Coordenada(1,8);
		Coordenada coordBonecrusher = new Coordenada(0,9);
		
		tablero.colocarEnTablero(megatron, coordMegatron);
		tablero.colocarEnTablero(frenzy, coordFrenzy);
		tablero.colocarEnTablero(bonecrusher, coordBonecrusher);
		
		tablero.descombinarAlgoformers(superion);
		
		Coordenada coordNuevaRatchet = new Coordenada(3,8);
		Coordenada coordNuevaBumblebee = new Coordenada(3,7);
		
		assertSame(tablero.obtenerAccionableEnCoordenada(coordOptimus), optimus);
		assertSame(tablero.obtenerAccionableEnCoordenada(coordNuevaRatchet), ratchet);
		assertSame(tablero.obtenerAccionableEnCoordenada(coordNuevaBumblebee), bumblebee);
		
	}
	
	@Test
	public void test10CombinarYDescombinarAutobotsEnCostadoCorrectamente(){
		Tablero tablero = new Tablero(100,100);
		
		Optimus optimus = new Optimus();
		Ratchet ratchet = new Ratchet();
		Bumblebee bumblebee = new Bumblebee();
		
		Coordenada coordOptimus = new Coordenada(0,6);
		Coordenada coordRatchet = new Coordenada(0,7);
		Coordenada coordBumblebee = new Coordenada(1,6);
		
		tablero.colocarEnTablero(optimus, coordOptimus);
		tablero.colocarEnTablero(ratchet, coordRatchet);
		tablero.colocarEnTablero(bumblebee, coordBumblebee);
		
		Superion superion = new Superion(optimus,ratchet,bumblebee);
		
		tablero.combinarAlgoformers(superion, optimus, ratchet, bumblebee, 1);
		
		Megatron megatron = new Megatron();
		Frenzy frenzy = new Frenzy();
		Bonecrusher bonecrusher = new Bonecrusher();
		
		Coordenada coordMegatron = new Coordenada(0,7);
		Coordenada coordFrenzy = new Coordenada(1,6);
		Coordenada coordBonecrusher = new Coordenada(1,5);
		
		tablero.colocarEnTablero(megatron, coordMegatron);
		tablero.colocarEnTablero(frenzy, coordFrenzy);
		tablero.colocarEnTablero(bonecrusher, coordBonecrusher);
		
		tablero.descombinarAlgoformers(superion);
		
		Coordenada coordNuevaRatchet = new Coordenada(0,5);
		Coordenada coordNuevaBumblebee = new Coordenada(2,6);
		
		assertSame(tablero.obtenerAccionableEnCoordenada(coordOptimus), optimus);
		assertSame(tablero.obtenerAccionableEnCoordenada(coordNuevaRatchet), ratchet);
		assertSame(tablero.obtenerAccionableEnCoordenada(coordNuevaBumblebee), bumblebee);
	}
	//bonus no pasan a combinado y pasan los turnos del individual
	@Test 
	public void test11CuandoSeCombinanNoSePasanLosBonusAlAlgoformerCombinado(){
		Tablero tablero = new Tablero(10,10);
		
		Optimus optimus = new Optimus();
		Bumblebee bumblebee = new Bumblebee();
		Ratchet ratchet = new Ratchet();
		BurbujaInmaculada burbuja = new BurbujaInmaculada();
		Megatron megatron = new Megatron();
		
		Coordenada coordInicialOptimus = new Coordenada(0,1);
		Coordenada coordInicialBumblebee = new Coordenada(0,0);
		Coordenada coordInicialRatchet = new Coordenada(1,0);
		Coordenada coordBurbuja = new Coordenada(0,2);
		Coordenada coordMegatron = new Coordenada(1,1);
		
		tablero.colocarEnTablero(ratchet, coordInicialRatchet);
		tablero.colocarEnTablero(bumblebee, coordInicialBumblebee);
		tablero.colocarEnTablero(optimus, coordInicialOptimus);
		tablero.colocarEnTablero(burbuja, coordBurbuja);
		tablero.colocarEnTablero(megatron, coordMegatron);
		
		optimus.moverse(coordBurbuja, tablero);
		optimus.terminaTurno();
		
		//optimus tiene activado el bonus
		megatron.atacar(tablero, optimus);
		
		assertEquals(optimus.verVida(), 500);
		
		Superion superion = new Superion(optimus, ratchet, bumblebee);
		
		tablero.combinarAlgoformers(superion, optimus, ratchet, bumblebee, 1);
		superion.terminaTurno();
		
		//superion no tiene el bonus
		megatron.atacar(tablero, superion);
		assertEquals(superion.verVida(), 990);
	}
	
	@Test 
	public void test12CuandoSeCombinanLosTurnosDeBonusSiguenPasandoParaLosIndividuales(){
		Tablero tablero = new Tablero(10,10);
		
		Optimus optimus = new Optimus();
		Bumblebee bumblebee = new Bumblebee();
		Ratchet ratchet = new Ratchet();
		BurbujaInmaculada burbuja = new BurbujaInmaculada();
		Megatron megatron = new Megatron();
		
		Coordenada coordInicialOptimus = new Coordenada(0,1);
		Coordenada coordInicialBumblebee = new Coordenada(0,0);
		Coordenada coordInicialRatchet = new Coordenada(1,0);
		Coordenada coordBurbuja = new Coordenada(0,2);
		Coordenada coordMegatron = new Coordenada(1,1);
		
		tablero.colocarEnTablero(ratchet, coordInicialRatchet);
		tablero.colocarEnTablero(bumblebee, coordInicialBumblebee);
		tablero.colocarEnTablero(optimus, coordInicialOptimus);
		tablero.colocarEnTablero(burbuja, coordBurbuja);
		tablero.colocarEnTablero(megatron, coordMegatron);
		
		optimus.moverse(coordBurbuja, tablero);
		optimus.terminaTurno();
		
		//optimus tiene activado el bonus
		megatron.atacar(tablero, optimus);
		
		assertEquals(optimus.verVida(), 500);
		
		Superion superion = new Superion(optimus, ratchet, bumblebee);
		
		tablero.combinarAlgoformers(superion, optimus, ratchet, bumblebee, 1);
		//al final de cada turno, se pasa el turno del combinado y todos los individuales
		superion.terminaTurno();
		optimus.terminaTurno();
		
		//superion no tiene el bonus
		megatron.atacar(tablero, superion);
		assertEquals(superion.verVida(), 990);
		superion.terminaTurno();
		optimus.terminaTurno();
		
		tablero.descombinarAlgoformers(superion);
		optimus.terminaTurno();
		
		//pasaron 3 turnos->optimus no tiene bonus
		megatron.atacar(tablero, optimus);
		assertEquals(optimus.verVida(), 490);
		
	}
	//no agarran bonus salvo que esten sobre el casillero
	@Test 
	public void test20SiPasaPorCasillerosConBonusMientrasSeMueveNoLosAgarra(){
		Tablero tablero = new Tablero(10,10);
		
		Optimus optimus = new Optimus();
		optimus.cambiarModo(); //le cambio el modo para que tenga mas velocidad
		Megatron megatron = new Megatron();
		DobleCanion dobleCanion = new DobleCanion();
		BurbujaInmaculada burbuja = new BurbujaInmaculada();
		
		Coordenada coordInicialOptimus = new Coordenada(0,0);
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordCanion = new Coordenada(0,1);
		Coordenada coordBurbuja = new Coordenada(0,2);
		
		tablero.colocarEnTablero(optimus, coordInicialOptimus);
		tablero.colocarEnTablero(megatron, coordMegatron);
		tablero.colocarEnTablero(burbuja, coordBurbuja);
		tablero.colocarEnTablero(dobleCanion, coordCanion);
		
		optimus.moverse(new Coordenada(0,3), tablero);
		optimus.terminaTurno();
		
		megatron.atacar(tablero, optimus);
		megatron.terminaTurno();
		
		assertEquals(optimus.verVida(), 490);
		
		optimus.atacar(tablero, megatron);
		
		assertEquals(megatron.verVida(), 535);
	}
}
