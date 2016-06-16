package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import fiuba.algo3.algoFormers.vista.HexGrid;
import javafx.scene.image.Image;

public class FrenzyHumanoide extends ModoHumanoide {
	
	private static FrenzyHumanoide instancia;
	
	private FrenzyHumanoide(){
		this.ataque = 10;
		this.distAtaque = 5;
		this.velocidad = 2;
	}
	
	public static FrenzyHumanoide getInstance(){
		if (instancia == null){
			instancia = new FrenzyHumanoide();
		}
		return instancia;
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(FrenzyAlterno.getInstance());
	}

	

	public Image getImage() {
		return ClaseImagenes.getImageModo(this);
	}
	
	
}