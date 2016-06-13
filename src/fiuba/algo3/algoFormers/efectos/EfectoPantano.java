package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.generico.Algoformer;

/* Clase que representa al efecto causado por la superficie Pantano.
 * No permite que el casillero sea atravesado por algoformers en modo humanoide.
 * Causa que algoformers en modo terrestre tarden el doble en atravesar el casillero.*/
public class EfectoPantano implements Efecto{
	
	/*Metodos abstractos redefinidos*/
	@Override
	public void afectarAlgoformer(Algoformer algoformer){
		algoformer.multiplicarVelocidad(0.5);
	}

	@Override
	public void desafectarAlgoformer(Algoformer algoformer){
		algoformer.multiplicarVelocidad(2);
	}

}
