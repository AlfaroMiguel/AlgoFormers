package fiuba.algo3.algoFormers.superficie;

import fiuba.algo3.algoFormers.efectos.EfectoAndromeda;
import fiuba.algo3.algoFormers.afectadores.*;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.modos.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.HexGrid;

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
	public void ponerSuperficieAire(Coordenada coordenada) {
		 HexGrid.ponerSuperficieAndromeda(coordenada);
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
}
