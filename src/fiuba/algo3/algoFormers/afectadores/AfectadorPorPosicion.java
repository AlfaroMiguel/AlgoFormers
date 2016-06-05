package fiuba.algo3.algoFormers.afectadores;

import fiuba.algo3.algoFormers.efectos.Efecto;
import fiuba.algo3.algoFormers.efectos.EfectoTerminado;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class AfectadorPorPosicion extends Afectador {
	public AfectadorPorPosicion(Efecto efecto){
		this.efecto = efecto;
	}
	@Override
	public void desafectarAlgoformer(Algoformer algoformer){
		algoformer.getAfectadores().sacarAfectador(this);
	}
	@Override
	public void pasarTurno() {
		// TODO Auto-generated method stub
	}
	@Override
	public void afectarPorMicromovimiento(Algoformer algoformer) {
		this.efecto.afectarAlgoformer(algoformer);
		this.efecto.desafectarAlgoformer(algoformer);
		
	}
}
