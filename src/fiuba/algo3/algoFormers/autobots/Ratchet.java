package fiuba.algo3.algoFormers.autobots;

import fiuba.algo3.algoFormers.generico.Vida;
import fiuba.algo3.algoFormers.modos.RatchetHumanoide;

public class Ratchet extends Autobot {
	
	public Ratchet(){
		this.modo = RatchetHumanoide.getInstance();
		this.vida = new Vida(150);
	}
}
