package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import javafx.scene.image.Image;

/* Clase que representa un bonus que no ocupa lugar y no produce ningun efecto. */
public class BonusVacio extends Bonus {
	
	/* Metodos abstractos redefinidos */
	@Override
	public boolean fueConsumido(){
		return false;
	}
	@Override
	public boolean ocupaLugar() {
		return false;
	}
	@Override
	public void producirEfecto(Algoformer algoformer) {
	}

	@Override
	public void desafectar(Algoformer algoformer) {
	}
	
	@Override
	public boolean equals(BonusVacio otro){
		//el unico caso en que son iguales es si es otro bonus vacio
		return true;
	}
	
	@Override
	public Image getImage(){
		//no tiene imagen
		return null;
	}


}
