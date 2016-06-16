package fiuba.algo3.algoFormers.juego;

import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.ObservableTerminoJuego;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;
import fiuba.algo3.algoFormers.vista.Vista;

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
		try{
		this.equipo.retirarPersonajeActual(this.tablero);
		this.equipo.transformarAlgoformer();
		//Para que se apliquen los efectos cuando se cambia de modo a uno que si lo afecta
		this.equipo.reposicionarAlgoformer(this.tablero);
		}catch (MovimientoInvalidoException exception){
			this.equipo.transformarAlgoformer();
			this.equipo.reposicionarAlgoformer(this.tablero);
		}
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
		//Esto despues lo sacamos
		this.equipo.descombinarAlgoformers(this.tablero);
	}

	public void terminarTurno() {
		this.equipo.terminarTurno();
	}

	public ObservableTerminoJuego verEquipo() {
		return this.equipo;
	}

	public void agregarVista(Vista vista) {
		this.equipo.agregarVista(vista);
		
	}

	
}
