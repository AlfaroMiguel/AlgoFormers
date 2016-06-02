package fiuba.algo3.algoFormers.Tablero;

import java.util.ArrayList;

public class Coordenada {
	private int coordX;
	private int coordY;
	
	public Coordenada(int x,int y){
		coordX = x;
		coordY = y;
	}
	
	public void add(Coordenada otra){
		this.coordX += otra.coordX;
		this.coordY += otra.coordY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coordX;
		result = prime * result + coordY;
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
		if (coordX != other.coordX)
			return false;
		if (coordY != other.coordY)
			return false;
		return true;
	}
	
	public double distancia(Coordenada otra) {
		return Math.sqrt((this.coordX-otra.coordX)*(this.coordX-otra.coordX) + (this.coordY - otra.coordY)*(this.coordY-otra.coordY));
	}
	
}

