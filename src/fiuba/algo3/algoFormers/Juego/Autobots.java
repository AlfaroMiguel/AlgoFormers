package fiuba.algo3.algoFormers.Juego;

import fiuba.algo3.algoFormers.Habitables.Collectable;
import fiuba.algo3.algoFormers.Habitables.Vacio;
import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.excepciones.EquipoInvalidoException;
import fiuba.algo3.algoFormers.excepciones.NoAlgoformerException;

public class Autobots extends Equipo {
	
	protected Optimus optimus;
	protected Bumblebee bumblebee;
	protected Ratchet ratchet;
	
	public Autobots(){
		this.optimus = new Optimus();
		this.bumblebee = new Bumblebee();
		this.ratchet = new Ratchet();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bumblebee == null) ? 0 : bumblebee.hashCode());
		result = prime * result + ((optimus == null) ? 0 : optimus.hashCode());
		result = prime * result + ((ratchet == null) ? 0 : ratchet.hashCode());
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
		Autobots other = (Autobots) obj;
		if (bumblebee == null) {
			if (other.bumblebee != null)
				return false;
		} else if (!bumblebee.equals(other.bumblebee))
			return false;
		if (optimus == null) {
			if (other.optimus != null)
				return false;
		} else if (!optimus.equals(other.optimus))
			return false;
		if (ratchet == null) {
			if (other.ratchet != null)
				return false;
		} else if (!ratchet.equals(other.ratchet))
			return false;
		return true;
	}
	
	public void seleccionarAlgoformer(Autobot autobot){
		this.algoformerActual = autobot;
	}
	
	public void seleccionarAlgoformer(Decepticon decepticon){
		throw new EquipoInvalidoException();
	}
	

}
