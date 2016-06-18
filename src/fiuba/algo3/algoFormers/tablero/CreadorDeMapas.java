package fiuba.algo3.algoFormers.tablero;

import java.util.HashMap;

import fiuba.algo3.algoFormers.superficie.*;

public class CreadorDeMapas {

	public static void generarMapa(HashMap<Coordenada, Casillero> tablero, int height, int width) {
		
		Casillero casillero1 = new Casillero();
    	casillero1.agregarSuperficie(new SuperficieAndromeda());
    	casillero1.agregarSuperficie(new SuperficieEspinas());
        tablero.put(new Coordenada(3,6),casillero1);
        
        Casillero casillero2 = new Casillero();
    	casillero2.agregarSuperficie(new SuperficiePsionica());
    	casillero2.agregarSuperficie(new SuperficieRocosa());
        tablero.put(new Coordenada(6,7),casillero2);
        
        CreadorDeMapas.colocarMonte(tablero);
	}
	
	private static void colocarMonte(HashMap<Coordenada, Casillero> tablero){
		
		for (int i = 6; i < 14; i++){
        	Casillero casillero = new Casillero();
        	casillero.agregarSuperficie(new SuperficieMonte());
        	casillero.agregarSuperficie(new SuperficieNubes());
        	tablero.put(new Coordenada(i,-3), casillero);
        }
        
        for (int i = 6; i < 12; i++){
        	Casillero casillero = new Casillero();
        	casillero.agregarSuperficie(new SuperficieMonte());
        	casillero.agregarSuperficie(new SuperficieNubes());
        	tablero.put(new Coordenada(i,-2), casillero);
        }
        
        for (int i = 8; i < 14; i++){
        	Casillero casillero = new Casillero();
        	casillero.agregarSuperficie(new SuperficieMonte());
        	casillero.agregarSuperficie(new SuperficieNubes());
        	tablero.put(new Coordenada(i,-4), casillero);
        }
        
        for (int i = 10; i < 14; i++){
        	Casillero casillero = new Casillero();
        	casillero.agregarSuperficie(new SuperficieMonte());
        	casillero.agregarSuperficie(new SuperficieNubes());
        	tablero.put(new Coordenada(i,-5), casillero);
        }
        
        for (int i = 12; i < 14; i++){
        	Casillero casillero = new Casillero();
        	casillero.agregarSuperficie(new SuperficieMonte());
        	casillero.agregarSuperficie(new SuperficieNubes());
        	tablero.put(new Coordenada(i,-6), casillero);
        }
        
        for (int i = 6; i < 10; i++){
        	Casillero casillero = new Casillero();
        	casillero.agregarSuperficie(new SuperficieMonte());
        	casillero.agregarSuperficie(new SuperficieNubes());
        	tablero.put(new Coordenada(i,-1), casillero);
        }
        
        for (int i = 6; i < 8; i++){
        	Casillero casillero = new Casillero();
        	casillero.agregarSuperficie(new SuperficieMonte());
        	casillero.agregarSuperficie(new SuperficieNubes());
        	tablero.put(new Coordenada(i,0), casillero);
        }
	}

}
