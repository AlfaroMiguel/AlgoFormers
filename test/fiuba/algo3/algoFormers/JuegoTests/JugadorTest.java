package fiuba.algo3.algoFormers.JuegoTests;

import static org.junit.Assert.*;
import org.junit.Test;

import fiuba.algo3.algoFormers.Juego.Autobots;
import fiuba.algo3.algoFormers.Juego.Decepticons;
import fiuba.algo3.algoFormers.Juego.Equipo;
import fiuba.algo3.algoFormers.Juego.Jugador;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.decepticons.*;
import fiuba.algo3.algoFormers.excepciones.EquipoInvalidoException;


public class JugadorTest {
	
	@Test
	public void test01SeleccionarAutobotEquipoAutobots(){
		Autobots autobots = new Autobots();
		Tablero tablero = new Tablero(10,10);
		Jugador jugador = new Jugador(autobots, tablero);
		Optimus optimus = new Optimus();
		jugador.seleccionarAlgoformer(optimus);
		assertEquals(jugador.verAlgoformerActual(), optimus);
	}
	
	@Test (expected = EquipoInvalidoException.class)
	public void test02SeleccionarDecepticonEquipoAutobots(){
		Autobots autobots = new Autobots();
		Tablero tablero = new Tablero(10,10);
		Jugador jugador = new Jugador(autobots, tablero);
		Megatron megatron = new Megatron();
		jugador.seleccionarAlgoformer(megatron);
	}
	
	@Test (expected = EquipoInvalidoException.class)
	public void test03SeleccionarAutobotEquipoDecepticons(){
		Decepticons decepticons = new Decepticons();
		Tablero tablero = new Tablero(10,10);
		Jugador jugador = new Jugador(decepticons, tablero);
		Optimus optimus = new Optimus();
		jugador.seleccionarAlgoformer(optimus);
	}
	
	@Test
	public void test04SeleccionarDecepticonEquipoDecepticons(){
		Decepticons decepticons = new Decepticons();
		Tablero tablero = new Tablero(10,10);
		Jugador jugador = new Jugador(decepticons, tablero);
		Megatron megatron = new Megatron();
		jugador.seleccionarAlgoformer(megatron);
		assertEquals(jugador.verAlgoformerActual(), megatron);
	}
//	}
//	@Test
//	public void test01UnJugadorAtacaConSuTransformerAOtroDeOtroEauipo(){
//	Autobots autobots = new Autobots();
//	Tablero tablero = new Tablero (10,10);
//	Jugador jugador = new Jugador(autobots, tablero);
//	Optimus optimus = new Optimus();
//	Frenzy frenzy = new Frenzy();
//	jugador.seleccionarAlgoformer(optimus);
//	
//	Coordenada coordenadaOptimus= new Coordenada(2,3);
//	Coordenada coordenadaFrenzy = new Coordenada(2,5);
//	tablero.put(optimus, coordenadaOptimus);
//	tablero.put(frenzy, coordenadaFrenzy);
//	
//	jugador.atacar(coordenadaFrenzy);
//	assertEquals(frenzy.verVida(),350);
//	}
	
	@Test
	public void test02UnJugadorMueveASuTransformerHumanoide(){
	Autobots autobots = new Autobots();
	Tablero tablero = new Tablero (10,10);
	Jugador jugador = new Jugador(autobots, tablero);
	Optimus optimus = new Optimus();
	jugador.seleccionarAlgoformer(optimus);
	
	Coordenada coordenada = new Coordenada(2,3);
	Coordenada nuevaCoordenada= new Coordenada(2,1);
	tablero.put(jugador.verAlgoformerActual(), coordenada); 
	jugador.mover(nuevaCoordenada);
	
	assertEquals(tablero.getKeyValue(jugador.verAlgoformerActual()), nuevaCoordenada);
	}
	
	@Test
	public void test03UnJugadorMueveASuTransformerAlterno(){
	Equipo equipoAutobots = new Autobots();
	Tablero tablero = new Tablero (10,10);
	Jugador jugador = new Jugador(equipoAutobots, tablero);
	Optimus optimus = new Optimus();
	jugador.seleccionarAlgoformer(optimus);
	jugador.transformarAlgoformer();
	
	Coordenada coordenada = new Coordenada(2,3);
	Coordenada nuevaCoordenada= new Coordenada(2,8);
	tablero.put(jugador.verAlgoformerActual(), coordenada); 
	jugador.mover(nuevaCoordenada);
	
	assertEquals(tablero.getKeyValue(jugador.verAlgoformerActual()), nuevaCoordenada);
	}
	
}
