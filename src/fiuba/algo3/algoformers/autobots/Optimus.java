package fiuba.algo3.algoformers.autobots;

import fiuba.algo3.algoformers.modos.OptimusHumanoide;

public class Optimus extends Autobot {
	
	public Optimus(){
		this.modo = OptimusHumanoide.getInstance();
		this.vida = 500;
	}
}
