package fiuba.algo3.algoFormers.superficie;

import fiuba.algo3.algoFormers.afectadores.Afectador;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.modos.ModoAereo;
import fiuba.algo3.algoFormers.modos.ModoHumanoide;
import fiuba.algo3.algoFormers.modos.ModoTerrestre;
import fiuba.algo3.algoFormers.modos.ModoTerrestreAlterno;
import javafx.scene.image.Image;

public abstract class SuperficieTierra {
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


	/*Devuelve la imagen correspondiente a la superficie de tierra*/
	public abstract Image ponerSuperficieTierra();
	
	/*Final del DoubleDispatch de producir efecto donde a partir del modo en el que se encuentra
	 * tiene diferentes efectos
	 * Parametros: Algoformer a afectar y el modo en el que esta*/
	public abstract void afectar(Algoformer afectado, ModoTerrestreAlterno modo);

	/*Final del DoubleDispatch de producir efecto donde a partir del modo en el que se encuentra
	 * tiene diferentes efectos. Esta vacio porque en modo aereo una superficie de tierra no 
	 * afecta a un algoformer
	 * Paramentros:Algoformer y modo*/
	public void afectar(Algoformer afectado, ModoAereo modo){
	}

	/*Final del DoubleDispatch de producir efecto donde a partir del modo en el que se encuentra
	 * tiene diferentes efectos
	 * Parametros: Algoformer a afectar y el modo en el que esta*/
	public abstract void afectar(Algoformer afectado, ModoHumanoide modo);

	/*Final del DoubleDispatch de revertir efecto donde a partir del modo en el que se encuentra
	 * tiene diferentes efectos
	 * Parametros: Algoformer a desafectar y el modo en el que esta*/
	public abstract void desafectar(Algoformer algoformer, ModoTerrestreAlterno modoTerrestreAlterno);

	/*Final del DoubleDispatch de revertir efecto donde a partir del modo en el que se encuentra
	 * tiene diferentes efectos
	 * Parametros: Algoformer a desafectar y el modo en el que esta*/
	public abstract void desafectar(Algoformer algoformer, ModoHumanoide modoTerrestreAlterno);

	
	/*Final del DoubleDispatch para calcular el costo de por el paso de una superficie
	 * para un determinado algoformer en un determinado modo
	 * Parametros:Modo en el que se encuentra el algoformer que quiere transitar por al superficie*/
	public abstract int costoPorPaso(ModoTerrestreAlterno modoTerrestreAlterno); 

	/*Final del DoubleDispatch para calcular el costo de por el paso de una superficie
	 * para un determinado algoformer en un determinado modo
	 * Parametros:Modo en el que se encuentra el algoformer que quiere transitar por al superficie*/
	public abstract int costoPorPaso(ModoHumanoide modoHumanoide);

	/*Produce el efecto instantaneo por pasar ensima de una superficie
	 * Parametros:Accionable a afectar*/
	public void producirEfectoPorPaso(Accionable accionable) {
		accionable.efectoPorMicroMovimiento(this);
		
	}
	
	/*Final del double dispatch de producir efecto por paso
	 * Parametros:Algoformer a afectar y modo*/
	public abstract void producirEfectoPorPaso(Algoformer algoformer, ModoTerrestre modoTerrestre);

	/*Final del double dispatch para calcular el costo por pasar ensima de una superficie de
	 * tierra, en este caso en modo aereo es indifirente que superficie de tierra esta por transitar
	 * Parametro:Modo*/
	public int costoPorPaso(ModoAereo modoAereo) {
		return 1;
	}
	
	/*Funcion utilizada para el recorrido de dijkstra
	 * devuelve si es un monte o no*/
	public abstract boolean esMonte();
}
