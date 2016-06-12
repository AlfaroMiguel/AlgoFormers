package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.afectadores.Afectador;
import fiuba.algo3.algoFormers.afectadores.AfectadorPorTurnos;
import fiuba.algo3.algoFormers.efectos.EfectoBurbujaInmaculada;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class BurbujaInmaculada extends Bonus {

	public BurbujaInmaculada(){
		this.afectador = new AfectadorPorTurnos(2, new EfectoBurbujaInmaculada());
	}
	
	@Override
	public void producirEfecto(Algoformer algoformer){
		this.afectador.afectarAlgoformer(algoformer);
	}

	@Override
	public void desafectar(Algoformer algoformer){
		afectador.desafectarAlgoformer(algoformer);
	}

}
