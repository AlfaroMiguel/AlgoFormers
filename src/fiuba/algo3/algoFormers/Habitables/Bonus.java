package fiuba.algo3.algoFormers.Habitables;

import fiuba.algo3.algoFormers.afectadores.Afectador;
import fiuba.algo3.algoFormers.generico.Algoformer;

public abstract class Bonus implements Collectable{
	
	public Afectador afectador;
	public abstract void producirEfecto(Algoformer algoformer);
	public abstract void desafectar(Algoformer algoformer);


	@Override
	public void colisionar() {
	}

	@Override
	public boolean ocupaLugar() {
		return true;
	}	
}
