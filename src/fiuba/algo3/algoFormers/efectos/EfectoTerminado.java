package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.generico.Algoformer;

/* Clase que representa a un efecto que ya fue consumido 
 * y por lo tanto no causa nada.*/
public class EfectoTerminado implements Efecto {
	
	/*Metodos abstractos redefinidos*/
	@Override
	public void afectarAlgoformer(Algoformer algoformer){
	}

	@Override
	public void desafectarAlgoformer(Algoformer algoformer){	
	}
	
	@Override
	public boolean equals(Object obj){
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
