
package fiuba.algo3.algoFormers.tablero;

import java.util.ArrayList;

/* Clase que representa una coordenada del tablero*/
public class Coordenada {
	
	/* Atributos */
	/* Coordenadas axiales */
	public final int q;
    public final int r;
    public final int s;
    /* Lista de direcciones posibles desde una coordenada */
    public static ArrayList<Coordenada> direcciones = new ArrayList<Coordenada>(){
		{
	    	add(new Coordenada(1, 0)); 
	    	add(new Coordenada(1, -1)); 
	    	add(new Coordenada(0, -1)); 
	    	add(new Coordenada(-1, 0)); 
	    	add(new Coordenada(-1, 1)); 
	    	add(new Coordenada(0, 1));}
	 };
	 /* Lista de direcciones posibles en diagonal desde una coordenada */
	 static public ArrayList<Coordenada> diagonals = new ArrayList<Coordenada>(){
		{   add(new Coordenada(2, -1)); 
		    add(new Coordenada(1, -2));
		    add(new Coordenada(-1, -1));
		    add(new Coordenada(-2, 1)); 
		    add(new Coordenada(-1, 2)); 
		    add(new Coordenada(1, 1));}
	 };

	/* Constructor */
	/* Crea una coordenada con coordenadas axiales q, r y s.
	 * Parametros: q: equivalente a la coordenada cartesianda x.
	 * 			   r: equivalente a la coordenada cartesiana (y + x/2)*/
	public Coordenada(int q, int r){
	    this.q = q;
	    this.r = r;
	    this.s = -r-q;
	}
	
	/* Metodos de la clase */
	/* Suma dos coordenadas.
	 * Parametros: coordUno, coordDos: coordendas a sumar.*/
	public static Coordenada sumarCoordenadas(Coordenada coordUno, Coordenada coordDos){
	    return new Coordenada(coordUno.q + coordDos.q, coordUno.r + coordDos.r);
	}

	/* Resta dos coordenadas.
	 * Parametros: coordUno, coordDos: coordenadas a restar.*/
	public static Coordenada restarCoordenadas(Coordenada coordUno, Coordenada coordDos){
	    return new Coordenada(coordUno.q - coordDos.q, coordUno.r - coordDos.r);
	}

	/* Escala una coordenada.
	 * Parametros: coordenada: coordenada a escalar.
	 * 			   factor: factor por el que se quiere escalar. */
	public static Coordenada escalarCoordenada(Coordenada coordenada, int factor){
	    return new Coordenada(coordenada.q * factor, coordenada.r * factor);
	}
	/* Devuelve todaas las coordenadas que rodean a otra en un rango.
	 * Parametros: coordenada: coordenada de la que se buscan vecinos.
	 * 			   rango: rango en el que se buscan vecinos. */
	public static ArrayList<Coordenada> vecinosEnRango(Coordenada coordenada, int rango){
    	ArrayList<Coordenada> vecinosEnRango = new ArrayList<Coordenada>();
    	if (rango == 0)
    		return vecinosEnRango;
    	for(int j=0; j<6;j++){
    			if(!vecinosEnRango.contains(vecino(coordenada, j)))
    				vecinosEnRango.add(vecino(coordenada,j));
    			vecinosEnRango.addAll(vecinosEnRango(vecino(coordenada,j),rango-1));
    	}
	    return vecinosEnRango;
	}
	/* Devuelve la coordenada en una posicion indicada de la lista de direcciones.
	   Parametros: indice: indice de la direccion en la lista. */
	public static Coordenada direccion(int indice){
	    return Coordenada.direcciones.get(indice);
	}

	/* Devuelve la siguiente coordenada en la direccion indicada.
	 * Parametros: coordenada: coordenada de origen.
	 * 			   direccion: indice de la direccion en la lista de direcciones.*/
	public static Coordenada vecino(Coordenada coordenada, int direccion){
	    return Coordenada.sumarCoordenadas(coordenada, Coordenada.direccion(direccion));
	}
	/* Devuelve la siguiente coordenada en la direccion diagonal indicada.
	 * Parametros: coordenada: coordenada de origen.
	 * 			   direccion: indice de la direccion en la lista de direcciones diagonales.*/
    public static Coordenada vecinoDiagonal(Coordenada coordenada, int direccion){
	    return Coordenada.sumarCoordenadas(coordenada, Coordenada.diagonals.get(direccion));
	}

    /* Devuelve la representacion de la longitud de una coordenada
     * Parametros: coordenada: coordenada de la que se quiere calcular la longitud. */
	static public int longitud(Coordenada coordenada){
	    return (int)((Math.abs(coordenada.q) + Math.abs(coordenada.r) + Math.abs(coordenada.s)) / 2);
	}

	/* Devuelve la distancia entre la coordenada y otra.
	 * Parametros: otraCoordenada: coordenada con respecto a la que se calcula la distancia.*/
	public int distancia(Coordenada otraCoordenada){
	    return Coordenada.longitud(Coordenada.restarCoordenadas(this, otraCoordenada));
	}

	/* Metodos abstractos redefinidos */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + q;
		result = prime * result + r;
		result = prime * result + s;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		//dos coordenadas son iguales si tienen las mismas coordenadas axiales
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		if (q != other.q)
			return false;
		if (r != other.r)
			return false;
		if (s != other.s)
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return this.q+ " " + this.r;
	}
}

