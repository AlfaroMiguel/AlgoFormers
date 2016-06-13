package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class BumblebeeAlterno extends ModoTerrestreAlterno{
	
	private static BumblebeeAlterno instancia;
	
	private BumblebeeAlterno(){
		this.ataque = 20;
		this.distAtaque = 3;
		this.velocidad = 5;
	}
	
	public static BumblebeeAlterno getInstance(){
		if (instancia == null){
			instancia = new BumblebeeAlterno();
		}
		return instancia;
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(BumblebeeHumanoide.getInstance());
	}
	
	@Override
	public int simularPasoDe(SuperficiePantano superficiePantano){
		return 2;
	}
	
}
