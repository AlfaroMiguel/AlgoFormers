package fiuba.algo3.algoFormers.vista;

import fiuba.algo3.algoFormers.controlador.Controlador;
import fiuba.algo3.algoFormers.juego.Juego;
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

}
