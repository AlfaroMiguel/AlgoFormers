package fiuba.algo3.algoFormers.JuegoTests;

import junit.framework.Assert;
import org.junit.Test;

import fiuba.algo3.algoFormers.Juego.Autobots;
import fiuba.algo3.algoFormers.Juego.Equipo;
import fiuba.algo3.algoFormers.Juego.Jugador;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.decepticons.*;



public class JugadorTest {
	/*
	@Test
	public void test01UnJugadorAtacaConSuTransformerAOtroDeOtroEauipo(){
	Autobots autobots = new Autobots();
	Jugador jugador = new Jugador(autobots);
	Tablero tablero = new Tablero (10,10);
	//Esto de aca se haria con el equipo pero no esta hecho
	Optimus optimus = new Optimus();
	Frenzy frenzy = new Frenzy();
	
	Coordenada coordenadaOptimus= new Coordenada(2,3);
	Coordenada coordenadaFrenzy = new Coordenada(2,5);
	tablero.put(optimus, coordenadaOptimus);
	tablero.put(frenzy, coordenadaFrenzy);
	
	jugador.atacar(optimus, coordenadaFrenzy);
	Assert.assertEquals(frenzy.verVida(),350);
	}
	
	@Test
	public void test02UnJugadorMueveASuTransformerHumanoide(){
	Autobots autobots = new Autobots();
	Jugador jugador = new Jugador(autobots);
	Tablero tablero = new Tablero (10,10);
	//Esto de aca se haria con el equipo pero no esta hecho
	Optimus optimus = new Optimus();
	
	Coordenada coordenada = new Coordenada(2,3);
	Coordenada nuevaCoordenada= new Coordenada(2,1);
	tablero.put(optimus, coordenada); 
	jugador.mover(optimus, nuevaCoordenada);
	
	Assert.assertTrue(tablero.getKeyValue(optimus)==nuevaCoordenada);
	}
	
	@Test
	public void test03UnJugadorMueveASuTransformerAlterno(){
	Equipo equipoAutobots = new Autobots();
	Jugador jugador = new Jugador(equipoAutobots);
	Tablero tablero = new Tablero (10,10);
	//Esto de aca se haria con el equipo pero no esta hecho
	Optimus optimus = new Optimus();
	optimus.cambiarModo();
	// supongo que esto seria un jugador.seleccionar optimus
	// y jugador.transformar Optimus ??
	
	
	Coordenada coordenada = new Coordenada(2,3);
	Coordenada nuevaCoordenada= new Coordenada(2,8);
	tablero.put(optimus, coordenada); 
	jugador.mover(optimus, nuevaCoordenada);
	
	Assert.assertTrue(tablero.getKeyValue(optimus)==nuevaCoordenada);
	}
	*/
}
