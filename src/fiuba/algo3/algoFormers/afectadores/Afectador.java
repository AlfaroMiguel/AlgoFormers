package fiuba.algo3.algoFormers.afectadores;

import fiuba.algo3.algoFormers.efectos.Efecto;
import fiuba.algo3.algoFormers.generico.*;

/*Clase que se encarga de manejar los efectos que estan activos en los algoformer
 * durante el tiempo que corresponda*/
public abstract class Afectador{
	
	/*Atributos*/
	/*Efecto que el afectador va a producir en el algoformer*/
	protected Efecto efecto;
	
	/*Metodos abstractos*/
	/*Agrega el efecto en el algoformer*/
	public abstract void afectarAlgoformer(Algoformer algoformer);
	/*Revierte el efecto en el algoformer*/
	public abstract void desafectarAlgoformer(Algoformer algoformer);
	/*Reduce el turno en uno para los efectos que duran por turnos*/
	public abstract void pasarTurno();
	/*Afecta solo cuando pasa por un casillero*/
	public abstract void afectarPorPaso(Algoformer algoformer);
	
	/*Metodos de la clase*/
	/*Activa el efecto en el algoformer*/
	public void producirEfecto(Algoformer algoformer){
		this.efecto.afectarAlgoformer(algoformer);
	}
	
	/*Metodos abstractos redefinidos*/
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((efecto == null) ? 0 : efecto.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj){
		//Dos afectadores son iguales si tienen el mismo efecto
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
