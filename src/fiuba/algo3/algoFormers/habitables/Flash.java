package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.afectadores.AfectadorPorTurnos;
import fiuba.algo3.algoFormers.efectos.EfectoFlash;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import fiuba.algo3.algoFormers.vista.HexGrid;
import javafx.scene.image.Image;

public class Flash extends Bonus {
	

	public Flash(){
		this.afectador = new AfectadorPorTurnos(3, new EfectoFlash());
	}
	
	@Override
	public void producirEfecto(Algoformer algoformer){
		this.afectador.afectarAlgoformer(algoformer);
	}

	@Override
	public void desafectar(Algoformer algoformer) {
		afectador.desafectarAlgoformer(algoformer);
	}

	@Override
	public Image getImage() {
		return ClaseImagenes.getImageRecolectable(this);
	}

}