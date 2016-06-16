package fiuba.algo3.algoFormers.superficie;

import fiuba.algo3.algoFormers.afectadores.Afectador;
import fiuba.algo3.algoFormers.afectadores.AfectadorPorTurnos;
import fiuba.algo3.algoFormers.efectos.EfectoAndromeda;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.modos.ModoAereo;
import fiuba.algo3.algoFormers.modos.ModoHumanoide;
import fiuba.algo3.algoFormers.modos.ModoTerrestreAlterno;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import javafx.scene.image.Image;

public class SuperficieAndromeda extends SuperficieAire {

	public SuperficieAndromeda() {
		this.afectador = new AfectadorPorTurnos(3, new EfectoAndromeda());
	}

	public void afectar(Algoformer algoformer, ModoAereo modo) {
		Afectador afectadorCopia = new AfectadorPorTurnos(3, new EfectoAndromeda());
		afectadorCopia.afectarAlgoformer(algoformer);
	}

	public void afectar(Algoformer algoformer, ModoTerrestreAlterno modo) {
	}

	public void afectar(Algoformer algoformer, ModoHumanoide modo) {
	}

	public int simularPasoDe(Algoformer algoformer) {
		return algoformer.simularPasoDe(this);
	}

	@Override
	public Image ponerSuperficieAire() {
		 return ClaseImagenes.getImageSuperficie(this);
	}

	public void producirEfecto(Accionable afectado) {
		afectado.reaccionarASuperficie(this);
	}

	@Override
	public void desafectar(Algoformer algoformer, ModoAereo modoAereo) {
		afectador.desafectarAlgoformer(algoformer);
	}

	@Override
	public int costoPorPaso(ModoAereo modoAereo) {
		return 1000000;
	}

	@Override
	public void producirEfectoPorPaso(Algoformer algoformer, ModoAereo modoAereo) {
		//Nunca Va a pasar por ensima de una superficie de andromeda sin quedarse parado
		
	}
}
