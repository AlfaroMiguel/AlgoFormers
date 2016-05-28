package fiuba.algo3.algoformers.autobots;

import fiuba.algo3.algoFormers.modos.BumblebeeHumanoide;

public class Bumblebee extends Autobot {
	
	public Bumblebee(){
		this.modo = BumblebeeHumanoide.getInstance();
		this.vida = 350;
	}
}
