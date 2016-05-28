package fiuba.algo3.algoformers.modos;

import fiuba.algo3.algoformers.Algoformer;
import fiuba.algo3.algoformers.autobots.Autobot;
import fiuba.algo3.algoformers.decepticons.Decepticon;

public interface Modo{
	
	public void atacar(Autobot atacante, Algoformer atacado);
	public void atacar(Decepticon atacante, Algoformer atacado);
	public void cambiar(Algoformer algoformer);
}
