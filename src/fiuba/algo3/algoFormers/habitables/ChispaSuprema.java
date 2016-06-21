package fiuba.algo3.algoFormers.habitables;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.ObservadorTerminoJuego;
import fiuba.algo3.algoFormers.modos.BonecrusherAlterno;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import fiuba.algo3.algoFormers.vista.HexGrid;
import javafx.scene.image.Image;

/* Clase que representa un bonus que cuando se recolecta, el equipo que lo recolecta
 * gana el juego. Es una clase del tipo Singleton. */
public class ChispaSuprema implements Recolectable{

	/* Atributos */
	/* Representa la unica instancia existente de la clase. */
	private static ChispaSuprema instancia;
	/* Lista de observadores para el patron observer */
	private List<ObservadorTerminoJuego> observadores = new ArrayList<ObservadorTerminoJuego>();
	/* Representa la coordenada en la que se encuentra la chispa en un momento dado. */
	public Coordenada posicion;
	
	/* Metodos de la clase */
	/* Devuelve la unica instancia de la clase. */
	public static ChispaSuprema getInstance(){
		if (instancia == null){
			instancia = new ChispaSuprema();
		}
		return instancia;
	}
	
	/* Metodos de la clase */
	/* Actualiza la coordenada en la que se encuentra la chispa.
	 * Parametros: posicion: coordenada a la que se quiere actualizar. */
	public void setCoordenada(Coordenada posicion){
		this.posicion = posicion;
		//this.vista.update(this,posicion);
	}
	/* Devuelve la coordenada actual en la que se encuentra el bonus. */
	public Coordenada getCoordenada(){
		return this.posicion;
	}
	/* Indica que fue recolectada por algun accionable */
	public void serCapturada() {
		this.notificarObservadores();
	}
	
	/* Metodos abstractos redefinidos */
	@Override
	public void colisionar(){	
	}

	@Override
	public boolean ocupaLugar(){
		return true;
	}
	
	@Override
	public void producirEfecto(Algoformer algoformer){
		algoformer.capturarChispa(this);
	}

	@Override
	public void desafectar(Algoformer algoformer) {
	}

	@Override
	public boolean fueConsumido() {
		return true;
	}

	@Override
	public boolean equals(BonusVacio otro) {
		return false;
	}

	@Override
	public Image getImage() {
		return ClaseImagenes.getImageRecolectable(this);
	}


	@Override
	public void agregarObservador(ObservadorTerminoJuego observador) {
		if (!this.observadores.contains(observador)){
			this.observadores.add(observador);
		}
	}

	@Override
	public void eliminarObservador(ObservadorTerminoJuego observador) {
		this.observadores.remove(observador);
	}

	@Override
	public void notificarObservadores() {
		for (ObservadorTerminoJuego observador: observadores){
			observador.actualizar();
		}
	}

}
