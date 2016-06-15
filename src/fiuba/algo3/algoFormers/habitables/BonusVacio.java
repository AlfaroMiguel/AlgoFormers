package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.tablero.Coordenada;

public class BonusVacio extends Bonus {

	@Override
	public void colisionar() {
		// TODO Auto-generated method stub

	}
	public boolean fueConsumido(){
		return false;
	}
	@Override
	public boolean ocupaLugar() {
		return false;
	}


	@Override
	public void producirEfecto(Algoformer algoformer) {
	}

	@Override
	public void desafectar(Algoformer algoformer) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean equals(BonusVacio otro){
		return true;
	}
	@Override
	public void ponerRecolectable(Coordenada c) {
		// TODO Auto-generated method stub
		
	}

}
