package fiuba.algo3.algoFormers.Juego;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class Equipo{
	
	protected Algoformer algoformerActual;
	
	public Equipo(){
	}
	
	public void seleccionarAlgoformer(HabitableDelMapa habitable){
		this.seleccionarAlgoformer(habitable);
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
