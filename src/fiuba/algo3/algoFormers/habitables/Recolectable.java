package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.ObservableTerminoJuego;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import javafx.scene.image.Image;

/* Interfaz que agrupan los elementos del juego que pueden ser retirados del tablero
 * por otros elementos. */
public interface Recolectable extends ObservableTerminoJuego{
	
	/* Metodos abstractos */
	/* Colisiona con cualquier elemento.
	 * Lanza: NoColisionableException si ningun elemento puede colisionar contra el. */
	public void colisionar();
	/* Devuelve true si ocupa o no un lugar representativo en el tablero y false
	 * en caso contrario.*/
	public boolean ocupaLugar();
	/* Activa el efecto del recolectable sobre un algoformer.
	 * Parametros: algoformer: algoformer sobre el que se quiere producir el efecto. */
	public void producirEfecto(Algoformer algoformer);
	/* Revierte el efecto del recoletable sobre un algoformer.
	 * Parametros: algoformer: algoformer sobre el que se quiere revertir el efecto. */
	public void desafectar(Algoformer algoformer);
	/* Devuelve true si algun accionable ya lo recolecto del tablero y false en caso contrario. */
	public boolean fueConsumido();
	/* Un bonus cualquiera nunca es igual a un bonus vacio */
	public boolean equals(BonusVacio otro);
	/* Devuelve la imagen que representa al recolectable. */
	public Image getImage();
}
