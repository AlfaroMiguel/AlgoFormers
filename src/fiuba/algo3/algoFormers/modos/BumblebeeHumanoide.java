package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Superficies.SuperficiePantano;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class BumblebeeHumanoide extends ModoTerrestre {
	
	private static BumblebeeHumanoide instancia;
	
	private BumblebeeHumanoide(){
		this.ataque = 40;
		this.distAtaque = 1;
		this.velocidad = 2;
	}
	
	public static BumblebeeHumanoide getInstance(){
		if (instancia == null){
			instancia = new BumblebeeHumanoide();
		}
		return instancia;
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(BumblebeeAlterno.getInstance());
	}
	@Override
	public int simularPasoDe(SuperficiePantano superficiePantano){
		return 1000000;
	}
}
