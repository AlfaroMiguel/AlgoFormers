package fiuba.algo3.algoFormers.decepticons;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Juego.EquipoAutobots;
import fiuba.algo3.algoFormers.Juego.EquipoDecepticons;
import fiuba.algo3.algoFormers.Superficies.SuperficieAire;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.excepciones.EquipoInvalidoException;
import fiuba.algo3.algoFormers.excepciones.MismoEquipoException;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class Decepticon extends Algoformer {

	public Decepticon() {
	}
	
	@Override
	public void serAtacado(Autobot autobot, int ataque){
		this.vida.sacarVida(ataque);
	}
	
	@Override
	public void serAtacado(Decepticon decepticon, int ataque){
		throw new MismoEquipoException();
	}
	
	@Override
	public void atacar(Tablero tablero, HabitableDelMapa atacado) {
		this.modo.atacar(tablero, this,atacado,this.potencia);		
	}
	
	@Override
	public void serSeleccionado(EquipoAutobots equipoAutobot) {
		throw new EquipoInvalidoException();
	}

	@Override
	public void serSeleccionado(EquipoDecepticons equipoDecepticon) {
		equipoDecepticon.setAlgoformerActual(this);
	}

	@Override
	public void serDesafectado(SuperficieAire superficieAire) {
		// TODO Auto-generated method stub
		
	}

}
