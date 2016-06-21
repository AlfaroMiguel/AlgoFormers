package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import fiuba.algo3.algoFormers.vista.HexGrid;
import javafx.scene.image.Image;

/* Clase que representa a un ratchet en modo humanoide. Es una clase del tipo Singleton.*/
public class RatchetHumanoide extends ModoHumanoide {
	
	/* Atributos */
	/* Representa la unica instancia existente de la clase. */
	private static RatchetHumanoide instancia;
	
	/* Constructor */
	/* Crea un racthet en modo humanoide con 5 puntos de ataque, 5 de distancia de ataque
	 * y 1 de velocidad */
	private RatchetHumanoide(){
		this.ataque = 5;
		this.distAtaque = 5;
		this.velocidad = 1;
	}
	
	/* Metodos de la clase */
	/* Devuelve la unica instancia de la clase */
	public static RatchetHumanoide getInstance(){
		if (instancia == null){
			instancia = new RatchetHumanoide();
		}
		return instancia;
	}
	
	/* Metodos abstractos redefinidos */
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(RatchetAlterno.getInstance());
	}
	@Override
	public Image verImagen() {
		return ClaseImagenes.getImageModo(this);
	}
}
