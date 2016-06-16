package fiuba.algo3.algoFormers.superficie;

import fiuba.algo3.algoFormers.afectadores.*;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.modos.ModoAereo;
import fiuba.algo3.algoFormers.modos.ModoHumanoide;
import fiuba.algo3.algoFormers.modos.ModoTerrestre;
import fiuba.algo3.algoFormers.tablero.Coordenada;

public abstract class SuperficieAire {
	public Afectador afectador;

	public void producirEfecto(Accionable afectado) {
		afectado.reaccionarASuperficie(this);
	}

	public void revertirEfecto(Accionable afectado) {
		afectado.serDesafectado(this);
	}

	public int simularRecorrido(Accionable transeunte) {
		return transeunte.simularPasoPor(this);
	}

	public abstract int simularPasoDe(Algoformer algoformer);

	public abstract void ponerSuperficieAire(Coordenada coordenada);

	public void afectar(Algoformer afectado, ModoTerrestre modo) {

	}

	public abstract void afectar(Algoformer afectado, ModoAereo modo);

	public void afectar(Algoformer afectado, ModoHumanoide modo) {

	}

	public abstract void desafectar(Algoformer algoformer, ModoAereo modoAereo);

	public abstract int costoPorPaso(ModoAereo modoAereo);

	public void producirEfectoPorPaso(Accionable accionable) {
		accionable.efectoPorMicroMovimiento(this);
		
	}

	public abstract void producirEfectoPorPaso(Algoformer algoformer, ModoAereo modoAereo);

}
