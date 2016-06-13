package fiuba.algo3.algoFormers.superficie;

import fiuba.algo3.algoFormers.afectadores.*;
import fiuba.algo3.algoFormers.efectos.EfectoPantano;
import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.modos.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.HexGrid;

public class SuperficiePantano extends SuperficieTierra {

	public SuperficiePantano() {
		this.afectador = new AfectadorPorPosicion(new EfectoPantano());
	}

	public int simularPasoDe(Algoformer algoformer) {
		return algoformer.simularPasoDe(this);
	}

	@Override
	public void ponerSuperficieTierra(Coordenada coordenada) {
		// HexGrid.ponerSuperficiePantano(coordenada);

	}

	public void afectar(Algoformer algoformer, ModoTerrestreAlterno modo) {
		afectador.afectarAlgoformer(algoformer);
	}

	public void afectar(Algoformer algoformer, ModoHumanoide modo) {
		throw new MovimientoInvalidoException();
	}

	public void afectar(Algoformer algoformer, ModoAereo modo) {
	}

	public void desafectar(Algoformer algoformer) {
		afectador.desafectarAlgoformer(algoformer);
	}

	@Override
	public void desafectar(Algoformer algoformer, ModoTerrestreAlterno modoTerrestreAlterno) {
		afectador.desafectarAlgoformer(algoformer);

	}

	@Override
	public void desafectar(Algoformer algoformer, ModoHumanoide modoTerrestreAlterno) {

	}

}
