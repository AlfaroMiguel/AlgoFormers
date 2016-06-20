package fiuba.algo3.algoFormers.juego;

import java.util.*;

import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;

/* Clase que se encarga de ubicar a los personajes del juego en el tablero. */
public class UbicadorDePersonajes {
	
	/* Metodos de la clase */
	/* Ubica a los miembros del equipo Autobot en triangulo en una esquina del tablero.
	 * Parametros: integrantes: lista con los 3 miembros del equipo.
	 * 			   tablero: tablero del juego.*/
	public static void posicionarEquipoAutobot(List<Autobot> integrantes, Tablero tablero) {
		tablero.colocarEnTablero(integrantes.get(0), new Coordenada(1,2));
	 	tablero.colocarEnTablero(integrantes.get(1), new Coordenada(3,2));
	 	tablero.colocarEnTablero(integrantes.get(2), new Coordenada(3,0));	
	}
	/* Ubica a los miembros del equipo Decepticon en triangulo en una esquina del tablero.
	 * Parametros: integrantes: lista con los 3 miembros del equipo.
	 * 			   tablero: tablero del juego.*/
	public static void posicionarEquipoDecepticon(List<Decepticon> integrantes, Tablero tablero) {
		tablero.colocarEnTablero(integrantes.get(0), new Coordenada(18,-7));
	 	tablero.colocarEnTablero(integrantes.get(1), new Coordenada(17,-5));
	 	tablero.colocarEnTablero(integrantes.get(2), new Coordenada(16,-6));
		
	}


}
