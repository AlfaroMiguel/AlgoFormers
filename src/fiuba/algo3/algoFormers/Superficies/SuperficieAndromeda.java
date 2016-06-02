package fiuba.algo3.algoFormers.Superficies;

import fiuba.algo3.algoFormers.efectos.EfectoAndromeda;
import fiuba.algo3.algoFormers.efectos.EfectoNubes;

public class SuperficieAndromeda extends SuperficieAire {
	
	public SuperficieAndromeda(){
		this.efecto = new EfectoAndromeda();
	}
}
