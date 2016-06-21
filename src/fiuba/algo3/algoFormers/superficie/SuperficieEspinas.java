package fiuba.algo3.algoFormers.superficie;

import fiuba.algo3.algoFormers.afectadores.AfectadorPorPosicion;
import fiuba.algo3.algoFormers.efectos.EfectoEspinas;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.modos.ModoAereo;
import fiuba.algo3.algoFormers.modos.ModoHumanoide;
import fiuba.algo3.algoFormers.modos.ModoTerrestre;
import fiuba.algo3.algoFormers.modos.ModoTerrestreAlterno;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import javafx.scene.image.Image;

public class SuperficieEspinas extends SuperficieTierra {

	public SuperficieEspinas() {
		this.afectador = new AfectadorPorPosicion(new EfectoEspinas());
	}


	@Override
	public Image ponerSuperficieTierra() {
		return ClaseImagenes.getImageSuperficie(this);
	}

	public void afectar(Algoformer algoformer, ModoTerrestreAlterno modo) {
		afectador.afectarAlgoformer(algoformer);
	}

	public void afectar(Algoformer algoformer, ModoAereo modo) {
	}

	public void desafectar(Algoformer algoformer) {
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

	@Override
	public int costoPorPaso(ModoTerrestreAlterno modoTerrestreAlterno) {
		return 1;
	}

	@Override
	public int costoPorPaso(ModoHumanoide modoHumanoide) {
		return 1;
	}

	@Override
	public void producirEfectoPorPaso(Algoformer algoformer, ModoTerrestre modoTerrestre) {
		this.afectador.producirEfecto(algoformer);
		
	}

	@Override
	public boolean esMonte() {
		return false;
	}
}
