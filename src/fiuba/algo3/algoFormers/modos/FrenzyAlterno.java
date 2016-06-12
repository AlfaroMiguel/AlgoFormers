package fiuba.algo3.algoFormers.modos;


import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class FrenzyAlterno extends ModoTerrestreAlterno {
	
	private static FrenzyAlterno instancia;
	
	private FrenzyAlterno(){
		this.ataque = 25;
		this.distAtaque = 2;
		this.velocidad = 6;
	}
	
	public static FrenzyAlterno getInstance(){
		if (instancia == null){
			instancia = new FrenzyAlterno();
		}
		return instancia;
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(FrenzyHumanoide.getInstance());
	}
	@Override
	public int simularPasoDe(SuperficiePantano superficiePantano){
		return 2;
	}

}
