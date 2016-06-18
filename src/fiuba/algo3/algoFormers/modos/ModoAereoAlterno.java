package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.SuperficieTierra;

public abstract class ModoAereoAlterno extends ModoAereo {
	
	public void reaccionarASuperficie(SuperficieTierra superficieTierra, Algoformer afectado){
		superficieTierra.afectar(afectado, this);
	}
	
}
