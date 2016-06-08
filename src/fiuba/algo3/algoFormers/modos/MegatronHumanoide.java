package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Superficies.SuperficieAndromeda;
import fiuba.algo3.algoFormers.Superficies.SuperficieEspinas;
import fiuba.algo3.algoFormers.Superficies.SuperficieNubes;
import fiuba.algo3.algoFormers.Superficies.SuperficiePantano;
import fiuba.algo3.algoFormers.Superficies.SuperficiePsionica;
import fiuba.algo3.algoFormers.Superficies.SuperficieRocosa;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class MegatronHumanoide extends ModoAereo {
	
	private static MegatronHumanoide instancia;
	
	private MegatronHumanoide(){
		this.ataque = 10;
		this.distAtaque = 3;
		this.velocidad = 1;
	}
	
	public static MegatronHumanoide getInstance(){
		if (instancia == null){
			instancia = new MegatronHumanoide();
		}
		return instancia;
	}

	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(MegatronAlterno.getInstance());
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
		// TODO Auto-generated method stub
		
	}

}
