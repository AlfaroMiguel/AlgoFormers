package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.afectadores.AfectadorPorTurnos;
import fiuba.algo3.algoFormers.efectos.EfectoDobleCanion;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import fiuba.algo3.algoFormers.vista.HexGrid;
import javafx.scene.image.Image;

/* Clase que representa un bonus cuyo efecto es duplicar la capacidad de ataque del
 * accionable durante 3 turnos del mismo. */ 
public class DobleCanion extends Bonus {
	
	/* Constructor */
	/* Crea un doble cañon cuyo afectador por turnos dura 3 turnos y tiene el efecto
	 * correspondiente a la clase. */
	public DobleCanion(){
		this.afectador = new AfectadorPorTurnos(3, new EfectoDobleCanion());
	}
	
	/* Metodos abstractos redefinidos */
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
