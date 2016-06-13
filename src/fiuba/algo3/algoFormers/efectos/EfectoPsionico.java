package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.generico.Algoformer;

/* Clase que representa al efecto causado por la superficie Tormenta Psionica.
 * Causa una perdida del 40% de poder de ataque permanente al algoformer que la
 * atraviesa solo la primera vez. Luego no causa nada.*/
public class EfectoPsionico implements Efecto {
	
	/*Metodos abstractos redefinidos*/
	@Override
	public void afectarAlgoformer(Algoformer algoformer){
		algoformer.multiplicarAtaque(0.4);
	}

	@Override
	public void desafectarAlgoformer(Algoformer algoformer){
	}

}
