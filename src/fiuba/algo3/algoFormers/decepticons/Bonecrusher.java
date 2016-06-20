package fiuba.algo3.algoFormers.decepticons;

import fiuba.algo3.algoFormers.generico.Vida;
import fiuba.algo3.algoFormers.modos.BonecrusherHumanoide;

/*Clase que representa al algoformer decepticon Bonecrusher*/
public class Bonecrusher extends Decepticon {
	
	/*Constructor*/
	/*Crea un bonecrusher en modo humanoide con 200 puntos de vida*/
	public Bonecrusher(){
		this.nombre = "Bonecrusher";
		this.modo = BonecrusherHumanoide.getInstance();
		this.vida = new Vida(200);
	}
}
