package fiuba.algo3.algoFormers.JuegoTests;
import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.juego.Juego;
import fiuba.algo3.algoFormers.juego.Jugador;
import fiuba.algo3.algoFormers.tablero.Coordenada;

public class JuegoTest{

	@Test
	public void test01JuegoCambiaDeTurnoCuandoSeLoPide(){
		Juego juego = new Juego();
		Jugador jugador1 = juego.obtenerJugadorActual();
		juego.cambiarTurno();
		Jugador jugador2 = juego.obtenerJugadorActual();
		juego.cambiarTurno();
		Jugador jugador3 = juego.obtenerJugadorActual();
		juego.cambiarTurno();
		Jugador jugador4 = juego.obtenerJugadorActual();
		
		assertEquals(jugador1,jugador3);
		assertEquals(jugador2,jugador4);
	}

	@Test
	public void test02UbicarPersonajes(){
		Juego juego = new Juego ();
		assertTrue(juego.seUbicoALosPersonajes());	
	}
	
	@Test
	public void test03UbicarChispa(){
		Juego juego = new Juego();
		assertTrue(juego.estaLaChispa());
	}
	
	@Test 
	public void test04UbicarBonus(){
		Juego juego = new Juego();
		assertTrue(juego.seUbicoALosBonus());
	}
	
	@Test
	public void test05AlgoformerCapturaChispaYTerminaElJuego(){
		Juego juego = new Juego();
		juego.capturarChispa();
		assertTrue(juego.estaTerminado());
	}
	
	@Test
	public void test06EquipoEsVencidoYTerminaElJuego(){
		Juego juego = new Juego();
		juego.hacerGanarEquipo();
		assertTrue(juego.estaTerminado());
	}
}
