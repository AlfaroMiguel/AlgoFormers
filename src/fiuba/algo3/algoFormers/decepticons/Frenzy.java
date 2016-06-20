package fiuba.algo3.algoFormers.decepticons;

import fiuba.algo3.algoFormers.generico.Vida;
import fiuba.algo3.algoFormers.modos.FrenzyHumanoide;

/*Clase que representa al algoformer decepticon Frenzy*/
public class Frenzy extends Decepticon {
	
	/*Constructor*/
	/*Crea un frenzy en modo humanoide con 400 puntos de vida*/
	public Frenzy(){
		this.nombre = "Frenzy";
		this.modo = FrenzyHumanoide.getInstance();
		this.vida = new Vida(400);
	}
}
