package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.generico.Algoformer;

public class EfectoEspinas implements Efecto {

	@Override
	public void afectarAlgoformer(Algoformer algoformer) {
		algoformer.multiplicarVida(0.95);
	}

	@Override
	public void desafectarAlgoformer(Algoformer algoformer) {
	}

}
