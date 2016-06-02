package fiuba.algo3.algoFormers.autobots;

import fiuba.algo3.algoFormers.generico.Vida;
import fiuba.algo3.algoFormers.modos.BumblebeeHumanoide;

public class Bumblebee extends Autobot {
	
	public Bumblebee(){
		this.modo = BumblebeeHumanoide.getInstance();
		this.vida = new Vida(350);
	}
}
