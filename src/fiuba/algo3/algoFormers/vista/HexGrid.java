package fiuba.algo3.algoFormers.vista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.habitables.Recolectable;
import fiuba.algo3.algoFormers.juego.Juego;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Casillero;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.Hexagono;
import javafx.scene.Group;

public class HexGrid {
	
	private static final double l=50;

	private static HashMap<Coordenada,Hexagono> grid = new HashMap<Coordenada,Hexagono>();
	

	public static Group crearTablero(int ancho,int alto) {
		
		Group  group = new Group();
		//esto lo haria el generador de coordenadas pero no quiero tocar todavia
		for (int q = 0; q < ancho; q++) {
		    int q_offset = (int)Math.floor(q/2);
		    for (int r = -q_offset; r < alto - q_offset; r++) {
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
	 	public static void pintarCamino(List<Coordenada> camino){
	 		// Recorro la lista y pinto los hex correspondientes
	 		for(Coordenada coordenada: camino){
	 			grid.get(coordenada).paint();
	 		}
	 		
	 	}

		public static void ponerSuperficieTierra(Coordenada coordenada, SuperficieTierra superficieTierra) {
			superficieTierra.ponerSuperficieTierra(coordenada);
		}
		public static void ponerSuperficieRocosa(Coordenada coordenada) {
			grid.get(coordenada).ponerRocosa();
		}
		public static void ponerSuperficiePantano(Coordenada coordenada) {
			grid.get(coordenada).ponerPantano();
		}
		public static void ponerSuperficieEspinas(Coordenada coordenada) {
			grid.get(coordenada).ponerEspinas();
		}
//		public static Group GrupoDeTablero(int width, int height) {
//			Group group = new Group();
//			for (int q = 0; q < width; q++) {
//			    int q_offset = (int)Math.floor(q/2);
//			    for (int r = -q_offset; r < height - q_offset; r++) {
//			        Hexagono hex = grid.get(new Coordenada(q,r));
//			        group.getChildren().add(hex);
//			    }
//			}
//	        return group;
//		}
		public static void ponerSuperficieAire(Coordenada coordenada, SuperficieAire superficieAire) {
			superficieAire.ponerSuperficieAire(coordenada);
		}
		public static void ponerSuperficieNubes(Coordenada coordenada) {
			grid.get(coordenada).ponerNubes();
		}
		public static void ponerSuperficieAndromeda(Coordenada coordenada) {
			grid.get(coordenada).ponerAndromeda();
		}
		public static void ponerSuperficiePsionica(Coordenada coordenada) {
			grid.get(coordenada).ponerPsionica();
		}
		public static void inicializarTablero(int alto, int ancho,Juego juego) {
			for (int q = 0; q < ancho; q++) {
			    int q_offset = (int)Math.floor(q/2);
			    for (int r = -q_offset; r < alto - q_offset; r++) {
			    	Coordenada c = new Coordenada(q,r);
			        HexGrid.ponerSuperficieTierra(c,juego.obtenerSuperficieTierra(c));
			        HexGrid.ponerSuperficieAire(c, juego.obtenerSuperficieAire(c));
			        HexGrid.ponerAccionable(c,juego.obtenerAccionable(c));
			        HexGrid.ponerRecolectable(c,juego.obtenerRecolectable(c));
			        //TODO Falta poner algoformers y bonus y demas
			    }
			}
		}
		private static void ponerRecolectable(Coordenada c, Recolectable recolectable) {
			recolectable.ponerRecolectable(c);
		}
		private static void ponerAccionable(Coordenada c, Accionable accionable) {
			accionable.ponerAccionable(c);
		}
		public static void ponerVacio(Coordenada c) {
			
		}
		public static void ponerBonecrusherAlterno(Coordenada coordenada) {
			// TODO Auto-generated method stub	
		}
		public static void ponerBonecrusherHumanoide(Coordenada coordenada) {
			grid.get(coordenada).ponerBonecrusherHumanoide();			
		}
		public static void ponerBumblebeeAlterno(Coordenada coordenada) {
			// TODO Auto-generated method stub
		}
		public static void ponerBumblebeeHumanoide(Coordenada coordenada) {
			grid.get(coordenada).ponerBumblebeeHumanoide();
		}
		public static void ponerFrenzyAlterno(Coordenada coordenada) {
			// TODO Auto-generated method stub
		}
		public static void ponerFrenzyHumanoide(Coordenada coordenada) {
			grid.get(coordenada).ponerFrenzyHumanoide();
			}
		public static void ponerMegatronAlterno(Coordenada coordenada) {
			// TODO Auto-generated method stub
		}
		public static void ponerMegatronHumanoide(Coordenada coordenada) {
			grid.get(coordenada).ponerMegatronHumanoide();
		}
		public static void ponerMenasor(Coordenada coordenada) {
			// TODO Auto-generated method stub
		}
		public static void ponerOptimusAlterno(Coordenada coordenada) {
			// TODO Auto-generated method stub	
		}
		public static void ponerOptimusHumanoide(Coordenada coordenada) {
			grid.get(coordenada).ponerOptimusHumanoide();
		}
		public static void ponerRatchetAlterno(Coordenada coordenada) {
			// TODO Auto-generated method stub
		}
		public static void ponerRatchetHumanoide(Coordenada coordenada) {
			grid.get(coordenada).ponerRatchetHumanoide();
		}
		public static void ponerSuperion(Coordenada coordenada) {
			// TODO Auto-generated method stub
		}
		public static void ponerChispa(Coordenada c) {
			grid.get(c).ponerChispa();
		}

}
