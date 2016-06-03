package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.generico.Algoformer;

public class EfectoPantano implements Efecto {

	@Override
	public void afectarAlgoformer(Algoformer algoformer) {
		algoformer.multiplicarVelocidad(0.5);
	}

	@Override
	public void desafectarAlgoformer(Algoformer algoformer) {
		algoformer.multiplicarVelocidad(2);
	}

}
