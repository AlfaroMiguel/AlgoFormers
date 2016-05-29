package fiuba.algo3.algoFormers.Habitables;

import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.excepciones.NoAtacableException;

public class ChispaSuprema implements Collectable{

	private static final ChispaSuprema INSTANCE = new ChispaSuprema();
	private ChispaSuprema(){}

	public static ChispaSuprema getInstance(){
		return INSTANCE;
	}
	public boolean ocupaLugar(){
		return true;
	}
	public void colisionar(){
		
	}

	@Override
	public void serAtacado(Autobot atacante, int ataque) {
		throw new NoAtacableException();
	}
	
	@Override
	public void serAtacado(Decepticon atacante, int ataque) {
		throw new NoAtacableException();
	}
}
