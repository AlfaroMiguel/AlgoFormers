package fiuba.algo3.algoFormers.tablero;

import fiuba.algo3.algoFormers.tablero.*;

/*	Clase para el funcionamiento interno de GeneradorDeCaminos 
 *  guarda una coordenada y su distancia a otra
 *  */
public class Tupla implements Comparable<Tupla>{
	private Coordenada coord;
	private int dist;
	
	public Tupla(Coordenada coord,int dist){
		this.coord = coord;
		this.dist = dist;
	}
	public int compareTo(Tupla otra){
		if(this.dist == otra.dist)
			return 0;
		else if(this.dist < otra.dist)
			return -1;
		return 1;
	}
	public Coordenada getCoordenada() {
		return this.coord;
	}
	

}
