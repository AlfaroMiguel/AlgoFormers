package fiuba.algo3.algoFormers.JuegoTests;

import static org.junit.Assert.*;
import org.junit.Test;

import fiuba.algo3.algoFormers.Entrega2Test.FailTestException;
import fiuba.algo3.algoFormers.Habitables.Vacio;
import fiuba.algo3.algoFormers.Juego.EquipoAutobots;
import fiuba.algo3.algoFormers.Juego.EquipoDecepticons;
import fiuba.algo3.algoFormers.Juego.Equipo;
import fiuba.algo3.algoFormers.Juego.Jugador;
import fiuba.algo3.algoFormers.Superficies.SuperficieAndromeda;
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
		tablero.colocarEnTablero(optimus, coordenada);
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
		tablero.colocarEnTablero(megatron, coordenada);
		jugador.seleccionarAlgoformer(coordenada);
	}
	
	@Test (expected = EquipoInvalidoException.class)
	public void test03SeleccionarAutobotEquipoDecepticons(){
		EquipoDecepticons decepticons = new EquipoDecepticons();
		Tablero tablero = new Tablero(10,10);
		Jugador jugador = new Jugador(decepticons, tablero);
		Optimus optimus = new Optimus();
		Coordenada coordenada = new Coordenada(2,4);
		tablero.colocarEnTablero(optimus, coordenada);
		jugador.seleccionarAlgoformer(coordenada);
	}
	
	@Test
	public void test04SeleccionarDecepticonEquipoDecepticons(){
		EquipoDecepticons decepticons = new EquipoDecepticons();
		Tablero tablero = new Tablero(10,10);
		Jugador jugador = new Jugador(decepticons, tablero);
		Megatron megatron = new Megatron();
		Coordenada coordenada = new Coordenada(2,4);
		tablero.colocarEnTablero(megatron, coordenada);
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
		tablero.colocarEnTablero(espacioVacio, coordenada);
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
	tablero.colocarEnTablero(optimus, coordenadaOptimus);
	tablero.colocarEnTablero(frenzy, coordenadaFrenzy);
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
	tablero.colocarEnTablero(optimus, coordenada); 
	jugador.seleccionarAlgoformer(coordenada);
	
	jugador.mover(nuevaCoordenada);
	assertEquals(tablero.obtenerCoordenadaDeElemento(jugador.verAlgoformerActual()), nuevaCoordenada);
	}
	
	@Test
	public void test08UnJugadorMueveASuTransformerAlterno(){
	Equipo equipoAutobots = new EquipoAutobots();
	Tablero tablero = new Tablero (10,10);
	Jugador jugador = new Jugador(equipoAutobots, tablero);
	Optimus optimus = new Optimus();
	Coordenada coordenada = new Coordenada(2,3);
	Coordenada nuevaCoordenada= new Coordenada(2,8);
	tablero.colocarEnTablero(optimus, coordenada);
	jugador.seleccionarAlgoformer(coordenada);
	jugador.transformarAlgoformer();
	jugador.mover(nuevaCoordenada);
	assertEquals(tablero.obtenerCoordenadaDeElemento(jugador.verAlgoformerActual()), nuevaCoordenada);
	}
	
	@Test
	public void test09UnJugadorCombinaASuAlgoformer(){
		EquipoAutobots equipoAutobots = new EquipoAutobots();
		Tablero tablero = new Tablero(10,10);
		Jugador jugador = new Jugador(equipoAutobots, tablero);
		Coordenada coordOptimus = new Coordenada(1,2);
		tablero.colocarEnTablero(equipoAutobots.optimus, coordOptimus);
		tablero.colocarEnTablero(equipoAutobots.bumblebee, new Coordenada(1,3));
		tablero.colocarEnTablero(equipoAutobots.ratchet, new Coordenada(1,4));
		jugador.combinarAlgoformers();
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordOptimus).getClass(), Superion.class);
	}
	@Test
	public void test10UnJugadorCombinaASuAlgoformerPeroNoLoPuedeMoverNiAtacarPor2Turnos(){
		EquipoAutobots equipoAutobots = new EquipoAutobots();
		Tablero tablero = new Tablero(10,10);
		Jugador jugador = new Jugador(equipoAutobots, tablero);
		Coordenada coordOptimus = new Coordenada(1,2);
		tablero.colocarEnTablero(equipoAutobots.optimus, coordOptimus);
		tablero.colocarEnTablero(equipoAutobots.bumblebee, new Coordenada(1,3));
		tablero.colocarEnTablero(equipoAutobots.ratchet, new Coordenada(1,4));
		Megatron megatron = new Megatron();
		jugador.combinarAlgoformers();
		jugador.seleccionarAlgoformer(new Coordenada(1,2));
		tablero.colocarEnTablero(megatron, new Coordenada(1,4));
		int vidaInicial = megatron.verVida();
		jugador.terminarTurno();
		//primer turno
		try{
			jugador.atacar(new Coordenada(1,4));
			jugador.mover(new Coordenada(1,3));
			throw new FailTestException();
		}
		catch(Throwable MovimientoInvalidoException){
		}
		jugador.terminarTurno();
		//Ya se puede mover
		jugador.mover(new Coordenada(1,3));
		assertEquals(megatron.verVida(),vidaInicial);
		assertEquals(tablero.obtenerAccionableEnCoordenada(new Coordenada(1,3)), jugador.verAlgoformerActual());
	}
}
