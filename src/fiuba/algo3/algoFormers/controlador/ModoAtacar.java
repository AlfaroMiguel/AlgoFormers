package fiuba.algo3.algoFormers.controlador;

import fiuba.algo3.algoFormers.juego.Juego;
import fiuba.algo3.algoFormers.tablero.Coordenada;

public class ModoAtacar implements ModoControlador {

	public ModoAtacar(Juego juego){
		juego.nuevaSeleccion();
		juego.verRangoAtaque();
	}
	@Override
	public void fueSeleccionado(Juego juego, Coordenada coordenada) {
		juego.atacarConSeleccionadoACoordenada(coordenada);
	}

	@Override
	public void entro(Juego juego, Coordenada coordenada) {
		// No hace nada
	}

}
