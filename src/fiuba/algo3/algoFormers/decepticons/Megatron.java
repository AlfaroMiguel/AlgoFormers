package fiuba.algo3.algoFormers.decepticons;

import fiuba.algo3.algoFormers.generico.Vida;
import fiuba.algo3.algoFormers.modos.MegatronHumanoide;

public class Megatron extends Decepticon {
	
	public Megatron(){
		this.modo = MegatronHumanoide.getInstance();
		this.vida = new Vida(550);
	}
}
