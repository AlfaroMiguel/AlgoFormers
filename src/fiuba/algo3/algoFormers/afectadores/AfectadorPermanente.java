package fiuba.algo3.algoFormers.afectadores;

import fiuba.algo3.algoFormers.efectos.Efecto;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.ListaDeAfectadores;

public class AfectadorPermanente extends Afectador {
	
	public AfectadorPermanente(Efecto efecto){
		this.efecto = efecto;
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

	@Override
	public void pasarTurno() {
	}
}
