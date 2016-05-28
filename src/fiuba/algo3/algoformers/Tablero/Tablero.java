package Tablero;
import Habitables.*;
import java.util.*;


public class Tablero {
	HashMap<Coordenada,Casillero> superficies = new HashMap<Coordenada,Casillero>();
	HashMap<Coordenada,HabitableDelMapa> habitables = new HashMap<Coordenada,HabitableDelMapa>();
	public Tablero(int height,int width){
		GeneradorDeCoordenadas.generarCasillerosDelTablero(this.superficies,height,width);
		GeneradorDeCoordenadas.generarCoordenadasDelTablero(this.habitables,height,width);
	}
	public boolean estaVacio(int i, int j) {
		try{
		Coordenada coordenada = new Coordenada(i,j);
		this.habitables.get(coordenada).estaVacio();
		return true;
		}catch(Throwable g){
			return false;
		}
	}
	public void put(HabitableDelMapa habitable,Coordenada coordenada){
		try{
			this.habitables.get(coordenada).colisionar();
			//habitable.recibir(this.habitables.get(coordenada));
			this.habitables.put(coordenada,habitable);
		}
		catch(Throwable g){
		}
	}
	public void put(Collectable collectable,Coordenada coordenada){
		try{
			this.habitables.get(coordenada).estaVacio();
			this.habitables.put(coordenada, collectable);

	}catch(Throwable g){

		}

	}

}
