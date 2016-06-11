package fiuba.algo3.algoFormers.afectadores;

import fiuba.algo3.algoFormers.efectos.Efecto;
import fiuba.algo3.algoFormers.generico.*;

public abstract class Afectador{
	
	protected Efecto efecto;
	
	public abstract void afectarPorPaso(Algoformer algoformer);
	public abstract void desafectarAlgoformer(Algoformer algoformer);
	public abstract void pasarTurno();
	
	public abstract void afectarAlgoformer(Algoformer algoformer);
	
	public void producirEfecto(Algoformer algoformer){
		this.efecto.afectarAlgoformer(algoformer);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((efecto == null) ? 0 : efecto.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Afectador other = (Afectador) obj;
		if (efecto == null) {
			if (other.efecto != null)
				return false;
		} else if (!efecto.equals(other.efecto))
			return false;
		return true;
	}	
	
}
