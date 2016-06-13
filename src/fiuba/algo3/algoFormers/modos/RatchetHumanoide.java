package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.superficies.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.HexGrid;

public class RatchetHumanoide extends ModoHumanoide {
	
	private static RatchetHumanoide instancia;
	
	
	private RatchetHumanoide(){
		this.ataque = 5;
		this.distAtaque = 5;
		this.velocidad = 1;
	}
	
	public static RatchetHumanoide getInstance(){
		if (instancia == null){
			instancia = new RatchetHumanoide();
		}
		return instancia;
	}
		
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(RatchetAlterno.getInstance());
	}
	@Override
	public int simularPasoDe(SuperficiePantano superficiePantano){
		return 1000000;
	}
	@Override
	public void ponerAccionable(Coordenada coordenada) {
		HexGrid.ponerRatchetHumanoide(coordenada);
	}
}
