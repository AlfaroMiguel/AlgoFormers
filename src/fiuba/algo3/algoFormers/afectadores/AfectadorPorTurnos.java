package fiuba.algo3.algoFormers.afectadores;

import fiuba.algo3.algoFormers.efectos.Efecto;
import fiuba.algo3.algoFormers.efectos.EfectoTerminado;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.ListaDeAfectadores;

public class AfectadorPorTurnos extends Afectador {
	
	int turnos;
	
	public AfectadorPorTurnos(int turnos,Efecto efecto){
		this.turnos = turnos;
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
	}
	
	@Override
	public void afectarPorPaso(Algoformer algoformer) {
		algoformer.agregarEfecto(this);	
	}

	@Override
	public void afectarAlgoformer(Algoformer algoformer) {
		ListaDeAfectadores afectadores  = algoformer.getAfectadores();
		afectadores.agregarAfectador(this);	
	}
}
