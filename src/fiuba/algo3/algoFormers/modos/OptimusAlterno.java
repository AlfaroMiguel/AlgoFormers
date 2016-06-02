package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.generico.Algoformer;

public class OptimusAlterno extends ModoTerrestre {
	
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
}
