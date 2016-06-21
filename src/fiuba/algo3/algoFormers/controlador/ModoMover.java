package fiuba.algo3.algoFormers.controlador;

import fiuba.algo3.algoFormers.juego.Juego;
import fiuba.algo3.algoFormers.tablero.Coordenada;

public class ModoMover implements ModoControlador {

//	Uno de los modos del controlador.
//	Se utiliza para mover al
//	algoFormer de lugar
	
	//	Intenta mover al algoformer hacia la coordenada
	//	seleccionada
	@Override
	public void fueSeleccionado(Juego juego, Coordenada coordenada) {
		juego.moverSeleccionadoACoordenada(coordenada);
	}

	// Se fija si el algoFormer puede pagar el
	// camino hacia la coordenada 
	@Override
	public void entro(Juego juego, Coordenada coordenada) {
		juego.nuevaSeleccion();
		juego.simularMovimiento(coordenada);
	}

}
