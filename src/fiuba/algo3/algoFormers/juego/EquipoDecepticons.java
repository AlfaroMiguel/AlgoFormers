package fiuba.algo3.algoFormers.juego;

import java.util.*;

import fiuba.algo3.algoFormers.autobots.Optimus;
import fiuba.algo3.algoFormers.decepticons.*;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.CreadorDeAlgoformersCombinados;
import fiuba.algo3.algoFormers.generico.ObservableTerminoJuego;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.tablero.Tablero;
import fiuba.algo3.algoFormers.vista.Vista;


public class EquipoDecepticons extends Equipo {

	private static final int CANT_MIEMBROS_CONTRARIOS = 3;
	protected Megatron megatron;
	protected Frenzy frenzy;
	protected Bonecrusher bonecrusher;
	public Menasor menasor;

	public EquipoDecepticons(){
		this.megatron = new Megatron();
		this.frenzy = new Frenzy();
		this.bonecrusher = new Bonecrusher();
		this.menasor = CreadorDeAlgoformersCombinados.crearAlgoformerCombinado(this.megatron, this.frenzy, this.bonecrusher);
		this.algoformerActual = megatron;
	}

	public Megatron getMegatron(){
		return this.megatron;
	}

	public void seleccionarAlgoformer(Accionable seleccionado){
		seleccionado.serSeleccionado(this);
	}

	@Override
	public void ubicarPersonajes(Tablero tablero) {
		//Documentacion
		List<Decepticon> integrantes = new ArrayList<Decepticon>();
		integrantes.add(this.megatron);
		integrantes.add(this.bonecrusher);
		integrantes.add(this.frenzy);
		UbicadorDePersonajes.posicionarEquipoDecepticon(integrantes,tablero);
		}

	@Override
	public void combinarAlgoformers(Tablero tablero) {
		Menasor menasor = CreadorDeAlgoformersCombinados.crearAlgoformerCombinado(this.megatron, this.frenzy, this.bonecrusher);
		this.menasor = menasor;
		tablero.combinarAlgoformers(menasor, this.megatron, this.bonecrusher, this.frenzy, this.distanciaMinimaCombinacion);
		this.algoformerActual = menasor;
	}

	@Override
	public void descombinarAlgoformers(Tablero tablero) {
		tablero.descombinarAlgoformers(menasor);
		this.algoformerActual = this.obtenerAlgoformerConVida();
	}

		private Algoformer obtenerAlgoformerConVida() {
		if (megatron.verVida()>0)
			return megatron;
		if (bonecrusher.verVida()>0)
			return bonecrusher;
		return frenzy;
	}

	@Override
	public void terminarTurno() {
		this.bonecrusher.terminaTurno();
		this.megatron.terminaTurno();
		this.frenzy.terminaTurno();
		this.menasor.terminaTurno();
	}

	@Override
	public void atacar(Tablero tablero, Accionable atacado) {
		this.observarA(atacado);
		this.algoformerActual.atacar(tablero, atacado);
		if (this.vencioEquipoContrario()){
			this.notificarObservadores();
		}
	}

	public boolean vencioEquipoContrario() {
		return this.oponentesVencidos == EquipoDecepticons.CANT_MIEMBROS_CONTRARIOS;
	}

	@Override
	public void agregarVista(Vista vista) {
		this.megatron.agregarVista(vista);
		this.bonecrusher.agregarVista(vista);
		this.frenzy.agregarVista(vista);
		this.menasor.agregarVista(vista);

	}

	@Override
	public List<Algoformer> obtenerAutobots() {
		List<Algoformer> autobots = new ArrayList<Algoformer>();
		return autobots;
	}

	@Override
	public List<Algoformer> obtenerDecepticons() {
		List<Algoformer> decepticons= new ArrayList<Algoformer>();
		decepticons.add(this.megatron);
		decepticons.add(this.frenzy);
		decepticons.add(this.bonecrusher);
		decepticons.add(this.menasor);
		return decepticons;
	}

	@Override
	public String obtenerNombre(String nombreJugadorAutobots, String nombreJugadorDecepticons) {
		return nombreJugadorDecepticons;
	}
}
