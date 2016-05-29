package fiuba.algo3.algoFormers.Juego;

import fiuba.algo3.algoFormers.Habitables.Collectable;
import fiuba.algo3.algoFormers.Habitables.Vacio;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.*;
import fiuba.algo3.algoFormers.excepciones.EquipoInvalidoException;
import fiuba.algo3.algoFormers.excepciones.NoAlgoformerException;

public class Decepticons extends Equipo {
	
	protected Megatron megatron;
	protected Frenzy frenzy;
	protected Bonecrusher bonecrusher;
	
	public Decepticons(){
		this.megatron = new Megatron();
		this.frenzy = new Frenzy();
		this.bonecrusher = new Bonecrusher();
		

		this.seleccionarAlgoformer(megatron);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bonecrusher == null) ? 0 : bonecrusher.hashCode());
		result = prime * result + ((frenzy == null) ? 0 : frenzy.hashCode());
		result = prime * result + ((megatron == null) ? 0 : megatron.hashCode());
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
		Decepticons other = (Decepticons) obj;
		if (bonecrusher == null) {
			if (other.bonecrusher != null)
				return false;
		} else if (!bonecrusher.equals(other.bonecrusher))
			return false;
		if (frenzy == null) {
			if (other.frenzy != null)
				return false;
		} else if (!frenzy.equals(other.frenzy))
			return false;
		if (megatron == null) {
			if (other.megatron != null)
				return false;
		} else if (!megatron.equals(other.megatron))
			return false;
		return true;
	}
	
	public void seleccionarAlgoformer(Decepticon decepticon){
		this.algoformerActual = decepticon;
	}
	
	public void seleccionarAlgoformer(Autobot autobot){
		throw new EquipoInvalidoException();
	}	
	
	public void seleccionarAlgoformer(Vacio espacioVacio){
		throw new NoAlgoformerException();
	}
	
	public void seleccionarAlgoformer(Collectable collectable){
		throw new NoAlgoformerException();
	}
	@Override
	public void ubicarPersonajes(Tablero tablero) {
		tablero.put(this.megatron, new Coordenada(18,2));
	 	tablero.put(this.frenzy, new Coordenada(18,2));
	 	tablero.put(this.bonecrusher, new Coordenada(19,1));
		}
}
