package fiuba.algo3.algoFormers.superficie;

import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.modos.ModoAereo;
import fiuba.algo3.algoFormers.modos.ModoHumanoide;
import fiuba.algo3.algoFormers.modos.ModoTerrestre;
import fiuba.algo3.algoFormers.modos.ModoTerrestreAlterno;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import javafx.scene.image.Image;

public class SuperficieMonte extends SuperficieTierra {

	@Override
	public int simularPasoDe(Algoformer algoformer) {
		return algoformer.simularPasoDe(this);
	}

	@Override
	public Image ponerSuperficieTierra() {
		return ClaseImagenes.getImageSuperficie(this);
	}

	@Override
	public void afectar(Algoformer afectado, ModoTerrestreAlterno modo) {
		throw new MovimientoInvalidoException();
	}

	@Override
	public void afectar(Algoformer afectado, ModoHumanoide modo) {
		throw new MovimientoInvalidoException();
	}
	
	@Override
	public void afectar(Algoformer afectado, ModoAereo modo){
		throw new MovimientoInvalidoException();
	}

	@Override
	public void desafectar(Algoformer algoformer, ModoTerrestreAlterno modoTerrestreAlterno) {
	}

	@Override
	public void desafectar(Algoformer algoformer, ModoHumanoide modoTerrestreAlterno) {
	}

	@Override
	public int costoPorPaso(ModoTerrestreAlterno modoTerrestreAlterno) {
		return 10000000;
	}

	@Override
	public int costoPorPaso(ModoHumanoide modoHumanoide) {
		return 10000000;
	}
	
	@Override
	public int costoPorPaso(ModoAereo modoAereo) {
		return 10000000;
	}
	
	@Override
	public void producirEfectoPorPaso(Algoformer algoformer, ModoTerrestre modoTerrestre) {
	}

}
