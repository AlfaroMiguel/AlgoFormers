package fiuba.algo3.algoFormers.superficie;

import fiuba.algo3.algoFormers.afectadores.*;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.modos.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;

public abstract class SuperficieTierra {
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

	public void ubicar(Accionable habitable) {
		// TODO Auto-generated method stub

	}

	public abstract int simularPasoDe(Algoformer algoformer);

	public abstract void ponerSuperficieTierra(Coordenada coordenada);

	public abstract void afectar(Algoformer afectado, ModoTerrestreAlterno modo);

	public void afectar(Algoformer afectado, ModoAereo modo) {

	}

	public abstract void afectar(Algoformer afectado, ModoHumanoide modo);

	public abstract void desafectar(Algoformer algoformer, ModoTerrestreAlterno modoTerrestreAlterno);

	public abstract void desafectar(Algoformer algoformer, ModoHumanoide modoTerrestreAlterno);

	
	public abstract int costoPorPaso(ModoTerrestreAlterno modoTerrestreAlterno); 

	public abstract int costoPorPaso(ModoHumanoide modoHumanoide);
}
