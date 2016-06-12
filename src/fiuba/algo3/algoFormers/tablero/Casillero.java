package fiuba.algo3.algoFormers.tablero;

import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.superficie.*;

public class Casillero {
	
	private SuperficieAire aire;
	private SuperficieTierra tierra;
	
	public Casillero(){
	}
	
	public void agregarSuperficie(SuperficieTierra tierra){
		this.tierra = tierra;
	}
	
	public void agregarSuperficie(SuperficieAire aire){
		this.aire = aire;
	}
	
	public void producirEfecto(Accionable afectado){
		this.aire.producirEfecto(afectado);
		this.tierra.producirEfecto(afectado);
	}
	
	public void revertirEfecto(Accionable desafectado){
		this.aire.revertirEfecto(desafectado);
		this.tierra.revertirEfecto(desafectado);
	}
	
	public int calcularMovimiento(Accionable transeunte){
		return Math.max(this.aire.simularRecorrido(transeunte), this.tierra.simularRecorrido(transeunte));
	}
	
}
