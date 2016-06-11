package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.afectadores.Afectador;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class EfectoBurbujaInmaculada implements Efecto{
	
	
	@Override
	public void afectarAlgoformer(Algoformer algoformer) {
		algoformer.colocarEscudo();
	}

	@Override
	public void desafectarAlgoformer(Algoformer algoformer){
		algoformer.sacarEscudo();
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
