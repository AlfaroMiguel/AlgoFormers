package fiuba.algo3.algoFormers.afectadores;

import fiuba.algo3.algoFormers.generico.*;
import fiuba.algo3.algoFormers.efectos.*;

public abstract class Afectador{
	private Efecto efecto;
	public void afectarAlgoformer(Algoformer algoformer){
		algoformer.agregarEfecto(this);
	}
	public abstract void desafectarAlgoformer(Algoformer algoformer);
	public abstract void pasarTurno();
	
}
