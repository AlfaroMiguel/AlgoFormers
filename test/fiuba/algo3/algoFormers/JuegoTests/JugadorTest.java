package fiuba.algo3.algoFormers.JuegoTests;

import static org.junit.Assert.*;
import org.junit.Test;

import fiuba.algo3.algoFormers.Habitables.Vacio;
import fiuba.algo3.algoFormers.Juego.EquipoAutobots;
import fiuba.algo3.algoFormers.Juego.EquipoDecepticons;
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
		EquipoAutobots autobots = new EquipoAutobots();
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
		EquipoAutobots autobots = new EquipoAutobots();
		Tablero tablero = new Tablero(10,10);
		Jugador jugador = new Jugador(autobots, tablero);
		Megatron megatron = new Megatron();
		Coordenada coordenada = new Coordenada(2,4);
		tablero.put(megatron, coordenada);
		jugador.seleccionarAlgoformer(coordenada);
	}
	
	@Test (expected = EquipoInvalidoException.class)
	public void test03SeleccionarAutobotEquipoDecepticons(){
		EquipoDecepticons decepticons = new EquipoDecepticons();
		Tablero tablero = new Tablero(10,10);
		Jugador jugador = new Jugador(decepticons, tablero);
		Optimus optimus = new Optimus();
		Coordenada coordenada = new Coordenada(2,4);
		tablero.put(optimus, coordenada);
		jugador.seleccionarAlgoformer(coordenada);
	}
	
	@Test
	public void test04SeleccionarDecepticonEquipoDecepticons(){
		EquipoDecepticons decepticons = new EquipoDecepticons();
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
		EquipoDecepticons decepticons = new EquipoDecepticons();
		Tablero tablero = new Tablero(10,10);
		Jugador jugador = new Jugador(decepticons, tablero);
		Vacio espacioVacio = new Vacio();
		Coordenada coordenada = new Coordenada(2,4);
		tablero.put(espacioVacio, coordenada);
		jugador.seleccionarAlgoformer(coordenada);
	}
	
	@Test
	public void test06UnJugadorAtacaConSuTransformerAOtroDeOtroEquipo(){
	EquipoAutobots autobots = new EquipoAutobots();
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
	public void test07UnJugadorMueveASuTransformerHumanoide(){
	EquipoAutobots autobots = new EquipoAutobots();
	Tablero tablero = new Tablero (10,10);
	Jugador jugador = new Jugador(autobots, tablero);
	Optimus optimus = new Optimus();
	Coordenada coordenada = new Coordenada(2,3);
	Coordenada nuevaCoordenada= new Coordenada(2,1);
	tablero.put(optimus, coordenada); 
	jugador.seleccionarAlgoformer(coordenada);
	
	jugador.mover(nuevaCoordenada);
	assertEquals(tablero.obtenerCoordenadaDeHabitable(jugador.verAlgoformerActual()), nuevaCoordenada);
	}
	
	@Test
	public void test08UnJugadorMueveASuTransformerAlterno(){
	Equipo equipoAutobots = new EquipoAutobots();
	Tablero tablero = new Tablero (10,10);
	Jugador jugador = new Jugador(equipoAutobots, tablero);
	Optimus optimus = new Optimus();
	Coordenada coordenada = new Coordenada(2,3);
	Coordenada nuevaCoordenada= new Coordenada(2,8);
	tablero.put(optimus, coordenada);
	jugador.seleccionarAlgoformer(coordenada);
	jugador.transformarAlgoformer();
	jugador.mover(nuevaCoordenada);
	assertEquals(tablero.obtenerCoordenadaDeHabitable(jugador.verAlgoformerActual()), nuevaCoordenada);
	}
	
	@Test
	public void test09UnJugadorCombinaASuAlgoformer(){
		EquipoAutobots equipoAutobots = new EquipoAutobots();
		Tablero tablero = new Tablero(10,10);
		Jugador jugador = new Jugador(equipoAutobots, tablero);
		Coordenada coordOptimus = new Coordenada(1,2);
		tablero.put(equipoAutobots.optimus, coordOptimus);
		tablero.put(equipoAutobots.bumblebee, new Coordenada(1,3));
		tablero.put(equipoAutobots.ratchet, new Coordenada(1,4));
		jugador.combinarAlgoformers();
		assertEquals(tablero.obtenerHabitableEnCoordenada(coordOptimus).getClass(), Superion.class);
	}
}
