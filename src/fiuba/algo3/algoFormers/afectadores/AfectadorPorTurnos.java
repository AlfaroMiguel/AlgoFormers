package fiuba.algo3.algoFormers.afectadores;

import fiuba.algo3.algoFormers.efectos.Efecto;
import fiuba.algo3.algoFormers.efectos.EfectoTerminado;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.ListaDeAfectadores;

public class AfectadorPorTurnos extends Afectador {
	
	int turnos;
	private boolean activado;
	
	public AfectadorPorTurnos(int turnos,Efecto efecto){
		this.turnos = turnos;
		this.efecto = efecto;
		this.activado=false;
	}
	public void activar(){
		this.activado=true;
	}
	public boolean activado(){
		return this.activado;
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
	public void desafectarAlgoformer(Algoformer algoformer){
	}
	
	@Override
	public void afectarPorPaso(Algoformer algoformer) {
		algoformer.agregarEfecto(this);	
	}

	@Override
	public void afectarAlgoformer(Algoformer algoformer) {
		ListaDeAfectadores afectadores  = algoformer.obtenerAfectadoresEnAtacable();
		afectadores.agregarAfectador(this);	
	}
}
