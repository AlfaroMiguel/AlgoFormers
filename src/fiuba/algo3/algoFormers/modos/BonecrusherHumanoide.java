package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.HexGrid;

public class BonecrusherHumanoide extends ModoHumanoide {
	
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
	
	@Override
	public int simularPasoDe(SuperficiePantano superficiePantano){
		return 1000000;
	}
	@Override
	public void ponerAccionable(Coordenada coordenada) {
		HexGrid.ponerBonecrusherHumanoide(coordenada);
	}
}
