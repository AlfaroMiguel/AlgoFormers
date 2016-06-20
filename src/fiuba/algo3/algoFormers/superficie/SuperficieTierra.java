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

	public abstract Image ponerSuperficieTierra();

	public abstract void afectar(Algoformer afectado, ModoTerrestreAlterno modo);

	public void afectar(Algoformer afectado, ModoAereo modo){
	}

	public abstract void afectar(Algoformer afectado, ModoHumanoide modo);

	public abstract void desafectar(Algoformer algoformer, ModoTerrestreAlterno modoTerrestreAlterno);

	public abstract void desafectar(Algoformer algoformer, ModoHumanoide modoTerrestreAlterno);

	
	public abstract int costoPorPaso(ModoTerrestreAlterno modoTerrestreAlterno); 

	public abstract int costoPorPaso(ModoHumanoide modoHumanoide);

	public void producirEfectoPorPaso(Accionable accionable) {
		accionable.efectoPorMicroMovimiento(this);
		
	}

	public abstract void producirEfectoPorPaso(Algoformer algoformer, ModoTerrestre modoTerrestre);

	public int costoPorPaso(ModoAereo modoAereo) {
		return 1;
	}

	public abstract boolean esMonte();
}
