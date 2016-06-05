package fiuba.algo3.algoFormers.Superficies;

import fiuba.algo3.algoFormers.efectos.EfectoNubes;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.afectadores.*;

public class SuperficieNubes extends SuperficieAire {
	
	public SuperficieNubes(){
		this.afectador = new AfectadorPorPosicion(new EfectoNubes());
	}

	public int simularPasoDe(Algoformer algoformer) {
		return 1;
	}
}
