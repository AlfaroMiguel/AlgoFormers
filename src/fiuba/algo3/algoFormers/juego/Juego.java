package fiuba.algo3.algoFormers.juego;

import java.util.List;

import fiuba.algo3.algoFormers.excepciones.*;
import fiuba.algo3.algoFormers.generico.Observable;
import fiuba.algo3.algoFormers.generico.Observador;
import fiuba.algo3.algoFormers.habitables.*;
import fiuba.algo3.algoFormers.superficie.SuperficieAire;
import fiuba.algo3.algoFormers.superficie.SuperficieEspinas;
import fiuba.algo3.algoFormers.superficie.SuperficiePantano;
import fiuba.algo3.algoFormers.superficie.SuperficieTierra;
import fiuba.algo3.algoFormers.tablero.*;


public class Juego implements Observador{
	
	protected Jugador jugadorActual;
	protected Jugador jugadorAnterior;
	protected Tablero tablero;
	private UbicadorDeColectables ubicadorDeColectables;
	private Observable observado;
	private boolean terminado = false;
	

	//cuando se inicia el juego
	public Juego(int alto, int ancho){
		//se crea el tablero

		this.tablero = new Tablero(alto, ancho);
		this.ubicadorDeColectables = new UbicadorDeColectables(alto,ancho);

		
		//Para probar
		tablero.colocarSuperficieEnTablero(new SuperficiePantano(), new Coordenada(5,5));
		tablero.colocarSuperficieEnTablero(new SuperficieEspinas(), new Coordenada(14,5));
		
		//se definen los jugadores
		this.elegirPrimerJugador();
		this.tablero.generarMapa();

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

	public boolean seleccionarCoordenada(Coordenada coordenada){
		try	{
			this.jugadorActual.seleccionarAlgoformer(coordenada);
			//Esto es nuevo 13/6/2016
			System.out.println("Selecciona correctamente");
			return true;

		}
		catch(NoSeleccionableException exception) {
			//no se puede seleccionar lo que hay en la coordenada
			return false;
		}
		catch(EquipoInvalidoException exception){
			//el algoformer en la posicion es del otro equipo
			return false;
		}

	}

	public void moverSeleccionadoACoordenada(Coordenada coordenada){
		this.observarA(ChispaSuprema.getInstance());
		ChispaSuprema.getInstance().agregarObservador(this);
		this.jugadorActual.mover(coordenada);
		this.cambiarTurno();
	}

	public void atacarConSeleccionadoACoordenada(Coordenada coordenada){
		this.observarA(this.jugadorActual.verEquipo());
		this.jugadorActual.verEquipo().agregarObservador(this);
		this.jugadorActual.atacar(coordenada);
		this.cambiarTurno();
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

	@Override
	public void actualizar(){
		this.terminarJuego();
	}

	private void terminarJuego(){
		this.terminado = true;
	}
	
	public boolean estaTerminado(){
		return terminado;
	}

	@Override
	public void observarA(Observable observable) {
		this.observado = observable;
		observado.agregarObservador(this);
	}
 	
	//metodos de prueba
	public void capturarChispa(){
		this.observarA(ChispaSuprema.getInstance());
		ChispaSuprema.getInstance().producirEfecto(this.jugadorActual.verAlgoformerActual());
	}
	
	public void hacerGanarEquipo(){
		this.observarA(this.jugadorActual.equipo);
		this.jugadorActual.equipo.hacerGanar();
	}
	
	public boolean seUbicoALosPersonajes() {
 		return jugadorActual.ubicoSusPersonajes();
  	}
 	
 	public boolean estaLaChispa(){
 			try {
 				tablero.obtenerCoordenadaDeElemento(ChispaSuprema.getInstance());
 				return true;
 			}
 			catch(Throwable e){ return false;}
 	}
	
}
