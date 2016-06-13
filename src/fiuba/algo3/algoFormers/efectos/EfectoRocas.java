package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.generico.Algoformer;

/* Clase que representa al efecto causado por la superficie Rocosa.
 * No causa nada al algoformer que la atraviesa*/
public class EfectoRocas implements Efecto {
	
	/*Metodos abstractos redefinidos*/
	@Override
	public void afectarAlgoformer(Algoformer algoformer) {
	}

	@Override
	public void desafectarAlgoformer(Algoformer algoformer) {
	}

}
