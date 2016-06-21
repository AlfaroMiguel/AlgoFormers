package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.generico.Algoformer;

/* Clase que representa al efecto causado por el bonus BurbujaInmaculada.
 * Impide que el algoformer reciba daño durante 2 turnos propios.*/
public class EfectoBurbujaInmaculada implements Efecto{
	
	/*Metodos abstractos redefinidos*/
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
		//dos efectos son iguales si son de la misma clase
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	
}
