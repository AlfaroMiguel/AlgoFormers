package fiuba.algo3.algoFormers.controlador;

import fiuba.algo3.algoFormers.juego.Juego;
import fiuba.algo3.algoFormers.tablero.Coordenada;

public interface ModoControlador {
	
	public void fueSeleccionado(Juego juego, Coordenada coordenada);
	public void entro(Juego juego, Coordenada coordenada);

}
