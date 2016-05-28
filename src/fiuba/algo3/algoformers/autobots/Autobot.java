package fiuba.algo3.algoformers.autobots;

import fiuba.algo3.algoformers.Algoformer;
import fiuba.algo3.algoformers.decepticons.Decepticon;
import fiuba.algo3.algoformers.excepciones.MismoEquipoException;

public class Autobot extends Algoformer{

	public Autobot(){
	}

	@Override
	public void serAtacado(Autobot atacante, int ataque){
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
