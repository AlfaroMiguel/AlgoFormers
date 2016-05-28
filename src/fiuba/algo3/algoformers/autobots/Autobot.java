package fiuba.algo3.algoFormers.autobots;

import fiuba.algo3.algoFormers.Algoformer;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.excepciones.MismoEquipoException;

public class Autobot extends Algoformer{

	public Autobot(){
	}
	
	public void atacar(Algoformer atacado){
		this.modo.atacar(this, atacado);
	}
	
	public void serAtacado(Autobot autobot, int ataque){
		throw new MismoEquipoException();
	}

	public void serAtacado(Decepticon decepticon, int ataque){
		this.vida = this.vida - ataque;
	}

}
