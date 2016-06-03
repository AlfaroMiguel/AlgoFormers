package fiuba.algo3.algoFormers.Juego;

import java.util.*;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.decepticons.*;
import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;


public class EquipoDecepticons extends Equipo {
	
	protected Megatron megatron;
	protected Frenzy frenzy;
	protected Bonecrusher bonecrusher;
	public Menasor menasor;
	
	public EquipoDecepticons(){
		this.megatron = new Megatron();
		this.frenzy = new Frenzy();
		this.bonecrusher = new Bonecrusher();
		this.algoformerActual = megatron;
	}
	
	public void seleccionarAlgoformer(HabitableDelMapa seleccionado){
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
		Menasor menasor = new Menasor(this.megatron, this.bonecrusher, this.frenzy);
		this.menasor = menasor;
		tablero.combinarAlgoformers(menasor, this.megatron, this.bonecrusher, this.frenzy, this.distanciaMinimaCombinacion);
	}

	@Override
	public void descombinarAlgoformers(Tablero tablero) {
		tablero.descombinarAlgoformers(menasor);
	}
}
