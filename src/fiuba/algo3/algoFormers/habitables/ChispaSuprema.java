package fiuba.algo3.algoFormers.habitables;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.Observador;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.HexGrid;

public class ChispaSuprema implements Recolectable{

	private static final ChispaSuprema INSTANCE = new ChispaSuprema();
	private List<Observador> observadores = new ArrayList<Observador>();
	
	private ChispaSuprema(){}

	public static ChispaSuprema getInstance(){
		return INSTANCE;
	}
	
	public boolean ocupaLugar(){
		return true;
	}
	
	public void colisionar(){	
	}
	
	@Override
	public void producirEfecto(Algoformer algoformer){
		//algoformer.obtenerColectablesEnAtacable().agregarColectable(this); si cambiamos el final
		algoformer.capturarChispa(this);
	}

	@Override
	public void desafectar(Algoformer algoformer) {
	}

	@Override
	public boolean fueConsumido() {
		return true;
	}

	@Override
	public boolean equals(BonusVacio otro) {
		return false;
	}

	@Override
	public void ponerRecolectable(Coordenada c) {
		HexGrid.ponerChispa(c);
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
	public void notificarObservadores() {
		for (Observador observador: observadores){
			observador.actualizar();
		}
	}

	public void serCapturada() {
		this.notificarObservadores();
	}

}
