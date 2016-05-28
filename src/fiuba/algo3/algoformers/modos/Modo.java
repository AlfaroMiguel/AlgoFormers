package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.generico.Algoformer;
fiuba.algo3.algoFormers.Algoformer;

public interface Modo{
	
	public void atacar(Autobot atacante, Algoformer atacado);
	public void atacar(Decepticon atacante, Algoformer atacado);
	public void cambiar(algoformer);
}
