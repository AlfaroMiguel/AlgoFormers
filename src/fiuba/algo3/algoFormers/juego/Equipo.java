package fiuba.algo3.algoFormers.juego;

import fiuba.algo3.algoFormers.excepciones.EquipoVencidoException;
import fiuba.algo3.algoFormers.excepciones.SinVidaException;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;

public abstract class Equipo{
	
	protected Algoformer algoformerActual;
	public int distanciaMinimaCombinacion;
	public int vencidos;
	

	public abstract void combinarAlgoformers(Tablero tablero);
	public abstract void descombinarAlgoformers(Tablero tablero);
	public abstract void ubicarPersonajes(Tablero tablero);
	public abstract void seleccionarAlgoformer(Accionable seleccionado);
	public abstract void terminarTurno();
	
	public Equipo(){
		this.distanciaMinimaCombinacion = 1;
		this.vencidos = 0;
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

	
	public abstract void atacar(Tablero tablero, Accionable atacado);
		
	public void reposicionarAlgoformer(Tablero tablero) {
		this.algoformerActual.reposicionarse(tablero);
	}
	
	public void retirarPersonajeActual(Tablero tablero) {
		tablero.retirarAlgoformer(this.algoformerActual);
		
	}
	
}
