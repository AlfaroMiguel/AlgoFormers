package fiuba.algo3.algoformers.decepticons;

import fiuba.algo3.algoformers.modos.MegatronHumanoide;

public class Megatron extends Decepticon {
	
	public Megatron(){
		this.modo = MegatronHumanoide.getInstance();
		this.vida = 550;
	}
}
