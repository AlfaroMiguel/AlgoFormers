package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Superficies.SuperficiePantano;
import fiuba.algo3.algoFormers.excepciones.ModoUnicoException;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class MenasorTerrestre extends ModoTerrestre {

	private static MenasorTerrestre instancia;

	private MenasorTerrestre(){
		this.ataque = 100;
		this.distAtaque = 2;
		this.velocidad = 3;
	}
		
	public static MenasorTerrestre getInstance(){
		if (instancia == null){
			instancia = new MenasorTerrestre();
		}
		return instancia;
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		throw new ModoUnicoException();
	}
	@Override
	public int simularPasoDe(SuperficiePantano superficiePantano){
		return 1000000;
	}

}
