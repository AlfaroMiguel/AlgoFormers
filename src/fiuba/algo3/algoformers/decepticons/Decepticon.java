package fiuba.algo3.algoformers.decepticons;

import fiuba.algo3.algoformers.Algoformer;
import fiuba.algo3.algoformers.autobots.Autobot;
import fiuba.algo3.algoformers.excepciones.MismoEquipoException;
import fiuba.algo3.algoformers.modos.Modo;

public class Decepticon extends Algoformer {

	public Decepticon() {
	}
	
<<<<<<< HEAD
	public void atacar(Algoformer atacado){
		this.modo.atacar(this, atacado);
	}
	
	
=======
	@Override
>>>>>>> 4e6dd9403278a679b94419db6271f3e291308933
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
