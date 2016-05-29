package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.generico.Algoformer;

public interface Modo{
	
	public void atacar(Autobot atacante, Algoformer atacado);
	public void atacar(Decepticon atacante, Algoformer atacado);
	public void cambiar(Algoformer algoformer);
	public void moverse(Algoformer algoformer, Coordenada coordenada, Tablero tablero);
}
