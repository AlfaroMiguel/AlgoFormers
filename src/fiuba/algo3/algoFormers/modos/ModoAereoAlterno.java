package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.SuperficieTierra;

/* Clase que representa al modo aereo en modo alterno */
public abstract class ModoAereoAlterno extends ModoAereo {
	
	/* Metodos abstractos redefinidos */
	@Override
	public void reaccionarASuperficie(SuperficieTierra superficie, Algoformer afectado){
		superficie.afectar(afectado, this);
	}
	
}
