package fiuba.algo3.algoFormers.Superficies;

import fiuba.algo3.algoFormers.efectos.EfectoNubes;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Vista.HexGrid;
import fiuba.algo3.algoFormers.afectadores.*;

public class SuperficieNubes extends SuperficieAire {
	
	public SuperficieNubes(){
		this.afectador = new AfectadorPorPosicion(new EfectoNubes());
	}

	public int simularPasoDe(Algoformer algoformer) {
		return 1;
	}

	public void ponerSuperficieAire(Coordenada coordenada) {
		HexGrid.ponerSuperficieNubes(coordenada);
	}
}
