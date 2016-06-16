package fiuba.algo3.algoFormers.superficie;

import fiuba.algo3.algoFormers.afectadores.AfectadorPorPosicion;
import fiuba.algo3.algoFormers.efectos.EfectoRocas;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.modos.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.HexGrid;

public class SuperficieRocosa extends SuperficieTierra {

	public SuperficieRocosa() {
		this.afectador = new AfectadorPorPosicion(new EfectoRocas());
	}

	public int simularPasoDe(Algoformer algoformer) {
		return algoformer.simularPasoDe(this);
	}

	@Override
	public void ponerSuperficieTierra(Coordenada coordenada) {
		 HexGrid.ponerSuperficieRocosa(coordenada);
	}

	public void afectar(Algoformer algoformer, ModoAereo modo) {

	}

	@Override
	public void afectar(Algoformer afectado, ModoHumanoide modo) {
		afectador.desafectarAlgoformer(afectado);

	}

	@Override
	public void desafectar(Algoformer algoformer, ModoTerrestreAlterno modoTerrestreAlterno) {
		afectador.desafectarAlgoformer(algoformer);

	}

	@Override
	public void desafectar(Algoformer algoformer, ModoHumanoide modoTerrestreAlterno) {
		afectador.desafectarAlgoformer(algoformer);

	}

	@Override
	public void afectar(Algoformer afectado, ModoTerrestreAlterno modo) {
		afectador.afectarAlgoformer(afectado);

	}

	@Override
	public int costoPorPaso(ModoTerrestreAlterno modoTerrestreAlterno) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int costoPorPaso(ModoHumanoide modoHumanoide) {
		// TODO Auto-generated method stub
		return 1;
	}
}
