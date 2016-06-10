package fiuba.algo3.algoFormers.Juego;

import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class Jugador{
	protected Equipo equipo;
	protected Tablero tablero;
	
	public Jugador(Equipo equipo, Tablero tablero){
		this.equipo = equipo;
		this.tablero = tablero;
	}
	
	public Algoformer verAlgoformerActual(){
		return this.equipo.verAlgoformerActual();
	}

	public void seleccionarAlgoformer(Coordenada coordenada){
		this.equipo.seleccionarAlgoformer(this.tablero.obtenerAccionableEnCoordenada(coordenada));
	}
	
	public void atacar(Coordenada coordenadaDestino) {
		this.equipo.atacar(this.tablero, this.tablero.obtenerAccionableEnCoordenada(coordenadaDestino));
	}
	
	public void mover(Coordenada coordenada) {
		this.equipo.mover(coordenada, this.tablero);
	}
	
	public void transformarAlgoformer(){
		this.equipo.retirarPersonajeActual(this.tablero);
		this.equipo.transformarAlgoformer();
		//Para que se apliquen los efectos cuando se cambia de modo a uno que si lo afecta
		this.equipo.reposicionarAlgoformer(this.tablero);
	}
	
	public boolean ubicoSusPersonajes() {
		 return !(this.tablero.obtenerCoordenadaDeElemento(this.verAlgoformerActual()) == null);
	 }
	
	public void ubicarPersonajes() {
		 this.equipo.ubicarPersonajes(this.tablero);
	}
	
	public void combinarAlgoformers(){
		this.equipo.combinarAlgoformers(this.tablero);
	}
	
	public void descombinarAlgoformers(){
		this.equipo.descombinarAlgoformers(this.tablero);
	}

	public void terminarTurno() {
		this.equipo.terminarTurno();
		
	}
	
	
}
