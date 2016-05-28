package fiuba.algo3.algoformers.modos;

import fiuba.algo3.algoFormers.Algoformer;

public interface Modo{
	public void atacar(Algoformer atacante, Algoformer atacado);
	public void cambiar(Algoformer algoformer);
}
