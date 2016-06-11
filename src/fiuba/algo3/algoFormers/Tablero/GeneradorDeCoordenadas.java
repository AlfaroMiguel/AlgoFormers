package fiuba.algo3.algoFormers.Tablero;

import fiuba.algo3.algoFormers.efectos.*;
import java.util.HashMap;

import fiuba.algo3.algoFormers.Habitables.Accionable;
import fiuba.algo3.algoFormers.Habitables.BonusVacio;
import fiuba.algo3.algoFormers.Habitables.Collectable;
import fiuba.algo3.algoFormers.Habitables.Vacio;
import fiuba.algo3.algoFormers.Superficies.SuperficieNubes;
import fiuba.algo3.algoFormers.Superficies.SuperficieRocosa;
import fiuba.algo3.algoFormers.Vista.Aplicacion;

public class GeneradorDeCoordenadas {

	public static void generarCasillerosDelTablero(HashMap<Coordenada,Casillero> tablero,int height, int width){
		for (int q = 0; q < width; q++) {
		    int q_offset = (int)Math.floor(q/2); // or q>>1
		    for (int r = -q_offset; r < height - q_offset; r++) {
		    	Casillero casillero = new Casillero();
		    	casillero.agregarSuperficie(new SuperficieNubes());
		    	casillero.agregarSuperficie(new SuperficieRocosa());
		        tablero.put(new Coordenada(q,r),casillero);
		        Aplicacion.ponerSuperficieTierra(new Coordenada(q,r),new SuperficieRocosa());
		        Aplicacion.ponerSuperficieAire(new Coordenada(q,r),new SuperficieNubes());
		    }
		}
	}
	public static void generarCoordenadasDelTablero(HashMap<Coordenada,Accionable> tablero,int height, int width){
		for (int q = 0; q < width; q++) {
		    int q_offset = (int)Math.floor(q/2); // or q>>1
		    for (int r = -q_offset; r < height - q_offset; r++) {
		        tablero.put(new Coordenada(q,r),new Vacio());
		    }
		}
	}

	public static void generarBonusDelTablero(HashMap<Coordenada,Collectable> tablero,int height, int width){
		for (int q = 0; q < width; q++) {
		    int q_offset = (int)Math.floor(q/2); // or q>>1
		    for (int r = -q_offset; r < height - q_offset; r++) {
		        tablero.put(new Coordenada(q,r),new BonusVacio());
		    }
		}
	}

}
