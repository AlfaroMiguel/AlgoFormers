package fiuba.algo3.algoFormers.afectadores;

import fiuba.algo3.algoFormers.efectos.Efecto;
import fiuba.algo3.algoFormers.efectos.EfectoTerminado;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class AfectadorPorTurnos extends Afectador {
	int turnos;
	public AfectadorPorTurnos(int i,Efecto efecto){
		this.turnos = i;
		this.efecto = efecto;		
	}
	@Override
	public void pasarTurno(){
		this.turnos--;
		if(this.turnos == 0)
			this.cambiarEfecto();
	}
	public void cambiarEfecto(){
		this.efecto = new EfectoTerminado();
	}
	@Override
	public void desafectarAlgoformer(Algoformer algoformer) {
		// TODO
		
	}
	@Override
	public void afectarPorMicromovimiento(Algoformer algoformer) {
		algoformer.agregarEfecto(this);
		
	}
}
