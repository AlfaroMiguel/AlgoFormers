package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import fiuba.algo3.algoFormers.vista.HexGrid;
import javafx.scene.image.Image;

/* Clase que representa a un optimus en modo humanoide. Es una clase del tipo Singleton.*/
public class OptimusHumanoide extends ModoHumanoide {
	
	/* Atributos */
	/* Representa la unica instancia existente de la clase. */
	private static OptimusHumanoide instancia;
	
	/* Constructor */
	/* Crea un optimus en modo humanoide con 50 puntos de ataque, 2 de distancia de ataque
	 * y 2 de velocidad */
	private OptimusHumanoide(){
		this.ataque = 50;
		this.distAtaque = 2;
		this.velocidad = 2;
	}
	
	/* Metodos de la clase */
	/* Devuelve la unica instancia de la clase */
	public static OptimusHumanoide getInstance(){
		if (instancia == null){
			instancia = new OptimusHumanoide();
		}
		return instancia;
	}
	
	/* Metodos abstractos redefinidos */
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(OptimusAlterno.getInstance());
	}
	@Override
	public Image verImagen() {
		return ClaseImagenes.getImageModo(this);
	}
}