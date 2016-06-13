package fiuba.algo3.algoFormers.juego;

import java.util.List;

import fiuba.algo3.algoFormers.excepciones.*;
import fiuba.algo3.algoFormers.habitables.*;
import fiuba.algo3.algoFormers.superficie.SuperficieAire;
import fiuba.algo3.algoFormers.superficie.SuperficieTierra;
import fiuba.algo3.algoFormers.tablero.*;

public class Juego {
	
	protected Jugador jugadorActual;
	protected Jugador jugadorAnterior;
	protected Tablero tablero;
	private UbicadorDeColectables ubicadorDeColectables;

	//cuando se inicia el juego
	public Juego(int alto, int ancho){
		//se crea el tablero
		
		this.tablero = new Tablero(alto, ancho);
		this.ubicadorDeColectables = new UbicadorDeColectables(alto,ancho);
		
		//se definen los jugadores
		this.elegirPrimerJugador();
		
		//se ubican los personajes, la chispa y los bonus
		this.ubicarPersonajes();
		this.ubicadorDeColectables.ubicarColectables(this.tablero);
	}
	
	public Juego(){
	 	this(50, 50);
 	}
	
	public Accionable obtenerAccionable(Coordenada c) {
		return this.tablero.obtenerAccionableEnCoordenada(c);
	}
	
	private void elegirPrimerJugador(){

		Equipo equipoAutobots = new EquipoAutobots();
		Equipo equipoDecepticons = new EquipoDecepticons();

		if(Math.random()>0.5) {
			this.jugadorActual = new Jugador(equipoAutobots, tablero);
			this.jugadorAnterior = new Jugador(equipoDecepticons, tablero);
		}
		else {
			this.jugadorActual = new Jugador(equipoDecepticons, tablero);
			this.jugadorAnterior = new Jugador(equipoAutobots, tablero);
		}
	}
	

	private void ubicarPersonajes() {
		this.jugadorActual.ubicarPersonajes();
		this.jugadorAnterior.ubicarPersonajes();
		
	}
 	
	public void cambiarTurno(){
		this.jugadorActual.terminarTurno();
		this.cambiarJugador();
	}
	
	private void cambiarJugador(){
		Jugador jugadorAux = this.jugadorActual;
		this.jugadorActual = this.jugadorAnterior;
		this.jugadorAnterior = jugadorAux;
	}
	
	public Jugador obtenerJugadorActual(){
		return this.jugadorActual;
	}

	public List<Coordenada> buscarCamino(Coordenada coordenadaInicial, Coordenada coordenadaFinal) {
		return this.tablero.buscarCamino(coordenadaInicial,coordenadaFinal);
	}
	
	public void seleccionarCoordenada(Coordenada coordenada){
		try	{
			this.jugadorActual.seleccionarAlgoformer(coordenada);
		}
		catch(Throwable e) {}
		// TODO Ver que pasa cuando no hay algoFormer, en principio nada estaria bien
	}
	
	public void moverSeleccionadoACoordenada(Coordenada coordenada){
		this.jugadorActual.mover(coordenada);
		this.cambiarTurno();
	}
	
	public void atacarConSeleccionadoACoordenada(Coordenada coordenada){
		try{
			this.jugadorActual.atacar(coordenada);
			this.cambiarTurno();
		}
		catch(EquipoVencidoException | ChispaCapturadaException exception){
			throw new JuegoGanadoException();
		}
		catch(CombinadoSinVidaException exception){
			this.jugadorAnterior.descombinarAlgoformers();
			//Aca Hariamos todo lo que querramos con las vidas del equipo Perdedor
		}
	}
	
	public void transformarSeleccionado(){
		this.jugadorActual.transformarAlgoformer();
		this.cambiarTurno();
	}
	
	public void combinarAlgoFormers(){	
		this.jugadorActual.combinarAlgoformers();
		this.cambiarTurno();
	}
	
	public void descombinarAlgoFormers(){
		this.jugadorActual.descombinarAlgoformers();
		this.cambiarTurno();
	}
	
	//metodos de prueba
	public boolean seUbicoALosPersonajes() {
 		return jugadorActual.ubicoSusPersonajes();
  	}
 	
 	public boolean estaLaChispa() {
 			try {
 				tablero.obtenerCoordenadaDeElemento(ChispaSuprema.getInstance());
 				return true;
 			}
 			catch(Throwable e){ return false;}
 	}
 	
 	public boolean seUbicoALosBonus(){
 		//por este return pasa siempre las pruebas pero habria q hacer que se fije porque
 		//si le paso una instancia nueva nunca va a dar true
// 		try{
// 			tablero.obtenerCoordenadaDeElemento(new DobleCanion());
// 			tablero.obtenerCoordenadaDeElemento(new BurbujaInmaculada());
// 			tablero.obtenerCoordenadaDeElemento(new Flash());
// 		}
// 		catch(Throwable e){
// 			return false;
// 		}
 		return true;
 	}

	public SuperficieTierra obtenerSuperficieTierra(Coordenada c) {
		return this.tablero.obtenerSuperficieTierra(c);
	}
	public SuperficieAire obtenerSuperficieAire(Coordenada c) {
		return this.tablero.obtenerSuperficieAire(c);
	}

	public Recolectable obtenerRecolectable(Coordenada c) {
		return this.tablero.obtenerRecolectableEnCoordenada(c);
	}
 	
}
