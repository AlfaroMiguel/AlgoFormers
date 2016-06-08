package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Superficies.SuperficieAndromeda;
import fiuba.algo3.algoFormers.Superficies.SuperficieEspinas;
import fiuba.algo3.algoFormers.Superficies.SuperficieNubes;
import fiuba.algo3.algoFormers.Superficies.SuperficiePantano;
import fiuba.algo3.algoFormers.Superficies.SuperficiePsionica;
import fiuba.algo3.algoFormers.Superficies.SuperficieRocosa;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Vista.HexGrid;
import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class BumblebeeHumanoide extends ModoTerrestre {
	
	private static BumblebeeHumanoide instancia;
	
	private BumblebeeHumanoide(){
		this.ataque = 40;
		this.distAtaque = 1;
		this.velocidad = 2;
	}
	
	public static BumblebeeHumanoide getInstance(){
		if (instancia == null){
			instancia = new BumblebeeHumanoide();
		}
		return instancia;
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(BumblebeeAlterno.getInstance());
	}
	@Override
	public int simularPasoDe(SuperficiePantano superficiePantano){
		return 1000000;
	}
	
	@Override
	public void reaccionarASuperficie(SuperficiePantano superficiePantano, Algoformer afectado){
		throw new MovimientoInvalidoException();
	}
	
	@Override
	public void reaccionarASuperficie(SuperficieRocosa superficieRocosa, Algoformer afectado){
		superficieRocosa.afectar(afectado);
	}
	
	@Override
	public void reaccionarASuperficie(SuperficieEspinas superficieEspinas, Algoformer afectado){
		superficieEspinas.afectar(afectado);
	}
	
	@Override
	public void reaccionarASuperficie(SuperficieNubes superficieNubes, Algoformer afectado){
	}
	
	@Override
	public void reaccionarASuperficie(SuperficieAndromeda superficieAndromeda, Algoformer afectado){
	}
	
	@Override
	public void reaccionarASuperficie(SuperficiePsionica superficiePsionica, Algoformer afectado){
	}

	@Override
	public void ponerAlgoFormer(Coordenada coordenada) {
		HexGrid.ponerBumbleBeeAlterno(coordenada);
	}
}
