package fiuba.algo3.algoFormers.BonusTests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.Habitables.BurbujaInmaculada;
import fiuba.algo3.algoFormers.Habitables.DobleCanion;
import fiuba.algo3.algoFormers.Habitables.Flash;
import fiuba.algo3.algoFormers.Tablero.*;
import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.decepticons.*;
import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;

public class BonusTests{

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
		
		bumblebee.moverse(coordBonus, tablero);
		
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
		
		assertEquals(optimus.verAtaque(), 100);
		
		optimus.moverse(coordenadaInicialDobleCanion2, tablero);
		
		assertEquals(optimus.verAtaque(), 100);
	}
	
}