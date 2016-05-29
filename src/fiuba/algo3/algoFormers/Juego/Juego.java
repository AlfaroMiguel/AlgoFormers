package fiuba.algo3.algoFormers.Juego;

import fiuba.algo3.algoFormers.Tablero.*;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class Juego {
	
	protected Jugador jugadorActual;
	protected Jugador jugadorAnterior;
	protected Tablero tablero;
	
	public Juego(){
		this.tablero = new Tablero(20,20);
		
		Equipo equipoAutobots = new Autobots();
		this.jugadorActual = new Jugador(equipoAutobots, tablero);
		
		Equipo equipoDecepticons = new Decepticons();
		this.jugadorAnterior = new Jugador(equipoDecepticons, tablero);
		
		this.ubicarPersonajes();
		
	}
	
	private void ubicarPersonajes() {
		this.jugadorActual.ubicarPersonajes();
		this.jugadorAnterior.ubicarPersonajes();
		
	}

	public void cambiarTurno(){
		Jugador jugadorAux = this.jugadorAnterior;
		this.jugadorAnterior = this.jugadorActual;
		this.jugadorActual = jugadorAux;
	}
	
	public Jugador obtenerJugadorActual(){
		return this.jugadorActual;
	}

	public boolean seUbicoALosPersonajes() {
		return jugadorActual.ubicoSusPersonajes();
		//return (this.jugadorActual.ubicoSusPersonajes() && this.jugadorAnterior.ubicoSusPersonajes());
	}

	
}
