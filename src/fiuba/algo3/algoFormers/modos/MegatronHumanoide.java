package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import fiuba.algo3.algoFormers.vista.HexGrid;
import javafx.scene.image.Image;

/* Clase que representa a un megatron en modo humanoide. Es una clase del tipo Singleton.*/
public class MegatronHumanoide extends ModoHumanoide {
	
	/* Atributos */
	/* Representa la unica instancia existente de la clase. */
	private static MegatronHumanoide instancia;
	
	/* Constructor */
	/* Crea un megatron en modo humanoide con 10 puntos de ataque, 3 de distancia de ataque
	 * y 1 de velocidad */
	private MegatronHumanoide(){
		this.ataque = 10;
		this.distAtaque = 3;
		this.velocidad = 1;
	}
	
	/* Metodos de la clase */
	/* Devuelve la unica instancia de la clase */
	public static MegatronHumanoide getInstance(){
		if (instancia == null){
			instancia = new MegatronHumanoide();
		}
		return instancia;
	}

	/* Metodos abstractos redefinidos */
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(MegatronAlterno.getInstance());
	}
	@Override
	public Image verImagen() {
		return ClaseImagenes.getImageModo(this);
	}
}