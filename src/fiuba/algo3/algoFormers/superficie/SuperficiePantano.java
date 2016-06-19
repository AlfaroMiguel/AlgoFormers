package fiuba.algo3.algoFormers.superficie;

import fiuba.algo3.algoFormers.afectadores.AfectadorPorPosicion;
import fiuba.algo3.algoFormers.efectos.EfectoPantano;
import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.modos.ModoAereo;
import fiuba.algo3.algoFormers.modos.ModoHumanoide;
import fiuba.algo3.algoFormers.modos.ModoTerrestre;
import fiuba.algo3.algoFormers.modos.ModoTerrestreAlterno;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import javafx.scene.image.Image;

public class SuperficiePantano extends SuperficieTierra {

	public SuperficiePantano() {
		this.afectador = new AfectadorPorPosicion(new EfectoPantano());
	}

	public int simularPasoDe(Algoformer algoformer) {
		return algoformer.simularPasoDe(this);
	}

	@Override
	public Image ponerSuperficieTierra() {
		return ClaseImagenes.getImageSuperficie(this);

	}

	public void afectar(Algoformer algoformer, ModoTerrestreAlterno modo) {
		//afectador.afectarAlgoformer(algoformer);
	}

	public void afectar(Algoformer algoformer, ModoHumanoide modo) {
		throw new MovimientoInvalidoException();
	}

	public void afectar(Algoformer algoformer, ModoAereo modo) {
	}

	public void desafectar(Algoformer algoformer) {
		afectador.desafectarAlgoformer(algoformer);
	}

	@Override
	public void desafectar(Algoformer algoformer, ModoTerrestreAlterno modoTerrestreAlterno) {
		afectador.desafectarAlgoformer(algoformer);

	}

	@Override
	public void desafectar(Algoformer algoformer, ModoHumanoide modoTerrestreAlterno) {

	}

	@Override
	public int costoPorPaso(ModoTerrestreAlterno modoTerrestreAlterno) {
		return 2;
	}

	@Override
	public int costoPorPaso(ModoHumanoide modoHumanoide) {
		throw new MovimientoInvalidoException();
	}

	@Override
	public void producirEfectoPorPaso(Algoformer algoformer, ModoTerrestre modoTerrestre) {
	}

}
