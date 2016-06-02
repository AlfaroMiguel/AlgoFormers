package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.generico.Algoformer;

public class BonecrusherHumanoide extends ModoTerrestre {
	
	private static BonecrusherHumanoide instancia;
	
	private BonecrusherHumanoide(){
		this.ataque = 30;
		this.distAtaque = 3;
		this.velocidad = 1;
	}
	
	public static BonecrusherHumanoide getInstance(){
		if (instancia == null){
			instancia = new BonecrusherHumanoide();
		}
		return instancia;
	}

	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(BonecrusherAlterno.getInstance());
	}
}
