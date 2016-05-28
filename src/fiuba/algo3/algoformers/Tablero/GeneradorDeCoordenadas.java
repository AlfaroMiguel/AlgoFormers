package Tablero;
import java.util.*;
import Habitables.*;

public class GeneradorDeCoordenadas {

	public static void generarCasillerosDelTablero(HashMap<Coordenada,Casillero> tablero,int height, int width){
		for(int i=1;i<=height;i++){
			for(int j=1;j<=width;j++){
				Coordenada coordenada = new Coordenada(i,j);
				Casillero casillero = new Casillero();
				tablero.put(coordenada,casillero);
			}
		}
	}
	public static void generarCoordenadasDelTablero(HashMap<Coordenada,HabitableDelMapa> tablero,int height, int width){
		for(int i=1;i<=height;i++){
			for(int j=1;j<=width;j++){
				Coordenada coordenada = new Coordenada(i,j);
				Vacio vacio = new Vacio();
				tablero.put(coordenada,vacio);
			}
		}
	}
}
