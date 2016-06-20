package fiuba.algo3.algoFormers.autobots;

import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.excepciones.EquipoInvalidoException;
import fiuba.algo3.algoFormers.excepciones.MismoEquipoException;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.juego.EquipoAutobots;
import fiuba.algo3.algoFormers.juego.EquipoDecepticons;
import fiuba.algo3.algoFormers.tablero.Tablero;
import javafx.scene.media.AudioClip;

/*Clase que representa al tipo de algoformer Autobot*/
public class Autobot extends Algoformer{

	/*Metodos abstractos redefinidos*/
	@Override
	public void serAtacado(Autobot atacante, int ataque){
		throw new MismoEquipoException();
	}

	@Override
	public void serAtacado(Decepticon atacante, int ataque){
		//this.ataqueEfectuado();
		//Notifica A La Barra De Vida
		this.notificarRepresentaciones();
		this.vida.sacarVida(ataque*this.escudo.getEscudo());
		this.actualizarEstadoDeVida();
		this.actualizarVista(ataque*this.escudo.getEscudo());
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
