package fiuba.algo3.algoFormers.superficies;

import fiuba.algo3.algoFormers.efectos.EfectoPsionico;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.modos.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.HexGrid;
import fiuba.algo3.algoFormers.afectadores.*;

public class SuperficiePsionica extends SuperficieAire {
	public SuperficiePsionica() {
		this.afectador = new AfectadorPermanente(new EfectoPsionico());
	}

	public int simularPasoDe(Algoformer algoformer) {
		return 1;
	}

	public void ponerSuperficieAire(Coordenada coordenada) {
		// HexGrid.ponerSuperficiePsionica(coordenada);
	}

	public void afectar(Algoformer algoformer, ModoAereo modo) {
		afectador.afectarAlgoformer(algoformer);
	}

	public void afectar(Algoformer algoformer, ModoTerrestre modo) {
	}

	@Override
	public void desafectar(Algoformer algoformer, ModoAereo modoAereo) {
		afectador.desafectarAlgoformer(algoformer);

	}

}
