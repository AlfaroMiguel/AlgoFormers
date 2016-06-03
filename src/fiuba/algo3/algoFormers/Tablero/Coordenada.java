
package fiuba.algo3.algoFormers.Tablero;

import java.util.ArrayList;

import java.util.*;

public class Coordenada {
	    public Coordenada(int q, int r)
	    {
	        this.q = q;
	        this.r = r;
	        this.s = -r-q;
	    }
	    public final int q;
	    public final int r;
	    public final int s;

	    static public Coordenada add(Coordenada a, Coordenada b)
	    {
	        return new Coordenada(a.q + b.q, a.r + b.r);
	    }


	    static public Coordenada subtract(Coordenada a, Coordenada b)
	    {
	        return new Coordenada(a.q - b.q, a.r - b.r);
	    }


	    static public Coordenada scale(Coordenada a, int k)
	    {
	        return new Coordenada(a.q * k, a.r * k);
	    }

	    static public ArrayList<Coordenada> directions = new ArrayList<Coordenada>(){
	    	{
	    		add(new Coordenada(1, 0)); 
	    		add(new Coordenada(1, -1)); 
	    		add(new Coordenada(0, -1)); 
	    		add(new Coordenada(-1, 0)); 
	    		add(new Coordenada(-1, 1)); 
	    		add(new Coordenada(0, 1));}
	    	};
	    	
	    public static ArrayList<Coordenada> neighborsInRange(Coordenada hex, int range){
	    	ArrayList<Coordenada> vecinosEnRango = new ArrayList<Coordenada>();
	    	if(range==0)return vecinosEnRango;
	    	for(int j=0; j<6;j++){
	    			if(!vecinosEnRango.contains(neighbor(hex, j)))
	    				vecinosEnRango.add(neighbor(hex,j));
	    			vecinosEnRango.addAll(neighborsInRange(neighbor(hex,j),range-1));
	    	}
	    	return vecinosEnRango;
	    }
	    static public Coordenada direction(int direction)
	    {
	        return Coordenada.directions.get(direction);
	    }


	    static public Coordenada neighbor(Coordenada hex, int direction)
	    {
	        return Coordenada.add(hex, Coordenada.direction(direction));
	    }

	    static public ArrayList<Coordenada> diagonals = new ArrayList<Coordenada>(){{add(new Coordenada(2, -1)); add(new Coordenada(1, -2)); add(new Coordenada(-1, -1)); add(new Coordenada(-2, 1)); add(new Coordenada(-1, 2)); add(new Coordenada(1, 1));}};

	    static public Coordenada diagonalNeighbor(Coordenada hex, int direction)
	    {
	        return Coordenada.add(hex, Coordenada.diagonals.get(direction));
	    }


	    static public int length(Coordenada hex)
	    {
	        return (int)((Math.abs(hex.q) + Math.abs(hex.r) + Math.abs(hex.s)) / 2);
	    }


	    public int distancia(Coordenada b)
	    {
	    	return Coordenada.length(Coordenada.subtract(this, b));
	    }


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

}

