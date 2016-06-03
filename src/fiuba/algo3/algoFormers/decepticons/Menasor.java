package fiuba.algo3.algoFormers.decepticons;

import fiuba.algo3.algoFormers.generico.Vida;
import fiuba.algo3.algoFormers.modos.MenasorTerrestre;

public class Menasor extends Decepticon {
	private Megatron megatron;
	private Bonecrusher bonecrusher;
	private Frenzy frenzy;
	
	public Menasor(Megatron megatron, Bonecrusher bonecrusher, Frenzy frenzy){
		this.megatron = megatron;
		this.bonecrusher = bonecrusher;
		this.frenzy = frenzy;
		this.vida = new Vida(megatron.verVida() + bonecrusher.verVida() + frenzy.verVida());
		this.modo = MenasorTerrestre.getInstance();
	}

	public Megatron getMegatron() {
		return this.megatron;
	}
	
	public Bonecrusher getBonecrusher(){
		return this.bonecrusher;
	}
	
	public Frenzy getFrenzy(){
		return this.frenzy;
	}
}	
	
