package fiuba.algo3.algoFormers.superficies;

import fiuba.algo3.algoFormers.efectos.EfectoEspinas;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.modos.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.HexGrid;
import fiuba.algo3.algoFormers.afectadores.*;

public class SuperficieEspinas extends SuperficieTierra {
	
	public SuperficieEspinas(){
		this.afectador = new AfectadorPorPosicion(new EfectoEspinas());
	}

	@Override
	public int simularPasoDe(Algoformer algoformer) {
		return 1;
	}

	@Override
	public void ponerSuperficieTierra(Coordenada coordenada) {
		//HexGrid.ponerSuperficieEspinas(coordenada);
	}
	
	
	public void afectar(Algoformer algoformer,ModoTerrestreAlterno modo){
		afectador.afectarAlgoformer(algoformer);
	}
	
	public void afectar(Algoformer algoformer,ModoAereo modo){
	}
	
	public void desafectar(Algoformer algoformer){
		afectador.desafectarAlgoformer(algoformer);
	}

	

	@Override
	public void afectar(Algoformer afectado, ModoHumanoide modo) {
		afectador.afectarAlgoformer(afectado);
		
	}

	@Override
	public void desafectar(Algoformer algoformer, ModoTerrestreAlterno modoTerrestreAlterno) {
		afectador.desafectarAlgoformer(algoformer);
		
	}

	@Override
	public void desafectar(Algoformer algoformer, ModoHumanoide modoTerrestreAlterno) {
		afectador.desafectarAlgoformer(algoformer);
		
	}
}
