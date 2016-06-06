package fiuba.algo3.algoFormers.Superficies;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Vista.HexGrid;
import fiuba.algo3.algoFormers.afectadores.AfectadorPorPosicion;
import fiuba.algo3.algoFormers.efectos.EfectoRocas;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class SuperficieRocosa extends SuperficieTierra {
	
	public SuperficieRocosa(){
		this.afectador = new AfectadorPorPosicion(new EfectoRocas());
	}

	public int simularPasoDe(Algoformer algoformer) {
		return 1;
	}

	@Override
	public void ponerSuperficieTierra(Coordenada coordenada) {
		HexGrid.ponerSuperficieRocosa(coordenada);
	}
	
	public void producirEfecto(HabitableDelMapa afectado){
		afectado.reaccionarASuperficie(this);
	}
}
