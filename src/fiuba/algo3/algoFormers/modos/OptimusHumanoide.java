package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.HexGrid;

public class OptimusHumanoide extends ModoHumanoide {
	
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
	
	@Override
	public void ponerAccionable(Coordenada coordenada) {
		HexGrid.ponerOptimusHumanoide(coordenada);
	}
	
}