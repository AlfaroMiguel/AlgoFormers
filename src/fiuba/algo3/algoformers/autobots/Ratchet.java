package fiuba.algo3.algoFormers.autobots;

import fiuba.algo3.algoFormers.modos.RatchetHumanoide;

public class Ratchet extends Autobot {
	
	public Ratchet(){
		this.modo = RatchetHumanoide.getInstance();
		this.vida = 150;
	}
}
