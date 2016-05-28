package fiuba.algo3.algoformers.decepticons;

import fiuba.algo3.algoformers.Algoformer;
import fiuba.algo3.algoformers.autobots.Autobot;
import fiuba.algo3.algoformers.modos.Modo;

public class Decepticon extends Algoformer {

	public Decepticon() {
	}
	
	public void atacar(Algoformer atacado){
		this.modo.atacar(this, atacado);
	}
	
	public void serAtacado(Algoformer algoformer, int ataque){
		this.serAtacado(algoformer, ataque);
	}
	
	public void serAtacado(Autobot autobot, int ataque){
		this.vida = this.vida - ataque;
	}
	
	public void serAtacado(Decepticon decepticon, int ataque){
		//pass
	}
}
