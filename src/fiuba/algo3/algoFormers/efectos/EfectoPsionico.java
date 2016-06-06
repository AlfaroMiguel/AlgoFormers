package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.generico.Algoformer;

public class EfectoPsionico implements Efecto {

	@Override
	public void afectarAlgoformer(Algoformer algoformer) {
		algoformer.multiplicarAtaque(0.4);

	}

	@Override
	public void desafectarAlgoformer(Algoformer algoformer) {
		// TODO Auto-generated method stub

	}

}
