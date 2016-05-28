package fiuba.algo3.algoformers.decepticons;

import fiuba.algo3.algoformers.modos.FrenzyHumanoide;

public class Frenzy extends Decepticon {
	
	public Frenzy(){
		this.modo = FrenzyHumanoide.getInstance();
		this.vida = 400;
	}
}
