package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.afectadores.Afectador;
import fiuba.algo3.algoFormers.afectadores.AfectadorPorTurnos;
import fiuba.algo3.algoFormers.efectos.EfectoFlash;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class Flash extends Bonus {
	

	public Flash(){
		this.afectador = new AfectadorPorTurnos(3, new EfectoFlash());
	}
	
	@Override
	public void producirEfecto(Algoformer algoformer){
		this.afectador.afectarAlgoformer(algoformer);
	}

	@Override
	public void desafectar(Algoformer algoformer) {
		afectador.desafectarAlgoformer(algoformer);
	}
}