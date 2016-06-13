package fiuba.algo3.algoFormers.algoFormersTests;

import static org.junit.Assert.*;
import org.junit.Test;

import fiuba.algo3.algoFormers.Entrega2Test.FailTestException;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.Bumblebee;
import fiuba.algo3.algoFormers.autobots.Optimus;
import fiuba.algo3.algoFormers.autobots.Ratchet;
import fiuba.algo3.algoFormers.autobots.Superion;
import fiuba.algo3.algoFormers.decepticons.Bonecrusher;
import fiuba.algo3.algoFormers.decepticons.Frenzy;
import fiuba.algo3.algoFormers.decepticons.Megatron;
import fiuba.algo3.algoFormers.decepticons.Menasor;
import fiuba.algo3.algoFormers.excepciones.*;
import fiuba.algo3.algoFormers.modos.BumblebeeHumanoide;
import fiuba.algo3.algoFormers.modos.FrenzyHumanoide;
import fiuba.algo3.algoFormers.modos.OptimusAlterno;
import fiuba.algo3.algoFormers.superficies.*;



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
		Tablero tablero = new Tablero(100,100);
		Coordenada coordOptimus = new Coordenada(1,2);
		Coordenada coordRatchet = new Coordenada(1,3);
		tablero.colocarEnTablero(optimus,coordOptimus);
		tablero.colocarEnTablero(ratchet, coordRatchet);
		ratchet.atacar(tablero,optimus);
	}
	
	@Test (expected = FueraDeRangoException.class)
	public void test05AutobotAtacarAutobotDistanciaIncorrecta(){
		Ratchet ratchet = new Ratchet();
		Optimus optimus = new Optimus();
		Tablero tablero = new Tablero(100,100);
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
		Tablero tablero = new Tablero(100,100);
		Coordenada coordOptimus = new Coordenada(1,2);
		Coordenada coordRatchet = new Coordenada(1,7);
		tablero.colocarEnTablero(optimus,coordOptimus);
		tablero.colocarEnTablero(ratchet, coordRatchet);
		ratchet.atacar(tablero,optimus);
	}
	
	@Test (expected = MismoEquipoException.class)
	public void test07DecepticonAtacarDecepticonDistanciaCorrecta(){
		Tablero tablero = new Tablero(100,100);
		Megatron megatron = new Megatron();
		Bonecrusher bonecrusher = new Bonecrusher();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordBonecrusher = new Coordenada(1,4);
		tablero.colocarEnTablero(megatron,coordMegatron);
		tablero.colocarEnTablero(bonecrusher, coordBonecrusher);
		bonecrusher.atacar(tablero, megatron);
	}
	
	@Test (expected = FueraDeRangoException.class)
	public void test08DecepticonAtacarDecepticonDistanciaIncorrecta(){
		Tablero tablero = new Tablero(100,100);
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
		Tablero tablero = new Tablero(100,100);
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
		Tablero tablero = new Tablero(100,100);
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
	
	@Test (expected = FueraDeRangoException.class)
	public void test11AutobotAtacarDecepticonDistanciaIncorrecta(){
		Tablero tablero = new Tablero(100,100);
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordOptimus = new Coordenada(1,8);
		tablero.colocarEnTablero(megatron,coordMegatron);
		tablero.colocarEnTablero(optimus, coordOptimus);
		optimus.atacar(tablero,megatron);
	}
	
	@Test
	public void test12AutobotAtacarDecepticonDistanciaLimite(){
		Tablero tablero = new Tablero(100,100);
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
		Tablero tablero = new Tablero(100,100);
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
	
	@Test (expected = FueraDeRangoException.class)
	public void test14DecepticonAtacarAutobotDistanciaIncorrecta(){
		Tablero tablero = new Tablero(100,100);
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordOptimus = new Coordenada(1,8);
		tablero.colocarEnTablero(megatron,coordMegatron);
		tablero.colocarEnTablero(optimus, coordOptimus);
		megatron.atacar(tablero, optimus);
	}
	
	@Test
	public void test15DecepticonAtacarAutobotDistanciaLimite(){
		Tablero tablero = new Tablero(100,100);
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		Coordenada coordMegatron = new Coordenada(1,2);
		Coordenada coordOptimus = new Coordenada(1,5);
		tablero.colocarEnTablero(megatron,coordMegatron);
		tablero.colocarEnTablero(optimus, coordOptimus);
		megatron.atacar(tablero, optimus);
		assertEquals(optimus.verVida(), 490);
	}
	
	@Test
	public void test16CombinarAutobotsDistanciaCorrecta(){
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
	public void test17CombinarAutobotsDistanciaIncorrecta(){
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
	public void test18CombinarDecepticonsDistanciaCorrecta(){
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
	public void test19CombinarDecepticonsDistanciaIncorrecta(){
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
	
	@Test
	public void test20CombinarYDescombinarAutobotsConTableroVacioCorrectamente(){
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
	public void test21CombinarYDescombinarAutobotsConUnEspacioOcupadoCorrectamente(){
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
	public void test22CombinarYDescombinarAutobotsConMasDeUnEspacioOcupadoCorrectamente(){
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
	public void test23CombinarYDescombinarAutobotsEnEsquinaDeTableroVacioCorrectamente(){
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
	public void test24CombinarYDescombinarAutobotsEnEsquinaEncerradoCorrectamente(){
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
	public void test25CombinarYDescombinarAutobotsEnCostadoCorrectamente(){
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
	
	@Test
	public void test26CombinarAutobotsMoverSuperionYDescombinarConTableroVacioCorrectamente(){
		Tablero tablero = new Tablero(100,100);
		
		Optimus optimus = new Optimus();
		Ratchet ratchet = new Ratchet();
		Bumblebee bumblebee = new Bumblebee();
		
		Coordenada coordOptimus = new Coordenada(1,6);
		Coordenada coordRatchet = new Coordenada(2,6);
		Coordenada coordBumblebee = new Coordenada(2,5);
		
		tablero.colocarEnTablero(optimus, coordOptimus);
		tablero.colocarEnTablero(ratchet, coordRatchet);
		tablero.colocarEnTablero(bumblebee, coordBumblebee);
		
		Superion superion = new Superion(optimus,ratchet,bumblebee);
		
		Coordenada coordDestino = new Coordenada(5,4);

		tablero.combinarAlgoformers(superion, optimus, ratchet, bumblebee, 1);
		
		tablero.mover(superion, coordDestino, 4);
		
		tablero.descombinarAlgoformers(superion);
	
		Coordenada coordNuevaRatchet = new Coordenada(6,4);
		Coordenada coordNuevaBumblebee = new Coordenada(6,3);
		
		assertSame(tablero.obtenerAccionableEnCoordenada(coordDestino), optimus);
		assertSame(tablero.obtenerAccionableEnCoordenada(coordNuevaRatchet), ratchet);
		assertSame(tablero.obtenerAccionableEnCoordenada(coordNuevaBumblebee), bumblebee);
		
	}
	@Test
	public void test16CombinarAutobotsDistanciaCorrectaYMoverSuperion(){
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
		superion.moverse(coordRatchet, tablero);
		
		assertSame(tablero.obtenerAccionableEnCoordenada(coordRatchet),superion);
	}
}
