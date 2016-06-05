package fiuba.algo3.algoFormers.Superficies;

import fiuba.algo3.algoFormers.efectos.EfectoAndromeda;
import fiuba.algo3.algoFormers.afectadores.*;
import fiuba.algo3.algoFormers.efectos.EfectoNubes;
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
}
