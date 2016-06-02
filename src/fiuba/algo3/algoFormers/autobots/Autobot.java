package fiuba.algo3.algoFormers.autobots;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Juego.EquipoAutobots;
import fiuba.algo3.algoFormers.Juego.EquipoDecepticons;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.excepciones.EquipoInvalidoException;
import fiuba.algo3.algoFormers.excepciones.MismoEquipoException;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class Autobot extends Algoformer{

	public Autobot(){
	}

	@Override
	public void serAtacado(Autobot atacante, int ataque){
		throw new MismoEquipoException();
	}
	
	@Override
	public void serAtacado(Decepticon atacante, int ataque){
		this.vida = this.vida - ataque;
	}

	@Override
	public void atacar(Tablero tablero, HabitableDelMapa atacado) {
		this.modo.atacar(tablero,this,atacado);	
	}
	
	@Override
	public void serSeleccionado(EquipoAutobots equipoAutobot) {
		equipoAutobot.setAlgoformerActual(this);
	}

	@Override
	public void serSeleccionado(EquipoDecepticons equipoDecepticon) {
		throw new EquipoInvalidoException();
	}
}
