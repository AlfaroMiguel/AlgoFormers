package juego;

import fiuba.algo3.algoFormers.Tablero.*;

public class Juego {
	
	protected Jugador jugadorActual;
	protected Jugador jugadorAnterior;
	protected Tablero tablero;
	
	public Juego(){
		Equipo equipoAutobots = new Autobots();
		this.jugadorActual = new Jugador(equipoAutobots);
		
		Equipo equipoDecepticons = new Decepticons();
		this.jugadorAnterior = new Jugador(equipoDecepticons);
		
		this.tablero = new Tablero(20,20);
	}
	
	public void cambiarTurno(){
		Jugador jugadorAux = this.jugadorAnterior;
		this.jugadorAnterior = this.jugadorActual;
		this.jugadorActual = jugadorAux;
	}
	
	public Jugador obtenerJugadorActual(){
		return this.jugadorActual;
	}
	
}
