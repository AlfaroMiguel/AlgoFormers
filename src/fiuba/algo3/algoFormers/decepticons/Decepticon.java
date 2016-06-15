package fiuba.algo3.algoFormers.decepticons;

import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.excepciones.EquipoInvalidoException;
import fiuba.algo3.algoFormers.excepciones.MismoEquipoException;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.juego.EquipoAutobots;
import fiuba.algo3.algoFormers.juego.EquipoDecepticons;
import fiuba.algo3.algoFormers.tablero.Tablero;

/*Clase que representa al tipo de algoformer Decepticon*/
public class Decepticon extends Algoformer {

	/*Metodos abstractos redefinidos*/
	@Override
	public void serAtacado(Autobot autobot, int ataque){
		this.vida.sacarVida(ataque*this.escudo.getEscudo());
		this.actualizarEstadoDeVida();
	}

	@Override
	public void serAtacado(Decepticon decepticon, int ataque){
		throw new MismoEquipoException();
	}

	@Override
	public void atacar(Tablero tablero, Accionable atacado) {
		this.modo.atacar(tablero, this,atacado,this.potencia);
	}

	@Override
	public void serSeleccionado(EquipoAutobots equipoAutobot) {
		
		throw new EquipoInvalidoException();
	}

	@Override
	public void serSeleccionado(EquipoDecepticons equipoDecepticon) {
		System.out.println("Me seleccionaron Decepticon");
		equipoDecepticon.setAlgoformerActual(this);
	}

}
