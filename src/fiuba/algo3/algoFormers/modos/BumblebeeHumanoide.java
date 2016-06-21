package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import fiuba.algo3.algoFormers.vista.HexGrid;
import javafx.scene.image.Image;

/* Clase que representa a un bonecrusher en modo humanoide. Es una clase del tipo Singleton.*/
public class BumblebeeHumanoide extends ModoHumanoide {
	
	/* Atributos */
	/* Representa la unica instancia existente de la clase. */
	private static BumblebeeHumanoide instancia;
	
	/* Constructor */
	/* Crea un bonecrusher en modo humanoide con 40 puntos de ataque, 1 de distancia de ataque
	 * y 2 de velocidad */ 
	private BumblebeeHumanoide(){
		this.ataque = 40;
		this.distAtaque = 1;
		this.velocidad = 2;
	}
	/* Metodos de la clase */
	/* Devuelve la unica instancia de la clase */
	public static BumblebeeHumanoide getInstance(){
		if (instancia == null){
			instancia = new BumblebeeHumanoide();
		}
		return instancia;
	}
	
	/* Metodos abstractos redefinidos */ 
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(BumblebeeAlterno.getInstance());
	}
	@Override
	public Image verImagen() {
		return ClaseImagenes.getImageModo(this);
	}
	
}
