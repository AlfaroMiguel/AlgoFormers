package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.afectadores.AfectadorPorTurnos;
import fiuba.algo3.algoFormers.efectos.EfectoFlash;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import fiuba.algo3.algoFormers.vista.HexGrid;
import javafx.scene.image.Image;

/* Clase que representa un bonus cuyo efecto es triplicar la velocidad de desplazamiento
 * del accionable durante 3 turnos del mismo. */
public class Flash extends Bonus {
	
	/* Constructor */
	/* Crea un flash cuyo afectador por turnos dura 3 turnos y tiene el efecto
	 * correspondiente a la clase */
	public Flash(){
		this.afectador = new AfectadorPorTurnos(3, new EfectoFlash());
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