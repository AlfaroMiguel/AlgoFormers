package fiuba.algo3.algoFormers.superficie;

import fiuba.algo3.algoFormers.afectadores.AfectadorPermanente;
import fiuba.algo3.algoFormers.efectos.EfectoPsionico;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.modos.ModoAereo;
import fiuba.algo3.algoFormers.modos.ModoTerrestre;
import fiuba.algo3.algoFormers.vista.ClaseImagenes;
import javafx.scene.image.Image;

public class SuperficiePsionica extends SuperficieAire {
	public SuperficiePsionica() {
		this.afectador = new AfectadorPermanente(new EfectoPsionico());
	}

	public int simularPasoDe(Algoformer algoformer) {
		return algoformer.simularPasoDe(this);
	}

	public Image ponerSuperficieAire() {
		return ClaseImagenes.getImageSuperficie(this);
	}

	public void afectar(Algoformer algoformer, ModoAereo modo) {
		afectador.afectarAlgoformer(algoformer);
	}

	public void afectar(Algoformer algoformer, ModoTerrestre modo) {
	}

	@Override
	public void desafectar(Algoformer algoformer, ModoAereo modoAereo) {
		afectador.desafectarAlgoformer(algoformer);

	}

	@Override
	public int costoPorPaso(ModoAereo modoAereo) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void producirEfectoPorPaso(Algoformer algoformer, ModoAereo modoAereo) {
		this.afectador.afectarAlgoformer(algoformer);
		
	}

}
