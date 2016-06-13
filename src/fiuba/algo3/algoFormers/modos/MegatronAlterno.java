package fiuba.algo3.algoFormers.modos;


import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.HexGrid;

public class MegatronAlterno extends ModoAereoAlterno {
	
	private static MegatronAlterno instancia;
	
	private MegatronAlterno(){
		this.ataque = 55;
		this.distAtaque = 2;
		this.velocidad = 8;
	}
	
	public static MegatronAlterno getInstance(){
		if (instancia == null){
			instancia = new MegatronAlterno();
		}
		return instancia;
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(MegatronHumanoide.getInstance());
	}
	@Override
	public void ponerAccionable(Coordenada coordenada) {
		HexGrid.ponerMegatronAlterno(coordenada);
	}
	
}
