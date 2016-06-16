package fiuba.algo3.algoFormers.vista;

import fiuba.algo3.algoFormers.controlador.Controlador;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.juego.Juego;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;
import javafx.scene.Group;

public class Vista {
	private HexGrid hexGrid;
	public Vista(){
		this.hexGrid = new HexGrid();
	}

	public void inicializarTablero(int alto, int ancho, Juego juego) {
		this.hexGrid.inicializarTablero(alto,ancho,juego);
		
	}

	public Group crearTablero(int ancho, int alto, Controlador controlador) {
		return this.hexGrid.crearTablero(ancho,alto,controlador);
	}

	public void update(Tablero tablero, Coordenada coordenada,boolean esAlgoformer) {
		if(esAlgoformer)
			this.hexGrid.borrarAlgoformer(coordenada);
		else
			this.hexGrid.borrarRecolectable(coordenada);
		
	}

	public void update(Algoformer algoformer, Coordenada posicion) {
		this.hexGrid.ponerAccionable(posicion, algoformer);
		
	}

}
