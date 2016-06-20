package fiuba.algo3.algoFormers.juego;

import java.util.List;

import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.ObservableTerminoJuego;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;
import fiuba.algo3.algoFormers.vista.Vista;

/* Clase que representa a un jugador del juego.*/
public class Jugador{
	
	/* Atributos */
	/* Equipo del jugador */
	public Equipo equipo;
	/* Tablero el juego */
	protected Tablero tablero;
	
	/* Constructor */
	/* Crea un jugador con un equipo.
	 * Parametros: equipo: equipo que pertenece al jugador. 
	 * 			   tablero: tablero del juego. */
	public Jugador(Equipo equipo, Tablero tablero){
		this.equipo = equipo;
		this.tablero = tablero;
	}
	
	/* Devuelve el algoformer actual del equipo */
	public Algoformer verAlgoformerActual(){
		return this.equipo.verAlgoformerActual();
	}
	/* Selecciona el algoformer que se encuentra en una coordenada.
	 * Parametros: coordenada: coordenada donde se deberia encontrar un algoformer.
	 * Lanza: NoSeleccionableException si no se puede seleccionar lo que hay en la coordenada.
	 * 		  EquipoInvalidoException si el algoformer que se intenta seleccionar es del equipo contrario */
	public void seleccionarAlgoformer(Coordenada coordenada){
		this.equipo.seleccionarAlgoformer(this.tablero.obtenerAccionableEnCoordenada(coordenada));
	}
	/* Ataca con el algoformer actual del equipo a una coordenada.
	 * Parametros: coordenada: coordenada a la que se quiere atacar.*/
	public void atacar(Coordenada coordenada) {
		this.equipo.atacar(this.tablero, this.tablero.obtenerAccionableEnCoordenada(coordenada));
	}
	/* Mueve el algoformer actual del equipo a una coordenada.
	 * Parametros: coordenada: coordenada a la que se quiere llegar. */
	public void mover(Coordenada coordenada) {
		this.equipo.mover(coordenada, this.tablero);
	}
	/* Transforma al algoformer actual salvo que caiga sobre una superficie a la que no puede ingresar
	 * en ese modo. En tal caso, no cambia de modo.*/
	public void transformarAlgoformer(){
		try{
			this.equipo.desafectarPersonajeActual(this.tablero);
			this.equipo.transformarAlgoformer();
			//Para que se apliquen los efectos cuando se cambia de modo a uno que si lo afecta
			this.equipo.reposicionarAlgoformer(this.tablero);
		}catch (MovimientoInvalidoException exception){
			this.equipo.transformarAlgoformer();
			this.equipo.reposicionarAlgoformer(this.tablero);
		}
	}
	/* Ubica a los miembros del equipo en el tablero */
	public void ubicarPersonajes() {
		 this.equipo.ubicarPersonajes(this.tablero);
	}
	/* Combina a los miembros del equipo en un solo algoformer */
	public void combinarAlgoformers(){
		this.equipo.combinarAlgoformers(this.tablero);
	}
	/* Descombina a los miembros del equipo */
	public void descombinarAlgoformers(){
		this.equipo.descombinarAlgoformers(this.tablero);
	}
	/* Termina el turno del equipo */
	public void terminarTurno() {
		this.equipo.terminarTurno();
	}
	/* Devuelve el equipo del jugador */
	public ObservableTerminoJuego verEquipo() {
		return this.equipo;
	}
	/* Permite a una vista observar al equipo.
	 * Parametros: vista: vista que va a observar al equipo. */
	public void agregarVista(Vista vista) {
		this.equipo.agregarVista(vista);
	}
	/* Centra la pantalla en la posicion del algoformer actual del equipo */
	public void centrarEnAlgoFormerActual() {
		this.equipo.centrarEnAlgoFormerActual();
	}
	/* Devuelve una lista con los autobots miembros del equipo */
	public List<Algoformer> obtenerAutobots() {
		return this.equipo.obtenerAutobots();
	}
	/* Devuelve una lista con los decepticons miembros del equipo */
	public List<Algoformer> obtenerDecepticons() {
		return this.equipo.obtenerDecepticons();
	}
	
	/* Metodos de prueba */
	public boolean ubicoSusPersonajes() {
		 return !(this.tablero.obtenerCoordenadaDeElemento(this.verAlgoformerActual()) == null);
	 }

}
