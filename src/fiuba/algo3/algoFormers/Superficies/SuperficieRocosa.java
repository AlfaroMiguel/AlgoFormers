package fiuba.algo3.algoFormers.Superficies;

import fiuba.algo3.algoFormers.afectadores.AfectadorPorPosicion;
import fiuba.algo3.algoFormers.efectos.EfectoRocas;

public class SuperficieRocosa extends SuperficieTierra {
	
	public SuperficieRocosa(){
		this.afectador = new AfectadorPorPosicion(new EfectoRocas());
	}
}
