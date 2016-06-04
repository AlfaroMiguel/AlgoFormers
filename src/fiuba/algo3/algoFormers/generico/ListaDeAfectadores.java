package fiuba.algo3.algoFormers.generico;

import fiuba.algo3.algoFormers.afectadores.*;
import java.util.*;

public class ListaDeAfectadores {
	List<Afectador> afectadores = new ArrayList<Afectador>();
	public void agregarAfectador(Afectador afectador){
		afectadores.add(afectador);
	}
	public void agregarAfectador(AfectadorPermanente afectador){
		boolean tieneAfectador = false;
		for(Afectador afectadoresContenidos: afectadores){
			if(afectadoresContenidos.equals(afectador))
				tieneAfectador = true;
		}
		if(!tieneAfectador){
			afectadores.add(afectador);
		}
			
	}
	public void pasarTurno(){
		for(Afectador afectador: afectadores){
			afectador.pasarTurno();
		}
	}
	public void afectarAlgoformer(Algoformer algoformer){
		for(Afectador afectador: afectadores){
			afectador.producirEfecto(algoformer);
		}
	}
	public void desafectarAlgoformer(Algoformer algoformer){
		for(Afectador afectador: afectadores){
			afectador.desafectarAlgoformer(algoformer);
		}
	}
}
