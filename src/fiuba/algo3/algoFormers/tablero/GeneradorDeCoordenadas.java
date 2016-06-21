package fiuba.algo3.algoFormers.tablero;

import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.habitables.BonusVacio;
import fiuba.algo3.algoFormers.habitables.Recolectable;
import fiuba.algo3.algoFormers.habitables.Vacio;

import java.util.HashMap;

import fiuba.algo3.algoFormers.superficie.*;

/*	Clase estatica para generar los casilleros,
 *  bonus y coordenadas del tablero
 */
public class GeneradorDeCoordenadas {

	/*	Llena todos los casilleros del tablero recien inicializado
	 *  con la superficie por defecto */
	public static void generarCasillerosDelTablero(HashMap<Coordenada,Casillero> tablero,int height, int width){
		for (int q = 0; q < width; q++) {
		    int q_offset = (int)Math.floor(q/2); // or q>>1
		    for (int r = -q_offset; r < height - q_offset; r++) {
		    	Casillero casillero = new Casillero();
		    	casillero.agregarSuperficie(new SuperficieNubes());
		    	casillero.agregarSuperficie(new SuperficieRocosa());
		        tablero.put(new Coordenada(q,r),casillero);
		    }
		}
	}
	/*	Llena todos los lugares de accionables del tablero
	 *  con un vacio */
	public static void generarCoordenadasDelTablero(HashMap<Coordenada,Accionable> tablero,int height, int width){
		for (int q = 0; q < width; q++) {
		    int q_offset = (int)Math.floor(q/2); // or q>>1
		    for (int r = -q_offset; r < height - q_offset; r++) {
		        tablero.put(new Coordenada(q,r),new Vacio());
		    }
		}
	}
	/*	Llena todos los lugares de recolectables del tablero
	 *  con un bonus vacio */
	public static void generarBonusDelTablero(HashMap<Coordenada,Recolectable> tablero,int height, int width){
		for (int q = 0; q < width; q++) {
		    int q_offset = (int)Math.floor(q/2); // or q>>1
		    for (int r = -q_offset; r < height - q_offset; r++) {
		        tablero.put(new Coordenada(q,r),new BonusVacio());
		    }
		}
	}

}
