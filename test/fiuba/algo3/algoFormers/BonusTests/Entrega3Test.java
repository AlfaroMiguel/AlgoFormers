package fiuba.algo3.algoFormers.BonusTests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.decepticons.*;
import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.habitables.BonusVacio;
import fiuba.algo3.algoFormers.habitables.BurbujaInmaculada;
import fiuba.algo3.algoFormers.habitables.DobleCanion;
import fiuba.algo3.algoFormers.habitables.Flash;
import fiuba.algo3.algoFormers.tablero.*;

public class Entrega3Test{

	@Test
	public void test01AlgoformerHumanoideAtacaConDobleCanionAOtroAlgoformerPorTresTurnos() {
		Tablero tablero = new Tablero(10,10);
		
		Optimus optimus = new Optimus();
		DobleCanion dobleCanion = new DobleCanion();
		Megatron megatron = new Megatron();
		
		Coordenada coordenadaInicialOptimus = new Coordenada(3,4);
		Coordenada coordenadaInicialMegatron = new Coordenada(3,6);
		Coordenada coordenadaInicialDobleCanion = new Coordenada(3,5);
		
		tablero.colocarEnTablero(optimus, coordenadaInicialOptimus);
		tablero.colocarEnTablero(megatron, coordenadaInicialMegatron);
		tablero.colocarEnTablero(dobleCanion, coordenadaInicialDobleCanion);
		
		// vida inicial megatron 550
		//ataque inicial optimus humanoide 50
		
		optimus.moverse(coordenadaInicialDobleCanion, tablero);
		optimus.terminaTurno();
		
		//primer turno
		optimus.atacar(tablero, megatron);
		optimus.terminaTurno();
		
		assertEquals(optimus.verAtaque(), 100);
		assertEquals(megatron.verVida(), 450);
		
		//segundo turno
		optimus.atacar(tablero, megatron);
		optimus.terminaTurno();
		
		assertEquals(optimus.verAtaque(), 100);
		assertEquals(megatron.verVida(), 350);
		
		//tercer turno
		optimus.atacar(tablero, megatron);
		optimus.terminaTurno();
		
		assertEquals(optimus.verAtaque(), 50);
		assertEquals(megatron.verVida(), 250);
		
		//cuarto turno
		optimus.atacar(tablero, megatron);
		optimus.terminaTurno();
		
		assertEquals(optimus.verAtaque(), 50);
		assertEquals(megatron.verVida(), 200);	
	}
	
	@Test
	public void test02AlgoformerAlternoAtacaConDobleCanionAOtroAlgoformerPorTresTurnos() {
		Tablero tablero = new Tablero(10,10);
		
		Optimus optimus = new Optimus();
		DobleCanion dobleCanion = new DobleCanion();
		Megatron megatron = new Megatron();
		
		optimus.cambiarModo();
		
		Coordenada coordenadaInicialOptimus = new Coordenada(3,4);
		Coordenada coordenadaInicialMegatron = new Coordenada(3,6);
		Coordenada coordenadaInicialDobleCanion = new Coordenada(3,5);
		
		tablero.colocarEnTablero(optimus, coordenadaInicialOptimus);
		tablero.colocarEnTablero(megatron, coordenadaInicialMegatron);
		tablero.colocarEnTablero(dobleCanion, coordenadaInicialDobleCanion);
		
		// vida inicial megatron 550
		//ataque inicial optimus alterno 15
		
		optimus.moverse(coordenadaInicialDobleCanion, tablero);
		optimus.terminaTurno();
		
		//primer turno
		optimus.atacar(tablero, megatron);
		optimus.terminaTurno();
		
		assertEquals(optimus.verAtaque(), 30);
		assertEquals(megatron.verVida(), 520);
		
		//segundo turno
		optimus.atacar(tablero, megatron);
		optimus.terminaTurno();
		
		assertEquals(optimus.verAtaque(), 30);
		assertEquals(megatron.verVida(), 490);
		
		//tercer turno
		optimus.atacar(tablero, megatron);
		optimus.terminaTurno();
		
		assertEquals(optimus.verAtaque(), 15);
		assertEquals(megatron.verVida(), 460);
		
		//cuarto turno
		optimus.atacar(tablero, megatron);
		optimus.terminaTurno();
		
		assertEquals(optimus.verAtaque(), 15);
		assertEquals(megatron.verVida(), 445);	
	}
	
	@Test
	public void test03AlgoformerCambiandoModoAtacaConDobleCanionAOtroAlgoformerPorTresTurnos() {
		Tablero tablero = new Tablero(10,10);
		
		Optimus optimus = new Optimus();
		DobleCanion dobleCanion = new DobleCanion();
		Megatron megatron = new Megatron();
		
		Coordenada coordenadaInicialOptimus = new Coordenada(3,4);
		Coordenada coordenadaInicialMegatron = new Coordenada(3,6);
		Coordenada coordenadaInicialDobleCanion = new Coordenada(3,5);
		
		tablero.colocarEnTablero(optimus, coordenadaInicialOptimus);
		tablero.colocarEnTablero(megatron, coordenadaInicialMegatron);
		tablero.colocarEnTablero(dobleCanion, coordenadaInicialDobleCanion);
		
		// vida inicial megatron 550
		//ataque inicial optimus 50
		
		optimus.moverse(coordenadaInicialDobleCanion, tablero);
		optimus.terminaTurno();
		
		//primer turno
		optimus.atacar(tablero, megatron);
		optimus.terminaTurno();
		
		assertEquals(optimus.verAtaque(), 100);
		assertEquals(megatron.verVida(), 450);
		
		//segundo turno
		optimus.cambiarModo();
		optimus.atacar(tablero, megatron);
		optimus.terminaTurno();
		
		assertEquals(optimus.verAtaque(), 30);
		assertEquals(megatron.verVida(), 420);
		
		//tercer turno
		optimus.cambiarModo();
		optimus.atacar(tablero, megatron);
		optimus.terminaTurno();
		
		assertEquals(optimus.verAtaque(), 50);
		assertEquals(megatron.verVida(), 320);
		
		//cuarto turno
		optimus.atacar(tablero, megatron);
		optimus.terminaTurno();
		
		assertEquals(optimus.verAtaque(), 50);
		assertEquals(megatron.verVida(), 270);	
	}
	
	@Test
	public void test04AlgoformerHumanoideEsAtacadoConBurbujaInmaculadaAOtroAlgoformerPorDosTurnos() {
		Tablero tablero = new Tablero(10,10);
		
		Optimus optimus = new Optimus();
		BurbujaInmaculada burbujaInmaculada = new BurbujaInmaculada();
		Megatron megatron = new Megatron();
		
		Coordenada coordenadaInicialOptimus = new Coordenada(3,4);
		Coordenada coordenadaInicialMegatron = new Coordenada(3,6);
		Coordenada coordenadaInicialBurbujaInmaculada = new Coordenada(3,5);
		
		tablero.colocarEnTablero(optimus, coordenadaInicialOptimus);
		tablero.colocarEnTablero(megatron, coordenadaInicialMegatron);
		tablero.colocarEnTablero(burbujaInmaculada, coordenadaInicialBurbujaInmaculada);
		
		// vida inicial optimus 500
		// ataque megatron humanoide 10
		
		optimus.moverse(coordenadaInicialBurbujaInmaculada, tablero);
		optimus.terminaTurno();
		
		//primer turno
		megatron.atacar(tablero, optimus);
		optimus.terminaTurno();
		
		assertEquals(optimus.verVida(), 500);
		
		//segundo turno
		megatron.atacar(tablero, optimus);
		optimus.terminaTurno();
		
		assertEquals(optimus.verVida(), 500);
		
		//tercer turno
		megatron.atacar(tablero, optimus);
		optimus.terminaTurno();
		
		assertEquals(optimus.verVida(), 490);
	}
	
	@Test
	public void test05AlgoformerAlternoEsAtacadoConBurbujaInmaculadaAOtroAlgoformerPorDosTurnos() {
		Tablero tablero = new Tablero(10,10);
		
		Optimus optimus = new Optimus();
		BurbujaInmaculada burbujaInmaculada = new BurbujaInmaculada();
		Megatron megatron = new Megatron();
		
		optimus.cambiarModo();
		
		Coordenada coordenadaInicialOptimus = new Coordenada(3,4);
		Coordenada coordenadaInicialMegatron = new Coordenada(3,6);
		Coordenada coordenadaInicialBurbujaInmaculada = new Coordenada(3,5);
		
		tablero.colocarEnTablero(optimus, coordenadaInicialOptimus);
		tablero.colocarEnTablero(megatron, coordenadaInicialMegatron);
		tablero.colocarEnTablero(burbujaInmaculada, coordenadaInicialBurbujaInmaculada);
		
		// vida inicial optimus 500
		// ataque megatron humanoide 10
		
		optimus.moverse(coordenadaInicialBurbujaInmaculada, tablero);
		optimus.terminaTurno();
		
		//primer turno
		megatron.atacar(tablero, optimus);
		optimus.terminaTurno();
		
		assertEquals(optimus.verVida(), 500);
		
		//segundo turno
		megatron.atacar(tablero, optimus);
		optimus.terminaTurno();
		
		assertEquals(optimus.verVida(), 500);
		
		//tercer turno
		megatron.atacar(tablero, optimus);
		optimus.terminaTurno();
		
		assertEquals(optimus.verVida(), 490);
	}
	
	@Test
	public void test06AlgoformerCambiandoModoEsAtacadoConBurbujaInmaculadaAOtroAlgoformerPorDosTurnos() {
		Tablero tablero = new Tablero(10,10);
		
		Optimus optimus = new Optimus();
		BurbujaInmaculada burbujaInmaculada = new BurbujaInmaculada();
		Megatron megatron = new Megatron();
		
		Coordenada coordenadaInicialOptimus = new Coordenada(3,4);
		Coordenada coordenadaInicialMegatron = new Coordenada(3,6);
		Coordenada coordenadaInicialBurbujaInmaculada = new Coordenada(3,5);
		
		tablero.colocarEnTablero(optimus, coordenadaInicialOptimus);
		tablero.colocarEnTablero(megatron, coordenadaInicialMegatron);
		tablero.colocarEnTablero(burbujaInmaculada, coordenadaInicialBurbujaInmaculada);
		
		// vida inicial optimus 500
		// ataque megatron humanoide 10
		
		optimus.moverse(coordenadaInicialBurbujaInmaculada, tablero);
		optimus.terminaTurno();
		
		optimus.cambiarModo();
		//primer turno
		megatron.atacar(tablero, optimus);
		optimus.terminaTurno();
		
		assertEquals(optimus.verVida(), 500);
		
		//segundo turno
		megatron.atacar(tablero, optimus);
		optimus.terminaTurno();
		
		assertEquals(optimus.verVida(), 500);
		
		//tercer turno
		optimus.cambiarModo();
		megatron.atacar(tablero, optimus);
		optimus.terminaTurno();
		
		assertEquals(optimus.verVida(), 490);
	}
	
	@Test
	public void test07AlgoformerHumanoideSeMueve3VecesMasRapidoConBonusFlashPor3Turnos(){
		Tablero tablero = new Tablero(20,20);
		
		//Bumblebee tiene velocidad 2
		
		Bumblebee bumblebee = new Bumblebee();
		Flash flash = new Flash();
		
		Coordenada coordInicialBumblebee = new Coordenada(2,4);
		Coordenada coordBonus = new Coordenada (2,6);
		
		tablero.colocarEnTablero(bumblebee, coordInicialBumblebee);
		tablero.colocarEnTablero(flash, coordBonus);
		
		bumblebee.moverse(coordBonus, tablero);
		bumblebee.terminaTurno();
		
		// Bumblebee tiene velocidad 6 con el Bonus
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordBonus), bumblebee);
		
		Coordenada coordPaso = new Coordenada(2,12);
		
		//Primer turno
		
		bumblebee.moverse(coordPaso, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso), bumblebee);
		
		//Segundo turno
		
		bumblebee.moverse(coordBonus, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordBonus), bumblebee);
		
		//Tercer turno
		
		bumblebee.moverse(coordPaso, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso), bumblebee);
		
	}
	
	@Test(expected = MovimientoInvalidoException.class)
	public void test08AlgoformerHumanoideSeMueve3VecesMasRapidoConBonusFlashPor3TurnosYDespuesNoPuede(){
		Tablero tablero = new Tablero(20,20);
		
		//Bumblebee tiene velocidad 2
		
		Bumblebee bumblebee = new Bumblebee();
		Flash flash = new Flash();
		
		Coordenada coordInicialBumblebee = new Coordenada(2,4);
		Coordenada coordBonus = new Coordenada(2,6);
		
		tablero.colocarEnTablero(bumblebee, coordInicialBumblebee);
		tablero.colocarEnTablero(flash, coordBonus);
		
		bumblebee.moverse(coordBonus, tablero);
		bumblebee.terminaTurno();
		
		// Bumblebee tiene velocidad 6 con el Bonus
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordBonus), bumblebee);
		
		Coordenada coordPaso = new Coordenada(2,12);
		
		//Primer turno
		
		bumblebee.moverse(coordPaso, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso), bumblebee);
		
		//Segundo turno
		
		bumblebee.moverse(coordBonus, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordBonus), bumblebee);
		
		//Tercer turno
		
		bumblebee.moverse(coordPaso, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso), bumblebee);
		
		//Cuarto turno (No tiene el bonus activado no llega a la coordenada del bonus)
		bumblebee.moverse(coordBonus, tablero);
	}
	
	@Test
	public void test09AlgoformerHumanoideSeMueve3VecesMasRapidoConBonusFlashPor3TurnosYDespuesPuedeMoverseNormalmente(){
		Tablero tablero = new Tablero(20,20);
		
		//Bumblebee tiene velocidad 2
		
		Bumblebee bumblebee = new Bumblebee();
		Flash flash = new Flash();
		
		Coordenada coordInicialBumblebee = new Coordenada(2,4);
		Coordenada coordBonus = new Coordenada (2,6);
		
		tablero.colocarEnTablero(bumblebee, coordInicialBumblebee);
		tablero.colocarEnTablero(flash, coordBonus);
		
		bumblebee.moverse(coordBonus, tablero);
		bumblebee.terminaTurno();
		
		// Bumblebee tiene velocidad 6 con el Bonus
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordBonus), bumblebee);
		
		Coordenada coordPaso = new Coordenada(2,12);
		
		//Primer turno
		
		bumblebee.moverse(coordPaso, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso), bumblebee);
		
		//Segundo turno
		
		bumblebee.moverse(coordBonus, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordBonus), bumblebee);
		
		//Tercer turno
		
		bumblebee.moverse(coordPaso, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso), bumblebee);
		
		//Cuarto turno (No tiene el bonus activado se puede mover con velocidad 2)
		
		Coordenada coordPaso2 = new Coordenada(2,10);
		
		bumblebee.moverse(coordPaso2, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso2), bumblebee);	
	}
	
	@Test
	public void test10AlgoformerAlternoSeMueve3VecesMasRapidoConBonusFlashPor3Turnos(){
		Tablero tablero = new Tablero(20,20);
		
		//Bumblebee tiene velocidad 2
		
		Bumblebee bumblebee = new Bumblebee();
		bumblebee.cambiarModo();
		Flash flash = new Flash();
		
		Coordenada coordInicialBumblebee = new Coordenada(2,4);
		Coordenada coordBonus = new Coordenada (2,6);
		
		tablero.colocarEnTablero(bumblebee, coordInicialBumblebee);
		tablero.colocarEnTablero(flash, coordBonus);
		
		bumblebee.moverse(coordBonus, tablero);
		bumblebee.terminaTurno();
		
		// Bumblebee tiene velocidad 6 con el Bonus
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordBonus), bumblebee);
		
		Coordenada coordPaso = new Coordenada(2,12);
		
		//Primer turno
		
		bumblebee.moverse(coordPaso, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso), bumblebee);
		
		//Segundo turno
		
		bumblebee.moverse(coordBonus, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordBonus), bumblebee);
		
		//Tercer turno
		
		bumblebee.moverse(coordPaso, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso), bumblebee);
		
	}
	
	@Test(expected = MovimientoInvalidoException.class)
	public void test11AlgoformerAlternoSeMueve3VecesMasRapidoConBonusFlashPor3TurnosYDespuesNoPuede(){
		Tablero tablero = new Tablero(20,20);
		
		//Bumblebee tiene velocidad 2
		
		Bumblebee bumblebee = new Bumblebee();
		bumblebee.cambiarModo();
		Flash flash = new Flash();
		
		Coordenada coordInicialBumblebee = new Coordenada(2,4);
		Coordenada coordBonus = new Coordenada (2,6);
		
		tablero.colocarEnTablero(bumblebee, coordInicialBumblebee);
		tablero.colocarEnTablero(flash, coordBonus);
		
		bumblebee.moverse(coordBonus, tablero);
		bumblebee.terminaTurno();
		
		// Bumblebee tiene velocidad 6 con el Bonus
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordBonus), bumblebee);
		
		Coordenada coordPaso = new Coordenada(2,12);
		
		//Primer turno
		
		bumblebee.moverse(coordPaso, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso), bumblebee);
		
		//Segundo turno
		
		bumblebee.moverse(coordBonus, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordBonus), bumblebee);
		
		//Tercer turno
		
		bumblebee.moverse(coordPaso, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso), bumblebee);
		
		//Cuarto turno (No tiene el bonus activado no llega a la coordenada del bonus)
		
		bumblebee.moverse(coordBonus, tablero);
		
	}
	
	@Test
	public void test12AlgoformerAlternoSeMueve3VecesMasRapidoConBonusFlashPor3TurnosYDespuesPuedeMoverseNormalmente(){
		Tablero tablero = new Tablero(20,20);
		
		//Bumblebee tiene velocidad 2
		
		Bumblebee bumblebee = new Bumblebee();
		bumblebee.cambiarModo();
		Flash flash = new Flash();
		
		Coordenada coordInicialBumblebee = new Coordenada(2,4);
		Coordenada coordBonus = new Coordenada (2,6);
		
		tablero.colocarEnTablero(bumblebee, coordInicialBumblebee);
		tablero.colocarEnTablero(flash, coordBonus);
		
		bumblebee.moverse(coordBonus, tablero);
		bumblebee.terminaTurno();
		
		// Bumblebee tiene velocidad 6 con el Bonus
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordBonus), bumblebee);
		
		Coordenada coordPaso = new Coordenada(2,12);
		
		//Primer turno
		
		bumblebee.moverse(coordPaso, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso), bumblebee);
		
		//Segundo turno
		
		bumblebee.moverse(coordBonus, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordBonus), bumblebee);
		
		//Tercer turno
		
		bumblebee.moverse(coordPaso, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso), bumblebee);
		
		//Cuarto turno (No tiene el bonus activado se puede mover con velocidad 2)
		
		Coordenada coordPaso2 = new Coordenada(2,10);
		
		bumblebee.moverse(coordPaso2, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso2), bumblebee);	
	}
	
	@Test
	public void test13AlgoformerCambiandoModoSeMueve3VecesMasRapidoConBonusFlashPor3Turnos(){
		Tablero tablero = new Tablero(20,20);
		
		//Bumblebee tiene velocidad 2
		
		Bumblebee bumblebee = new Bumblebee();
		Flash flash = new Flash();
		
		Coordenada coordInicialBumblebee = new Coordenada(2,4);
		Coordenada coordBonus = new Coordenada (2,6);
		
		tablero.colocarEnTablero(bumblebee, coordInicialBumblebee);
		tablero.colocarEnTablero(flash, coordBonus);
		
		bumblebee.moverse(coordBonus, tablero);
		bumblebee.terminaTurno();
		
		// Bumblebee tiene velocidad 6 con el Bonus
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordBonus), bumblebee);
		
		Coordenada coordPaso = new Coordenada(2,12);
		
		//Primer turno
		
		bumblebee.moverse(coordPaso, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso), bumblebee);

		bumblebee.cambiarModo();
		//Segundo turno
		
		bumblebee.moverse(coordBonus, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordBonus), bumblebee);
		
		//Tercer turno

		bumblebee.cambiarModo();
		
		bumblebee.moverse(coordPaso, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso), bumblebee);
		
	}
	
	@Test(expected = MovimientoInvalidoException.class)
	public void test14AlgoformerCambiandoModoSeMueve3VecesMasRapidoConBonusFlashPor3TurnosYDespuesNoPuede(){
		Tablero tablero = new Tablero(20,20);
		
		//Bumblebee tiene velocidad 2
		
		Bumblebee bumblebee = new Bumblebee();

		Flash flash = new Flash();
		
		Coordenada coordInicialBumblebee = new Coordenada(2,4);
		Coordenada coordBonus = new Coordenada (2,6);
		
		tablero.colocarEnTablero(bumblebee, coordInicialBumblebee);
		tablero.colocarEnTablero(flash, coordBonus);
		
		bumblebee.moverse(coordBonus, tablero);
		bumblebee.terminaTurno();
		
		// Bumblebee tiene velocidad 6 con el Bonus
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordBonus), bumblebee);
		
		Coordenada coordPaso = new Coordenada(2,12);
		
		
		//Primer turno
		
		bumblebee.moverse(coordPaso, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso), bumblebee);
		
		//Segundo turno
		
		bumblebee.cambiarModo();
		
		bumblebee.moverse(coordBonus, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordBonus), bumblebee);
		
		//Tercer turno
		
		
		bumblebee.moverse(coordPaso, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso), bumblebee);
		
		//Cuarto turno (No tiene el bonus activado no llega a la coordenada del bonus)
		bumblebee.moverse(new Coordenada(2,1), tablero);
		
		
	}
	
	@Test
	public void test15AlgoformerCambiandoModoSeMueve3VecesMasRapidoConBonusFlashPor3TurnosYDespuesPuedeMoverseNormalmente(){
		Tablero tablero = new Tablero(20,20);
		
		//Bumblebee tiene velocidad 2
		
		Bumblebee bumblebee = new Bumblebee();
		Flash flash = new Flash();
		
		Coordenada coordInicialBumblebee = new Coordenada(2,4);
		Coordenada coordBonus = new Coordenada (2,6);
		
		tablero.colocarEnTablero(bumblebee, coordInicialBumblebee);
		tablero.colocarEnTablero(flash, coordBonus);
		
		bumblebee.moverse(coordBonus, tablero);
		bumblebee.terminaTurno();
		
		// Bumblebee tiene velocidad 6 con el Bonus
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordBonus), bumblebee);
		
		Coordenada coordPaso = new Coordenada(2,12);
		
		//Primer turno
		
		bumblebee.moverse(coordPaso, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso), bumblebee);
		
		//Segundo turno

		bumblebee.cambiarModo();
		
		bumblebee.moverse(coordBonus, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordBonus), bumblebee);
		
		//Tercer turno
		
		bumblebee.cambiarModo();
		
		bumblebee.moverse(coordPaso, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso), bumblebee);
		
		//Cuarto turno (No tiene el bonus activado se puede mover con velocidad 2)
		
		Coordenada coordPaso2 = new Coordenada(2,10);
		
		bumblebee.moverse(coordPaso2, tablero);
		bumblebee.terminaTurno();
		
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordPaso2), bumblebee);	
	}
	
	//CASOS BORDE
	
	@Test
	public void test16NoAgarraBonusSiYaTieneBonusDelMismoTipo(){
		Tablero tablero = new Tablero(10,10);
		
		Optimus optimus = new Optimus();
		DobleCanion dobleCanion1 = new DobleCanion();
		DobleCanion dobleCanion2 = new DobleCanion();
		
		Coordenada coordenadaInicialOptimus = new Coordenada(2,3);
		Coordenada coordenadaInicialDobleCanion1 = new Coordenada(2,4);
		Coordenada coordenadaInicialDobleCanion2 = new Coordenada(2,5);
		tablero.colocarEnTablero(optimus, coordenadaInicialOptimus);
		tablero.colocarEnTablero(dobleCanion1, coordenadaInicialDobleCanion1);
		tablero.colocarEnTablero(dobleCanion2, coordenadaInicialDobleCanion2);
		
		optimus.moverse(coordenadaInicialDobleCanion1, tablero);
		optimus.terminaTurno();
		
		assertEquals(optimus.verAtaque(), 100);
		
		optimus.moverse(coordenadaInicialDobleCanion2, tablero);
		optimus.terminaTurno();
		
		assertEquals(optimus.verAtaque(), 100);
	}
	
	@Test
	public void test17ApenasTerminaEfectoDeBonusSiAgarraOtroBonusTieneEfecto(){
		Tablero tablero = new Tablero(10,10);
			
		Optimus optimus = new Optimus();
		BurbujaInmaculada burbujaInmaculada1 = new BurbujaInmaculada();
		BurbujaInmaculada burbujaInmaculada2 = new BurbujaInmaculada();
		Megatron megatron = new Megatron();
			
		Coordenada coordenadaInicialOptimus = new Coordenada(3,4);
		Coordenada coordenadaInicialMegatron = new Coordenada(3,6);
		Coordenada coordenadaInicialBurbujaInmaculada1 = new Coordenada(3,5);
		Coordenada coordenadaInicialBurbujaInmaculada2 = new Coordenada(4,5);
			
		tablero.colocarEnTablero(optimus, coordenadaInicialOptimus);
		tablero.colocarEnTablero(megatron, coordenadaInicialMegatron);
		tablero.colocarEnTablero(burbujaInmaculada1, coordenadaInicialBurbujaInmaculada1);
		tablero.colocarEnTablero(burbujaInmaculada2, coordenadaInicialBurbujaInmaculada2);
			
			// vida inicial optimus 500
			// ataque megatron humanoide 10
			
		optimus.moverse(coordenadaInicialBurbujaInmaculada1, tablero);
		optimus.terminaTurno();
			
			//primer turno
		megatron.atacar(tablero, optimus);
		optimus.terminaTurno();
			
		assertEquals(optimus.verVida(), 500);
			
			//segundo turno
		megatron.atacar(tablero, optimus);
		optimus.terminaTurno();
			
		assertEquals(optimus.verVida(), 500);
			
			//tercer turno: perdio el anterior bonus, agarra otro.
		megatron.atacar(tablero, optimus);
		optimus.moverse(coordenadaInicialBurbujaInmaculada2, tablero);
		optimus.terminaTurno();
			
		assertEquals(optimus.verVida(), 490);
		
		//cuarto turno: agarro un nuevo bonus, le hace efecto.
		megatron.atacar(tablero, optimus);
		optimus.terminaTurno();
		
		assertEquals(optimus.verVida(), 490);
	}
	
	@Test
	public void test18SiPasaPorUnBonusQueYaTieneEsteNoDesaparece(){
		Tablero tablero = new Tablero(10,10);
		
		Optimus optimus = new Optimus();
		DobleCanion dobleCanion1 = new DobleCanion();
		DobleCanion dobleCanion2 = new DobleCanion();
		
		Coordenada coordenadaInicialOptimus = new Coordenada(2,3);
		Coordenada coordenadaInicialDobleCanion1 = new Coordenada(2,4);
		Coordenada coordenadaInicialDobleCanion2 = new Coordenada(2,5);
		tablero.colocarEnTablero(optimus, coordenadaInicialOptimus);
		tablero.colocarEnTablero(dobleCanion1, coordenadaInicialDobleCanion1);
		tablero.colocarEnTablero(dobleCanion2, coordenadaInicialDobleCanion2);
		
		optimus.moverse(coordenadaInicialDobleCanion1, tablero);
		optimus.terminaTurno();
		
		assertFalse(tablero.obtenerColectableEnCoordenada(coordenadaInicialDobleCanion1)==dobleCanion1);
		
		optimus.moverse(coordenadaInicialDobleCanion2, tablero);
		optimus.terminaTurno();
		
		assertEquals(tablero.obtenerColectableEnCoordenada(coordenadaInicialDobleCanion2),dobleCanion2);
	}
	
	@Test 
	public void test19AgarraUnBonusYEsteDesapareceDelTablero(){
		Tablero tablero = new Tablero(10,10);
		
		Optimus optimus = new Optimus();
		Flash flash = new Flash();
		
		Coordenada coordInicialOptimus = new Coordenada(2,3);
		Coordenada coordFlash = new Coordenada(3,3);
		
		tablero.colocarEnTablero(optimus, coordInicialOptimus);
		tablero.colocarEnTablero(flash, coordFlash);
		
		optimus.moverse(coordFlash, tablero);
		
		assertFalse(tablero.obtenerColectableEnCoordenada(coordFlash)==flash);
	}
	
	@Test //supuesto
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
	
	@Test //supuesto
	public void test21CuandoSeCombinanNoSePasanLosBonusAlAlgoformerCombinado(){
		Tablero tablero = new Tablero(10,10);
		
		Optimus optimus = new Optimus();
		Bumblebee bumblebee = new Bumblebee();
		Ratchet ratchet = new Ratchet();
		BurbujaInmaculada burbuja = new BurbujaInmaculada();
		Megatron megatron = new Megatron();
		
		Coordenada coordInicialOptimus = new Coordenada(0,0);
		Coordenada coordInicialBumblebee = new Coordenada(0,1);
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

}