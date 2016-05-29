package fiuba.algo3.algoFormers.JuegoTests;
import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.Juego.Juego;
import fiuba.algo3.algoFormers.Juego.Jugador;

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
	
	
}
