package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.generico.Algoformer;

public class EfectoAndromeda implements Efecto {

	@Override
	public void afectarAlgoformer(Algoformer algoformer) {
		algoformer.inmovilizar();

	}

	@Override
	public void desafectarAlgoformer(Algoformer algoformer) {
		// TODO Auto-generated method stub

	}

}
