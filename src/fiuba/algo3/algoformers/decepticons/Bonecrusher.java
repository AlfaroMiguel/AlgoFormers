package fiuba.algo3.algoformers.decepticons;

import fiuba.algo3.algoformers.modos.BonecrusherHumanoide;


public class Bonecrusher extends Decepticon {
	
	public Bonecrusher(){
		this.modo = BonecrusherHumanoide.getInstance();
		this.vida = 200;
	}
}
