package fiuba.algo3.algoFormers.decepticons;

import fiuba.algo3.algoFormers.generico.Vida;
import fiuba.algo3.algoFormers.modos.MegatronHumanoide;

/*Clase que representa al algoformer decepticon Megatron*/
public class Megatron extends Decepticon {
	
	/*Constructor*/
	/*Crea un megatron en modo humanoide con 550 puntos de vida*/
	public Megatron(){
		this.nombre = "Megatron";
		this.modo = MegatronHumanoide.getInstance();
		this.vida = new Vida(550);
	}
}
