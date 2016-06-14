package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.afectadores.AfectadorPorTurnos;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.Observador;

public abstract class Bonus implements Recolectable{
	
	public AfectadorPorTurnos afectador;
	public abstract void producirEfecto(Algoformer algoformer);
	public abstract void desafectar(Algoformer algoformer);

	public boolean fueConsumido(){
		return this.afectador.estaActivado();
	}
	
	@Override
	public void colisionar() {
	}

	@Override
	public boolean ocupaLugar() {
		return true;
	}	
	
	public boolean equals(BonusVacio otro){
		return false;
	}
	
	@Override
	public void agregarObservador(Observador observador) {
	}
	
	@Override
	public void eliminarObservador(Observador observador) {
	}
	
	@Override
	public void notificarObservadores() {
	}
}
