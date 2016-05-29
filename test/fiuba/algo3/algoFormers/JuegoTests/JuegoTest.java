package fiuba.algo3.algoFormers.JuegoTests;
import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.Juego.Juego;
import fiuba.algo3.algoFormers.Juego.Jugador;
import junit.framework.Assert;

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
		Assert.assertTrue(juego.seUbicoALosPersonajes());	
	}
	
	@Test
	public void test03UbicarChispa(){
		Juego juego = new Juego();
		Boolean encontro = false;
		for(int i=9;i<12;i++){
			for(int j=9;j<12;j++){
				if(juego.estaLaChispa(i,j)){
					encontro = true;
				}
			}
		}
		Assert.assertTrue(encontro);
	}
}
