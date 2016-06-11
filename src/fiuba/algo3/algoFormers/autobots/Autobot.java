package fiuba.algo3.algoFormers.autobots;

import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.excepciones.EquipoInvalidoException;
import fiuba.algo3.algoFormers.excepciones.MismoEquipoException;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.habitables.Collectable;
import fiuba.algo3.algoFormers.juego.EquipoAutobots;
import fiuba.algo3.algoFormers.juego.EquipoDecepticons;
import fiuba.algo3.algoFormers.tablero.Tablero;

public class Autobot extends Algoformer{

	public Autobot(){
	}

	@Override
	public void serAtacado(Autobot atacante, int ataque){
		throw new MismoEquipoException();
	}
	
	@Override
	public void serAtacado(Decepticon atacante, int ataque){
		this.vida.sacarVida(ataque*this.escudo.getEscudo());
	}

	@Override
	public void atacar(Tablero tablero, Accionable atacado) {
		this.modo.atacar(tablero,this,atacado,this.potencia);	
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
