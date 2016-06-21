package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.afectadores.AfectadorPorTurnos;
import fiuba.algo3.algoFormers.efectos.EfectoBurbujaInmaculada;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import fiuba.algo3.algoFormers.vista.HexGrid;
import javafx.scene.image.Image;

/* Clase que representa un bonus cuyo efecto es bloquear ataques sobre el accionable
 * durante 2 turnos del mismo. */
public class BurbujaInmaculada extends Bonus {
	
	/* Constructor */
	/* Crea una burbuja inmaculada cuyo afectador por turnos dura 2 turnos y tiene
	 * el efecto correspondiente a la clase. */
	public BurbujaInmaculada(){
		this.afectador = new AfectadorPorTurnos(2, new EfectoBurbujaInmaculada());
	}
	
	/* Metodos abstractos redefinidos */
	@Override
	public void producirEfecto(Algoformer algoformer){
		this.afectador.afectarAlgoformer(algoformer);
	}

	@Override
	public void desafectar(Algoformer algoformer){
		afectador.desafectarAlgoformer(algoformer);
	}
	
	@Override
	public Image getImage() {
		return ClaseImagenes.getImageRecolectable(this);
	}

}
