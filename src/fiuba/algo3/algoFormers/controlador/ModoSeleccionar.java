package fiuba.algo3.algoFormers.controlador;

import fiuba.algo3.algoFormers.juego.Juego;
import fiuba.algo3.algoFormers.tablero.Coordenada;

public class ModoSeleccionar implements ModoControlador {
//	El modo por defecto del controlador.
//	Se utiliza para seleccionar a 
//	los algoFormers
	
	//	Intenta seleccionar al algoFomer en la coordenada
	@Override
	public void fueSeleccionado(Juego juego, Coordenada coordenada) {
		Boolean seleccionado = juego.puedoSeleccionarCoordenada(coordenada);
	}
	public void entro(Juego juego, Coordenada coordenada) {
		//No hace nada
	}

}
