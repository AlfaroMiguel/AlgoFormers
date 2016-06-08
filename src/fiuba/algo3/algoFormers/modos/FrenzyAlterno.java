package fiuba.algo3.algoFormers.modos;


import fiuba.algo3.algoFormers.Superficies.SuperficieAndromeda;
import fiuba.algo3.algoFormers.Superficies.SuperficieEspinas;
import fiuba.algo3.algoFormers.Superficies.SuperficieNubes;
import fiuba.algo3.algoFormers.Superficies.SuperficiePantano;
import fiuba.algo3.algoFormers.Superficies.SuperficiePsionica;
import fiuba.algo3.algoFormers.Superficies.SuperficieRocosa;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class FrenzyAlterno extends ModoTerrestre {
	
	private static FrenzyAlterno instancia;
	
	private FrenzyAlterno(){
		this.ataque = 25;
		this.distAtaque = 2;
		this.velocidad = 6;
	}
	
	public static FrenzyAlterno getInstance(){
		if (instancia == null){
			instancia = new FrenzyAlterno();
		}
		return instancia;
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(FrenzyHumanoide.getInstance());
	}
	@Override
	public int simularPasoDe(SuperficiePantano superficiePantano){
		return 2;
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
		superficieNubes.afectar(afectado);
	}
	
	@Override
	public void reaccionarASuperficie(SuperficieAndromeda superficieAndromeda, Algoformer afectado){
		superficieAndromeda.afectar(afectado);
	}
	
	@Override
	public void reaccionarASuperficie(SuperficiePsionica superficiePsionica, Algoformer afectado){
		superficiePsionica.afectar(afectado);
	}

	@Override
	public void ponerAlgoFormer(Coordenada coordenada) {
		// TODO Auto-generated method stub
		
	}
}
