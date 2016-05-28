package fiuba.algo3.algoformers.autobots;

import fiuba.algo3.algoformers.Algoformer;
import fiuba.algo3.algoformers.decepticons.Decepticon;
import fiuba.algo3.algoformers.excepciones.MismoEquipoException;

public class Autobot extends Algoformer{

	public Autobot(){
	}
	
	public void atacar(Algoformer atacado){
		this.modo.atacar(this, atacado);
	}
	
	public void serAtacado(Algoformer algoformer, int ataque){
		this.serAtacado(algoformer, ataque);
	}
	
	public void serAtacado(Autobot autobot, int ataque){
		throw new MismoEquipoException();
	}

	public void serAtacado(Decepticon decepticon, int ataque){
		this.vida = this.vida - ataque;
	}

}
