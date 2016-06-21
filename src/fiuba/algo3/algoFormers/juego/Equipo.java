package fiuba.algo3.algoFormers.juego;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.ObservableTerminoJuego;
import fiuba.algo3.algoFormers.generico.ObservadorTerminoJuego;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;
import fiuba.algo3.algoFormers.vista.BarraAlgoformers;
import fiuba.algo3.algoFormers.vista.Vista;

/* Clase que representa un equipo de algoformers */
public abstract class Equipo implements ObservadorTerminoJuego, ObservableTerminoJuego{
	
	/* Atributos */
	/* Indica el algoformer del equipo que esta seleccionado en un momento dado. */
	protected Algoformer algoformerActual;
	/* Representa la distancia maxima a la que pueden estar los integrantes del equipo para formar
	 * un algoformer combinado. */
	public int distanciaMaximaCombinacion;
	/* Observable que es observado por el equipo en un momento dado. */
	private ObservableTerminoJuego observado;
	/* Representa la cantidad de miembros del equipo enemigo que murieron.*/
	public int oponentesVencidos;
	/* Lista de observadores para el patron observer */
	private List<ObservadorTerminoJuego> observadores = new ArrayList<ObservadorTerminoJuego>();
	/* Elemento de la vista que representa al equipo */
	protected BarraAlgoformers vista;

	/* Metodos abstractos */
	/* Junta a los algoformers del equipo en un algoformer combinado.
	 * Parametros: tablero: tablero del juego. */
	public abstract void combinarAlgoformers(Tablero tablero);
	/* Separa al algoformer combinado y vuelven a ser los miembros individuales.
	 * Parametros: tablero: tablero del juego. */
	public abstract void descombinarAlgoformers(Tablero tablero);
	/* Ubica a los miembros del equipo en el tablero.
	 * Parametros: tablero: tablero del juego. */
	public abstract void ubicarPersonajes(Tablero tablero);
	/* Selecciona a un algoformer del equipo.
	 * Parametros: seleccionado: algoformer seleccionado. */
	public abstract void seleccionarAlgoformer(Accionable seleccionado);
	/* Termina el turno de todos los miembros del equipo. */
	public abstract void terminarTurno();
	/* Devuelve el nombre del jugador que esta usando al equipo.
	 * Parametros: nombreJugadorAutobots: nombre del jugador del equipo autobots.
	 * 			   nombreJugadorDecepticons: nombre del jugador del equipo decepticons.*/
	public abstract String obtenerNombre(String nombreJugadorAutobots, String nombreJugadorDecepticons);
	/* Ataca a otro accionable con el algoformer seleccionado actualmente.
	 * Parametros: atacado: accionable a atacar.
	 * 			   tablero: tablero del juego. */
	public abstract void atacar(Tablero tablero, Accionable atacado);
	/* Devuelve una lista con los autobots del equipo. */
	public abstract List<Algoformer> obtenerAutobots();
	/* Devuelve una lista con los decepticons del equipo.*/
	public abstract List<Algoformer> obtenerDecepticons();
	/* Permite a una vista observar a los miembros del equipo.
	 * Parametros: vista: vista que va a observar al equipo. */
	public abstract void agregarVista(Vista vista);
	/* Devuelve el miembro del equipo con vida cuando todos los demas murieron. */
	protected abstract Algoformer obtenerAlgoformerConVida();
	/* Devuelve true si todos los miembros del equipo enemigo estan muertos, y false en caso contrario. */
	public abstract boolean vencioEquipoContrario();

	/* Constructor */
	/* Crea un equipo que aun no vencio a ningun oponente y cuyos miembros deben estar como
	 * maximo a 1 casillero de distancia para poder combinarse. */
	public Equipo(){
		this.distanciaMaximaCombinacion = 1;
		this.oponentesVencidos = 0;
	}
	
	/* Metodos de la clase */
	/* Actualiza el algoformer seleccionado actualmente.
	 * Parametros: algoformer: algoformer seleccionado.*/
	public void setAlgoformerActual(Algoformer algoformer){
		this.algoformerActual = algoformer;
	}
	/* Mueve al algoformer seleccionado actualmente a una coordenada del tablero.
	 * Parametros: coordenada: coordenada de destino.
	 * 			   tablero: tablero del juego.*/
	public void mover(Coordenada coordenada, Tablero tablero){
		this.algoformerActual.moverse(coordenada, tablero);
	}
	/* Cambia el modo del algoformer seleccionado actualmente. */
	public void transformarAlgoformer(){
		this.algoformerActual.cambiarModo();
	}
	/* Devuelve el algoformer seleccionado actualmente. */
	public Algoformer verAlgoformerActual() {
		return this.algoformerActual;
	}
	/* Coloca al algoformer actual en otra posicion del tablero.
	 * Parametros: tablero: tablero del juego. */
	public void reposicionarAlgoformer(Tablero tablero) {
		this.algoformerActual.reposicionarse(tablero);
	}
	/* Revierte los efectos existentes en el algoformer seleccionado actualmente. */
	public void desafectarPersonajeActual(Tablero tablero) {
		tablero.desafectarAlgoformer(this.algoformerActual);
	}
	/* Centra la pantalla en la posicion del algoformer seleccionado actualmente */
	public void centrarEnAlgoFormerActual() {
		this.algoformerActual.centrar();
	}
	
	/* Metodos abstractos redefinidos */
	@Override
	public void actualizar() {
		this.oponentesVencidos++;
	}
	@Override
	public void actualizarCombinado() {
		this.oponentesVencidos = 3;
	}
	
	@Override
	public void observarA(ObservableTerminoJuego observable) {
		this.observado = observable;
		this.observado.agregarObservador(this); 
	}
	@Override
	public void agregarObservador(ObservadorTerminoJuego observador) {
		if (!this.observadores.contains(observador)){
			this.observadores.add(observador);
		}
	}
	@Override
	public void eliminarObservador(ObservadorTerminoJuego observador) {
		this.observadores.remove(observador);
	}
	@Override
	public void notificarObservadores(){
		for (ObservadorTerminoJuego observador: observadores){
			observador.actualizar();
		}
	}

	/* Metodos de prueba*/
	public void hacerGanar(){
		this.notificarObservadores();
	}
	public abstract void empiezaTurno();
}
