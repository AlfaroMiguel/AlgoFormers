package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.generico.ObservableTerminoJuego;
import fiuba.algo3.algoFormers.juego.EquipoAutobots;
import fiuba.algo3.algoFormers.juego.EquipoDecepticons;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import javafx.scene.image.Image;

/* Interfaz que representa a los elementos del juego que pueden realizar
 * acciones tales como atacar y moverse.*/
public interface Accionable extends ObservableTerminoJuego{

	/* Metodos abstractos */
	/* Colisiona con cualquier elemento.
	 * Lanza: NoColisionableException si ningun elemento puede colisionar contra el. */
	public void colisionar();
	/* Devuelve: true o false dependiendo de si ocupa o no un lugar
	 * representativo en el tablero.*/
	public boolean ocupaLugar();
	
	/* Reacciona ante el ataque de otro accionable. 
	 * Parametros: atacante: accionable que lo ataca.
	 * 			   ataque: capacidad de ataque del atacante.
	 * Lanza: MismoEquipoException si el atacante es del mismo equipo. */
	public void serAtacado(Autobot atacante, int ataque);
	/* Reacciona ante el ataque de otro accionable. 
	 * Parametros: atacante: accionable que lo ataca.
	 * 			   ataque: capacidad de ataque del atacante.
	 * Lanza: MismoEquipoException si el atacante es del mismo equipo. */
	public void serAtacado(Decepticon atacante, int ataque);
	
	/* Reacciona al ser seleccionado.
	 * Parametros: equipo: equipo que lo selecciona.
	 * Lanza: EquipoInvalidoException si el equipo no es el suyo. 
	 * 		  NoSeleccionableException si no puede ser seleccionado. */
	public void serSeleccionado(EquipoAutobots equipo);
	/* Reacciona al ser seleccionado.
	 * Parametros: equipo: equipo que lo selecciona.
	 * Lanza: EquipoInvalidoException si el equipo no es el suyo.
	 * 		  NoSeleccionableException si no puede ser seleccionado. */
	public void serSeleccionado(EquipoDecepticons equipo);
	
	/* Reacciona a una superficie.
	 * Parametros: superficie: superficie a la que debe reaccionar.*/
	public void reaccionarASuperficie(SuperficieAire superficie);
	/* Reacciona a una superficie.
	 * Parametros: superficie: superficie a la que debe reaccionar.*/
	public void reaccionarASuperficie(SuperficieTierra superficie);
	
	/* Deja de afectarlo el efecto de la superficie.
	 * Parametros: superficie: superficie que posee el efecto.*/
	public void serDesafectado(SuperficieAire superficie);
	/* Deja de afectarlo el efecto de la superficie.
	 * Parametros: superficie: superficie que posee el efecto.*/
	public void serDesafectado(SuperficieTierra superficie);
	
	/* Devuelve la coordenada actual del accionable */
	public Coordenada getCoordenada();
	/* Actualiza la coordenada actual del accionable e informa a las vistas.
	 * Parametros: posicion: coordenada actual del accionable. */
	public void setCoordenada(Coordenada coordenada);
	
	/* Devuelve el peso de salir de una determinada superficie.
	 * Parametros: superficie: superficie de tierra de la que se quiere ver el peso de salir. */
	public int simularPasoPor(SuperficieTierra superficie);
	/* Devuelve el peso de salir de una determinada superficie.
	 * Parametros: superficie: superficie de aire de la que se quiere ver el peso de salir. */
	public int simularPasoPor(SuperficieAire superficie);
	/* Levanta un recolectable del mapa (si no tiene uno del mismo tipo activo)
	 * y es afectado por el mismo.
	 * Parametros: recolectable: recolectable a levantar.*/
	public void recolectar(Recolectable recolectable);
	
	/* Afecta al algoformer al pasar por una superficie que produce algun efecto.
	 * Parametros: superficie: superficie de aire atravesada.*/
	public void efectoPorMicroMovimiento(SuperficieAire superficie);
	/* Afecta al algoformer al pasar por una superficie que produce algun efecto.
	 * Parametros: superficie: superficie de tierra atravesada.*/
	public void efectoPorMicroMovimiento(SuperficieTierra superficie);
	
	/* Devuelve la imagen que representa al accionable*/
	public Image getImage();
}
