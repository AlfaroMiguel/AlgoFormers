package fiuba.algo3.algoFormers.afectadores;

import fiuba.algo3.algoFormers.efectos.Efecto;
import fiuba.algo3.algoFormers.efectosTest.*;
import fiuba.algo3.algoFormers.generico.*;

public abstract class Afectador{
	private Efecto efecto;
	public void afectarAlgoformer(Algoformer algoformer){
		algoformer.agregarEfecto(this);
	}
	public abstract void desafectarAlgoformer(Algoformer algoformer);
	public abstract void pasarTurno();
	
}
