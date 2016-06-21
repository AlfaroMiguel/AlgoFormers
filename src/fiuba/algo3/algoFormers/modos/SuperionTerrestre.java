package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.excepciones.ModoUnicoException;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import fiuba.algo3.algoFormers.vista.HexGrid;
import javafx.scene.image.Image;

/* Clase que representa a un superion en modo unico. Es una clase del tipo Singleton.*/
public class SuperionTerrestre extends ModoHumanoide {
	
	/* Atributos */
	/* Representa la unica instancia existente de la clase. */
	private static SuperionTerrestre instancia;

	/* Constructor */
	/* Crea un superion en modo unico con 100 puntos de ataque, 2 de distancia de ataque
	 * y 3 de velocidad */
	private SuperionTerrestre(){
		this.ataque = 100;
		this.distAtaque = 2;
		this.velocidad = 3;
	}
	
	/* Metodos de la clase */
	/* Devuelve la unica instancia de la clase */
	public static SuperionTerrestre getInstance(){
		if (instancia == null){
			instancia = new SuperionTerrestre();
		}
		return instancia;
	}
	
	/* Metodos abstractos redefinidos */
	@Override
	public void cambiar(Algoformer algoformer) {
		throw new ModoUnicoException();
	}
	@Override
	public Image verImagen() {
		System.out.println("Me pidieron la imagen");
		return ClaseImagenes.getImageModo(this);
	}
}
