package fiuba.algo3.algoFormers.Juego;

import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.autobots.Optimus;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class Jugador {
	protected Equipo equipo;
	//Va a tener nombre, es necesario?
	
	
	public Jugador(Equipo equipo){
		this.equipo = equipo;
	}

	public void atacar(Algoformer algoformer, Coordenada coordenada) {
		//El jugador va a tener el tablero?? No me acuerdo como lo haciamos
	}

	public void mover(Optimus optimus, Coordenada nuevaCoordenada) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((equipo == null) ? 0 : equipo.hashCode());
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
		Jugador other = (Jugador) obj;
		if (equipo == null) {
			if (other.equipo != null)
				return false;
		} else if (!equipo.equals(other.equipo))
			return false;
		return true;
	}
	
}
