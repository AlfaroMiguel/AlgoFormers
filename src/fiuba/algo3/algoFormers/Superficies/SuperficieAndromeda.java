package fiuba.algo3.algoFormers.Superficies;

import fiuba.algo3.algoFormers.efectos.EfectoAndromeda;
import fiuba.algo3.algoFormers.afectadores.*;
import fiuba.algo3.algoFormers.efectos.EfectoNubes;

public class SuperficieAndromeda extends SuperficieAire {
	
	private EfectoAndromeda efecto;

	public SuperficieAndromeda(){
		this.afectador = new AfectadorPorTurnos(3,new EfectoAndromeda());
	}
}
