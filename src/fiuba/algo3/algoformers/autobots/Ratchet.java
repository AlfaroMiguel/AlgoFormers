package fiuba.algo3.algoformers.autobots;

import fiuba.algo3.algoformers.modos.RatchetHumanoide;

public class Ratchet extends Autobot {
	
	public Ratchet(){
		this.modo = RatchetHumanoide.getInstance();
		this.vida = 150;
	}
}
