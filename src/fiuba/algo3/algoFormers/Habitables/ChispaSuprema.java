package fiuba.algo3.algoFormers.Habitables;

import fiuba.algo3.algoFormers.Juego.EquipoAutobots;
import fiuba.algo3.algoFormers.Juego.EquipoDecepticons;
import fiuba.algo3.algoFormers.Superficies.SuperficieAire;
import fiuba.algo3.algoFormers.Superficies.SuperficieAndromeda;
import fiuba.algo3.algoFormers.Superficies.SuperficieEspinas;
import fiuba.algo3.algoFormers.Superficies.SuperficieNubes;
import fiuba.algo3.algoFormers.Superficies.SuperficiePantano;
import fiuba.algo3.algoFormers.Superficies.SuperficiePsionica;
import fiuba.algo3.algoFormers.Superficies.SuperficieRocosa;
import fiuba.algo3.algoFormers.Superficies.SuperficieTierra;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Vista.HexGrid;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.excepciones.NoAlgoformerException;
import fiuba.algo3.algoFormers.excepciones.NoAtacableException;

public class ChispaSuprema implements Collectable{

	private static final ChispaSuprema INSTANCE = new ChispaSuprema();
	private ChispaSuprema(){}

	public static ChispaSuprema getInstance(){
		return INSTANCE;
	}
	public boolean ocupaLugar(){
		return true;
	}
	public void colisionar(){
		
	}

	@Override
	public void serAtacado(Autobot atacante, int ataque) {
		throw new NoAtacableException();
	}
	
	@Override
	public void serAtacado(Decepticon atacante, int ataque) {
		throw new NoAtacableException();
	}
	
	@Override
	public void serSeleccionado(EquipoAutobots equipoAutobots) {
		throw new NoAlgoformerException();
	}

	@Override
	public void serSeleccionado(EquipoDecepticons equipoDecepticons) {
		throw new NoAlgoformerException();
	}



	@Override
	public void serDesafectado(SuperficieAire superficieAire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void serDesafectado(SuperficieTierra superficieTierra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int simularEfecto(SuperficieAire superficieAire) {
		return 0;
	}

	@Override
	public int simularEfecto(SuperficieTierra superficieTierra) {
		return 0;
	}

	@Override
	public void reaccionarASuperficie(SuperficiePantano superficiePantano) {
	}

	@Override
	public void reaccionarASuperficie(SuperficieRocosa superficieRocosa) {
	}

	@Override
	public void reaccionarASuperficie(SuperficieEspinas superficieEspinas) {	
	}

	@Override
	public void reaccionarASuperficie(SuperficieNubes superficieNubes) {
	}

	@Override
	public void reaccionarASuperficie(SuperficieAndromeda superficieAndromeda) {	
	}

	@Override
	public void reaccionarASuperficie(SuperficiePsionica superficiePsionica) {	
	}

	@Override
	public void ponerHabitable(Coordenada coordenada) {
		HexGrid.ponerChispa(coordenada);
	}
}
