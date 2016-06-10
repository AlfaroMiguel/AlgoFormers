package fiuba.algo3.algoFormers.Superficies;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.afectadores.*;
import fiuba.algo3.algoFormers.efectos.Efecto;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.modos.*;

public abstract class SuperficieTierra{
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
	public void ubicar(HabitableDelMapa habitable) {
		// TODO Auto-generated method stub
		
	}
	public abstract int simularPasoDe(Algoformer algoformer);
	public abstract void ponerSuperficieTierra(Coordenada coordenada);
	public abstract  void afectar(Algoformer afectado, ModoTerrestreAlterno modo);
	public void afectar(Algoformer afectado, ModoAereo modo){
		
	}
	public abstract  void afectar(Algoformer afectado, ModoHumanoide modo);
	public abstract void desafectar(Algoformer algoformer, ModoTerrestreAlterno modoTerrestreAlterno);
	public abstract void desafectar(Algoformer algoformer, ModoHumanoide modoTerrestreAlterno);
}
