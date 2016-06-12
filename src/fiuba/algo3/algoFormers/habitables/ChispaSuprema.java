package fiuba.algo3.algoFormers.habitables;

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
	public void producirEfecto(Algoformer algoformer){
		//algoformer.obtenerColectablesEnAtacable().agregarColectable(this); si cambiamos el final
		throw new JuegoGanadoException();
	}

	@Override
	public void desafectar(Algoformer algoformer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean consumido() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean equals(BonusVacio otro) {
		return false;
	}

}
