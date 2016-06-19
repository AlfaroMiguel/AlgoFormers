package fiuba.algo3.algoFormers.tablero;

import java.util.*;


import fiuba.algo3.algoFormers.superficie.SuperficieAndromeda;
import fiuba.algo3.algoFormers.superficie.SuperficieEspinas;
import fiuba.algo3.algoFormers.superficie.SuperficieMonte;
import fiuba.algo3.algoFormers.superficie.SuperficieNubes;
import fiuba.algo3.algoFormers.superficie.SuperficiePantano;
import fiuba.algo3.algoFormers.superficie.SuperficiePsionica;
import fiuba.algo3.algoFormers.superficie.SuperficieRocosa;

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
        
        for (int i = 0; i < 6; i++){
        	Casillero casillero = new Casillero();
        	casillero.agregarSuperficie(new SuperficiePantano());
        	casillero.agregarSuperficie(new SuperficieAndromeda());
        	tablero.put(new Coordenada(i,14), casillero);
        }
        
        int j = 4;
        for (int i = 20; i > 13; i--){
        		Casillero casillero = new Casillero();
        		casillero.agregarSuperficie(new SuperficiePantano());
        		casillero.agregarSuperficie(new SuperficieAndromeda());
        		tablero.put(new Coordenada(i,j), casillero);
        		j++;
        }
        
        //6,8; 7,7; 8,8; 9,7; 10,8; 11,7; 12,8; 13,7
        j = 8;
        for (int i = 6; i < 14; i++){
        	Casillero casillero = new Casillero();
    		casillero.agregarSuperficie(new SuperficiePantano());
    		casillero.agregarSuperficie(new SuperficieAndromeda());
    		if (i%2 == 0){
    			tablero.put(new Coordenada(i,j), casillero);
    			j--;
    		}
        }
        
        j = 7;
        for (int i = 6; i < 14; i++){
        	Casillero casillero = new Casillero();
    		casillero.agregarSuperficie(new SuperficiePantano());
    		casillero.agregarSuperficie(new SuperficieAndromeda());
    		if (i%2 == 1){
    			tablero.put(new Coordenada(i,j), casillero);
    			j--;
    		}
        }
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
	private List<Coordenada> obtenerCoordenadasMontañas(){
		List<Coordenada> montañas = new ArrayList<Coordenada>();
		for(int i =0; i<16;i++){
			montañas.add(new Coordenada(0,i));
		}
		for(int i =-9; i<2;i++){
			montañas.add(new Coordenada(19,i));
		}
		montañas.add(new Coordenada(1,0));
		montañas.add(new Coordenada(2,-1));
		montañas.add(new Coordenada(3,-1));
		montañas.add(new Coordenada(4,-2));
		montañas.add(new Coordenada(5,-2));
		montañas.add(new Coordenada(6,-3));
		montañas.add(new Coordenada(7,-3));
		montañas.add(new Coordenada(8,-4));
		montañas.add(new Coordenada(9,-4));
		montañas.add(new Coordenada(10,-5));
		montañas.add(new Coordenada(11,-5));
		montañas.add(new Coordenada(12,-6));
		montañas.add(new Coordenada(13,-6));
		montañas.add(new Coordenada(14,-7));
		montañas.add(new Coordenada(15,-7));
		montañas.add(new Coordenada(16,-8));
		montañas.add(new Coordenada(17,-8));
		montañas.add(new Coordenada(18,-9));
		montañas.add(new Coordenada(6,-2));
		montañas.add(new Coordenada(6,-1));
		montañas.add(new Coordenada(6,0));
		montañas.add(new Coordenada(6,1));
		montañas.add(new Coordenada(7,1));
		montañas.add(new Coordenada(8,1));
		montañas.add(new Coordenada(9,1));
		montañas.add(new Coordenada(7,-1));
		montañas.add(new Coordenada(7,-2));
		montañas.add(new Coordenada(8,-3));
		montañas.add(new Coordenada(9,-4));
		montañas.add(new Coordenada(12,-5));
		montañas.add(new Coordenada(12,-4));
		montañas.add(new Coordenada(13,-5));
		montañas.add(new Coordenada(13,-4));
		montañas.add(new Coordenada(13,-3));
		montañas.add(new Coordenada(13,-2));
		montañas.add(new Coordenada(12,-1));
		montañas.add(new Coordenada(11,-0));
		montañas.add(new Coordenada(14,1));
		montañas.add(new Coordenada(14,2));
		montañas.add(new Coordenada(14,3));
		montañas.add(new Coordenada(15,2));
		montañas.add(new Coordenada(15,1));
		montañas.add(new Coordenada(3,7));
		montañas.add(new Coordenada(4,7));
		montañas.add(new Coordenada(5,7));
		montañas.add(new Coordenada(5,6));
		montañas.add(new Coordenada(6,6));
		montañas.add(new Coordenada(3,11));
		montañas.add(new Coordenada(4,11));
		montañas.add(new Coordenada(4,10));
		montañas.add(new Coordenada(5,10));
		montañas.add(new Coordenada(11,7));
		montañas.add(new Coordenada(12,7));
		montañas.add(new Coordenada(13,6));	
		return montañas;
	}
	public List<Coordenada> obtenerCordenadasEspinas(){
		List<Coordenada> espinas = new ArrayList<Coordenada>();
		for(int i =15; i<19;i++){
			espinas.add(new Coordenada(i,-2));
		}
		for(int i =15; i<19;i++){
			espinas.add(new Coordenada(i,-1));
		}
		for(int i =16; i<19;i++){
			espinas.add(new Coordenada(i,0));
		}
		for(int i =7; i<10;i++){
			espinas.add(new Coordenada(1,i));
		}
		for(int i =6; i<9;i++){
			espinas.add(new Coordenada(2,i));
		}
		espinas.add(new Coordenada(3,5));
		espinas.add(new Coordenada(3,6));
		espinas.add(new Coordenada(6,3));
		espinas.add(new Coordenada(6,4));
		for(int i =15; i<19;i++){
			espinas.add(new Coordenada(i,-2));
		}
		for(int i =4; i<7;i++){
			espinas.add(new Coordenada(4,i));
		}
		for(int i =3; i<6;i++){
			espinas.add(new Coordenada(5,i));
		}
		espinas.add(new Coordenada(2,10));
		espinas.add(new Coordenada(2,11));
		espinas.add(new Coordenada(2,12));
		espinas.add(new Coordenada(14,4));
		espinas.add(new Coordenada(15,3));
		espinas.add(new Coordenada(16,3));
		espinas.add(new Coordenada(15,5));
		espinas.add(new Coordenada(16,4));
		espinas.add(new Coordenada(14,6));
		return espinas;
	}
}
