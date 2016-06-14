package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.Observable;
import fiuba.algo3.algoFormers.tablero.Coordenada;

public interface Recolectable extends Observable{
	
	public void colisionar();
	public boolean ocupaLugar();
	public void producirEfecto(Algoformer algoformer);
	public void desafectar(Algoformer algoformer);
	public boolean fueConsumido();
	public boolean equals(BonusVacio otro);
	public void ponerRecolectable(Coordenada c);
}
