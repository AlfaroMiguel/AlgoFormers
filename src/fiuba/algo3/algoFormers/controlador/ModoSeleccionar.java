package fiuba.algo3.algoFormers.controlador;

import fiuba.algo3.algoFormers.juego.Juego;
import fiuba.algo3.algoFormers.tablero.Coordenada;

public class ModoSeleccionar implements ModoControlador {

	@Override
	public void fueSeleccionado(Juego juego, Coordenada coordenada) {
		juego.seleccionarCoordenada(coordenada);
	}

	@Override
	public void entro(Juego juego, Coordenada coordenada) {
	}

}
