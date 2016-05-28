package fiuba.algo3.algoFormers.decepticons;

import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.excepciones.MismoEquipoException;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.modos.Modo;

public class Decepticon extends Algoformer {

	public Decepticon() {
	}
	
	@Override
	public void serAtacado(Autobot autobot, int ataque){
		this.vida = this.vida - ataque;
	}
	
	@Override
	public void serAtacado(Decepticon decepticon, int ataque){
		throw new MismoEquipoException();
	}
	
	@Override
	public void atacar(Algoformer atacado) {
		this.modo.atacar(this,atacado);		
	}
}
