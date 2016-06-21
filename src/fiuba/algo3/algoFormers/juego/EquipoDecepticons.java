package fiuba.algo3.algoFormers.juego;

import java.util.*;

import fiuba.algo3.algoFormers.autobots.Optimus;
import fiuba.algo3.algoFormers.decepticons.*;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.CreadorDeAlgoformersCombinados;
import fiuba.algo3.algoFormers.generico.ObservableTerminoJuego;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.tablero.Tablero;
import fiuba.algo3.algoFormers.vista.BarraAlgoformers;
import fiuba.algo3.algoFormers.vista.Vista;

/* Clase que representa un equipo formado por algoformers del tipo decepticon. */
public class EquipoDecepticons extends Equipo {
	
	/* Constantes */
	/* Cantidad de miembros del equipo enemigo */
	private static final int CANT_MIEMBROS_CONTRARIOS = 3;
	
	/* Atributos */
	/* Decepticons individuales que componen el equipo */
	protected Megatron megatron;
	protected Frenzy frenzy;
	protected Bonecrusher bonecrusher;
	/* Decepticon resultado de la composicion de los miembros individuales */
	public Menasor menasor;
	
	/* Constructor */
	/* Crea un equipo formado por 3 decepticons individuales y un decepticon compuesto. Por defecto
	 * el algoformer seleccionado es megatron. */
	public EquipoDecepticons(){
		this.megatron = new Megatron();
		this.frenzy = new Frenzy();
		this.bonecrusher = new Bonecrusher();
		this.menasor = CreadorDeAlgoformersCombinados.crearAlgoformerCombinado(this.megatron, this.frenzy, this.bonecrusher);
		this.algoformerActual = megatron;
	}
	
	/* Metodos abstractos redefinidos */
	@Override
	public void seleccionarAlgoformer(Accionable seleccionado){
		seleccionado.serSeleccionado(this);
	}

	@Override
	public void ubicarPersonajes(Tablero tablero) {
		List<Decepticon> integrantes = new ArrayList<Decepticon>();
		integrantes.add(this.megatron);
		integrantes.add(this.bonecrusher);
		integrantes.add(this.frenzy);
		UbicadorDePersonajes.posicionarEquipoDecepticon(integrantes,tablero);
	}

	@Override
	public void combinarAlgoformers(Tablero tablero) {
		if(this.algoformerActual == this.menasor)
			return;
		CreadorDeAlgoformersCombinados.prepararCombinadoParaPosicionar(this.menasor);
		this.menasor.notificarRepresentaciones();
		this.menasor.puestoEnMapa();
		tablero.combinarAlgoformers(menasor, this.megatron, this.bonecrusher, this.frenzy, this.distanciaMaximaCombinacion);
		this.megatron.sacadoDelMapa();
		this.bonecrusher.sacadoDelMapa();
		this.frenzy.sacadoDelMapa();
		this.algoformerActual = menasor;
	}

	@Override
	public void descombinarAlgoformers(Tablero tablero) {
		tablero.descombinarAlgoformers(menasor);
		this.menasor.sacadoDelMapa();
		this.algoformerActual = this.obtenerAlgoformerConVida();
		this.megatron.puestoEnMapa();
		this.bonecrusher.puestoEnMapa();
		this.frenzy.puestoEnMapa();
		
	}
	
	@Override
	protected Algoformer obtenerAlgoformerConVida() {
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
		try{
		this.algoformerActual.atacar(tablero, atacado);
		}
		catch(NullPointerException e){
			//Resumo la ejecucion del metodo luego de atacar
		}
		if (this.vencioEquipoContrario()){
			this.notificarObservadores();
		}
	}
	
	@Override
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
		//devuelve lista vacia porque no contiene autobots
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
	
	
	/* Metodos de prueba */
	public Megatron getMegatron(){
		return this.megatron;
	}

	@Override
	public void empiezaTurno() {
		if(this.algoformerActual.verVida() == 0)
			this.algoformerActual = this.obtenerAlgoformerConVida();
	}
}
