package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.generico.Algoformer;

/* Clase que representa al efecto causado por el bonus Flash.
 * Triplica la velocidad del algoformer durante 3 turnos propios*/
public class EfectoFlash implements Efecto {
	
	/*Metodos abstractos redefinidos*/
	@Override
	public void afectarAlgoformer(Algoformer algoformer) {
		algoformer.multiplicarVelocidad(3);
	}

	@Override
	public void desafectarAlgoformer(Algoformer algoformer) {
		algoformer.multiplicarVelocidad(1/3);
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
