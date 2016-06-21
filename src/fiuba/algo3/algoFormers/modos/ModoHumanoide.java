package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.generico.Algoformer;

/* Clase que representa al modo humanoide */
public abstract class ModoHumanoide extends ModoTerrestre {
	
	/* Metodos abstractos redefinidos */
	@Override
	public void reaccionarASuperficie(SuperficieTierra superficie, Algoformer afectado){
		superficie.afectar(afectado,this);
	}
	@Override
	public void serDesafectado(SuperficieTierra superficie, Algoformer algoformer){
		superficie.desafectar(algoformer,this);
	}
	@Override
	public int simularPasoDe(SuperficieTierra superficie){
		return superficie.costoPorPaso(this);
	}
}
