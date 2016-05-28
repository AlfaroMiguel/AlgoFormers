package fiuba.algo3.algoformers.autobots;

import fiuba.algo3.algoformers.Algoformer;
import fiuba.algo3.algoformers.decepticons.Decepticon;
import fiuba.algo3.algoformers.excepciones.MismoEquipoException;

public class Autobot extends Algoformer{

	public Autobot(){
	}
<<<<<<< HEAD
	
	public void atacar(Algoformer atacado){
		this.modo.atacar(this, atacado);
	}
	
	public void serAtacado(Autobot autobot, int ataque){
=======

	@Override
	public void serAtacado(Autobot atacante, int ataque){
>>>>>>> 4e6dd9403278a679b94419db6271f3e291308933
		throw new MismoEquipoException();
	}
	
	@Override
	public void serAtacado(Decepticon atacante, int ataque){
		this.vida = this.vida - ataque;
	}


	@Override
	public void atacar(Algoformer atacado) {
		this.modo.atacar(this,atacado);
		
	}
	
}
