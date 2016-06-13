package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.generico.Algoformer;

public interface Recolectable{
	
	public void colisionar();
	public boolean ocupaLugar();
	public void producirEfecto(Algoformer algoformer);
	public void desafectar(Algoformer algoformer);
	public boolean consumido();
	public boolean equals(BonusVacio otro);
}
