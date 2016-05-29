package fiuba.algo3.algoFormers.Juego;

import fiuba.algo3.algoFormers.Habitables.ChispaSuprema;
import fiuba.algo3.algoFormers.Tablero.*;

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
		
<<<<<<< HEAD
	}
	
=======
		this.ubicarPersonajes();
		this.ubicarChispa();
	}
	
	private void ubicarChispa() {
		ChispaSuprema chispaSuprema = ChispaSuprema.getInstance();
		this.tablero.put(chispaSuprema, new Coordenada(10,10));
		
	}


	private void ubicarPersonajes() {
		this.jugadorActual.ubicarPersonajes();
		this.jugadorAnterior.ubicarPersonajes();
		
	}

>>>>>>> 3845e10979f19b729e91f32b7d1eaab937586a70
	public void cambiarTurno(){
		Jugador jugadorAux = this.jugadorAnterior;
		this.jugadorAnterior = this.jugadorActual;
		this.jugadorActual = jugadorAux;
	}
	
	public Jugador obtenerJugadorActual(){
		return this.jugadorActual;
	}
	
<<<<<<< HEAD
=======
	public void seleccionarAlgoformer(Coordenada coordenada){
		this.jugadorActual.seleccionarAlgoformer(this.tablero.ver(coordenada));
	}

	public boolean seUbicoALosPersonajes() {
		return jugadorActual.ubicoSusPersonajes();
		//return (this.jugadorActual.ubicoSusPersonajes() && this.jugadorAnterior.ubicoSusPersonajes());
	}

	public boolean estaLaChispa(int i, int j) {
		return !(tablero.estaVacio(new Coordenada(i,j)));
	}

	
>>>>>>> 3845e10979f19b729e91f32b7d1eaab937586a70
}
