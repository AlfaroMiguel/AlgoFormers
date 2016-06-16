package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.HexGrid;

public class BonecrusherAlterno extends ModoTerrestreAlterno {
	
	private static BonecrusherAlterno instancia;
	
	private BonecrusherAlterno(){
		this.ataque = 30;
		this.distAtaque = 3;
		this.velocidad = 8;
	}
	
	public static BonecrusherAlterno getInstance(){
		if (instancia == null){
			instancia = new BonecrusherAlterno();
		}
		return instancia;
	}

	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(BonecrusherHumanoide.getInstance());
	}
	
	

	@Override
	public void ponerAccionable(Coordenada coordenada) {
		HexGrid.ponerBonecrusherAlterno(coordenada);
	}
	
}
