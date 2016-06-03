package fiuba.algo3.algoFormers.afectadores;

import fiuba.algo3.algoFormers.efectos.*;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class AfectadorPorPosicion extends Afectador {
	private Efecto efecto;
	public AfectadorPorPosicion(Efecto efecto){
		this.efecto = efecto;
	}
	@Override
	public void desafectarAlgoformer(Algoformer algoformer){
		this.efecto = new EfectoTerminado();
	}
	@Override
	public void pasarTurno() {
		// TODO Auto-generated method stub
		
	}
}
