package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Superficies.SuperficieAndromeda;
import fiuba.algo3.algoFormers.Superficies.SuperficieEspinas;
import fiuba.algo3.algoFormers.Superficies.SuperficieNubes;
import fiuba.algo3.algoFormers.Superficies.SuperficiePantano;
import fiuba.algo3.algoFormers.Superficies.SuperficiePsionica;
import fiuba.algo3.algoFormers.Superficies.SuperficieRocosa;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class OptimusAlterno extends ModoTerrestreAlterno {
	
	private static OptimusAlterno instancia;
	
	private OptimusAlterno(){
		this.ataque = 15;
		this.distAtaque = 4;
		this.velocidad = 5;
	}
	
	public static OptimusAlterno getInstance(){
		if (instancia == null){
			instancia = new OptimusAlterno();
		}
		return instancia;
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(OptimusHumanoide.getInstance());
	}
	@Override
	public int simularPasoDe(SuperficiePantano superficiePantano){
		return 2;
	}
}
