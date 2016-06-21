package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import fiuba.algo3.algoFormers.vista.HexGrid;
import javafx.scene.image.Image;

/* Clase que representa a un frenzy en modo humanoide. Es una clase del tipo Singleton.*/
public class FrenzyHumanoide extends ModoHumanoide {
	
	/* Atributos */
	/* Representa la unica instancia existente de la clase. */
	private static FrenzyHumanoide instancia;
	
	/* Constructor */
	/* Crea un frenzy en modo humanoide con 10 puntos de ataque, 5 de distancia de ataque
	 * y 2 de velocidad */
	private FrenzyHumanoide(){
		this.ataque = 10;
		this.distAtaque = 5;
		this.velocidad = 2;
	}
	
	/* Metodos de la clase */
	/* Devuelve la unica instancia de la clase */
	public static FrenzyHumanoide getInstance(){
		if (instancia == null){
			instancia = new FrenzyHumanoide();
		}
		return instancia;
	}
	
	/* Metodos abstractos redefinidos */
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(FrenzyAlterno.getInstance());
	}
	@Override
	public Image verImagen() {
		return ClaseImagenes.getImageModo(this);
	}
	
	
}