package fiuba.algo3.algoFormers.decepticons;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Juego.Autobots;
import fiuba.algo3.algoFormers.Juego.Decepticons;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.excepciones.EquipoInvalidoException;
import fiuba.algo3.algoFormers.excepciones.MismoEquipoException;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class Decepticon extends Algoformer {

	public Decepticon() {
	}
	
	@Override
	public void serAtacado(Autobot autobot, int ataque){
		this.vida = this.vida - ataque;
	}
	
	@Override
	public void serAtacado(Decepticon decepticon, int ataque){
		throw new MismoEquipoException();
	}
	
	@Override
	public void atacar(HabitableDelMapa atacado) {
		this.modo.atacar(this,atacado);		
	}
	
	@Override
	public void serSeleccionado(Autobots equipoAutobot) {
		throw new EquipoInvalidoException();
	}

	@Override
	public void serSeleccionado(Decepticons equipoDecepticon) {
		equipoDecepticon.setAlgoformerActual(this);
	}

}
