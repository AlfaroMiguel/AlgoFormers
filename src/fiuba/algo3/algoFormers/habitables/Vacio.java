package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.excepciones.NoAlgoformerException;
import fiuba.algo3.algoFormers.excepciones.NoAtacableException;
import fiuba.algo3.algoFormers.juego.EquipoAutobots;
import fiuba.algo3.algoFormers.juego.EquipoDecepticons;

public class Vacio implements Accionable{

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

	@Override
	public void reaccionarASuperficie(SuperficieAire superficieAire) {
		// TODO Auto-generated method stub
	}

	@Override
	public void reaccionarASuperficie(SuperficieTierra superficieTierra) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void recolectar(Collectable colectable) {
		// TODO Auto-generated method stub	
	}
	
}
