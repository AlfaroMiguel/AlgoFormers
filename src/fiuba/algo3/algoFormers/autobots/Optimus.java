package fiuba.algo3.algoFormers.autobots;

import fiuba.algo3.algoFormers.generico.Vida;
import fiuba.algo3.algoFormers.modos.OptimusHumanoide;

public class Optimus extends Autobot {
	
	public Optimus(){
		this.modo = OptimusHumanoide.getInstance();
		this.vida = new Vida(500);
	}
}
