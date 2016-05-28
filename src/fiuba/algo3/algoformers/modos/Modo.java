package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.generico.Algoformer;
<<<<<<< HEAD
fiuba.algo3.algoFormers.Algoformer;
=======
>>>>>>> 50141a8f524a316f866abc74cc649178add4c3e7

public interface Modo{
	
	public void atacar(Autobot atacante, Algoformer atacado);
	public void atacar(Decepticon atacante, Algoformer atacado);
	public void cambiar(algoformer);
}
