package fiuba.algo3.algoFormers.Juego;

import java.util.List;

import fiuba.algo3.algoFormers.Habitables.ChispaSuprema;
import fiuba.algo3.algoFormers.Tablero.*;

public class Juego {
	
	protected Jugador jugadorActual;
	protected Jugador jugadorAnterior;
	protected Tablero tablero;

	public Juego(int alto, int ancho){
		this.tablero = new Tablero(alto,ancho);
		
		Equipo equipoAutobots = new EquipoAutobots();
		this.jugadorActual = new Jugador(equipoAutobots, tablero);
		
		Equipo equipoDecepticons = new EquipoDecepticons();
		this.jugadorAnterior = new Jugador(equipoDecepticons, tablero);
		
		this.ubicarPersonajes();
		this.ubicarChispa();		
	}
	public Juego(){
		this(20,20);
	}
	
	private void ubicarChispa() {
		ChispaSuprema chispaSuprema = ChispaSuprema.getInstance();
		
		this.tablero.colocarEnTablero(chispaSuprema, coordenadaChispa());
		
	}
	
	private Coordenada coordenadaChispa(){
		int i=9 + (int) (Math.random()*(11-9+1));
		int j=9 + (int) (Math.random()*(11-9+1));
		return new Coordenada(i,j);
	}


	private void ubicarPersonajes() {
		this.jugadorActual.ubicarPersonajes();
		this.jugadorAnterior.ubicarPersonajes();
		
	}
 
 	public boolean seUbicoALosPersonajes() {
 		return jugadorActual.ubicoSusPersonajes();
  	}
 	
 	public boolean estaLaChispa(int i, int j) {
 			return !(tablero.estaVacio(new Coordenada(i,j)));
 		}
 	
	public void cambiarTurno(){
		JugadorProxy jugadorProxy = new JugadorProxy(this.jugadorActual);
		jugadorProxy.eliminarBonus();
		Jugador jugadorAux = this.jugadorAnterior;
		this.jugadorAnterior = this.jugadorActual;
		this.jugadorActual = jugadorAux;
		
	}
	
	public Jugador obtenerJugadorActual(){
		return this.jugadorActual;
	}
	
	public void combinarAlgoformers(){
		this.jugadorActual.combinarAlgoformers();
	}

	public List<Coordenada> buscarCamino(Coordenada coordenadaInicial, Coordenada coordenadaFinal) {
		return this.tablero.buscarCamino(coordenadaInicial,coordenadaFinal);
	}
	
	
}
