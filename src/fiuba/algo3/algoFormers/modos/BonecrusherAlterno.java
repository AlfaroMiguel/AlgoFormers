package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import fiuba.algo3.algoFormers.vista.HexGrid;
import javafx.scene.image.Image;

/* Clase que representa a un bonecrusher en modo alterno. Es una clase del tipo Singleton.*/
public class BonecrusherAlterno extends ModoTerrestreAlterno {
	
	/* Atributos */
	/* Representa la unica instancia existente de la clase. */
	private static BonecrusherAlterno instancia;
	
	/* Constructor */
	/* Crea un bonecrusher en modo alterno con 3 puntos de ataque, 3 de distancia de ataque
	 * y 8 de velocidad */ 
	private BonecrusherAlterno(){
		this.ataque = 30;
		this.distAtaque = 3;
		this.velocidad = 8;
	}
	
	/* Metodos de la clase */
	/* Devuelve la unica instancia de la clase */
	public static BonecrusherAlterno getInstance(){
		if (instancia == null){
			instancia = new BonecrusherAlterno();
		}
		return instancia;
	}
	
	/* Metodos abstractos redefinidos */
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(BonecrusherHumanoide.getInstance());
	}

	@Override
	public Image verImagen() {
		return ClaseImagenes.getImageModo(this);
	}	
}
