package fiuba.algo3.algoFormers.superficie;

import fiuba.algo3.algoFormers.afectadores.Afectador;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.modos.ModoAereo;
import fiuba.algo3.algoFormers.modos.ModoHumanoide;
import fiuba.algo3.algoFormers.modos.ModoTerrestre;
import javafx.scene.image.Image;

public abstract class SuperficieAire {
	/*Afectador de la superficie, posee los efectos de la misma*/
	public Afectador afectador;

	/*Produce el efecto por finalizar el movimiento en una superficie
	 * Parametros: el Accionable afectado*/
	public void producirEfecto(Accionable afectado) {
		afectado.reaccionarASuperficie(this);
	}

	/*Revierte el efecto producido por finalizar el movimiento una superficie
	 * complementaria con producir efecto
	 * Parametros: Accionable a desafectar*/
	public void revertirEfecto(Accionable afectado) {
		afectado.serDesafectado(this);
	}

	/*Inicio de DoubleDispatch para calcular cuanto cuesta atravezar una superficie
	 * Parametros: Accionable que transita por la superficie*/
	public int simularRecorrido(Accionable transeunte) {
		return transeunte.simularPasoPor(this);
	}


	/*Devuelve la imagen correspondiente a la superficie de aire*/
	public abstract Image ponerSuperficieAire();

	/*Final del DoubleDispatch de producir efecto donde a partir del modo en el que se encuentra
	 * tiene diferentes efectos. Esta vacio porque en modo terrestre una superficie de aire no 
	 * afecta a un algoformer
	 * Paramentros:Algoformer y modo*/
	public void afectar(Algoformer afectado, ModoTerrestre modo) {

	}

	/*Final del DoubleDispatch de producir efecto donde a partir del modo en el que se encuentra
	 * tiene diferentes efectos
	 * Parametros: Algoformer a afectar y el modo en el que esta*/
	public abstract void afectar(Algoformer afectado, ModoAereo modo);

	/*Final del DoubleDispatch de producir efecto donde a partir del modo en el que se encuentra
	 * tiene diferentes efectos. Esta vacio porque en modo humanoide una superficie de aire no 
	 * afecta a un algoformer
	 * Paramentros:Algoformer y modo*/
	public void afectar(Algoformer afectado, ModoHumanoide modo) {

	}

	/*Final del DoubleDispatch de revertir efecto donde a partir del modo en el que se encuentra
	 * tiene diferentes efectos
	 * Parametros: Algoformer a desafectar y el modo en el que esta*/
	public abstract void desafectar(Algoformer algoformer, ModoAereo modoAereo);

	/*Final del DoubleDispatch para calcular el costo de por el paso de una superficie
	 * para un determinado algoformer en un determinado modo
	 * Parametros:Modo en el que se encuentra el algoformer que quiere transitar por al superficie*/
	public abstract int costoPorPaso(ModoAereo modoAereo);

	/*Produce el efecto instantaneo por pasar ensima de una superficie
	 * Parametros:Accionable a afectar*/
	public void producirEfectoPorPaso(Accionable accionable) {
		accionable.efectoPorMicroMovimiento(this);
		
	}
	
	/*Final del double dispatch de producir efecto por paso
	 * Parametros:Algoformer a afectar y modo*/
	public abstract void producirEfectoPorPaso(Algoformer algoformer, ModoAereo modoAereo);

}
