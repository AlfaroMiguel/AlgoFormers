package fiuba.algo3.algoFormers.tablero;

import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.superficie.*;

public class Casillero {
	/*	Atributos */
	/* 	la superficie que hay en el aire en el casillero */
	public SuperficieAire aire;
	/* 	la superficie que hay en la tierra en el casillero */
	public SuperficieTierra tierra;
	
	public Casillero(){
	}

	public void agregarSuperficie(SuperficieTierra tierra){
		this.tierra = tierra;
	}
	
	public void agregarSuperficie(SuperficieAire aire){
		this.aire = aire;
	}
	
	/* 	Le produce el efecto al AlgoFormer que entre en el casillero */
	public void producirEfecto(Accionable afectado){
		this.aire.producirEfecto(afectado);
		this.tierra.producirEfecto(afectado);
	}
	/* 	Le revierte el efecto que le habia
	 *  provocado al AlgoFormer que entro en el casillero */
	public void revertirEfecto(Accionable desafectado){
		this.aire.revertirEfecto(desafectado);
		this.tierra.revertirEfecto(desafectado);
	}
	
	/* calcula cuanto gastaria un AlgoFomer en pasar por el casillero */
	public int calcularMovimiento(Accionable transeunte){
		return Math.max(this.aire.simularRecorrido(transeunte), this.tierra.simularRecorrido(transeunte));
	}

	/* 	Le produce el efecto al AlgoFormer que pasa por el casillero */
	public void producirEfectoPorPaso(Accionable accionable) {
		this.aire.producirEfectoPorPaso(accionable);
		this.tierra.producirEfectoPorPaso(accionable);
	}

	public boolean esUnMonte() {
		return this.tierra.esMonte();
	}
	
}
