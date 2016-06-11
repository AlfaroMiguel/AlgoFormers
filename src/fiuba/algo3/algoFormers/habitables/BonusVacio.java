package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.excepciones.NoProduceEfectoException;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class BonusVacio implements Collectable {

	@Override
	public void colisionar() {
		// TODO Auto-generated method stub

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

}
