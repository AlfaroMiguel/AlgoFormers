package fiuba.algo3.algoFormers.juego;

import java.util.*;

import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.excepciones.EquipoVencidoException;
import fiuba.algo3.algoFormers.excepciones.SinVidaException;
import fiuba.algo3.algoFormers.generico.CreadorDeAlgoformersCombinados;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.tablero.Tablero;

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
		try{
			this.algoformerActual.atacar(tablero, atacado);
		}
		catch(SinVidaException exception){
			this.vencidos++;
			if (this.vencidos == EquipoAutobots.CANT_MIEMBROS_CONTRARIOS){
				throw new EquipoVencidoException();
			}
		}
	}
	
	public Optimus getOptimus(){
		return this.optimus;
	}
	
}
