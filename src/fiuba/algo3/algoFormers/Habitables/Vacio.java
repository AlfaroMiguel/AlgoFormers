package fiuba.algo3.algoFormers.Habitables;

import fiuba.algo3.algoFormers.Juego.Autobots;
import fiuba.algo3.algoFormers.Juego.Decepticons;
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
	public void serSeleccionado(Autobots equipoAutobots) {
		throw new NoAlgoformerException();
	}

	@Override
	public void serSeleccionado(Decepticons equipoDecepticons) {
		throw new NoAlgoformerException();
	}
}
