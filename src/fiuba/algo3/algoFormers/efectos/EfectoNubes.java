package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.generico.Algoformer;

/* Clase que representa al efecto causado por la superficie Nubes.
 * No causa nada al algoformer que la atraviesa.*/
public class EfectoNubes implements Efecto {
	
	/*Metodos abstractos redefinidos*/
	@Override
	public void afectarAlgoformer(Algoformer algoformer) {
	}

	@Override
	public void desafectarAlgoformer(Algoformer algoformer) {
	}

}
