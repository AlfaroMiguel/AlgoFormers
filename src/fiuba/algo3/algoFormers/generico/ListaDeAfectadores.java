package fiuba.algo3.algoFormers.generico;

import fiuba.algo3.algoFormers.afectadores.*;
import java.util.*;

/* Clase que representa un lista de los afectadores que tiene activos un determinado algoformer
 * en un determinado momento. */
public class ListaDeAfectadores {
	
	/* Atributos */
	/* Lista que contiene a los afectadores activos. */
	List<Afectador> afectadores = new ArrayList<Afectador>();
	
	/* Metodos de la clase */
	/* Agrega un nuevo afectador a la lista si este no se encuentra en ella.
	 * Parametros: afectador: afectador que se quiere agregar.*/
	public void agregarAfectador(Afectador afectador){
		boolean tieneAfectador = false;
		for(Afectador afectadoresContenidos: afectadores){
			if(afectadoresContenidos.equals(afectador))
				tieneAfectador = true;
		}
		if(!tieneAfectador){
			afectadores.add(afectador);
		}	
	}
	/* Agrega un nuevo afectador por turnos a la lista si este no se encuentra en ella.
	 * Parametros: afectador: afectador por turnos que se quiere agregar.*/
	public void agregarAfectador(AfectadorPorTurnos afectador){
		boolean tieneAfectador = false;
		for(Afectador afectadoresContenidos: afectadores){
			if(afectadoresContenidos.equals(afectador))
				tieneAfectador = true;
		}
		if(!tieneAfectador){
			afectadores.add(afectador);
			afectador.activar();
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
	
	public void sacarAfectador(AfectadorPorPosicion afectador) {
		this.afectadores.remove(afectador);
	}
	

}
