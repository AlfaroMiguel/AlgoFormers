package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Superficies.SuperficiePantano;
import fiuba.algo3.algoFormers.Superficies.SuperficieTierra;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class BonecrusherAlterno extends ModoTerrestre {
	
	private static BonecrusherAlterno instancia;
	
	private BonecrusherAlterno(){
		this.ataque = 30;
		this.distAtaque = 3;
		this.velocidad = 8;
	}
	
	public static BonecrusherAlterno getInstance(){
		if (instancia == null){
			instancia = new BonecrusherAlterno();
		}
		return instancia;
	}

	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(BonecrusherHumanoide.getInstance());
	}
	@Override
	public int simularPasoDe(SuperficiePantano superficiePantano){
		return 2;
	}

	
	
}
