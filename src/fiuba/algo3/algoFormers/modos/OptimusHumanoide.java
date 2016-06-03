package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.generico.Algoformer;

public class OptimusHumanoide extends ModoTerrestre {
	
	private static OptimusHumanoide instancia;
	
	private OptimusHumanoide(){
		this.ataque = 50;
		this.distAtaque = 2;
		this.velocidad = 2;
	}
	
	public static OptimusHumanoide getInstance(){
		if (instancia == null){
			instancia = new OptimusHumanoide();
		}
		return instancia;
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(OptimusAlterno.getInstance());
	}
}
