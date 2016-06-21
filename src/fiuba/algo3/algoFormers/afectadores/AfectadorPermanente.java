package fiuba.algo3.algoFormers.afectadores;

import fiuba.algo3.algoFormers.efectos.Efecto;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.ListaDeAfectadores;

/*Tipo de afectador que maneja los efectos permanentes*/
public class AfectadorPermanente extends Afectador {
	
	/*Constructor*/
	/*Parametros: -efecto: es el efecto que se le quiere asignar al afectador*/
	public AfectadorPermanente(Efecto efecto){
		this.efecto = efecto;
	}
	
	/*Metodos abstractos redefinidos*/
	@Override
	public void desafectarAlgoformer(Algoformer algoformer){	
	}

	@Override
	public void afectarPorPaso(Algoformer algoformer) {
		algoformer.agregarEfecto(this);	
	}

	@Override
	public void afectarAlgoformer(Algoformer algoformer) {
		ListaDeAfectadores afectadores  = algoformer.obtenerAfectadoresEnAtacable();
		afectadores.agregarAfectador(this);
	}

	@Override
	public void pasarTurno() {
	}
}
