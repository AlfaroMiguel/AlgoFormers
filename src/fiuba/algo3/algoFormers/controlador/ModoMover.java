package fiuba.algo3.algoFormers.controlador;

import fiuba.algo3.algoFormers.juego.Juego;
import fiuba.algo3.algoFormers.tablero.Coordenada;

public class ModoMover implements ModoControlador {

	@Override
	public void fueSeleccionado(Juego juego, Coordenada coordenada) {
		juego.moverSeleccionadoACoordenada(coordenada);
		System.out.println("Movimos");
	}

	@Override
	public void entro(Juego juego, Coordenada coordenada) {
		juego.nuevaSeleccion();
		juego.simularMovimiento(coordenada);
	}

}
