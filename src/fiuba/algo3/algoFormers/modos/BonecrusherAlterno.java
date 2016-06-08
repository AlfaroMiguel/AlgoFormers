package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Superficies.SuperficieAndromeda;
import fiuba.algo3.algoFormers.Superficies.SuperficieEspinas;
import fiuba.algo3.algoFormers.Superficies.SuperficieNubes;
import fiuba.algo3.algoFormers.Superficies.SuperficiePantano;
import fiuba.algo3.algoFormers.Superficies.SuperficiePsionica;
import fiuba.algo3.algoFormers.Superficies.SuperficieRocosa;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class BonecrusherAlterno extends ModoTerrestre {
	
	private static BonecrusherAlterno instancia;
	
	private BonecrusherAlterno(){
		this.ataque = 30;
		this.distAtaque = 3;
		this.velocidad = 8;
	}
	
	public static BonecrusherAlterno getInstance(){
		if (instancia == null){
			instancia = new BonecrusherAlterno();
		}
		return instancia;
	}

	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(BonecrusherHumanoide.getInstance());
	}
	@Override
	public int simularPasoDe(SuperficiePantano superficiePantano){
		return 2;
	}
	
	@Override
	public void reaccionarASuperficie(SuperficiePantano superficiePantano, Algoformer afectado){
		superficiePantano.afectar(afectado);
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
