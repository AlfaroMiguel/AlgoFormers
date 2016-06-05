package fiuba.algo3.algoFormers.Superficies;

import fiuba.algo3.algoFormers.efectos.EfectoEspinas;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Vista.HexGrid;
import fiuba.algo3.algoFormers.afectadores.*;

public class SuperficieEspinas extends SuperficieTierra {
	
	public SuperficieEspinas(){
		this.afectador = new AfectadorPorPosicion(new EfectoEspinas());
	}

	@Override
	public int simularPasoDe(Algoformer algoformer) {
		return 1;
	}

	@Override
	public void ponerSuperficieTierra(Coordenada coordenada) {
		HexGrid.ponerSuperficieEspinas(coordenada);
	}
}
