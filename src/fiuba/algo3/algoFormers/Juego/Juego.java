package fiuba.algo3.algoFormers.Juego;

import java.util.List;

import fiuba.algo3.algoFormers.Habitables.ChispaSuprema;
import fiuba.algo3.algoFormers.Tablero.*;

public class Juego {
	
	protected Jugador jugadorActual;
	protected Jugador jugadorAnterior;
	protected Tablero tablero;

	public Juego(){
		final int ancho = 20;
		final int alto = 20;
		this.tablero = new Tablero(alto,ancho);
		
		this.elegirPrimerJugador();
		
		this.ubicarPersonajes();
		this.ubicarChispa(alto,ancho);
		
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
	
	private void ubicarChispa(int alto,int ancho) {
		ChispaSuprema chispaSuprema = ChispaSuprema.getInstance();
		
		this.tablero.colocarEnTablero(chispaSuprema, coordenadaChispa(alto,ancho));
		
	}
	
	private Coordenada coordenadaChispa(int alto, int ancho){
//		int q= 3 + (int) (Math.random()*((ancho - 6)));
//		int r= alto/2 + (int) (Math.random()*((alto/2))- 3 );
		return new Coordenada(10,10);
	}


	private void ubicarPersonajes() {
		this.jugadorActual.ubicarPersonajes();
		this.jugadorAnterior.ubicarPersonajes();
		
	}
 
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
 	
	public void cambiarTurno(){
		JugadorProxy jugadorProxy = new JugadorProxy(this.jugadorActual);
		jugadorProxy.eliminarBonus();
		Jugador jugadorAux = this.jugadorAnterior;
		this.jugadorAnterior = this.jugadorActual;
		this.jugadorActual = jugadorAux;
		
	}
	
	public Jugador obtenerJugadorActual(){
		return this.jugadorActual;
	}
	
	public void combinarAlgoformers(){
		this.jugadorActual.combinarAlgoformers();
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
	}
	public void atacarConSeleccionadoACoordenada(Coordenada coordenada){
		this.jugadorActual.atacar(coordenada);
	}
	public void transformarSeleccionado(){
		this.jugadorActual.transformarAlgoformer();
	}
	public void combinarAlgoFormers(){	
		this.jugadorActual.combinarAlgoformers();
	}
	public void descombinarAlgoFormers(){
		this.jugadorActual.descombinarAlgoformers();
	}
}
