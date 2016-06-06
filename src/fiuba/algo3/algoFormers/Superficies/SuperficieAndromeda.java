package fiuba.algo3.algoFormers.Superficies;

import fiuba.algo3.algoFormers.efectos.EfectoAndromeda;
import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Vista.HexGrid;
import fiuba.algo3.algoFormers.afectadores.*;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class SuperficieAndromeda extends SuperficieAire {
	
	private EfectoAndromeda efecto;

	public SuperficieAndromeda(){
		this.afectador = new AfectadorPorTurnos(3,new EfectoAndromeda());
	}
	@Override
	public void afectar(Algoformer algoformer){
		//Ojala java tuvise un copyObject
		Afectador afectadorCopia = new AfectadorPorTurnos(3,new EfectoAndromeda());
		afectadorCopia.afectarAlgoformer(algoformer);
	}
	public int simularPasoDe(Algoformer algoformer) {
		return 1000000;
	}
	@Override
	public void ponerSuperficieAire(Coordenada coordenada) {
		HexGrid.ponerSuperficieAndromeda(coordenada);
	}
	
	public void producirEfecto(HabitableDelMapa afectado){
		afectado.reaccionarASuperficie(this);
	}
}
