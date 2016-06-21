package fiuba.algo3.algoFormers.modos;


import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import fiuba.algo3.algoFormers.vista.HexGrid;
import javafx.scene.image.Image;

/* Clase que representa a un frenzy en modo alterno. Es una clase del tipo Singleton.*/
public class FrenzyAlterno extends ModoTerrestreAlterno {
	
	/* Atributos */
	/* Representa la unica instancia existente de la clase. */
	private static FrenzyAlterno instancia;
	
	/* Constructor */
	/* Crea un frenzy en modo alterno con 25 puntos de ataque, 2 de distancia de ataque
	 * y 6 de velocidad */ 
	private FrenzyAlterno(){
		this.ataque = 25;
		this.distAtaque = 2;
		this.velocidad = 6;
	}
	
	/* Metodos de la clase */
	/* Devuelve la unica instancia de la clase */
	public static FrenzyAlterno getInstance(){
		if (instancia == null){
			instancia = new FrenzyAlterno();
		}
		return instancia;
	}
	
	/* Metodos abstractos redefinidos */
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(FrenzyHumanoide.getInstance());
	}
	@Override
	public Image verImagen() {
		return ClaseImagenes.getImageModo(this);
	}

}
