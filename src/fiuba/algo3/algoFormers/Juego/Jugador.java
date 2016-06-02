package fiuba.algo3.algoFormers.Juego;

import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class Jugador{
	protected Equipo equipo;
	//Va a tener nombre, es necesario?
	protected Tablero tablero;
	
	public Jugador(Equipo equipo, Tablero tablero){
		this.equipo = equipo;
		this.tablero = tablero;
	}
	
	public Algoformer verAlgoformerActual(){
		return this.equipo.verAlgoformerActual();
	}

	public void seleccionarAlgoformer(Coordenada coordenada){
		this.equipo.seleccionarAlgoformer(this.tablero.obtenerHabitableEnCoordenada(coordenada));
	}
	
	public void atacar(Coordenada coordenadaDestino) {
		this.equipo.atacar(tablero, this.tablero.obtenerHabitableEnCoordenada(coordenadaDestino));
	}
	
	public void mover(Coordenada coordenada) {
		this.equipo.mover(coordenada, tablero);
	}
	
	public void transformarAlgoformer(){
		this.equipo.transformarAlgoformer();
	}
	
	public boolean ubicoSusPersonajes() {
		 if (this.tablero.obtenerCoordenadaDeHabitable(this.verAlgoformerActual()) == null){
			 return false;
		 }
		 return true;
	 }
	
	public void ubicarPersonajes() {
		 this.equipo.ubicarPersonajes(this.tablero);
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
