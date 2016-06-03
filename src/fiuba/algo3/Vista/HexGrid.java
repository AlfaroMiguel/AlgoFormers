package fiuba.algo3.Vista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fiuba.algo3.Vista.Hexagono;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import javafx.scene.Group;

public class HexGrid {
	
	private static final double l=50;

	private static HashMap<Coordenada,Hexagono> grid = new HashMap<Coordenada,Hexagono>();
	

	public static Group crearTablero() {
		
		Group  group = new Group();
		int width = 10;
		int height = 10;
		//esto lo haria el generador de coordenadas pero no quiero tocar todavia
		for (int q = 0; q < width; q++) {
		    int q_offset = (int)Math.floor(q/2);
		    for (int r = -q_offset; r < height - q_offset; r++) {
		        Hexagono hex = new Hexagono(q,r,l);
		        grid.put(new Coordenada(q,r),hex); //agrega en mi matriz para despues tenerlos
		        group.getChildren().add(hex);//los agrega al grupo que termina en el layout que es lo que se imprime
		        hex.setTranslateX(l*q*(1+Math.cos(Math.PI/3)));
		        hex.setTranslateY(-l*q*Math.sin(Math.PI/3)-2*l*r*Math.sin(Math.PI/3));
		        //calcula la posicion del hexagono en base a las coordenadas actuales
		    }
		}
        return group;
        	
        }
	 	public static void pintarCamino(){
	 		List<Coordenada> camino = new ArrayList <Coordenada>();
	 		camino.add(new Coordenada(3,4));
	 		//Genera el camino 
	 		
	 		// ahora recorro la lista y pinto los hex correspondientes
	 		for(Coordenada coordenada: camino){
	 			grid.get(coordenada).paint();
	 		}
	 		
	 		
	 	}

}
