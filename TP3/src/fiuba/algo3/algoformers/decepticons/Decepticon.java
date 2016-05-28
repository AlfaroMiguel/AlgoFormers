package fiuba.algo3.algoformers.decepticons;

import fiuba.algo3.algoformers.Algoformer;
import fiuba.algo3.algoformers.autobots.Autobot;
import fiuba.algo3.algoformers.modos.Modo;

public class Decepticon extends Algoformer {

	public Decepticon(Modo modo) {
		super(modo);
	}
	
	public void atacar(Algoformer algoformer){
		this.modo.atacar(algoformer);
	}
	
	public void serAtacado(Algoformer algoformer, int daño){
		this.serAtacado(algoformer, daño);
	}
	
	public void serAtacado(Autobot autobot, int daño){
		this.vida = this.vida - daño;
	}
}
