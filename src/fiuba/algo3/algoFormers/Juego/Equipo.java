package fiuba.algo3.algoFormers.Juego;

import fiuba.algo3.algoFormers.Habitables.Collectable;
import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Habitables.Vacio;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.excepciones.NoAlgoformerException;
import fiuba.algo3.algoFormers.generico.Algoformer;

public abstract class Equipo{
	
	protected Algoformer algoformerActual;
	
	public Equipo(){
	}
	
	public void seleccionarAlgoformer(Autobot autobot){
		this.seleccionarAlgoformer(autobot);
	}
	
	public void seleccionarAlgoformer(Decepticon decepticon){
		this.seleccionarAlgoformer(decepticon);
	}
	public void mover(Coordenada coordenada, Tablero tablero){
		this.algoformerActual.moverse(coordenada, tablero);
	}
	
	public void transformarAlgoformer(){
		this.algoformerActual.cambiarModo();
	}

	public Algoformer verAlgoformerActual() {
		return this.algoformerActual;
	}
	
}
