package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.generico.Algoformer;

/* Clase que representa al efecto causado por la superficie Espinas.
 * Causa un 5% de daño al algoformer que la atraviese en cualquier estado*/
public class EfectoEspinas implements Efecto {
	
	/*Metodos abstractos redefinidos*/
	@Override
	public void afectarAlgoformer(Algoformer algoformer){
		algoformer.multiplicarVida(0.95);
	}

	@Override
	public void desafectarAlgoformer(Algoformer algoformer){
	}

}
