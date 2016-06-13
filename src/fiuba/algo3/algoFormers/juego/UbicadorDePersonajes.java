package fiuba.algo3.algoFormers.juego;

import java.util.*;

import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;


public class UbicadorDePersonajes {

	public static void posicionarEquipoAutobot(List<Autobot> integrantes, Tablero tablero) {
		tablero.colocarEnTablero(integrantes.get(0), new Coordenada(1,2));
	 	tablero.colocarEnTablero(integrantes.get(1), new Coordenada(2,2));
	 	tablero.colocarEnTablero(integrantes.get(2), new Coordenada(2,1));
		
	}

	public static void posicionarEquipoDecepticon(List<Decepticon> integrantes, Tablero tablero) {
		tablero.colocarEnTablero(integrantes.get(0), new Coordenada(18,1));
	 	tablero.colocarEnTablero(integrantes.get(1), new Coordenada(18,2));
	 	tablero.colocarEnTablero(integrantes.get(2), new Coordenada(19,1));
		
	}


}
