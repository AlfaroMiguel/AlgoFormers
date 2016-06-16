package fiuba.algo3.algoFormers.tablero;

import java.util.HashMap;

import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.superficie.*;

public class CreadorDeMapas {

	public static void generarMapa(HashMap<Coordenada, Casillero> tablero, int height, int width) {
		Casillero casillero = new Casillero();
    	casillero.agregarSuperficie(new SuperficieAndromeda());
    	casillero.agregarSuperficie(new SuperficieEspinas());
        tablero.put(new Coordenada(3,6),casillero);
        
        Casillero casillero2 = new Casillero();
    	casillero2.agregarSuperficie(new SuperficiePsionica());
    	casillero2.agregarSuperficie(new SuperficieRocosa());
        tablero.put(new Coordenada(6,7),casillero2);
	}

}
