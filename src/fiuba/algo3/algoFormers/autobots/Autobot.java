package fiuba.algo3.algoFormers.autobots;

import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.excepciones.MismoEquipoException;
import fiuba.algo3.algoFormers.generico.Algoformer;

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

	@Override
	public void colisionar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean ocupaLugar() {
		return true;
	}
	
}
