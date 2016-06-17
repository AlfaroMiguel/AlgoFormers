package fiuba.algo3.algoFormers.vista;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fiuba.algo3.algoFormers.controlador.Controlador;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.habitables.Recolectable;
import fiuba.algo3.algoFormers.juego.Juego;
import fiuba.algo3.algoFormers.superficie.SuperficieAire;
import fiuba.algo3.algoFormers.superficie.SuperficieTierra;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import javafx.scene.Group;

public class HexGrid {

	private final double l=50;

	private HashMap<Coordenada,Hexagono> grid = new HashMap<Coordenada,Hexagono>();


	public Group crearTablero(int ancho,int alto,Controlador controlador) {

		Group  group = new Group();
		//esto lo haria el generador de coordenadas pero no quiero tocar todavia
		for (int q = 0; q < ancho; q++) {
		    int q_offset = (int)Math.floor(q/2);
		    for (int r = -q_offset; r < alto - q_offset; r++) {
		        Hexagono hex = new Hexagono(q,r,l);
		      //Esto es nuevo 13/6/2016
		        hex.setControlador(controlador);
		        grid.put(new Coordenada(q,r),hex); //agrega en mi matriz para despues tenerlos
		        group.getChildren().add(hex);//los agrega al grupo que termina en el layout que es lo que se imprime
		        hex.setTranslateX(l*q*(1+Math.cos(Math.PI/3)));
		        hex.setTranslateY(-l*q*Math.sin(Math.PI/3)-2*l*r*Math.sin(Math.PI/3));
		        //calcula la posicion del hexagono en base a las coordenadas actuales
		    }
		}
        return group;
     }


 	public void pintarCaminoCorrecto(List<Coordenada> camino){
	 		// Recorro la lista y pinto los hex correspondientes
	 		for(Coordenada coordenada: camino){
	 			grid.get(coordenada).pintarCaminoCorrecto();
	 		}

 	}

	public void ponerSuperficieTierra(Coordenada coordenada, SuperficieTierra superficieTierra) {
			this.grid.get(coordenada).ponerSuperficie(superficieTierra);
	}

	public void ponerSuperficieAire(Coordenada coordenada, SuperficieAire superficieAire) {
			this.grid.get(coordenada).ponerSuperficie(superficieAire);
		}
	public void ponerRecolectable(Coordenada coordenada,Recolectable recolectable){
			this.grid.get(coordenada).ponerRecolectable(recolectable);
	}
	public void inicializarTablero(int alto, int ancho,Juego juego) {
			for (int q = 0; q < ancho; q++) {
			    int q_offset = (int)Math.floor(q/2);
			    for (int r = -q_offset; r < alto - q_offset; r++) {
			    	Coordenada c = new Coordenada(q,r);
			        this.ponerSuperficieTierra(c,juego.obtenerSuperficieTierra(c));
			        this.ponerSuperficieAire(c, juego.obtenerSuperficieAire(c));
			        this.ponerAccionable(c,juego.obtenerAccionable(c));
			        this.ponerRecolectable(c,juego.obtenerRecolectable(c));
			    }
			}
		}

	public void ponerAccionable(Coordenada coordenada, Accionable accionable) {
			this.grid.get(coordenada).ponerAccionable(accionable);
		}


	


	public void borrarRecolectable(Coordenada coordenada) {
		this.grid.get(coordenada).sacarRecolectable();
		
	}
	public void borrarAlgoformer(Coordenada coordenada) {
		this.grid.get(coordenada).sacarAlgoFormer();
	}


	public void limpiarSeleccion() {
		for(Map.Entry<Coordenada, Hexagono> entry : this.grid.entrySet()) {
           //this.grid.get(entry).limpiarSeleccion();
			entry.getValue().limpiarSeleccion();
        }
	}

}
