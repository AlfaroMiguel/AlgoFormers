package fiuba.algo3.algoFormers.Superficies;

import fiuba.algo3.algoFormers.efectos.EfectoEspinas;
import fiuba.algo3.algoFormers.afectadores.*;

public class SuperficieEspinas extends SuperficieTierra {
	
	public SuperficieEspinas(){
		this.afectador = new AfectadorPorPosicion(new EfectoEspinas());
	}
}
