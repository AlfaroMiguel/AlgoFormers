package fiuba.algo3.algoFormers.autobots;

import fiuba.algo3.algoFormers.generico.Vida;
import fiuba.algo3.algoFormers.modos.OptimusHumanoide;

/*Clase que representa al algoformer autobot Optimus*/
public class Optimus extends Autobot {
	
	/*Constructor*/
	/*Crea un optimus en modo humanoide con 500 puntos de vida*/
	public Optimus(){
		this.modo = OptimusHumanoide.getInstance();
		this.vida = new Vida(500);
	}
}
