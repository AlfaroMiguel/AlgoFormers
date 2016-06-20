package fiuba.algo3.algoFormers.juego;

import java.util.*;

import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.CreadorDeAlgoformersCombinados;
import fiuba.algo3.algoFormers.generico.ObservableTerminoJuego;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.tablero.Tablero;
import fiuba.algo3.algoFormers.vista.Vista;

public class EquipoAutobots extends Equipo {

	private static final int CANT_MIEMBROS_CONTRARIOS = 3;
	public Optimus optimus;
	public Bumblebee bumblebee;
	public Ratchet ratchet;
	public Superion superion;

	public EquipoAutobots(){
		this.optimus = new Optimus();
		this.bumblebee = new Bumblebee();
		this.ratchet = new Ratchet();
		this.superion = CreadorDeAlgoformersCombinados.crearAlgoformerCombinado(this.optimus,this.bumblebee,this.ratchet);
		this.algoformerActual = optimus;
	}

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
		Superion superion = CreadorDeAlgoformersCombinados.crearAlgoformerCombinado(this.optimus,this.bumblebee,this.ratchet);
		this.superion = superion;
		tablero.combinarAlgoformers(superion, this.optimus, this.ratchet, this.bumblebee, this.distanciaMinimaCombinacion);
		this.algoformerActual = superion;
	}

	@Override
	public void descombinarAlgoformers(Tablero tablero) {
		tablero.descombinarAlgoformers(this.superion);
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

	public Optimus getOptimus(){
		return this.optimus;
	}

	public boolean vencioEquipoContrario(){
		return this.oponentesVencidos == EquipoAutobots.CANT_MIEMBROS_CONTRARIOS;
	}

	@Override
	public void agregarVista(Vista vista) {
		this.optimus.agregarVista(vista);
		this.bumblebee.agregarVista(vista);
		this.ratchet.agregarVista(vista);
		this.superion.agregarVista(vista);

	}

	@Override
	public List<Algoformer> obtenerAutobots() {
		List<Algoformer> autobots = new ArrayList<Algoformer>();
		autobots.add(this.optimus);
		autobots.add(this.bumblebee);
		autobots.add(this.ratchet);
		return autobots;
	}

}
