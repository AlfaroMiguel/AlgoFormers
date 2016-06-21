package fiuba.algo3.algoFormers.autobots;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoFormers.generico.ObservadorTerminoJuego;
import fiuba.algo3.algoFormers.generico.Vida;
import fiuba.algo3.algoFormers.modos.SuperionTerrestre;
import fiuba.algo3.algoFormers.vista.RepresentacionDeAlgoformer;

/*Clase que representa al algoformer autobot combinado Superion*/
public class Superion extends Autobot {
	
	/*Atributos*/
	/*Cada uno de los autobots individuales que contiene*/
	private Optimus optimus;
	private Ratchet ratchet;
	private Bumblebee bumblebee;
	/* Lista de elementos de la vista que cambian segun cambia el combinado  */
	public static List<RepresentacionDeAlgoformer> representadoresCombinado = new ArrayList<RepresentacionDeAlgoformer>();
	
	/*Constructor*/
	/* Parametros: los autobots con los que se va a componer.
	 * Crea un superion en modo unico con la suma de las vidas de los algoformers
	 * que lo componen en el momento de la composicion*/
	public Superion(Optimus optimus, Ratchet ratchet, Bumblebee bumblebee){
		this.nombre = "Superion";
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
	
	/* Metodos abstractos redefinidos*/
	@Override
	public void agregarRepresentacionDeAlgoformer(RepresentacionDeAlgoformer representador){
		representadoresCombinado.add(representador);
	}
	@Override
	public void notificarRepresentaciones(){
		for(RepresentacionDeAlgoformer representador: representadoresCombinado)
			representador.actualizar();
	}
	@Override
	public void sacadoDelMapa(){
		for(RepresentacionDeAlgoformer representador: representadoresCombinado){
			if (representador.estaHabilitado())
				representador.deshabilitar();
		}
	}
	@Override
	public void puestoEnMapa(){
		for(RepresentacionDeAlgoformer representador: representadoresCombinado){
			if (!representador.estaHabilitado())
				representador.habilitar();
		}
	}
	@Override
	public void notificarObservadores() {
		for (ObservadorTerminoJuego observador: observadores){
			observador.actualizarCombinado();
		}
	}
}
