package fiuba.algo3.algoFormers.Superficies;

import fiuba.algo3.algoFormers.afectadores.*;
import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.generico.Algoformer;

public abstract class SuperficieAire{
	public Afectador afectador;
	
	public void revertirEfecto(HabitableDelMapa afectado){
		afectado.serDesafectado(this);
	}
	
	public void afectar(Algoformer algoformer){
		afectador.afectarAlgoformer(algoformer);
	}
	
	public void desafectar(Algoformer algoformer){
		afectador.desafectarAlgoformer(algoformer);
	}
	
	public int simularRecorrido(HabitableDelMapa transeunte) {
		return transeunte.simularEfecto(this);
	}
	
	public abstract int simularPasoDe(Algoformer algoformer);
	public abstract void ponerSuperficieAire(Coordenada coordenada);
	public abstract void producirEfecto(HabitableDelMapa afectado);
	
}
