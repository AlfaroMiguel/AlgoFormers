package fiuba.algo3.algoFormers.autobots;

import fiuba.algo3.algoFormers.generico.Vida;
import fiuba.algo3.algoFormers.modos.BumblebeeHumanoide;

/*Clase que representa al algoformer autobot Bumblebee*/
public class Bumblebee extends Autobot {
	
	/*Constructor*/
	/*Crea un bumblebee en modo humanoide con 350 puntos de vida*/
	public Bumblebee(){
		this.modo = BumblebeeHumanoide.getInstance();
		this.vida = new Vida(350);
	}
}
