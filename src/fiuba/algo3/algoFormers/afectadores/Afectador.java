package fiuba.algo3.algoFormers.afectadores;

import fiuba.algo3.algoFormers.efectos.Efecto;
import fiuba.algo3.algoFormers.generico.*;

public abstract class Afectador{
	
	protected Efecto efecto;
	
	public abstract void afectarPorPaso(Algoformer algoformer);
	public abstract void desafectarAlgoformer(Algoformer algoformer);
	public abstract void pasarTurno();
	
	public abstract void afectarAlgoformer(Algoformer algoformer);
	
	public void producirEfecto(Algoformer algoformer){
		this.efecto.afectarAlgoformer(algoformer);
	}	
}
