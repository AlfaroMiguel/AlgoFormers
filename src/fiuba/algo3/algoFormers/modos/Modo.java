package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Superficies.SuperficieTierra;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.generico.Algoformer;

public interface Modo{
	
	public void atacar(Tablero tablero, Autobot atacante, HabitableDelMapa atacado);
	public void atacar(Tablero tablero, Decepticon atacante, HabitableDelMapa atacado);
	public void cambiar(Algoformer algoformer);
	public void moverse(Algoformer algoformer, Coordenada coordenada, Tablero tablero);
	//public void reaccionar(SuperficieTierra superficie);
}
