package fiuba.algo3.algoFormers.Habitables;

import fiuba.algo3.algoFormers.generico.Algoformer;

public interface Collectable{
	
	public void colisionar();
	public boolean ocupaLugar();
	public void producirEfecto(Algoformer algoformer);
	public void desafectar(Algoformer algoformer);
}
