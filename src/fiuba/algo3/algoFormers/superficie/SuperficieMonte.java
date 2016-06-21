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

	/*Es una superficie a la que nadie puede acceder
	 * lanza errores en la mayoria de sus metodos debido a esto*/
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
		throw new MovimientoInvalidoException();
	}

	@Override
	public int costoPorPaso(ModoHumanoide modoHumanoide) {
		throw new MovimientoInvalidoException();
	}

	@Override
	public int costoPorPaso(ModoAereo modoAereo) {
		throw new MovimientoInvalidoException();
	}

	@Override
	public void producirEfectoPorPaso(Algoformer algoformer, ModoTerrestre modoTerrestre) {
	}

	@Override
	public boolean esMonte() {
		return true;
	}

}
