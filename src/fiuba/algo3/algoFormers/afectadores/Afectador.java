package fiuba.algo3.algoFormers.afectadores;

import fiuba.algo3.algoFormers.efectos.Efecto;
import fiuba.algo3.algoFormers.generico.*;

public abstract class Afectador{
	protected Efecto efecto;
	public void afectarAlgoformer(Algoformer algoformer){
		algoformer.agregarEfecto(this);
	}
	public void producirEfecto(Algoformer algoformer){
		this.efecto.afectarAlgoformer(algoformer);
	}
	public abstract void afectarPorMicromovimiento(Algoformer algoformer);
	public abstract void desafectarAlgoformer(Algoformer algoformer);
	public abstract void pasarTurno();
	
}
