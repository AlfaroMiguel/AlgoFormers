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
	/* Actualiza el turno de los efectos que duran por turno. */
	public void pasarTurno(){
		for(Afectador afectador: afectadores){
			afectador.pasarTurno();
		}
	}
	/* Cada afectador de la lista produce efecto sobre un algoformer.
	 * Parametros: algoformer: algoformer sobre el que se producen los efectos.*/
	public void afectarAlgoformer(Algoformer algoformer){
		for(Afectador afectador: afectadores){
			afectador.producirEfecto(algoformer);
		}
	}
	/* Cada afectador de la lista revierte el efecto sobre lo algoformers que lo contienen.
	 * Parametros: algoformer: algoformer sobre el que se revierten los efectos. */
	public void desafectarAlgoformer(Algoformer algoformer){
		for(Afectador afectador: afectadores){
			afectador.desafectarAlgoformer(algoformer);
		}
	}
	/* Se elimina un afectador por posicion de la lista.
	 * Parametros: afectador: afectador por posicion que se quiere eliminar. */
	public void sacarAfectador(AfectadorPorPosicion afectador) {
		this.afectadores.remove(afectador);
	}
	

}
