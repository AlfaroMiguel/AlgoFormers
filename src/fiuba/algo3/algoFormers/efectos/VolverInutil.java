package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.generico.Algoformer;

/* Clase que representa un efecto que causa que el algoformer afectado
 * no pueda realizar ninguna accion*/
public class VolverInutil implements Efecto {
	
	/*Metodos abstractos redefinidos*/
	@Override
	public void afectarAlgoformer(Algoformer algoformer){
		algoformer.multiplicarAtaque(0);
		algoformer.multiplicarVelocidad(0);
	}

	@Override
	public void desafectarAlgoformer(Algoformer algoformer){
	}

}
