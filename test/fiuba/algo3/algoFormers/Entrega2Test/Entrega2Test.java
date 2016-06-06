package fiuba.algo3.algoFormers.Entrega2Test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoFormers.Superficies.*;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.decepticons.*;
import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;

public class Entrega2Test {
	
	//ATRAVESAR ZONA ROCOSA, TODOS LOS ALGOFORMERS EN TODOS LOS MODOS
	//pruebas autobots
	@Test
	public void test01RatchetHumanoideAtraviesaSuperficieRocosa(){
			Tablero tablero = new Tablero(10,10);
			Ratchet ratchet = new Ratchet();
			Coordenada coordenadaInicialRatchet = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			tablero.colocarSuperficieEnTablero(new SuperficieRocosa(), coordenadaSuperficie);
			tablero.colocarEnTablero(ratchet, coordenadaInicialRatchet);
			//Los efectos se aplican al final de cada turno
			ratchet.moverse(coordenadaSuperficie,tablero);	
			ratchet.terminaTurno();
			Coordenada coordenadaFinalRatchet = new Coordenada(4,4);
			ratchet.moverse(coordenadaFinalRatchet, tablero);
			assertEquals(tablero.obtenerCoordenadaDeHabitable(ratchet), coordenadaFinalRatchet);
	}
	
	@Test
	public void test02RatchetAlternoAtraviesaSuperficieRocosa(){
			Tablero tablero = new Tablero(10,10);
			Ratchet ratchet = new Ratchet();
			ratchet.cambiarModo();
			Coordenada coordenadaInicialRatchet = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			ratchet.cambiarModo();
			tablero.colocarSuperficieEnTablero(new SuperficieRocosa(), coordenadaSuperficie);
			tablero.colocarEnTablero(ratchet, coordenadaInicialRatchet);
			//Los efectos se aplican al final de cada turno
			ratchet.moverse(coordenadaSuperficie,tablero);	
			ratchet.terminaTurno();
			Coordenada coordenadaFinalRatchet = new Coordenada(4,4);
			ratchet.moverse(coordenadaFinalRatchet, tablero);
			assertEquals(tablero.obtenerCoordenadaDeHabitable(ratchet), coordenadaFinalRatchet);
	}
	
	@Test
	public void test03OptimusHumanoideAtraviesaSuperficieRocosa(){
			Tablero tablero = new Tablero(10,10);
			Optimus optimus = new Optimus();
			Coordenada coordenadaInicialOptimus = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			tablero.colocarSuperficieEnTablero(new SuperficieRocosa(), coordenadaSuperficie);
			tablero.colocarEnTablero(optimus, coordenadaInicialOptimus);
			//Los efectos se aplican al final de cada turno
			optimus.moverse(coordenadaSuperficie,tablero);	
			optimus.terminaTurno();
			Coordenada coordenadaFinalOptimus = new Coordenada(4,4);
			optimus.moverse(coordenadaFinalOptimus, tablero);
			assertEquals(tablero.obtenerCoordenadaDeHabitable(optimus), coordenadaFinalOptimus);
	}
	
	@Test
	public void test04OptimusAlternoAtraviesaSuperficieRocosa(){
			Tablero tablero = new Tablero(10,10);
			Optimus optimus = new Optimus();
			optimus.cambiarModo();
			Coordenada coordenadaInicialOptimus = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			tablero.colocarSuperficieEnTablero(new SuperficieRocosa(), coordenadaSuperficie);
			tablero.colocarEnTablero(optimus, coordenadaInicialOptimus);
			//Los efectos se aplican al final de cada turno
			optimus.moverse(coordenadaSuperficie,tablero);	
			optimus.terminaTurno();
			Coordenada coordenadaFinalOptimus = new Coordenada(4,4);
			optimus.moverse(coordenadaFinalOptimus, tablero);
			assertEquals(tablero.obtenerCoordenadaDeHabitable(optimus), coordenadaFinalOptimus);
	}
	
	@Test
	public void test05BumblebeeHumanoideAtraviesaSuperficieRocosa(){
			Tablero tablero = new Tablero(10,10);
			Bumblebee bumblebee = new Bumblebee();
			Coordenada coordenadaInicialBumblebee = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			tablero.colocarSuperficieEnTablero(new SuperficieRocosa(), coordenadaSuperficie);
			tablero.colocarEnTablero(bumblebee, coordenadaInicialBumblebee);
			//Los efectos se aplican al final de cada turno
			bumblebee.moverse(coordenadaSuperficie,tablero);	
			bumblebee.terminaTurno();
			Coordenada coordenadaFinalBumblebee = new Coordenada(4,4);
			bumblebee.moverse(coordenadaFinalBumblebee, tablero);
			assertEquals(tablero.obtenerCoordenadaDeHabitable(bumblebee), coordenadaFinalBumblebee);
	}
	
	@Test
	public void test06BumblebeeAlternoAtraviesaSuperficieRocosa(){
			Tablero tablero = new Tablero(10,10);
			Bumblebee bumblebee = new Bumblebee();
			bumblebee.cambiarModo();
			Coordenada coordenadaInicialBumblebee = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			tablero.colocarSuperficieEnTablero(new SuperficieRocosa(), coordenadaSuperficie);
			tablero.colocarEnTablero(bumblebee, coordenadaInicialBumblebee);
			//Los efectos se aplican al final de cada turno
			bumblebee.moverse(coordenadaSuperficie,tablero);	
			bumblebee.terminaTurno();
			Coordenada coordenadaFinalBumblebee = new Coordenada(4,4);
			bumblebee.moverse(coordenadaFinalBumblebee, tablero);
			assertEquals(tablero.obtenerCoordenadaDeHabitable(bumblebee), coordenadaFinalBumblebee);
	}
	
	@Test
	public void test07SuperionAtraviesaSuperficieRocosa(){
			Tablero tablero = new Tablero(10,10);
			Optimus optimus = new Optimus();
			Bumblebee bumblebee = new Bumblebee();
			Ratchet ratchet = new Ratchet();
			Superion superion = new Superion(optimus, ratchet, bumblebee);
			Coordenada coordenadaInicialBumblebee = new Coordenada(2,3);
			Coordenada coordenadaInicialOptimus = new Coordenada(3,3);
			Coordenada coordenadaInicialRatchet = new Coordenada(3,4);
			tablero.colocarEnTablero(optimus, coordenadaInicialOptimus);
			tablero.colocarEnTablero(bumblebee, coordenadaInicialBumblebee);
			tablero.colocarEnTablero(ratchet, coordenadaInicialRatchet);
			tablero.combinarAlgoformers(superion, optimus, ratchet, bumblebee, 1);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			tablero.colocarSuperficieEnTablero(new SuperficieRocosa(), coordenadaSuperficie);
			//Los efectos se aplican al final de cada turno
			superion.moverse(coordenadaSuperficie,tablero);	
			superion.terminaTurno();
			Coordenada coordenadaFinalSuperion = new Coordenada(4,4);
			superion.moverse(coordenadaFinalSuperion, tablero);
			assertEquals(tablero.obtenerCoordenadaDeHabitable(superion), coordenadaFinalSuperion);
	}
	
	//pruebas decepticons
	@Test
	public void test08FrenzyHumanoideAtraviesaSuperficieRocosa(){
			Tablero tablero = new Tablero(10,10);
			Frenzy frenzy = new Frenzy();
			Coordenada coordenadaInicialFrenzy = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			tablero.colocarSuperficieEnTablero(new SuperficieRocosa(), coordenadaSuperficie);
			tablero.colocarEnTablero(frenzy, coordenadaInicialFrenzy);
			//Los efectos se aplican al final de cada turno
			frenzy.moverse(coordenadaSuperficie,tablero);	
			frenzy.terminaTurno();
			Coordenada coordenadaFinalFrenzy = new Coordenada(4,4);
			frenzy.moverse(coordenadaFinalFrenzy, tablero);
			assertEquals(tablero.obtenerCoordenadaDeHabitable(frenzy), coordenadaFinalFrenzy);
	}
	
	@Test
	public void test09FrenzyAlternoAtraviesaSuperficieRocosa(){
			Tablero tablero = new Tablero(10,10);
			Frenzy frenzy = new Frenzy();
			frenzy.cambiarModo();
			Coordenada coordenadaInicialFrenzy = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			tablero.colocarSuperficieEnTablero(new SuperficieRocosa(), coordenadaSuperficie);
			tablero.colocarEnTablero(frenzy, coordenadaInicialFrenzy);
			//Los efectos se aplican al final de cada turno
			frenzy.moverse(coordenadaSuperficie,tablero);	
			frenzy.terminaTurno();
			Coordenada coordenadaFinalFrenzy = new Coordenada(4,4);
			frenzy.moverse(coordenadaFinalFrenzy, tablero);
			assertEquals(tablero.obtenerCoordenadaDeHabitable(frenzy), coordenadaFinalFrenzy);
	}
	
	@Test
	public void test10MegatronHumanoideAtraviesaSuperficieRocosa(){
			Tablero tablero = new Tablero(10,10);
			Megatron megatron = new Megatron();
			Coordenada coordenadaInicialMegatron = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			tablero.colocarSuperficieEnTablero(new SuperficieRocosa(), coordenadaSuperficie);
			tablero.colocarEnTablero(megatron, coordenadaInicialMegatron);
			//Los efectos se aplican al final de cada turno
			megatron.moverse(coordenadaSuperficie,tablero);	
			megatron.terminaTurno();
			Coordenada coordenadaFinalMegatron = new Coordenada(4,4);
			megatron.moverse(coordenadaFinalMegatron, tablero);
			assertEquals(tablero.obtenerCoordenadaDeHabitable(megatron), coordenadaFinalMegatron);
	}
	
	@Test
	public void test11MegatronAlternoAtraviesaSuperficieRocosa(){
			Tablero tablero = new Tablero(10,10);
			Megatron megatron = new Megatron();
			megatron.cambiarModo();
			Coordenada coordenadaInicialMegatron = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			tablero.colocarSuperficieEnTablero(new SuperficieRocosa(), coordenadaSuperficie);
			tablero.colocarEnTablero(megatron, coordenadaInicialMegatron);
			//Los efectos se aplican al final de cada turno
			megatron.moverse(coordenadaSuperficie,tablero);	
			megatron.terminaTurno();
			Coordenada coordenadaFinalMegatron = new Coordenada(4,4);
			megatron.moverse(coordenadaFinalMegatron, tablero);
			assertEquals(tablero.obtenerCoordenadaDeHabitable(megatron), coordenadaFinalMegatron);
	}
	
	@Test
	public void test12BonecrusherHumanoideAtraviesaSuperficieRocosa(){
			Tablero tablero = new Tablero(10,10);
			Bonecrusher bonecrusher = new Bonecrusher();
			Coordenada coordenadaInicialBonecrusher = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			tablero.colocarSuperficieEnTablero(new SuperficieRocosa(), coordenadaSuperficie);
			tablero.colocarEnTablero(bonecrusher, coordenadaInicialBonecrusher);
			//Los efectos se aplican al final de cada turno
			bonecrusher.moverse(coordenadaSuperficie,tablero);	
			bonecrusher.terminaTurno();
			Coordenada coordenadaFinalBonecrusher = new Coordenada(4,4);
			bonecrusher.moverse(coordenadaFinalBonecrusher, tablero);
			assertEquals(tablero.obtenerCoordenadaDeHabitable(bonecrusher), coordenadaFinalBonecrusher);
	}
	
	@Test
	public void test13BonecrusherAlternoAtraviesaSuperficieRocosa(){
			Tablero tablero = new Tablero(10,10);
			Bonecrusher bonecrusher = new Bonecrusher();
			bonecrusher.cambiarModo();
			Coordenada coordenadaInicialBonecrusher = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			tablero.colocarSuperficieEnTablero(new SuperficieRocosa(), coordenadaSuperficie);
			tablero.colocarEnTablero(bonecrusher, coordenadaInicialBonecrusher);
			//Los efectos se aplican al final de cada turno
			bonecrusher.moverse(coordenadaSuperficie,tablero);	
			bonecrusher.terminaTurno();
			Coordenada coordenadaFinalBonecrusher = new Coordenada(4,4);
			bonecrusher.moverse(coordenadaFinalBonecrusher, tablero);
			assertEquals(tablero.obtenerCoordenadaDeHabitable(bonecrusher), coordenadaFinalBonecrusher);
	}
	
	@Test
	public void test14MenasorAtraviesaSuperficieRocosa(){
			Tablero tablero = new Tablero(10,10);
			Megatron megatron = new Megatron();
			Bonecrusher bonecrusher = new Bonecrusher();
			Frenzy frenzy = new Frenzy();
			Menasor menasor = new Menasor(megatron, bonecrusher, frenzy);
			Coordenada coordenadaInicialBonecrusher = new Coordenada(2,3);
			Coordenada coordenadaInicialMegatron = new Coordenada(3,3);
			Coordenada coordenadaInicialFrenzy = new Coordenada(3,4);
			tablero.colocarEnTablero(megatron, coordenadaInicialMegatron);
			tablero.colocarEnTablero(bonecrusher, coordenadaInicialBonecrusher);
			tablero.colocarEnTablero(frenzy, coordenadaInicialFrenzy);
			tablero.combinarAlgoformers(menasor, megatron, bonecrusher, frenzy, 1);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			tablero.colocarSuperficieEnTablero(new SuperficieRocosa(), coordenadaSuperficie);
			//Los efectos se aplican al final de cada turno
			menasor.moverse(coordenadaSuperficie,tablero);	
			menasor.terminaTurno();
			Coordenada coordenadaFinalMenasor = new Coordenada(4,4);
			menasor.moverse(coordenadaFinalMenasor, tablero);
			assertEquals(tablero.obtenerCoordenadaDeHabitable(menasor), coordenadaFinalMenasor);
	}
	
	//NO ATRAVESAR ZONA PANTANO EN MODO HUMANOIDE
	@Test (expected = MovimientoInvalidoException.class)
	public void test15AlgoformerUnidadTerrestreModoHumanoideNoAtraviesaZonaPantano(){
		Tablero tablero = new Tablero(10,10);
		Bonecrusher bonecrusher = new Bonecrusher();
		Coordenada coordenadaInicialBonecrusher = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficiePantano(), coordenadaSuperficie);
		tablero.colocarEnTablero(bonecrusher, coordenadaInicialBonecrusher);
		//Los efectos se aplican al final de cada turno
		bonecrusher.moverse(coordenadaSuperficie,tablero);	
	}
	
	@Test 
	public void test16AlgoformerUnidadTerrestreModoAlternoPuedeAtravesarZonaPantano(){
		Tablero tablero = new Tablero(10,10);
		Bonecrusher bonecrusher = new Bonecrusher();
		bonecrusher.cambiarModo();
		Coordenada coordenadaInicialBonecrusher = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficiePantano(), coordenadaSuperficie);
		tablero.colocarEnTablero(bonecrusher, coordenadaInicialBonecrusher);
		//Los efectos se aplican al final de cada turno
		bonecrusher.moverse(coordenadaSuperficie,tablero);	
		bonecrusher.terminaTurno();
		Coordenada coordenadaFinalBonecrusher = new Coordenada(3,8);
		bonecrusher.moverse(coordenadaFinalBonecrusher, tablero);
		assertEquals(tablero.obtenerCoordenadaDeHabitable(bonecrusher), coordenadaFinalBonecrusher);
	}
	
	@Test (expected = MovimientoInvalidoException.class)
	public void test17AlgoformerUnidadTerrestreModoAlternoPierdeVelocidadEnZonaPantano(){
		Tablero tablero = new Tablero(10,10);
		Bonecrusher bonecrusher = new Bonecrusher();
		bonecrusher.cambiarModo();
		Coordenada coordenadaInicialBonecrusher = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficiePantano(), coordenadaSuperficie);
		tablero.colocarEnTablero(bonecrusher, coordenadaInicialBonecrusher);
		//Los efectos se aplican al final de cada turno
		bonecrusher.moverse(coordenadaSuperficie,tablero);	
		bonecrusher.terminaTurno();
		Coordenada coordenadaFinalBonecrusher = new Coordenada(3,9);
		bonecrusher.moverse(coordenadaFinalBonecrusher, tablero);
	}
	
	@Test 
	public void test16AlgoformerUnidadAereaModoHumanoidePuedeAtravesarZonaPantano(){
		Tablero tablero = new Tablero(10,10);
		Frenzy frenzy = new Frenzy();
		Coordenada coordenadaInicialFrenzy = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficiePantano(), coordenadaSuperficie);
		tablero.colocarEnTablero(frenzy, coordenadaInicialFrenzy);
		//Los efectos se aplican al final de cada turno
		frenzy.moverse(coordenadaSuperficie,tablero);	
		frenzy.terminaTurno();
		Coordenada coordenadaFinalFrenzy = new Coordenada(3,5);
		frenzy.moverse(coordenadaFinalFrenzy, tablero);
		assertEquals(tablero.obtenerCoordenadaDeHabitable(frenzy), coordenadaFinalFrenzy);
	}
	
	@Test 
	public void test16AlgoformerUnidadAereaModoHumanoideNoPierdeVelocidadZonaPantano(){
		Tablero tablero = new Tablero(10,10);
		Frenzy frenzy = new Frenzy();
		Coordenada coordenadaInicialFrenzy = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficiePantano(), coordenadaSuperficie);
		tablero.colocarEnTablero(frenzy, coordenadaInicialFrenzy);
		//Los efectos se aplican al final de cada turno
		frenzy.moverse(coordenadaSuperficie,tablero);	
		frenzy.terminaTurno();
		Coordenada coordenadaFinalFrenzy = new Coordenada(3,6);
		frenzy.moverse(coordenadaFinalFrenzy, tablero);
		assertEquals(tablero.obtenerCoordenadaDeHabitable(frenzy), coordenadaFinalFrenzy);
	}
	
	@Test 
	public void test18AlgoformerUnidadAereaModoAlternoPuedeAtravesarZonaPantano(){
		Tablero tablero = new Tablero(10,10);
		Frenzy frenzy = new Frenzy();
		frenzy.cambiarModo();
		Coordenada coordenadaInicialFrenzy = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficiePantano(), coordenadaSuperficie);
		tablero.colocarEnTablero(frenzy, coordenadaInicialFrenzy);
		//Los efectos se aplican al final de cada turno
		frenzy.moverse(coordenadaSuperficie,tablero);	
		frenzy.terminaTurno();
		Coordenada coordenadaFinalFrenzy = new Coordenada(3,5);
		frenzy.moverse(coordenadaFinalFrenzy, tablero);
		assertEquals(tablero.obtenerCoordenadaDeHabitable(frenzy), coordenadaFinalFrenzy);
	}
	
	@Test 
	public void test19AlgoformerUnidadAereaModoAlternoNoPierdeVelocidadZonaPantano(){
		Tablero tablero = new Tablero(10,10);
		Frenzy frenzy = new Frenzy();
		frenzy.cambiarModo();
		Coordenada coordenadaInicialFrenzy = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficiePantano(), coordenadaSuperficie);
		tablero.colocarEnTablero(frenzy, coordenadaInicialFrenzy);
		//Los efectos se aplican al final de cada turno
		frenzy.moverse(coordenadaSuperficie,tablero);	
		frenzy.terminaTurno();
		Coordenada coordenadaFinalFrenzy = new Coordenada(3,8);
		frenzy.moverse(coordenadaFinalFrenzy, tablero);
		assertEquals(tablero.obtenerCoordenadaDeHabitable(frenzy), coordenadaFinalFrenzy);
	}
	
	//UNIDADES TERRESTRES PIERDEN 5% EN ESPINAS EN CUALQUIER MODO
	@Test 
	public void test20OptimusModoHumanoidePierdeVidaZonaEspinas(){
		Tablero tablero = new Tablero(10,10);
		Optimus optimus = new Optimus();
		Coordenada coordenadaInicialOptimus = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficieEspinas(), coordenadaSuperficie);
		tablero.colocarEnTablero(optimus, coordenadaInicialOptimus);
		int vidaInicial = optimus.verVida();
		//Los efectos se aplican al final de cada turno
		optimus.moverse(coordenadaSuperficie,tablero);	
		optimus.terminaTurno();
		Assert.assertEquals(optimus.verVida(), (int)(Math.ceil(vidaInicial*0.95)));
	}
	
	@Test 
	public void test21OptimusModoAlternoPierdeVidaZonaEspinas(){
		Tablero tablero = new Tablero(10,10);
		Optimus optimus = new Optimus();
		optimus.cambiarModo();
		Coordenada coordenadaInicialOptimus = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficieEspinas(), coordenadaSuperficie);
		tablero.colocarEnTablero(optimus, coordenadaInicialOptimus);
		int vidaInicial = optimus.verVida();
		//Los efectos se aplican al final de cada turno
		optimus.moverse(coordenadaSuperficie,tablero);	
		optimus.terminaTurno();
		Assert.assertEquals(optimus.verVida(), (int)(Math.ceil(vidaInicial*0.95)));
	}
	
	@Test 
	public void test22BumblebeeModoHumanoidePierdeVidaZonaEspinas(){
		Tablero tablero = new Tablero(10,10);
		Bumblebee bumblebee = new Bumblebee();
		Coordenada coordenadaInicialBumblebee = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficieEspinas(), coordenadaSuperficie);
		tablero.colocarEnTablero(bumblebee, coordenadaInicialBumblebee);
		int vidaInicial = bumblebee.verVida();
		//Los efectos se aplican al final de cada turno
		bumblebee.moverse(coordenadaSuperficie,tablero);	
		bumblebee.terminaTurno();
		Assert.assertEquals(bumblebee.verVida(), (int)(Math.ceil(vidaInicial*0.95)));
	}
	
	@Test 
	public void test23BumblebeeModoAlternoPierdeVidaZonaEspinas(){
		Tablero tablero = new Tablero(10,10);
		Bumblebee bumblebee = new Bumblebee();
		bumblebee.cambiarModo();
		Coordenada coordenadaInicialBumblebee = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficieEspinas(), coordenadaSuperficie);
		tablero.colocarEnTablero(bumblebee, coordenadaInicialBumblebee);
		int vidaInicial = bumblebee.verVida();
		//Los efectos se aplican al final de cada turno
		bumblebee.moverse(coordenadaSuperficie,tablero);	
		bumblebee.terminaTurno();
		Assert.assertEquals(bumblebee.verVida(), (int)(Math.ceil(vidaInicial*0.95)));
	}
	
	@Test 
	public void test24MegatronModoHumanoidePierdeVidaZonaEspinas(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		Coordenada coordenadaInicialMegatron = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficieEspinas(), coordenadaSuperficie);
		tablero.colocarEnTablero(megatron, coordenadaInicialMegatron);
		int vidaInicial = megatron.verVida();
		//Los efectos se aplican al final de cada turno
		megatron.moverse(coordenadaSuperficie,tablero);	
		megatron.terminaTurno();
		Assert.assertEquals(megatron.verVida(), (int)(Math.ceil(vidaInicial*0.95)));
	}
	
	@Test 
	public void test25MegatronModoAlternoPierdeVidaZonaEspinas(){
		Tablero tablero = new Tablero(10,10);
		Megatron megatron = new Megatron();
		megatron.cambiarModo();
		Coordenada coordenadaInicialMegatron = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficieEspinas(), coordenadaSuperficie);
		tablero.colocarEnTablero(megatron, coordenadaInicialMegatron);
		int vidaInicial = megatron.verVida();
		//Los efectos se aplican al final de cada turno
		megatron.moverse(coordenadaSuperficie,tablero);	
		megatron.terminaTurno();
		Assert.assertEquals(megatron.verVida(), (int)(Math.ceil(vidaInicial*0.95)));
	}
	
	@Test 
	public void test26BonecrusherModoHumanoidePierdeVidaZonaEspinas(){
		Tablero tablero = new Tablero(10,10);
		Bonecrusher bonecrusher = new Bonecrusher();
		Coordenada coordenadaInicialBonecrusher = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficieEspinas(), coordenadaSuperficie);
		tablero.colocarEnTablero(bonecrusher, coordenadaInicialBonecrusher);
		int vidaInicial = bonecrusher.verVida();
		//Los efectos se aplican al final de cada turno
		bonecrusher.moverse(coordenadaSuperficie,tablero);	
		bonecrusher.terminaTurno();
		Assert.assertEquals(bonecrusher.verVida(), (int)(Math.ceil(vidaInicial*0.95)));
	}
	
	@Test 
	public void test27BonecrusherModoAlternoPierdeVidaEspinas(){
		Tablero tablero = new Tablero(10,10);
		Bonecrusher bonecrusher = new Bonecrusher();
		bonecrusher.cambiarModo();
		Coordenada coordenadaInicialBonecrusher = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficieEspinas(), coordenadaSuperficie);
		tablero.colocarEnTablero(bonecrusher, coordenadaInicialBonecrusher);
		int vidaInicial = bonecrusher.verVida();
		//Los efectos se aplican al final de cada turno
		bonecrusher.moverse(coordenadaSuperficie,tablero);	
		bonecrusher.terminaTurno();
		Assert.assertEquals(bonecrusher.verVida(), (int)(Math.ceil(vidaInicial*0.95)));
	}
	
	//UNIDADES AEREAS NO SON AFECTADAS POR ESPINAS
	@Test
	public void test28FrenzyModoHumanoideNoEsAfectadoZonaEspinas(){
		Tablero tablero = new Tablero(10,10);
		Frenzy frenzy = new Frenzy();
		Coordenada coordenadaInicialFrenzy = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficieEspinas(), coordenadaSuperficie);
		tablero.colocarEnTablero(frenzy, coordenadaInicialFrenzy);
		int vidaInicial = frenzy.verVida();
		//Los efectos se aplican al final de cada turno
		frenzy.moverse(coordenadaSuperficie,tablero);	
		frenzy.terminaTurno();
		Assert.assertEquals(frenzy.verVida(), vidaInicial);
	}
	
	@Test
	public void test28FrenzyModoAlternoNoEsAfectadoZonaEspinas(){
		Tablero tablero = new Tablero(10,10);
		Frenzy frenzy = new Frenzy();
		frenzy.cambiarModo();
		Coordenada coordenadaInicialFrenzy = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficieEspinas(), coordenadaSuperficie);
		tablero.colocarEnTablero(frenzy, coordenadaInicialFrenzy);
		int vidaInicial = frenzy.verVida();
		//Los efectos se aplican al final de cada turno
		frenzy.moverse(coordenadaSuperficie,tablero);	
		frenzy.terminaTurno();
		Assert.assertEquals(frenzy.verVida(), vidaInicial);
	}
	
	@Test
	public void test28RatchetModoHumanoideNoEsAfectadoZonaEspinas(){
		Tablero tablero = new Tablero(10,10);
		Ratchet ratchet = new Ratchet();
		Coordenada coordenadaInicialRatchet = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficieEspinas(), coordenadaSuperficie);
		tablero.colocarEnTablero(ratchet, coordenadaInicialRatchet);
		int vidaInicial = ratchet.verVida();
		//Los efectos se aplican al final de cada turno
		ratchet.moverse(coordenadaSuperficie,tablero);	
		ratchet.terminaTurno();
		Assert.assertEquals(ratchet.verVida(), vidaInicial);
	}
	
	@Test
	public void test28RatchetModoAlternoNoEsAfectadoZonaEspinas(){
		Tablero tablero = new Tablero(10,10);
		Ratchet ratchet = new Ratchet();
		ratchet.cambiarModo();
		Coordenada coordenadaInicialRatchet = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficieEspinas(), coordenadaSuperficie);
		tablero.colocarEnTablero(ratchet, coordenadaInicialRatchet);
		int vidaInicial = ratchet.verVida();
		//Los efectos se aplican al final de cada turno
		ratchet.moverse(coordenadaSuperficie,tablero);	
		ratchet.terminaTurno();
		Assert.assertEquals(ratchet.verVida(), vidaInicial);
	}
	
	//UNIDADES AEREAS ATRAVIESAN NUBES
	@Test
	public void test29RatchetHumanoideAtraviesaSuperficieNubes(){
			Tablero tablero = new Tablero(10,10);
			Ratchet ratchet = new Ratchet();
			Coordenada coordenadaInicialRatchet = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			tablero.colocarSuperficieEnTablero(new SuperficieNubes(), coordenadaSuperficie);
			tablero.colocarEnTablero(ratchet, coordenadaInicialRatchet);
			//Los efectos se aplican al final de cada turno
			ratchet.moverse(coordenadaSuperficie,tablero);	
			ratchet.terminaTurno();
			Coordenada coordenadaFinalRatchet = new Coordenada(4,4);
			ratchet.moverse(coordenadaFinalRatchet, tablero);
			assertEquals(tablero.obtenerCoordenadaDeHabitable(ratchet), coordenadaFinalRatchet);
	}
	
	@Test
	public void test30RatchetAlternoAtraviesaSuperficieNubes(){
			Tablero tablero = new Tablero(10,10);
			Ratchet ratchet = new Ratchet();
			ratchet.cambiarModo();
			Coordenada coordenadaInicialRatchet = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			ratchet.cambiarModo();
			tablero.colocarSuperficieEnTablero(new SuperficieNubes(), coordenadaSuperficie);
			tablero.colocarEnTablero(ratchet, coordenadaInicialRatchet);
			//Los efectos se aplican al final de cada turno
			ratchet.moverse(coordenadaSuperficie,tablero);	
			ratchet.terminaTurno();
			Coordenada coordenadaFinalRatchet = new Coordenada(4,4);
			ratchet.moverse(coordenadaFinalRatchet, tablero);
			assertEquals(tablero.obtenerCoordenadaDeHabitable(ratchet), coordenadaFinalRatchet);
	}
	
	@Test
	public void test31FrenzyHumanoideAtraviesaSuperficieRocosa(){
			Tablero tablero = new Tablero(10,10);
			Frenzy frenzy = new Frenzy();
			Coordenada coordenadaInicialFrenzy = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			tablero.colocarSuperficieEnTablero(new SuperficieNubes(), coordenadaSuperficie);
			tablero.colocarEnTablero(frenzy, coordenadaInicialFrenzy);
			//Los efectos se aplican al final de cada turno
			frenzy.moverse(coordenadaSuperficie,tablero);	
			frenzy.terminaTurno();
			Coordenada coordenadaFinalFrenzy = new Coordenada(4,4);
			frenzy.moverse(coordenadaFinalFrenzy, tablero);
			assertEquals(tablero.obtenerCoordenadaDeHabitable(frenzy), coordenadaFinalFrenzy);
	}
	
	@Test
	public void test32FrenzyAlternoAtraviesaSuperficieRocosa(){
			Tablero tablero = new Tablero(10,10);
			Frenzy frenzy = new Frenzy();
			frenzy.cambiarModo();
			Coordenada coordenadaInicialFrenzy = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			tablero.colocarSuperficieEnTablero(new SuperficieNubes(), coordenadaSuperficie);
			tablero.colocarEnTablero(frenzy, coordenadaInicialFrenzy);
			//Los efectos se aplican al final de cada turno
			frenzy.moverse(coordenadaSuperficie,tablero);	
			frenzy.terminaTurno();
			Coordenada coordenadaFinalFrenzy = new Coordenada(4,4);
			frenzy.moverse(coordenadaFinalFrenzy, tablero);
			assertEquals(tablero.obtenerCoordenadaDeHabitable(frenzy), coordenadaFinalFrenzy);
	}
	
	//NEBULOSA ANDROMEDA UNIDAD AEREA QUEDA ATRAPADA 3 TURNOS
	@Test
	public void test32RatchetHumanoideQuedaAtrapado3TurnosSuperficieAndromeda(){
			Tablero tablero = new Tablero(10,10);
			Ratchet ratchet = new Ratchet();
			Coordenada coordenadaInicialRatchet = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			tablero.colocarSuperficieEnTablero(new SuperficieAndromeda(), coordenadaSuperficie);
			tablero.colocarEnTablero(ratchet, coordenadaInicialRatchet);
			//Los efectos se aplican al final de cada turno
			ratchet.moverse(coordenadaSuperficie,tablero);	
			ratchet.terminaTurno();
			Coordenada coordenadaFinalRatchet = new Coordenada(4,4);
			//primer turno
			try{
				ratchet.moverse(coordenadaFinalRatchet, tablero);
				throw new FailTestException();
			}
			catch(Throwable MovimientoInvalidoException){
			}
			ratchet.terminaTurno();
			//segundo turno
			try{
				ratchet.moverse(coordenadaFinalRatchet, tablero);
				throw new FailTestException();
			}
			catch(Throwable MovimientoInvalidoException){
			}
			ratchet.terminaTurno();
			//tercer turno
			try{
				ratchet.moverse(coordenadaFinalRatchet, tablero);
				throw new FailTestException();
			}
			catch(Throwable MovimientoInvalidoException){
			}
			ratchet.terminaTurno();
			//cuarto turno, se puede mover
			ratchet.moverse(coordenadaFinalRatchet, tablero);
			assertEquals(tablero.obtenerCoordenadaDeHabitable(ratchet), coordenadaFinalRatchet);
	}
	
	@Test
	public void test33RatchetAlternoQuedaAtrapado3TurnosSuperficieAndromeda(){
		Tablero tablero = new Tablero(10,10);
		Ratchet ratchet = new Ratchet();
		ratchet.cambiarModo();
		Coordenada coordenadaInicialRatchet = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficieAndromeda(), coordenadaSuperficie);
		tablero.colocarEnTablero(ratchet, coordenadaInicialRatchet);
		//Los efectos se aplican al final de cada turno
		ratchet.moverse(coordenadaSuperficie,tablero);	
		ratchet.terminaTurno();
		Coordenada coordenadaFinalRatchet = new Coordenada(4,4);
		//primer turno
		try{
			ratchet.moverse(coordenadaFinalRatchet, tablero);
			throw new FailTestException();
		}
		catch(Throwable MovimientoInvalidoException){
		}
		ratchet.terminaTurno();
		//segundo turno
		try{
			ratchet.moverse(coordenadaFinalRatchet, tablero);
			throw new FailTestException();
		}
		catch(Throwable MovimientoInvalidoException){
		}
		ratchet.terminaTurno();
		//tercer turno
		try{
			ratchet.moverse(coordenadaFinalRatchet, tablero);
			throw new FailTestException();
		}
		catch(Throwable MovimientoInvalidoException){
		}
		ratchet.terminaTurno();
		//cuarto turno, se puede mover
		ratchet.moverse(coordenadaFinalRatchet, tablero);
		assertEquals(tablero.obtenerCoordenadaDeHabitable(ratchet), coordenadaFinalRatchet);
	}
	
	@Test
	public void test34FrenzyHumanoideQuedaAtrapado3TurnosSuperficieAndromeda(){
		Tablero tablero = new Tablero(10,10);
		Frenzy frenzy = new Frenzy();
		Coordenada coordenadaInicialFrenzy = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficieAndromeda(), coordenadaSuperficie);
		tablero.colocarEnTablero(frenzy, coordenadaInicialFrenzy);
		//Los efectos se aplican al final de cada turno
		frenzy.moverse(coordenadaSuperficie,tablero);	
		frenzy.terminaTurno();
		Coordenada coordenadaFinalFrenzy = new Coordenada(4,4);
		//primer turno
		try{
			frenzy.moverse(coordenadaFinalFrenzy, tablero);
			throw new FailTestException();
		}
		catch(Throwable MovimientoInvalidoException){
		}
		frenzy.terminaTurno();
		//segundo turno
		try{
			frenzy.moverse(coordenadaFinalFrenzy, tablero);
			throw new FailTestException();
		}
		catch(Throwable MovimientoInvalidoException){
		}
		frenzy.terminaTurno();
		//tercer turno
		try{
			frenzy.moverse(coordenadaFinalFrenzy, tablero);
			throw new FailTestException();
		}
		catch(Throwable MovimientoInvalidoException){
		}
		frenzy.terminaTurno();
		//cuarto turno, se puede mover
		frenzy.moverse(coordenadaFinalFrenzy, tablero);
		assertEquals(tablero.obtenerCoordenadaDeHabitable(frenzy), coordenadaFinalFrenzy);
	}	
	
	@Test
	public void test35FrenzyAlternoQuedaAtrapado3TurnosSuperficieAndromeda(){
		Tablero tablero = new Tablero(10,10);
		Frenzy frenzy = new Frenzy();
		frenzy.cambiarModo();
		Coordenada coordenadaInicialFrenzy = new Coordenada(3,3);
		Coordenada coordenadaSuperficie = new Coordenada(3,4);
		tablero.colocarSuperficieEnTablero(new SuperficieAndromeda(), coordenadaSuperficie);
		tablero.colocarEnTablero(frenzy, coordenadaInicialFrenzy);
		//Los efectos se aplican al final de cada turno
		frenzy.moverse(coordenadaSuperficie,tablero);	
		frenzy.terminaTurno();
		Coordenada coordenadaFinalFrenzy = new Coordenada(4,4);
		//primer turno
		try{
			frenzy.moverse(coordenadaFinalFrenzy, tablero);
			throw new FailTestException();
		}
		catch(Throwable MovimientoInvalidoException){
		}
		frenzy.terminaTurno();
		//segundo turno
		try{
			frenzy.moverse(coordenadaFinalFrenzy, tablero);
			throw new FailTestException();
		}
		catch(Throwable MovimientoInvalidoException){
		}
		frenzy.terminaTurno();
		//tercer turno
		try{
			frenzy.moverse(coordenadaFinalFrenzy, tablero);
			throw new FailTestException();
		}
		catch(Throwable MovimientoInvalidoException){
		}
		frenzy.terminaTurno();
		//cuarto turno, se puede mover
		frenzy.moverse(coordenadaFinalFrenzy, tablero);
		assertEquals(tablero.obtenerCoordenadaDeHabitable(frenzy), coordenadaFinalFrenzy);
	}	
	
	//TORMENTA PSIONICA UNIDAD AEREA PASA UNA VEZ Y PIERDE ATAQUE, PASA OTRA VEZ Y NO LO AFECTA
	@Test
	public void test36RatchetHumanoideEnTormentaPsionicaNoPierdeAtaque(){
			Tablero tablero = new Tablero(10,10);
			Ratchet ratchet = new Ratchet();
			
			Coordenada coordenadaInicialRatchet = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			
			tablero.colocarSuperficieEnTablero(new SuperficiePsionica(), coordenadaSuperficie);
			tablero.colocarEnTablero(ratchet, coordenadaInicialRatchet);
			
			//Los efectos se aplican al final de cada turno
			
			int ataqueInicial = ratchet.verAtaque();
			
			ratchet.moverse(coordenadaSuperficie,tablero);
			
			ratchet.terminaTurno();
			
			Coordenada coordenadaFinalRatchet = new Coordenada(4,4);
			
			ratchet.moverse(coordenadaFinalRatchet, tablero);
			
			assertEquals(ratchet.verAtaque(), ataqueInicial);
	}
	
	@Test
	public void test37RatchetAlternoEnTormentaPsionicaPierdeAtaque(){
			Tablero tablero = new Tablero(10,10);
			Ratchet ratchet = new Ratchet();
			ratchet.cambiarModo();
			
			Coordenada coordenadaInicialRatchet = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			
			tablero.colocarSuperficieEnTablero(new SuperficiePsionica(), coordenadaSuperficie);
			tablero.colocarEnTablero(ratchet, coordenadaInicialRatchet);
			
			//Los efectos se aplican al final de cada turno
			
			int ataqueInicial = ratchet.verAtaque();
			int ataqueDisminuido = (int)(ataqueInicial*0.4);
			
			ratchet.moverse(coordenadaSuperficie,tablero);
			
			ratchet.terminaTurno();
			
			Coordenada coordenadaFinalRatchet = new Coordenada(4,4);
			
			ratchet.moverse(coordenadaFinalRatchet, tablero);
			
			ratchet.terminaTurno();
			
			assertEquals(ratchet.verAtaque(), ataqueDisminuido);
			
			ratchet.moverse(coordenadaSuperficie, tablero);
			
			ratchet.terminaTurno();
			
			ratchet.moverse(coordenadaInicialRatchet, tablero);
			
			ratchet.terminaTurno();
			
			assertEquals(ratchet.verAtaque(), ataqueDisminuido);
	}
	
	@Test
	public void test38FrenzyHumanoideEnTormentaPsionicaNoPierdeAtaque(){
			Tablero tablero = new Tablero(10,10);
			Frenzy frenzy = new Frenzy();
			
			Coordenada coordenadaInicialFrenzy = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			
			tablero.colocarSuperficieEnTablero(new SuperficiePsionica(), coordenadaSuperficie);
			tablero.colocarEnTablero(frenzy, coordenadaInicialFrenzy);
			
			//Los efectos se aplican al final de cada turno
			
			int ataqueInicial = frenzy.verAtaque();
			
			frenzy.moverse(coordenadaSuperficie,tablero);
			
			frenzy.terminaTurno();
			
			Coordenada coordenadaFinalFrenzy = new Coordenada(4,4);
			
			frenzy.moverse(coordenadaFinalFrenzy, tablero);
			
			assertEquals(frenzy.verAtaque(), ataqueInicial);
	}
	
	@Test
	public void test39FrenzyAlternoEnTormentaPsionicaPierdeAtaque(){
			Tablero tablero = new Tablero(10,10);
			Frenzy frenzy = new Frenzy();
			frenzy.cambiarModo();
			
			Coordenada coordenadaInicialFrenzy = new Coordenada(3,3);
			Coordenada coordenadaSuperficie = new Coordenada(3,4);
			
			tablero.colocarSuperficieEnTablero(new SuperficiePsionica(), coordenadaSuperficie);
			tablero.colocarEnTablero(frenzy, coordenadaInicialFrenzy);
			
			//Los efectos se aplican al final de cada turno
			
			int ataqueInicial = frenzy.verAtaque();
			int ataqueDisminuido = (int)(ataqueInicial*0.4);
			
			frenzy.moverse(coordenadaSuperficie,tablero);
			
			frenzy.terminaTurno();
			
			Coordenada coordenadaFinalFrenzy = new Coordenada(4,4);
			
			frenzy.moverse(coordenadaFinalFrenzy, tablero);
			
			frenzy.terminaTurno();
			
			assertEquals(frenzy.verAtaque(), ataqueDisminuido);
			
			frenzy.moverse(coordenadaSuperficie, tablero);
			
			frenzy.terminaTurno();
			
			frenzy.moverse(coordenadaInicialFrenzy, tablero);
			
			frenzy.terminaTurno();
			
			assertEquals(frenzy.verAtaque(), ataqueDisminuido);
	}}
