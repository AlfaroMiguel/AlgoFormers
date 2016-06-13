package fiuba.algo3.algoFormers.efectos;

import fiuba.algo3.algoFormers.generico.Algoformer;

/*Interfaz que representa los efectos que se le pueden aplicar a los algoformers*/
public interface Efecto {
	
	/*Metodos abstractos*/
	/*Se causa en el algoformer*/
	public void afectarAlgoformer(Algoformer algoformer);
	/*Se revierte en el algoformer*/
	public void desafectarAlgoformer(Algoformer algoformer);
}
