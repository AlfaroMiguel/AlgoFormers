package fiuba.algo3.algoFormers.decepticons;

import fiuba.algo3.algoFormers.modos.FrenzyHumanoide;

public class Frenzy extends Decepticon {
	
	public Frenzy(){
		this.modo = FrenzyHumanoide.getInstance();
		this.vida = 400;
	}
}
