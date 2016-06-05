package fiuba.algo3.algoFormers.Superficies;

import fiuba.algo3.algoFormers.efectos.EfectoPsionico;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.afectadores.*;

public class SuperficiePsionica extends SuperficieAire {
	public SuperficiePsionica(){
		this.afectador = new AfectadorPermanente(new EfectoPsionico());
	}

	public int simularPasoDe(Algoformer algoformer) {
		return 1;
	}
}
