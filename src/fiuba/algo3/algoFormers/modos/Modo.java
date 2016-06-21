package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;
import javafx.scene.image.Image;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.generico.*;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.superficie.*;

/* Interfaz que agrupa a los modo en los que se puede encontrar un algoformer */
public interface Modo{
	
	/* Metodos abstractos */
	/* Ataca con un autobot a un accionable cualquiera.
	 * Parametros: tablero: tablero del juego.
	 * 			   atacante: autobot que ataca.
	 * 			   atacado: accionable que es atacado.
	 * 			   potencia: potencia del atacante.*/
	public void atacar(Tablero tablero, Autobot atacante, Accionable atacado, Potencia potencia);
	/* Ataca con un decepticon a un accionable cualquiera.
	 * Parametros: tablero: tablero del juego.
	 * 			   atacante: decepticon que ataca.
	 * 			   atacado: accionable que es atacado.
	 * 			   potencia: potencia del atacante.*/
	public void atacar(Tablero tablero, Decepticon atacante, Accionable atacado,Potencia potencia);
	/* Cambia el modo de un algoformer.
	 * Parametros: algoformer del que se quiere cambiar el modo. */
	public void cambiar(Algoformer algoformer);
	/* Mueve un algoformer a una coordenada.
	 * Parametros: algoformer: algoformer que se quiere mover.
	 * 			   coordenada: coordenada de destino.
	 * 			   tablero: tablero del juego.
	 * 			   agilidad: agilidad del algoformer.*/
	public void moverse(Algoformer algoformer, Coordenada coordenada, Tablero tablero, Agilidad agilidad);
	/* Se coloca un algoformer en otra posicion dentro del tablero.
	 * Parametros: tablero: tablero del juego. 
	 * 			   algoformer: algoformer que se quiere reposicionar. */
	public void reposicionarse(Tablero tablero,Algoformer algoformer);
	
	/* Devuelve el peso de salir de una determinada superficie de tierra.
	 * Parametros: superficie: superficie de tierra de la que se quiere ver el peso de salir. */
	public int simularPasoDe(SuperficieTierra superficie);
	/* Devuelve el peso de salir de una determinada superficie de aire.
	 * Parametros: superficie: superficie de aire de la que se quiere ver el peso de salir. */
	public int simularPasoDe(SuperficieAire superficie);
	
	/* Reacciona a una superficie de aire.
	 * Parametros: superficie: superficie de aire a la que debe reaccionar.
	 *     		   algoformer: algoformer que reacciona. */
	public void reaccionarASuperficie(SuperficieAire superficie, Algoformer algoformer);
	/* Reacciona a una superficie de tierra.
	 * Parametros: superficie: superficie de tierra a la que debe reaccionar.
	 * 			   algoformer: algoformer que reacciona.*/
	public void reaccionarASuperficie(SuperficieTierra superficie, Algoformer algoformer);
	
	/* Deja de afectarlo el efecto de la superficie de tierra.
	 * Parametros: superficie: superficie de tierra que posee el efecto.
	 * 			   algoformer: algoformer a desafectar.*/
	public void serDesafectado(SuperficieTierra superficie, Algoformer algoformer);
	/* Deja de afectarlo el efecto de la superficie de aire.
	 * Parametros: superficie: superficie de aire que posee el efecto.
	 * 			   algoformer: algoformer a desafectar.*/
	public void serDesafectado(SuperficieAire superficie, Algoformer algoformer);
	
	/* Devuelve el ataque */
	public int verAtaque();
	/* Devuelve la distancia de ataque */
	public int verRangoAtaque();
	/* Devuelve la velocidad */
	public double verPaso();
	/* Devuelve la imagen que representa al modo*/
	public Image verImagen();
	
	/* Produce efecto sobre el algoformer por pasar por una superficie de aire.
	 * Parametros: superficie: superficie de aire que produce el efecto.
	 * 			   algoformer: algoformer que realiza el micro movimiento.*/
	public void producirEfectoPorMicroMovimiento(SuperficieAire superficie, Algoformer algoformer);
	/* Produce efecto sobre el algoformer por pasar por una superficie de tierra.
	 * Parametros: superficie: superficie de tierra que produce el efecto.
	 * 			   algoformer: algoformer que realiza el micro movimiento.*/
	public void producirEfectoPorMicroMovimiento(SuperficieTierra superficie, Algoformer algoformer);
	
}
