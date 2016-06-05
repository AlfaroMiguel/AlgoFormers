package fiuba.algo3.algoFormers.Habitables;

import fiuba.algo3.algoFormers.Juego.EquipoAutobots;
import fiuba.algo3.algoFormers.Juego.EquipoDecepticons;
import fiuba.algo3.algoFormers.Superficies.SuperficieAire;
import fiuba.algo3.algoFormers.Superficies.SuperficieTierra;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.excepciones.NoAlgoformerException;
import fiuba.algo3.algoFormers.excepciones.NoAtacableException;;

public class Vacio implements HabitableDelMapa{

	public Vacio(){}

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
	public void serSeleccionado(EquipoAutobots equipoAutobots) {
		throw new NoAlgoformerException();
	}

	@Override
	public void serSeleccionado(EquipoDecepticons equipoDecepticons) {
		throw new NoAlgoformerException();
	}

	@Override
	public void reaccionarASuperficie(SuperficieTierra superficieTierra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reaccionarASuperficie(SuperficieAire superficieTierra) {	
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int simularEfecto(SuperficieTierra superficieTierra) {
		// TODO Auto-generated method stub
		return 0;
	}
}
