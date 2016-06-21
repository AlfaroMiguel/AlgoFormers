package fiuba.algo3.algoFormers.superficie;

import fiuba.algo3.algoFormers.afectadores.AfectadorPorPosicion;
import fiuba.algo3.algoFormers.efectos.EfectoRocas;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.modos.ModoAereo;
import fiuba.algo3.algoFormers.modos.ModoHumanoide;
import fiuba.algo3.algoFormers.modos.ModoTerrestre;
import fiuba.algo3.algoFormers.modos.ModoTerrestreAlterno;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import javafx.scene.image.Image;

public class SuperficieRocosa extends SuperficieTierra {


	public SuperficieRocosa() {
		this.afectador = new AfectadorPorPosicion(new EfectoRocas());
	}


	@Override
	public Image ponerSuperficieTierra() {
			 return ClaseImagenes.getImageSuperficie(this);

	}

	public void afectar(Algoformer algoformer, ModoAereo modo) {

	}

	@Override
	public void afectar(Algoformer afectado, ModoHumanoide modo) {
		afectador.desafectarAlgoformer(afectado);

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
	public void afectar(Algoformer afectado, ModoTerrestreAlterno modo) {
		afectador.afectarAlgoformer(afectado);

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
		//No se produce ningun efecto por pasar ensima de una superficie rocosa
		
	}

	@Override
	public boolean esMonte() {
		return false;
	}
}
