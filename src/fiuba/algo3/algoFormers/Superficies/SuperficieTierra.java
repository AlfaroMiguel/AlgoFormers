package fiuba.algo3.algoFormers.Superficies;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.afectadores.*;
import fiuba.algo3.algoFormers.efectos.Efecto;
import fiuba.algo3.algoFormers.generico.Algoformer;

public abstract class SuperficieTierra{
	public Afectador afectador;
	
	public void producirEfecto(HabitableDelMapa afectado){
		afectado.reaccionarASuperficie(this);
	}
	public void revertirEfecto(HabitableDelMapa afectado){
		afectado.serDesafectado(this);
	}
	public void afectar(Algoformer algoformer){
		afectador.afectarAlgoformer(algoformer);
	}
	public void desafectar(Algoformer algoformer){
		afectador.desafectarAlgoformer(algoformer);
	}
	
	public void simularRecorrido(HabitableDelMapa transeunte) {
		// TODO Auto-generated method stub
		
	}
	public void ubicar(HabitableDelMapa habitable) {
		// TODO Auto-generated method stub
		
	}
}
