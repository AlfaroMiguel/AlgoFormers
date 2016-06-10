package fiuba.algo3.algoFormers.Habitables;

import fiuba.algo3.algoFormers.excepciones.JuegoGanadoException;
import fiuba.algo3.algoFormers.generico.Algoformer;

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
	public void producirEfecto(Algoformer algoformer) {
		throw new JuegoGanadoException();
	}

	@Override
	public void desafectar(Algoformer algoformer) {
		// TODO Auto-generated method stub
		
	}

}
