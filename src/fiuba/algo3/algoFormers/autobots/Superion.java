package fiuba.algo3.algoFormers.autobots;

import fiuba.algo3.algoFormers.generico.Vida;
import fiuba.algo3.algoFormers.modos.SuperionTerrestre;

public class Superion extends Autobot {
	private Optimus optimus;
	private Ratchet ratchet;
	private Bumblebee bumblebee;
	
	public Superion(Optimus optimus, Ratchet ratchet, Bumblebee bumblebee){
		this.optimus = optimus;
		this.ratchet = ratchet;
		this.bumblebee = bumblebee;
		this.vida = new Vida(optimus.verVida() + ratchet.verVida() + bumblebee.verVida());
		this.modo = SuperionTerrestre.getInstance();
	}

	public Optimus getOptimus() {
		return this.optimus;
	}
	
	public Bumblebee getBumblebee(){
		return this.bumblebee;
	}
	
	public Ratchet getRatchet(){
		return this.ratchet;
	}
}
