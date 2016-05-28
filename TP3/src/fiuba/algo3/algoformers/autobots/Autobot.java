package fiuba.algo3.algoformers.autobots;

import fiuba.algo3.algoformers.Algoformer;
import fiuba.algo3.algoformers.decepticons.Decepticon;
import fiuba.algo3.algoformers.modos.Modo;

public class Autobot extends Algoformer{

	public Autobot(Modo modo) {
		super(modo);
	}
	
	public void atacar(Algoformer algoformer){
		this.modo.atacar(algoformer);
	}
	
	public void serAtacado(Algoformer algoformer, int daño){
		this.serAtacado(algoformer, daño);
	}
	
	public void serAtacado(Autobot autobot, int daño){
		//pass
	}

	public void serAtacado(Decepticon decepticon, int daño){
		this.vida = this.vida - daño;
	}

}
