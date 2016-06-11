package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.generico.Algoformer;

public class EfectoFlash implements Efecto {

	@Override
	public void afectarAlgoformer(Algoformer algoformer) {
		algoformer.multiplicarVelocidad(3);
	}

	@Override
	public void desafectarAlgoformer(Algoformer algoformer) {
		algoformer.multiplicarVelocidad(1/3);
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
