package fiuba.algo3.algoFormers.superficie;

import fiuba.algo3.algoFormers.afectadores.AfectadorPorPosicion;
import fiuba.algo3.algoFormers.efectos.EfectoNubes;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.modos.ModoAereo;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import javafx.scene.image.Image;

public class SuperficieNubes extends SuperficieAire {

	public SuperficieNubes() {
		this.afectador = new AfectadorPorPosicion(new EfectoNubes());
	}


	public Image ponerSuperficieAire() {
		return ClaseImagenes.getImageSuperficie(this);
	}

	public void afectar(Algoformer algoformer, ModoAereo modo) {
		afectador.afectarAlgoformer(algoformer);
	}

	@Override
	public void desafectar(Algoformer algoformer, ModoAereo modoAereo) {
		afectador.desafectarAlgoformer(algoformer);

	}

	@Override
	public int costoPorPaso(ModoAereo modoAereo) {
		return 1;
	}

	@Override
	public void producirEfectoPorPaso(Algoformer algoformer, ModoAereo modoAereo) {
		//No se produce ningun efecto al pasar por una nube
		
	}
}
