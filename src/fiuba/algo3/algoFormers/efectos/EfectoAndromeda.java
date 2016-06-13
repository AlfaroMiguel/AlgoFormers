package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.generico.Algoformer;

/* Clase que representa al efecto causado por la superficie Nebulosa de Andromeda.
 * Atrapa al algoformer en el casillero durante 3 turnos propios.*/
public class EfectoAndromeda implements Efecto {

	/*Metodos abstractos redefinidos*/
	@Override
	public void afectarAlgoformer(Algoformer algoformer) {
		algoformer.inmovilizar();
	}

	@Override
	public void desafectarAlgoformer(Algoformer algoformer) {
	}

}
