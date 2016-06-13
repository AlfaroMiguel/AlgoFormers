package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.afectadores.AfectadorPorTurnos;
import fiuba.algo3.algoFormers.efectos.EfectoDobleCanion;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.tablero.Coordenada;

public class DobleCanion extends Bonus {
	

	public DobleCanion(){
		this.afectador = new AfectadorPorTurnos(3, new EfectoDobleCanion());
	}
	
	@Override
	public void producirEfecto(Algoformer algoformer){
		this.afectador.afectarAlgoformer(algoformer);
	}

	@Override
	public void desafectar(Algoformer algoformer) {
		afectador.desafectarAlgoformer(algoformer);
	}

	@Override
	public void ponerRecolectable(Coordenada c) {
		// TODO Auto-generated method stub
		
	}
}
