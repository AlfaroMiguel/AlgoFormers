package fiuba.algo3.algoFormers.tablero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.excepciones.NoColisionableException;
import fiuba.algo3.algoFormers.habitables.Accionable;

/*	Clase estatica para calular el camino de costo
 *  minimo entre una coordenada y otra
 */
public class GeneradorDeCaminos {
	
	/*	Devuelve una lista con las coordenadas del camino de menor
	 *  costo entre la coordenada origen y la destino
	 *  para el accionable que se pase como parametro	*/
	public static List<Coordenada> calcularCaminoDeCostoMinimo(HashMap<Coordenada,Casillero> superficies,HashMap<Coordenada,Accionable> personajes,Accionable personaje,Coordenada origen,Coordenada destino){
		//Se utiliza el algoritmo de Dijkstra
		PriorityQueue<Tupla> cola = new PriorityQueue<Tupla>();
		HashMap<Coordenada,Integer> distancia = new HashMap<Coordenada,Integer>();
		HashMap<Coordenada,Coordenada> padre = new HashMap<Coordenada,Coordenada>();
		HashMap<Coordenada,Boolean> visto = new HashMap<Coordenada,Boolean>();
		for(Map.Entry<Coordenada, Casillero> entry : superficies.entrySet()){
			distancia.put(entry.getKey(),100000000);
			visto.put(entry.getKey(),false);
		}
	    distancia.put(origen,0);
	    cola.add(new Tupla(origen,distancia.get(origen)));
	    while(!cola.isEmpty()){
	    	Coordenada actual = cola.remove().getCoordenada();
	    	visto.put(actual,true);

	    	for(Coordenada vecino: Coordenada.vecinosEnRango(actual,1)){
	    		try{
	    			personajes.get(vecino).colisionar();
	    			int costo = calcularCosto(superficies.get(actual),personaje);
	    			//Puede ser que en calcularCosto tenga que poner actual
	    			if(!visto.get(vecino) && (distancia.get(vecino)> distancia.get(actual)+ costo)){
	    				distancia.put(vecino,distancia.get(actual)+costo);
	    				padre.put(vecino, actual);
	    				if(vecino.equals(destino)){
	    					return pasarCaminoAList(padre,origen,destino);
	    				}
	    				cola.add(new Tupla(vecino,distancia.get(vecino)));
	    			}
	    		}
	    		catch(NoColisionableException g){
	    		}
	    		catch(NullPointerException g){
	    		}
	    		catch(MovimientoInvalidoException g){
	    		}
	    	}
	    }
	    return new ArrayList<Coordenada>();
	}

	/*	Metodo interno para calcular el costo de salir del casillero para el personaje	*/
	private static int calcularCosto(Casillero casillero, Accionable personaje) {
		return casillero.calcularMovimiento(personaje);
	}

	/*	Metodo interno para pasar el camino de la cola a una lista	*/
	private static List<Coordenada> pasarCaminoAList(HashMap<Coordenada, Coordenada> padre, Coordenada origen,
			Coordenada destino) {
		Coordenada actual = destino;
		List <Coordenada> camino = new ArrayList<Coordenada>();
		while(actual != origen){
			camino.add(actual);
			actual = padre.get(actual);
		}
		camino.add(actual);
		return camino;
	}
	/*	Devuleve true si el accionable puede pagar el costa del
	 *  camino con su paso actual
	 */
	public static boolean puedePagarCamino(List<Coordenada> camino, HashMap<Coordenada, Casillero> superficies, Accionable accionable,int paso) {
		try{
			superficies.get(camino.get(0)).calcularMovimiento(accionable);
		}catch(MovimientoInvalidoException g){
			return false;
		}
		//Hardcodeo el caso donde sale de una nebulosa despues de esperar 3 turnos
		camino.remove(0);
		if( paso>0 && superficies.get(camino.get(camino.size()-1)).calcularMovimiento(accionable) > 100){
			paso -= 1;
			camino.remove(camino.size()-1);
		}
		//Hasta aca
		for(Coordenada posicion : camino){
			paso-= superficies.get(posicion).calcularMovimiento(accionable);
		}
		if(paso>=0)
			return true;
		return false;

	}

}
