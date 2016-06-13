package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.afectadores.AfectadorPorTurnos;
import fiuba.algo3.algoFormers.generico.Algoformer;

public abstract class Bonus implements Collectable{
	
	public AfectadorPorTurnos afectador;
	public abstract void producirEfecto(Algoformer algoformer);
	public abstract void desafectar(Algoformer algoformer);

	public boolean consumido(){
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
}
