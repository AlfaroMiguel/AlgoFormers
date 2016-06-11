package fiuba.algo3.algoFormers.decepticons;

import fiuba.algo3.algoFormers.generico.Vida;
import fiuba.algo3.algoFormers.modos.BonecrusherHumanoide;


public class Bonecrusher extends Decepticon {
	
	public Bonecrusher(){
		this.modo = BonecrusherHumanoide.getInstance();
		this.vida = new Vida(200);
	}
}
