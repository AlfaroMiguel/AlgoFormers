package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.excepciones.NoAtacableException;
import fiuba.algo3.algoFormers.excepciones.NoSeleccionableException;
import fiuba.algo3.algoFormers.juego.EquipoAutobots;
import fiuba.algo3.algoFormers.juego.EquipoDecepticons;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.HexGrid;

public class Vacio implements Accionable{

	@Override
	 public void ponerAccionable(Coordenada c) {
	 	HexGrid.ponerVacio(c);
	}
	
	public boolean ocupaLugar(){
		return false;
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
	public void serSeleccionado(EquipoAutobots equipo) {
		throw new NoSeleccionableException();
	}

	@Override
	public void serSeleccionado(EquipoDecepticons equipo) {
		throw new NoSeleccionableException();
	}
	
	@Override
	public void serDesafectado(SuperficieAire superficie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void serDesafectado(SuperficieTierra superficie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int simularEfecto(SuperficieAire superficie) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int simularEfecto(SuperficieTierra superficie) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reaccionarASuperficie(SuperficieAire superficie) {
		// TODO Auto-generated method stub
	}

	@Override
	public void reaccionarASuperficie(SuperficieTierra superficie) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void recolectar(Recolectable colectable) {
		// TODO Auto-generated method stub	
	}
	
}
