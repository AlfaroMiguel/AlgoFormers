package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.generico.Algoformer;

public class VolverInutil implements Efecto {

	@Override
	public void afectarAlgoformer(Algoformer algoformer) {
		algoformer.multiplicarAtaque(0);
		algoformer.multiplicarVelocidad(0);

	}

	@Override
	public void desafectarAlgoformer(Algoformer algoformer) {
		// TODO Auto-generated method stub

	}

}
