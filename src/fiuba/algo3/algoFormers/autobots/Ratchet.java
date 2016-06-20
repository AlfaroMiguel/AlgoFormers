package fiuba.algo3.algoFormers.autobots;

import fiuba.algo3.algoFormers.generico.Vida;
import fiuba.algo3.algoFormers.modos.RatchetHumanoide;

/*Clase que representa al algoformer autobot Ratchet*/
public class Ratchet extends Autobot {
	
	/*Constructor*/
	/*Crea un ratchet en modo humanoide con 150 puntos de vida*/
	public Ratchet(){
		this.nombre = "Ratchet";
		this.modo = RatchetHumanoide.getInstance();
		this.vida = new Vida(150);
	}
}
