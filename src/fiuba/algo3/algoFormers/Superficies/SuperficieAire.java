package fiuba.algo3.algoFormers.Superficies;

import fiuba.algo3.algoFormers.afectadores.*;
import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.modos.ModoAereo;
import fiuba.algo3.algoFormers.modos.ModoHumanoide;
import fiuba.algo3.algoFormers.modos.ModoTerrestre;

public abstract class SuperficieAire{
	public Afectador afectador;
	
	public void producirEfecto(HabitableDelMapa afectado){
		afectado.reaccionarASuperficie(this);
	}
	public void revertirEfecto(HabitableDelMapa afectado){
		afectado.serDesafectado(this);
	}
	
	
	
	public int simularRecorrido(HabitableDelMapa transeunte) {
		return transeunte.simularEfecto(this);
	}
	
	public abstract int simularPasoDe(Algoformer algoformer);
	public abstract void ponerSuperficieAire(Coordenada coordenada);
	public void afectar(Algoformer afectado, ModoTerrestre modo){
		
	}
	public abstract void afectar(Algoformer afectado, ModoAereo modo);
	public void afectar(Algoformer afectado, ModoHumanoide modo){
		
	}
	public abstract void desafectar(Algoformer algoformer, ModoAereo modoAereo);

	
}
