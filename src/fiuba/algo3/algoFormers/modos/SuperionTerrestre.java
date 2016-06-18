package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.excepciones.ModoUnicoException;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import fiuba.algo3.algoFormers.vista.HexGrid;
import javafx.scene.image.Image;

public class SuperionTerrestre extends ModoHumanoide {
		
	private static SuperionTerrestre instancia;
	
	private SuperionTerrestre(){
		this.ataque = 100;
		this.distAtaque = 2;
		this.velocidad = 100;
	}
		
	public static SuperionTerrestre getInstance(){
		if (instancia == null){
			instancia = new SuperionTerrestre();
		}
		return instancia;
	}
		
	@Override
	public void cambiar(Algoformer algoformer) {
		throw new ModoUnicoException();
	}
	
	
	
	public Image getImage() {
		System.out.println("Me pidieron la imagen");
		return ClaseImagenes.getImageModo(this);
	}
}
