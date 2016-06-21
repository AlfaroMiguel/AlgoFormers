package fiuba.algo3.algoFormers.modos;


import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import fiuba.algo3.algoFormers.vista.HexGrid;
import javafx.scene.image.Image;

/* Clase que representa a un megatron en modo alterno. Es una clase del tipo Singleton.*/
public class MegatronAlterno extends ModoAereoAlterno {
	
	/* Atributos */
	/* Representa la unica instancia existente de la clase. */
	private static MegatronAlterno instancia;
	
	/* Constructor */
	/* Crea un megatron en modo alterno con 55 puntos de ataque, 2 de distancia de ataque
	 * y 8 de velocidad */
	private MegatronAlterno(){
		this.ataque = 55;
		this.distAtaque = 2;
		this.velocidad = 8;
	}
	
	/* Metodos de la clase */
	/* Devuelve la unica instancia de la clase */
	public static MegatronAlterno getInstance(){
		if (instancia == null){
			instancia = new MegatronAlterno();
		}
		return instancia;
	}
	
	/* Metodos abstractos redefinidos */
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(MegatronHumanoide.getInstance());
	}
	@Override
	public Image verImagen() {
		return ClaseImagenes.getImageModo(this);
	}
	
}
