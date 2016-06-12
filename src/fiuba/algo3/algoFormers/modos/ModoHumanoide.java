package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.generico.Algoformer;

public abstract class ModoHumanoide extends ModoTerrestre {
	public void reaccionarASuperficie(SuperficieTierra superficieTierra, Algoformer afectado){
		superficieTierra.afectar(afectado,this);
	}
	public void serDesafectado(SuperficieTierra superficieTierra, Algoformer algoformer){
		superficieTierra.desafectar(algoformer,this);
	}
}
