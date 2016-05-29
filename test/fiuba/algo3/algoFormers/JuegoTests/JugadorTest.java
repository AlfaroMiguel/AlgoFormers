package fiuba.algo3.algoFormers.JuegoTests;

import static org.junit.Assert.*;
import org.junit.Test;

import fiuba.algo3.algoFormers.Habitables.Vacio;
import fiuba.algo3.algoFormers.Juego.Autobots;
import fiuba.algo3.algoFormers.Juego.Decepticons;
import fiuba.algo3.algoFormers.Juego.Equipo;
import fiuba.algo3.algoFormers.Juego.Jugador;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.decepticons.*;
import fiuba.algo3.algoFormers.excepciones.EquipoInvalidoException;
import fiuba.algo3.algoFormers.excepciones.NoAlgoformerException;


public class JugadorTest {
	
	@Test
	public void test01SeleccionarAutobotEquipoAutobots(){
		Autobots autobots = new Autobots();
		Tablero tablero = new Tablero(10,10);
		Jugador jugador = new Jugador(autobots, tablero);
		Optimus optimus = new Optimus();
		Coordenada coordenada = new Coordenada(2,4);
		tablero.put(optimus, coordenada);
		jugador.seleccionarAlgoformer(coordenada);
		assertEquals(jugador.verAlgoformerActual(), optimus);
	}
	
	@Test (expected = EquipoInvalidoException.class)
	public void test02SeleccionarDecepticonEquipoAutobots(){
		Autobots autobots = new Autobots();
		Tablero tablero = new Tablero(10,10);
		Jugador jugador = new Jugador(autobots, tablero);
		Megatron megatron = new Megatron();
		Coordenada coordenada = new Coordenada(2,4);
		tablero.put(megatron, coordenada);
		jugador.seleccionarAlgoformer(coordenada);
	}
	
	@Test (expected = EquipoInvalidoException.class)
	public void test03SeleccionarAutobotEquipoDecepticons(){
		Decepticons decepticons = new Decepticons();
		Tablero tablero = new Tablero(10,10);
		Jugador jugador = new Jugador(decepticons, tablero);
		Optimus optimus = new Optimus();
		Coordenada coordenada = new Coordenada(2,4);
		tablero.put(optimus, coordenada);
		jugador.seleccionarAlgoformer(coordenada);
	}
	
	@Test
	public void test04SeleccionarDecepticonEquipoDecepticons(){
		Decepticons decepticons = new Decepticons();
		Tablero tablero = new Tablero(10,10);
		Jugador jugador = new Jugador(decepticons, tablero);
		Megatron megatron = new Megatron();
		Coordenada coordenada = new Coordenada(2,4);
		tablero.put(megatron, coordenada);
		jugador.seleccionarAlgoformer(coordenada);
		assertEquals(jugador.verAlgoformerActual(), megatron);
	}

	@Test (expected = NoAlgoformerException.class)
	public void test05SeleccionarEspacioVacioEquipoAutobots(){
		Decepticons decepticons = new Decepticons();
		Tablero tablero = new Tablero(10,10);
		Jugador jugador = new Jugador(decepticons, tablero);
		Vacio espacioVacio = new Vacio();
		Coordenada coordenada = new Coordenada(2,4);
		tablero.put(espacioVacio, coordenada);
		jugador.seleccionarAlgoformer(coordenada);
	}
	
	@Test
	public void test01UnJugadorAtacaConSuTransformerAOtroDeOtroEauipo(){
	Autobots autobots = new Autobots();
	Tablero tablero = new Tablero (10,10);
	Jugador jugador = new Jugador(autobots, tablero);
	Optimus optimus = new Optimus();
	Frenzy frenzy = new Frenzy();
	Coordenada coordenadaOptimus= new Coordenada(2,3);
	Coordenada coordenadaFrenzy = new Coordenada(2,5);
	tablero.put(optimus, coordenadaOptimus);
	tablero.put(frenzy, coordenadaFrenzy);
	jugador.seleccionarAlgoformer(coordenadaOptimus);

	jugador.atacar(coordenadaFrenzy);
	assertEquals(frenzy.verVida(),350);
	}
	
	@Test
	public void test02UnJugadorMueveASuTransformerHumanoide(){
	Autobots autobots = new Autobots();
	Tablero tablero = new Tablero (10,10);
	Jugador jugador = new Jugador(autobots, tablero);
	Optimus optimus = new Optimus();
	Coordenada coordenada = new Coordenada(2,3);
	Coordenada nuevaCoordenada= new Coordenada(2,1);
	tablero.put(optimus, coordenada); 
	jugador.seleccionarAlgoformer(coordenada);
	
	jugador.mover(nuevaCoordenada);
	assertEquals(tablero.getKeyValue(jugador.verAlgoformerActual()), nuevaCoordenada);
	}
	
	@Test
	public void test03UnJugadorMueveASuTransformerAlterno(){
	Equipo equipoAutobots = new Autobots();
	Tablero tablero = new Tablero (10,10);
	Jugador jugador = new Jugador(equipoAutobots, tablero);
	Optimus optimus = new Optimus();
	Coordenada coordenada = new Coordenada(2,3);
	Coordenada nuevaCoordenada= new Coordenada(2,8);
	tablero.put(optimus, coordenada);
	jugador.seleccionarAlgoformer(coordenada);
	jugador.transformarAlgoformer();
	 
	jugador.mover(nuevaCoordenada);
	
	assertEquals(tablero.getKeyValue(jugador.verAlgoformerActual()), nuevaCoordenada);
	}
	
}
