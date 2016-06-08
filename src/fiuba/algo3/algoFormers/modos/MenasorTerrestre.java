package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Superficies.SuperficieAndromeda;
import fiuba.algo3.algoFormers.Superficies.SuperficieEspinas;
import fiuba.algo3.algoFormers.Superficies.SuperficieNubes;
import fiuba.algo3.algoFormers.Superficies.SuperficiePantano;
import fiuba.algo3.algoFormers.Superficies.SuperficiePsionica;
import fiuba.algo3.algoFormers.Superficies.SuperficieRocosa;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.excepciones.ModoUnicoException;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class MenasorTerrestre extends ModoTerrestre {

	private static MenasorTerrestre instancia;

	private MenasorTerrestre(){
		this.ataque = 100;
		this.distAtaque = 2;
		this.velocidad = 3;
	}
		
	public static MenasorTerrestre getInstance(){
		if (instancia == null){
			instancia = new MenasorTerrestre();
		}
		return instancia;
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		throw new ModoUnicoException();
	}
	@Override
	public int simularPasoDe(SuperficiePantano superficiePantano){
		return 1000000;
	}
	
	@Override
	public void reaccionarASuperficie(SuperficiePantano superficiePantano, Algoformer afectado){
	}
	
	@Override
	public void reaccionarASuperficie(SuperficieRocosa superficieRocosa, Algoformer afectado){
	}
	
	@Override
	public void reaccionarASuperficie(SuperficieEspinas superficieEspinas, Algoformer afectado){
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
		// TODO Auto-generated method stub
		
	}

}
