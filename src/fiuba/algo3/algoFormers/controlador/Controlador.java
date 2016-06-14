package fiuba.algo3.algoFormers.controlador;

import fiuba.algo3.algoFormers.juego.Juego;
import fiuba.algo3.algoFormers.tablero.Coordenada;

public class Controlador {
	public Juego juego;
	public boolean seleccionado;
	public Controlador(Juego juego){
		this.juego= juego;
		this.seleccionado = false;
	}
	public void fueSeleccionado(Coordenada coordenada){
		if(!seleccionado){
			this.seleccionado = this.juego.seleccionarCoordenada(coordenada);
			System.out.println("Seleccionamos");
			return;
		}
		else{
			this.juego.moverSeleccionadoACoordenada(coordenada);
			System.out.println("Movimos");
			this.seleccionado = false;
			return;
		}
	}
}
