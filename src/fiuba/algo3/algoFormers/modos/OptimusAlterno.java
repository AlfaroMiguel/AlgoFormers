package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import fiuba.algo3.algoFormers.vista.HexGrid;
import javafx.scene.image.Image;

/* Clase que representa a un optimus en modo alterno. Es una clase del tipo Singleton.*/
public class OptimusAlterno extends ModoTerrestreAlterno {
	
	/* Atributos */
	/* Representa la unica instancia existente de la clase. */
	private static OptimusAlterno instancia;
	
	/* Constructor */
	/* Crea un optimus en modo alterno con 15 puntos de ataque, 4 de distancia de ataque
	 * y 5 de velocidad */
	private OptimusAlterno(){
		this.ataque = 15;
		this.distAtaque = 4;
		this.velocidad = 5;
	}
	
	/* Metodos de la clase */
	/* Devuelve la unica instancia de la clase */
	public static OptimusAlterno getInstance(){
		if (instancia == null){
			instancia = new OptimusAlterno();
		}
		return instancia;
	}
	
	/* Metodos abstractos redefinidos */
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(OptimusHumanoide.getInstance());
	}
	@Override
	public Image verImagen() {
		return ClaseImagenes.getImageModo(this);
	}
	}