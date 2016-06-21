package fiuba.algo3.algoFormers.juego;

import java.util.*;

import fiuba.algo3.algoFormers.autobots.*;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.CreadorDeAlgoformersCombinados;
import fiuba.algo3.algoFormers.generico.ObservableTerminoJuego;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.tablero.Tablero;
import fiuba.algo3.algoFormers.vista.BarraAlgoformers;
import fiuba.algo3.algoFormers.vista.Vista;

/* Clase que representa un equipo formado por algoformers del tipo autobot. */
public class EquipoAutobots extends Equipo {
	
	/* Constantes */
	/* Cantidad de miembros del equipo enemigo */
	private static final int CANT_MIEMBROS_CONTRARIOS = 3;
	
	/* Atributos */
	/* Autobots individuales que componen el equipo */
	public Optimus optimus;
	public Bumblebee bumblebee;
	public Ratchet ratchet;
	/* Autobot resultado de la composicion de los miembros individuales */
	public Superion superion;
	
	/* Constructor */
	/* Crea un equipo formado por 3 autobots individuales y un autobot compuesto. Por defecto
	 * el algoformer seleccionado es optimus. */
	public EquipoAutobots(){
		this.optimus = new Optimus();
		this.bumblebee = new Bumblebee();
		this.ratchet = new Ratchet();
		this.superion = CreadorDeAlgoformersCombinados.crearAlgoformerCombinado(this.optimus,this.bumblebee,this.ratchet);
		this.algoformerActual = optimus;
	}
	
	/* Metodos abstractos redefinidos */
	@Override
	public void seleccionarAlgoformer(Accionable seleccionado){
		seleccionado.serSeleccionado(this);
	}

	@Override
	public void ubicarPersonajes(Tablero tablero) {
		List<Autobot> integrantes = new ArrayList<Autobot>();
		integrantes.add(this.optimus);
		integrantes.add(this.bumblebee);
		integrantes.add(this.ratchet);
		UbicadorDePersonajes.posicionarEquipoAutobot(integrantes,tablero);
		}

	@Override
	public void combinarAlgoformers(Tablero tablero) {
		if(this.algoformerActual == this.superion)
			return;
		Superion superion = CreadorDeAlgoformersCombinados.crearAlgoformerCombinado(this.optimus,this.bumblebee,this.ratchet);
		this.superion = superion;
		tablero.combinarAlgoformers(superion, this.optimus, this.ratchet, this.bumblebee, this.distanciaMaximaCombinacion);
		this.superion.puestoEnMapa();
		this.optimus.sacadoDelMapa();
		this.ratchet.sacadoDelMapa();
		this.bumblebee.sacadoDelMapa();
		this.algoformerActual = superion;
	}

	@Override
	public void descombinarAlgoformers(Tablero tablero) {
		tablero.descombinarAlgoformers(this.superion);
		this.superion.sacadoDelMapa();
		this.algoformerActual = this.obtenerAlgoformerConVida();
		this.optimus.puestoEnMapa();
		this.bumblebee.puestoEnMapa();
		this.ratchet.puestoEnMapa();
	}

	@Override
	public void terminarTurno() {
		this.optimus.terminaTurno();
		this.ratchet.terminaTurno();
		this.bumblebee.terminaTurno();
		this.superion.terminaTurno();
	}

	@Override
	public void atacar(Tablero tablero, Accionable atacado) {
		this.observarA(atacado);
		this.algoformerActual.atacar(tablero, atacado);
		if (this.vencioEquipoContrario()){
			this.notificarObservadores();
		}
	}
	@Override
	protected Algoformer obtenerAlgoformerConVida() {
		if (optimus.verVida()>0)
			return optimus;
		if (bumblebee.verVida()>0)
			return bumblebee;
		return ratchet;
	}

	@Override
	public boolean vencioEquipoContrario(){
		return this.oponentesVencidos == EquipoAutobots.CANT_MIEMBROS_CONTRARIOS;
	}

	@Override
	public void agregarVista(Vista vista){
		this.optimus.agregarVista(vista);
		this.bumblebee.agregarVista(vista);
		this.ratchet.agregarVista(vista);
		this.superion.agregarVista(vista);
	}

	@Override
	public List<Algoformer> obtenerAutobots(){
		List<Algoformer> autobots = new ArrayList<Algoformer>();
		autobots.add(this.optimus);
		autobots.add(this.bumblebee);
		autobots.add(this.ratchet);
		autobots.add(this.superion);
		return autobots;
	}

	@Override
	public List<Algoformer> obtenerDecepticons(){
		//devuelve una lista vacia porque no contiene decepticons
		List<Algoformer> decepticons = new ArrayList<Algoformer>();
		return decepticons;
	}

	@Override
	public String obtenerNombre(String nombreJugadorAutobots, String nombreJugadorDecepticons) {
		return nombreJugadorAutobots;
	}
	
	/* Metodos de prueba */
	public Optimus getOptimus(){
		return this.optimus;
	}

}
