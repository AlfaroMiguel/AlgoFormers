package fiuba.algo3.algoFormers.autobots;

import fiuba.algo3.algoFormers.generico.Vida;
import fiuba.algo3.algoFormers.modos.SuperionTerrestre;
import fiuba.algo3.algoFormers.tablero.Coordenada;

/*Clase que representa al algoformer autobot combinado Superion*/
public class Superion extends Autobot {
	
	/*Atributos*/
	/*Cada uno de los autobots individuales que contiene*/
	private Optimus optimus;
	private Ratchet ratchet;
	private Bumblebee bumblebee;
	
	/*Constructor*/
	/* Parametros: los autobots con los que se va a componer.
	 * Crea un superion en modo unico con la suma de las vidas de los algoformers
	 * que lo componen en el momento de la composicion*/
	public Superion(Optimus optimus, Ratchet ratchet, Bumblebee bumblebee){
		this.optimus = optimus;
		this.ratchet = ratchet;
		this.bumblebee = bumblebee;
		this.vida = new Vida(optimus.verVida() + ratchet.verVida() + bumblebee.verVida());
		this.modo = SuperionTerrestre.getInstance();
	}
	
	/*Metodos de la clase*/
	/*Devuelve el optimus que contiene*/
	public Optimus getOptimus() {
		return this.optimus;
	}
	/*Devuelve el bumblebee que contiene*/
	public Bumblebee getBumblebee(){
		return this.bumblebee;
	}
	/*Devuelve el ratchet que contiene*/
	public Ratchet getRatchet(){
		return this.ratchet;
	}
	@Override
	public void setCoordenada(Coordenada coordenada){
		this.posicion = coordenada;
		this.actualizarVista();
	}
}
