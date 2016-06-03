package fiuba.algo3.algoFormers.afectadores;

import fiuba.algo3.algoFormers.efectos.Efecto;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class AfectadorPermanente extends Afectador {
	private Efecto efecto;
	public AfectadorPermanente(Efecto efecto){
		this.efecto= efecto;
	}
	@Override
	public void desafectarAlgoformer(Algoformer algoformer){
		
	}
	@Override
	public void pasarTurno() {
		// TODO Auto-generated method stub
		
	}

}
