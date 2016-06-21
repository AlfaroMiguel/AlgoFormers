package fiuba.algo3.algoFormers.controlador;

import fiuba.algo3.algoFormers.juego.Juego;
import fiuba.algo3.algoFormers.tablero.Coordenada;

public class ModoAtacar implements ModoControlador {

//	Uno de los modos del controlador.
//	Se utiliza para atacar a otros 
//	algoFormers
	
	//	Pinta todo el rango en el cual se puede
	//	atacar luego de limpiar la pantalla
	public ModoAtacar(Juego juego){
		juego.nuevaSeleccion();
		juego.verRangoAtaque();
	}
	
	// Este metodo ataca al algoFormer en la coordenada que le pasen
	@Override
	public void fueSeleccionado(Juego juego, Coordenada coordenada) {
		juego.atacarConSeleccionadoACoordenada(coordenada);
	}

	@Override
	public void entro(Juego juego, Coordenada coordenada) {
		// No hace nada
	}

}
