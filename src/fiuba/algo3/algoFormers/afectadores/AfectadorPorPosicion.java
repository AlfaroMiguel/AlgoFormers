package fiuba.algo3.algoFormers.afectadores;

import fiuba.algo3.algoFormers.efectos.Efecto;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.ListaDeAfectadores;

public class AfectadorPorPosicion extends Afectador {
	
	public AfectadorPorPosicion(Efecto efecto){
		this.efecto = efecto;
	}
	
	@Override
	public void desafectarAlgoformer(Algoformer algoformer){
		algoformer.obtenerAfectadoresEnAtacable().sacarAfectador(this);
	}
	
	@Override
	public void pasarTurno(){
	}
	
	@Override
	public void afectarPorPaso(Algoformer algoformer) {
		this.efecto.afectarAlgoformer(algoformer);
		this.efecto.desafectarAlgoformer(algoformer);	
	}

	@Override
	public void afectarAlgoformer(Algoformer algoformer) {
		ListaDeAfectadores afectadores  = algoformer.obtenerAfectadoresEnAtacable();
		afectadores.agregarAfectador(this);
	}
}
