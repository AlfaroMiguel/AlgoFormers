package fiuba.algo3.algoFormers.juego;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoFormers.excepciones.EquipoInvalidoException;
import fiuba.algo3.algoFormers.excepciones.NoSeleccionableException;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.ObservableTerminoJuego;
import fiuba.algo3.algoFormers.generico.ObservadorTerminoJuego;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.habitables.ChispaSuprema;
import fiuba.algo3.algoFormers.habitables.Recolectable;
import fiuba.algo3.algoFormers.superficie.SuperficieAire;
import fiuba.algo3.algoFormers.superficie.SuperficieEspinas;
import fiuba.algo3.algoFormers.superficie.SuperficiePantano;
import fiuba.algo3.algoFormers.superficie.SuperficieTierra;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;
import fiuba.algo3.algoFormers.vista.BarraAlgoformers;
import fiuba.algo3.algoFormers.vista.Vista;

/* Clase que representa al ciclo del juego */
public class Juego implements ObservadorTerminoJuego{
	
	/* Atributos */
	/* Jugador que tiene el turno actual */
	protected Jugador jugadorActual;
	/* Jugador que tuvo el turno anterior */
	protected Jugador jugadorAnterior;
	/* Tablero con los elementos del juego */
	protected Tablero tablero;
	/* Encargado de ubicar los recolectables en el tablero */
	private UbicadorDeRecolectables ubicadorDeRecolectables;
	/* Observable que es observado por el juego en un momento dado. */
	private ObservableTerminoJuego observado;
	/* Variable que indica si el juego tuvo o no un ganador. */
	private boolean terminado = false;
	/* Lista de vistas que cambian segun cambia el juego. */
	private List<Vista> vistas = new ArrayList<Vista>();
	
	/* Constructor */
	/* Crea un juego con un tablero con los elementos ubicados y un primer jugador elegido
	 * de manera aleatoria.
	 * Parametros: alto: alto del tablero.
	 * 			   ancho: ancho del tablero. */
	public Juego(int alto, int ancho){
		//se crea el tablero
		this.tablero = new Tablero(alto, ancho);
		this.ubicadorDeRecolectables = new UbicadorDeRecolectables(alto,ancho);
		//se definen los jugadores
		this.elegirPrimerJugador();
		this.tablero.generarMapa();
		//se ubican los personajes, la chispa y los bonus
		this.ubicarPersonajes();
		this.ubicadorDeRecolectables.ubicarRecolectables(this.tablero);
	}
	
	/* Metodos de la clase */
	/* Devuelve el accionable que se encuentre en una coordenada.
	 * Parametros: coordenada: coordenada en la que se busca el accionable. */
	public Accionable obtenerAccionable(Coordenada coordenada) {
		return this.tablero.obtenerAccionableEnCoordenada(coordenada);
	}
	/* Elige de manera aleatoria el primer jugador y el equipo que le pertenece. */
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
	/* Ubica los miembros de ambos equipos en el tablero. */
	private void ubicarPersonajes() {
		this.jugadorActual.ubicarPersonajes();
		this.jugadorAnterior.ubicarPersonajes();
	}
	/* Termina el turno del jugador actual y lo pasa al siguiente. Se centra la vista en el
	 * algoformer seleccionado por el equipo actual. */
	public void cambiarTurno(){
		this.jugadorActual.terminarTurno();
		this.cambiarJugador();
		this.jugadorActual.centrarEnAlgoFormerActual();
	}
	/* Cambia el jugador actual */
	private void cambiarJugador(){
		Jugador jugadorAux = this.jugadorActual;
		this.jugadorActual = this.jugadorAnterior;
		this.jugadorAnterior = jugadorAux;
	}
	/* Devuelve el jugador actual */
	public Jugador obtenerJugadorActual(){
		return this.jugadorActual;
	}
	/* Devuelve una lista con las coordenadas que pertenecen al camino que puede realizar el algoformer seleccionado
	 * del jugador actual para moverse de una coordenada a otra.
	 * Parametros: coordenadaInicial: coordenada de donde sale el algoformer.
	 * 			   coordenadaFinal: coordenada de destino. */
	public List<Coordenada> buscarCamino(Coordenada coordenadaInicial, Coordenada coordenadaFinal) {
		return this.tablero.buscarCamino(coordenadaInicial,coordenadaFinal,this.jugadorActual.verAlgoformerActual());
	}
	/* Selecciona al algoformer del jugador actual que se encuentra en la coordenada seleccionada.
	 * Parametros: coordenada: coordenada seleccionada. */
	public void seleccionarCoordenada(Coordenada coordenada){
		try	{
			this.jugadorActual.seleccionarAlgoformer(coordenada);
		}
		catch(NoSeleccionableException exception) {
			//no se puede seleccionar lo que hay en la coordenada
		}
		catch(EquipoInvalidoException exception){
			//el algoformer en la posicion es del otro equipo
		}
	}
	/* Mueve el algoformer seleccionado del jugador actual a una coordenada. Cuando termina la accion
	 * termina el turno del jugador.
	 * Parametros: coordenada: coordenada a la que se quiere llegar. */
	public void moverSeleccionadoACoordenada(Coordenada coordenada){
		this.observarA(ChispaSuprema.getInstance());
		ChispaSuprema.getInstance().agregarObservador(this);
		this.jugadorActual.mover(coordenada);
		this.cambiarTurno();
	}
	/* Ataca con el algoformer seleccionado del jugador actual a una coordenada.Cuando termina la accion
	 * termina el turno del jugador.
	 * Parametros: coordenada: coordenada a la que se quiere atacar.*/
	public void atacarConSeleccionadoACoordenada(Coordenada coordenada){
		this.observarA(this.jugadorActual.verEquipo());
		this.jugadorActual.atacar(coordenada);
		this.cambiarTurno();
	}
	/* Cambia el modo del algoformer seleccionado del jugador actual. Cuando termina la accion
	 * termina el turno del jugador.*/
	public void transformarSeleccionado(){
		this.jugadorActual.transformarAlgoformer();
		this.cambiarTurno();
	}
	/* Combina los algoformers del jugador actual. Cuando termina la accion
	 * termina el turno del jugador.*/
	public void combinarAlgoFormers(){
		this.jugadorActual.combinarAlgoformers();
		this.cambiarTurno();
	}
	/* Descombina los algoformers del jugador actual. Cuando termina la accion
	 * termina el turno del jugador.*/
	public void descombinarAlgoFormers(){
		this.jugadorActual.descombinarAlgoformers();
		this.cambiarTurno();
	}
	/* Devuelve la superficie de tierra que se encuentra en una coordenada.
	 * Parametros: coordenada: coordenada de la que se quiere obtener una superficie. */
	public SuperficieTierra obtenerSuperficieTierra(Coordenada coordenada) {
		return this.tablero.obtenerSuperficieTierra(coordenada);
	}
	/* Devuelve la superficie de aire que se encuentra en una coordenada.
	 * Parametros: coordenada: coordenada de la que se quiere obtener una superficie. */
	public SuperficieAire obtenerSuperficieAire(Coordenada coordenada) {
		return this.tablero.obtenerSuperficieAire(coordenada);
	}
	/* Devuelve el recolectable que se encuentra en una coordenada.
	 * Parametros: coordenada: coordenada de la que se quiere obtener un recolectable. */	
	public Recolectable obtenerRecolectable(Coordenada coordenada) {
		return this.tablero.obtenerRecolectableEnCoordenada(coordenada);
	}

	/* Actualiza el estado del juego e informa a los jugadores el ganador. */
	private void terminarJuego(){
		this.terminado = true;
		for(Vista vista: vistas){
			vista.ganoPartida();
		}
	}
	
	/* Permite a una vista observar al juego, a sus jugadores y al tablero.
	 * Parametros: vista: vista que va a observar a las clases. */
	public void agregarVista(Vista vista) {
		this.jugadorActual.agregarVista(vista);
		this.jugadorAnterior.agregarVista(vista);
		this.tablero.agregarVista(vista);
		this.vistas.add(vista);	
	}
	/* Actualiza a las vistas porque se realizo una seleccion */
	public void nuevaSeleccion() {
		this.tablero.nuevaSeleccion();
	}
	/* Simula el movimiento del algoformer seleccionado del jugador actual hacia una coordenada
	 * para poder mostrar al usuario el camino que puede seguir para llegar a la coordenada.
	 * Parametros: coordenada: coordenada a la que se quiere llegar. */
	public void simularMovimiento(Coordenada coordenada) {
		this.tablero.simularMovimiento(coordenada,jugadorActual.verAlgoformerActual());
	}
	/* Muestra al usuario los casilleros a los que puede atacar el algoformer seleccionado del
	 * jugadpr actual. */
	public void verRangoAtaque() {
		this.tablero.verRangoAtaque(jugadorActual.verAlgoformerActual().getCoordenada(),jugadorActual.verAlgoformerActual().verRango());
	}
	/* Mueve el tablero para que la pantalla quede centrada en una coordenada.
	 * Parametros: coordenada: coordenada en la que se quiere centrarse. */
	public void moverTablero(Coordenada coordenada) {
		this.tablero.moverTablero(coordenada);
	}
	/* Devuelve una lista con los autobots miembros del equipo del jugador actual. */
	public List<Algoformer> obtenerAutobots() {
		 List<Algoformer> autobots = this.jugadorActual.obtenerAutobots();
		 autobots.addAll(this.jugadorAnterior.obtenerAutobots());
		 return autobots;
	}
	/* Devuelve una lista con los decepticons miembros del equipo del jugador actual. */
	public List<Algoformer> obtenerDecepticons() {
		List<Algoformer> decepticons = this.jugadorActual.obtenerDecepticons();
		 decepticons.addAll(this.jugadorAnterior.obtenerDecepticons());
		 return decepticons;
	}
	
	/* Metodos abstractos */
	@Override
	public void actualizar(){
		this.terminarJuego();
	}
	@Override
	public void observarA(ObservableTerminoJuego observable) {
		this.observado = observable;
		observado.agregarObservador(this);
	}
	
	/* Constructor para pruebas */
	public Juego(){
	 	this(50, 50);
 	}
	
	/* Metodos de prueba */
	public void hacerGanarEquipo(){
		this.observarA(this.jugadorActual.equipo);
		this.jugadorActual.equipo.hacerGanar();
	}

	public boolean seUbicoALosPersonajes() {
 		return jugadorActual.ubicoSusPersonajes();
  	}
	
	public boolean seUbicoALosBonus(){
 		return this.tablero.fijarseSiEstanLosBonus();
 	}
	
	public void capturarChispa(){
		this.observarA(ChispaSuprema.getInstance());
		ChispaSuprema.getInstance().producirEfecto(this.jugadorActual.verAlgoformerActual());
	}
	
 	public boolean estaLaChispa(){
 			try {
 				tablero.obtenerCoordenadaDeElemento(ChispaSuprema.getInstance());
 				return true;
 			}
 			catch(Throwable e){ return false;}
 	}

 	public boolean estaTerminado(){
		return terminado;
	}

}
