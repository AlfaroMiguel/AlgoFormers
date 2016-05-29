package fiuba.algo3.algoformers.Tablero;
import java.util.HashMap;

import fiuba.algo3.algoformers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoformers.Habitables.Vacio;

public class GeneradorDeCoordenadas {

	public static void generarCasillerosDelTablero(HashMap<Coordenada,Casillero> tablero,int height, int width){
		for(int i=0;i<=height;i++){
			for(int j=0;j<=width;j++){
				Coordenada coordenada = new Coordenada(i,j);
				Casillero casillero = new Casillero();
				tablero.put(coordenada,casillero);
			}
		}
	}
	public static void generarCoordenadasDelTablero(HashMap<Coordenada,HabitableDelMapa> tablero,int height, int width){
		for(int i=0;i<=height;i++){
			for(int j=0;j<=width;j++){
				Coordenada coordenada = new Coordenada(i,j);
				Vacio vacio = new Vacio();
				tablero.put(coordenada,vacio);
			}
		}
	}
}
