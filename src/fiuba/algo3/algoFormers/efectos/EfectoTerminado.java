package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.generico.Algoformer;

public class EfectoTerminado implements Efecto {

	@Override
	public void afectarAlgoformer(Algoformer algoformer) {

	}

	@Override
	public void desafectarAlgoformer(Algoformer algoformer) {
		// TODO Auto-generated method stub
		
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
