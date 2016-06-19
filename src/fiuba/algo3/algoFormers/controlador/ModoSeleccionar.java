package fiuba.algo3.algoFormers.controlador;

import fiuba.algo3.algoFormers.juego.Juego;
import fiuba.algo3.algoFormers.tablero.Coordenada;

public class ModoSeleccionar implements ModoControlador {

	@Override
	public void fueSeleccionado(Juego juego, Coordenada coordenada) {
		Boolean seleccionado = juego.seleccionarCoordenada(coordenada);
	}
	public void entro(Juego juego, Coordenada coordenada) {
		//No hace nada
	}

}
