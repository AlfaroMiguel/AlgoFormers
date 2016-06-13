package fiuba.algo3.algoFormers.juego;

import java.util.*;

import fiuba.algo3.algoFormers.decepticons.*;
import fiuba.algo3.algoFormers.excepciones.EquipoVencidoException;
import fiuba.algo3.algoFormers.excepciones.SinVidaException;
import fiuba.algo3.algoFormers.generico.CreadorDeAlgoformersCombinados;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.tablero.Tablero;


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
	}

	@Override
	public void descombinarAlgoformers(Tablero tablero) {
		tablero.descombinarAlgoformers(menasor);
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
		try{
			this.algoformerActual.atacar(tablero, atacado);
		}
		catch(SinVidaException exception){
			this.vencidos++;
			if (this.vencidos == EquipoDecepticons.CANT_MIEMBROS_CONTRARIOS){
				throw new EquipoVencidoException();
			}
		}
	}
}
