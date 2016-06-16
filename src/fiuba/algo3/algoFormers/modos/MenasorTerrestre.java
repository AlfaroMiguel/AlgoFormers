package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.excepciones.ModoUnicoException;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.HexGrid;

public class MenasorTerrestre extends ModoHumanoide {

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
	public void ponerAccionable(Coordenada coordenada) {
		HexGrid.ponerMenasor(coordenada);
	}
	
}