package fiuba.algo3.algoFormers.Tablero;

import java.util.*;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
public class GeneradorDeCaminos {
	public static void solicitarCamino(HashMap<Coordenada,Casillero> superficies,HashMap<Coordenada,HabitableDelMapa> personajes,HabitableDelMapa personaje,Coordenada origen,Coordenada destino,int paso){
		List<Coordenada> camino =  calcularCaminoDeCostoMinimo(superficies,personajes, personaje, origen, destino);
		//simularCamino(camino,personaje);
		//Display del camino en rojo o amarillo
	}
	public static List<Coordenada> calcularCaminoDeCostoMinimo(HashMap<Coordenada,Casillero> superficies,HashMap<Coordenada,HabitableDelMapa> personajes,HabitableDelMapa personaje,Coordenada origen,Coordenada destino){
		//Dijkstra
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
	    	for(Coordenada vecino: Coordenada.neighborsInRange(actual,1)){
	    		try{
	    		personajes.get(vecino).colisionar();
	    		int costo = calcularCosto(superficies.get(vecino),personaje);
	    		//Puede ser que en calcularCosto tenga que poner actual
	    		if(!visto.get(vecino) && (distancia.get(vecino)> distancia.get(actual)+ costo)){
	    			distancia.put(vecino,distancia.get(actual)+costo);
	    			padre.put(vecino, actual);
	    			if(vecino.equals(destino)){
	    				return pasarCaminoAList(padre,origen,destino);
	    			}
	    			cola.add(new Tupla(vecino,distancia.get(vecino)));
	    		}
	    		}catch(Throwable g){
	    		}
	    	}
	    }
	    return new ArrayList<Coordenada>(); 
	}

	private static int calcularCosto(Casillero casillero, HabitableDelMapa personaje) {
		return casillero.calcularMovimiento(personaje);
	}

	private static List<Coordenada> pasarCaminoAList(HashMap<Coordenada, Coordenada> padre, Coordenada origen,
			Coordenada destino) {
		Coordenada actual = destino;
		List <Coordenada> camino = new ArrayList<Coordenada>();
		while(actual != origen){
			camino.add(actual);
			actual = padre.get(actual);
		}
		return camino;
	}

}
