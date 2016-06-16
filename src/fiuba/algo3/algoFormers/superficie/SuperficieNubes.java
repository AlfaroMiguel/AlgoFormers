package fiuba.algo3.algoFormers.superficie;

import fiuba.algo3.algoFormers.efectos.EfectoNubes;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.modos.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.HexGrid;
import fiuba.algo3.algoFormers.afectadores.*;

public class SuperficieNubes extends SuperficieAire {

	public SuperficieNubes() {
		this.afectador = new AfectadorPorPosicion(new EfectoNubes());
	}

	public int simularPasoDe(Algoformer algoformer) {
		return algoformer.simularPasoDe(this);
	}

	public void ponerSuperficieAire(Coordenada coordenada) {
		 HexGrid.ponerSuperficieNubes(coordenada);
	}

	public void afectar(Algoformer algoformer, ModoAereo modo) {
		afectador.afectarAlgoformer(algoformer);
	}

	@Override
	public void desafectar(Algoformer algoformer, ModoAereo modoAereo) {
		afectador.desafectarAlgoformer(algoformer);

	}

	@Override
	public int costoPorPaso(ModoAereo modoAereo) {
		return 1;
	}

	@Override
	public void producirEfectoPorPaso(Algoformer algoformer, ModoAereo modoAereo) {
		// TODO Auto-generated method stub
		
	}
}
