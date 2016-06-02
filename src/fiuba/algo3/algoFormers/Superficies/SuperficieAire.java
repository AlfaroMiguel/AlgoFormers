package fiuba.algo3.algoFormers.Superficies;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.efectos.Efecto;
import fiuba.algo3.algoFormers.generico.Algoformer;

public abstract class SuperficieAire{
	public Efecto efecto;
	
	public void producirEfecto(HabitableDelMapa afectado){
		afectado.reaccionarASuperficie(this);
	}
	public void revertirEfecto(HabitableDelMapa afectado){
		afectado.serDesafectado(this);
	}
	public void afectar(Algoformer algoformer){
		efecto.afectarAlgoformer(algoformer);
	}
	public void desafectar(Algoformer algoformer){
		efecto.desafectarAlgoformer(algoformer);
	}
	
	public void simularRecorrido(HabitableDelMapa transeunte) {
		// TODO Auto-generated method stub
		
	}
	
}
