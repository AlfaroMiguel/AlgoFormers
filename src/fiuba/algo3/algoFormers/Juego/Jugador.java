package fiuba.algo3.algoFormers.Juego;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class Jugador{
	protected Equipo equipo;
	//Va a tener nombre, es necesario?
	public Tablero tablero;
	
	public Jugador(Equipo equipo, Tablero tablero){
		this.equipo = equipo;
		this.tablero = tablero;
	}
	
	public Algoformer verAlgoformerActual(){
		return this.equipo.verAlgoformerActual();
	}
	
	public void seleccionarAlgoformer(Autobot autobot){
		this.equipo.seleccionarAlgoformer(autobot);
	}
	
	public void seleccionarAlgoformer(Decepticon decepticon){
		this.equipo.seleccionarAlgoformer(decepticon);
	}
	
	//no recibe un algoformer sino que ataca con el actual del equipo (el que este seleccionado)
	public void atacar(Coordenada coordenada) {
		
	}
	
	//no recibe un algoformer sino que mueve al actual del equipo (el que este seleccionado)
	public void mover(Coordenada coordenada) {
		this.equipo.mover(coordenada, tablero);
	}
	
	public void transformarAlgoformer(){
		this.equipo.transformarAlgoformer();
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
