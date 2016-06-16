package fiuba.algo3.algoFormers.juego;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.ObservableTerminoJuego;
import fiuba.algo3.algoFormers.generico.Observador;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;

public abstract class Equipo implements Observador, ObservableTerminoJuego{
	
	protected Algoformer algoformerActual;
	public int distanciaMinimaCombinacion;
	private ObservableTerminoJuego observado;
	public int oponentesVencidos;
	private List<Observador> observadores = new ArrayList<Observador>();
	

	public abstract void combinarAlgoformers(Tablero tablero);
	public abstract void descombinarAlgoformers(Tablero tablero);
	public abstract void ubicarPersonajes(Tablero tablero);
	public abstract void seleccionarAlgoformer(Accionable seleccionado);
	public abstract void terminarTurno();
	
	public Equipo(){
		this.distanciaMinimaCombinacion = 1;
		this.oponentesVencidos = 0;
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
		tablero.desafectarAlgoformer(this.algoformerActual);
	}
	
	@Override
	public void actualizar() {
		this.oponentesVencidos++;
	}

	@Override
	public void observarA(ObservableTerminoJuego observable) {
		this.observado = observable;
		this.observado.agregarObservador(this); //eliminar esto de todos lados y dejarlo aca
	}
	

	@Override
	public void agregarObservador(Observador observador) {
		if (!this.observadores.contains(observador)){
			this.observadores.add(observador);
		}
	}

	@Override
	public void eliminarObservador(Observador observador) {
		this.observadores.remove(observador);
	}

	@Override
	public void notificarObservadores(){
		for (Observador observador: observadores){
			observador.actualizar();
		}
	}
	
	//metodo de pruebas
	public void hacerGanar(){
		this.notificarObservadores();
	}

	
}
