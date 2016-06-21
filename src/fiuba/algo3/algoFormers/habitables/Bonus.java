package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.afectadores.AfectadorPorTurnos;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.ObservadorTerminoJuego;
import fiuba.algo3.algoFormers.tablero.Coordenada;

/* Clase que representa los bonus del juego que causan diferentes efectos a los
 * accionables cuando estos los recolectan. */
public abstract class Bonus implements Recolectable{
	
	/* Atributos */
	/* Afectador que producira los efectos del bonus en los algoformers.
	 * Todos los efectos duran una determinada cantidad de turnos. */ 
	public AfectadorPorTurnos afectador;
	/* Representa la coordenada en la que se encuentra el bonus en un momento dado. */
	public Coordenada posicion;
	
	/* Metodos de la clase */
	/* Actualiza la coordenada en la que se encuentra el bonus.
	 * Parametros: posicion: coordenada a la que se quiere actualizar. */
	public void setCoordenada(Coordenada coordenada){
		this.posicion = coordenada;
	}
	/* Devuelve la coordenada actual en la que se encuentra el bonus. */
	public Coordenada getCoordenada(){
		return this.posicion;
	} 
	
	/* Metodos abstractos redefinidos*/
	@Override
	public abstract void producirEfecto(Algoformer algoformer);
	@Override
	public abstract void desafectar(Algoformer algoformer);
	
	@Override
	public void colisionar(){
		//se puede colisionar
	}
	@Override
	public boolean ocupaLugar() {
		return true;
	}	
	@Override
	public boolean fueConsumido(){
		return this.afectador.estaActivado();
	}
	@Override
	public boolean equals(BonusVacio otro){
		return false;
	}
	@Override
	public void agregarObservador(ObservadorTerminoJuego observador) {
	}
	
	@Override
	public void eliminarObservador(ObservadorTerminoJuego observador) {
	}
	
	@Override
	public void notificarObservadores() {
	}
}
