package fiuba.algo3.algoFormers.Superficies;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.afectadores.*;
import fiuba.algo3.algoFormers.efectos.EfectoPantano;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class SuperficiePantano extends SuperficieTierra {

	public SuperficiePantano(){
		this.afectador = new AfectadorPorPosicion(new EfectoPantano());
	}

	public int simularPasoDe(Algoformer algoformer) {
		return algoformer.simularPasoDe(this);
	}

}
