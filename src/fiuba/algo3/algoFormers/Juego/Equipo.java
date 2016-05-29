package fiuba.algo3.algoFormers.Juego;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.generico.Algoformer;

public abstract class Equipo{
	
	protected Algoformer algoformerActual;
	
	public Equipo(){
	}
	
	public void seleccionarAlgoformer(HabitableDelMapa seleccionado){
		this.seleccionarAlgoformer(seleccionado);
	}
	
	public void setAlgoformerActual(Algoformer algoformer){
		this.algoformerActual = algoformer;
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
	public void ubicarPersonajes(Tablero tablero) {
			}
	
	public void atacar(Tablero tablero, HabitableDelMapa atacado){
		this.algoformerActual.atacar(tablero, atacado);
	}
	
}
