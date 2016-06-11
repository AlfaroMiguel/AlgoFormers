package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.generico.Algoformer;

public class EfectoDobleCanion implements Efecto {

	@Override
	public void afectarAlgoformer(Algoformer algoformer) {
		algoformer.multiplicarAtaque(2);
	}

	@Override
	public void desafectarAlgoformer(Algoformer algoformer) {
		algoformer.multiplicarAtaque(0.5);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}
