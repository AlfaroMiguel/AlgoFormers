package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.juego.EquipoAutobots;
import fiuba.algo3.algoFormers.juego.EquipoDecepticons;

/* Interfaz que representa a los elementos del juego que pueden realizar
 * acciones tales como atacar y moverse.*/
public interface Accionable{

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
	
	
	public int simularEfecto(SuperficieAire superficie);
	public int simularEfecto(SuperficieTierra superficie);

	public void recolectar(Collectable colectable);

}
