package fiuba.algo3.algoFormers.controlador;

import fiuba.algo3.algoFormers.juego.Juego;
import fiuba.algo3.algoFormers.tablero.Coordenada;

//	Esta es la interfaz de los modos
//	se definen los metodos que necesitan
//	los distintos modos

public interface ModoControlador {
	// Clikearon la coordenada
	public void fueSeleccionado(Juego juego, Coordenada coordenada);
	// Le pasaron por arriba a la coordenada
	public void entro(Juego juego, Coordenada coordenada);

}
