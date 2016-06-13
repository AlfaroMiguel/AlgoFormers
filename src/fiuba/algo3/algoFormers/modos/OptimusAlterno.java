package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.HexGrid;

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
	@Override
	public void ponerAccionable(Coordenada coordenada) {
		HexGrid.ponerOptimusAlterno(coordenada);
	}
}